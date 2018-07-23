/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - allow for multiple global stack frames
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;


/**
 * <p>A FrameStack is a stack of frames that stores the variables created during the
 * execution of an EOL program.</p>
 * 
 * <p>A FrameStack is divided into two distinct regions, one for global variables and
 * one for local variables. The global region always contains at least one frame, while 
 * the local region can be empty.</p> 
 * 
 *
 * @author Dimitrios Kolovos, Antonio García-Domínguez
 * @version 1.1
 * @see org.eclipse.epsilon.eol.execute.context.Frame
 */
public class FrameStack {
	
	/**
	 * <p>
	 * Implementation of {@link Frame} which hides the fact that global
	 * variables can now be split over several stack frames. Tries to follow a
	 * "Do What I Mean" approach:
	 * </p>
	 * <ul>
	 * <li>{@link #dispose()} and {@link #clear()} propagate over all stack
	 * frames.</li>
	 * <li>{@link #getAll()} continues until the topmost protected stack frame
	 * (inclusive).</li>
	 * <li>{@link #get(String)} and {@link #remove(String)} continue until the
	 * topmost match (up to the topmost protected stack frame, inclusive).</li>
	 * <li>and the rest only operate on the topmost global stack frame.</li>
	 * </ul>
	 *
	 * @author Antonio García-Domínguez
	 */
	private class GlobalFrame implements Frame {
		@Override
		public void dispose() {
			globals.dispose();
		}

		@Override
		public void clear() {
			globals.clear();
		}

		@Override
		public String getLabel() {
			return globals.top().getLabel();
		}

		@Override
		public void setLabel(String label) {
			globals.top().setLabel(label);
		}

		@Override
		public void put(String name, Object value) {
			globals.put(name, value);
		}

		@Override
		public void remove(String name) {
			globals.remove(name);
		}

		@Override
		public void put(Variable variable) {
			globals.put(variable);
		}

		@Override
		public void putAll(Map<String, Variable> variables) {
			globals.putAll(variables);
		}

		@Override
		public Variable get(String name) {
			return globals.get(name);
		}

		@Override
		public Map<String, Variable> getAll() {
			return globals.getAll();
		}

		@Override
		public boolean contains(String key) {
			return get(key) != null;
		}

		@Override
		public FrameType getType() {
			return globals.top().getType();
		}

		@Override
		public void setType(FrameType type) {
			globals.top().setType(type);
		}

		@Override
		public ModuleElement getEntryPoint() {
			return globals.top().getEntryPoint();
		}

		@Override
		public void setEntryPoint(ModuleElement entryPoint) {
			globals.top().setEntryPoint(entryPoint);
		}

		@Override
		public ModuleElement getCurrentStatement() {
			return globals.top().getCurrentStatement();
		}

		@Override
		public void setCurrentStatement(ModuleElement ast) {
			globals.top().setCurrentStatement(ast);
		}
	}

	protected FrameStackRegion globals = new FrameStackRegion();
	protected FrameStackRegion locals = new FrameStackRegion();
	protected HashMap<String, Variable> builtInVariables = new HashMap<String, Variable>();
	
	/**
	 * Creates a new frame stack
	 */
	public FrameStack() {
		enterGlobal(FrameType.UNPROTECTED, null);
		builtInVariables.put("null", Variable.createReadOnlyVariable("null", null));
	}
	
	public void dispose() {
		globals.dispose();
		locals.dispose();
	}

	/**
	 * Enters a new global frame.
	 * 
	 * @param type
	 *            The type of the frame: variables in lower stack frames are
	 *            visible from an {@link FrameType#UNPROTECTED} frame, and
	 *            invisible from a {@link FrameType#PROTECTED} frame.
	 * @param entryPoint
	 *            The AST from which the entry is performed
	 * @param variables
	 *            Zero or more variables that will be added to the new frame.
	 */
	public Frame enterGlobal(FrameType type, ModuleElement entryPoint, Variable... variables) {
		return globals.enter(type, entryPoint, variables);
	}
	
	/**
	 * Enters a new local frame.
	 *
	 * @param type
	 *            The type of the frame: variables in lower stack frames are
	 *            visible from an {@link FrameType#UNPROTECTED} frame, and
	 *            invisible from a {@link FrameType#PROTECTED} frame.
	 * @param entryPoint
	 *            The AST from which the entry is performed
	 * @param variables
	 *            Zero or more variables that will be added to the new frame.
	 * @return
	 */
	public Frame enterLocal(FrameType type, ModuleElement entryPoint, Variable... variables) {
		return locals.enter(type, entryPoint, variables);
	}
	
	/**
	 * Enters a new local frame.
	 *
	 * @deprecated Use {@link #enterLocal(FrameType, AST, Variable...)} instead.
	 *             This method will be removed from a future version of Epsilon.
	 */
	public Frame enter(FrameType type, ModuleElement entryPoint, Variable... variables) {
		return enterLocal(type, entryPoint, variables);
	}
	
		
	/**
	 * Leaves the current local frame and returns to the previous frame in the
	 * stack. This method cannot leave a global stack frame: use
	 * {@link #leaveGlobal(AST, boolean)} for that.
	 */
	public void leaveLocal(ModuleElement entryPoint, boolean dispose) {
		locals.leave(entryPoint, dispose);
	}
	
	/**
	 * Convenience method for {@link #leaveLocal(AST, boolean))} which disposes of the stack
	 * frame that was left.
	 */
	public void leaveLocal(ModuleElement entryPoint) {
		leaveLocal(entryPoint, true);
	}
	
	/**
	 * Leaves the current global stack frame and returns to the previous frame
	 * in the stack. This method cannot leave a local stack frame: use
	 * {@link #leaveLocal(AST, boolean)} for that. This method will not leave the
	 * last remaining global stack frame.
	 */
	public void leaveGlobal(ModuleElement entryPoint, boolean dispose) {
		if (countGlobalFrames() > 1)
			globals.leave(entryPoint, dispose);
	}
	
	/**
	 * Convenience method for {@link #leaveGlobal(AST, boolean)} which disposes of the
	 * global stack frame that was left.
	 */
	public void leaveGlobal(ModuleElement entryPoint) {
		leaveGlobal(entryPoint, true);
	}
	
	/**
	 * Leaves the current local frame and returns to the previous frame in the
	 * stack.
	 * 
	 * @deprecated Use {@link #leaveLocal(AST, boolean)} instead.
	 *             This method will be removed from a future version of Epsilon.
	 */
	public void leave(ModuleElement entryPoint, boolean dispose) {
		leaveLocal(entryPoint, dispose);
	}
	
	/**
	 * Convenience method for {@link #leaveLocal(AST)} which disposes of the stack
	 * frame that was left.
	 * 
	 * @deprecated Use {@link #leaveLocal(AST)} instead.
	 *             This method will be removed from a future version of Epsilon.
	 */
	public void leave(ModuleElement entryPoint) {
		leaveLocal(entryPoint, true);
	}

	/**
	 * Puts one or more new variables in the topmost frame of the scope.
	 * Note that the topmost frame can be either a local or a global frame,
	 * depending on the current state of the FrameStack.
	 */
	public void put(Variable... variables) {
		activeGroup().put(variables);
	}

	/**
	 * Puts a new variable in the topmost frame of the scope.
	 * Note that the topmost frame can be either a local or a global frame,
	 * depending on the current state of the FrameStack.
	 */
	public void put(Variable variable) {
		activeGroup().put(variable);
	}
	
	/**
	 * Puts one or more new variables in the topmost global stack frame.
	 */
	public void putGlobal(Variable... variables) {
		globals.put(variables);
	}
	
	/**
	 * Puts a new variable in the topmost global stack frame.
	 */
	public void putGlobal(Variable variable) {
		globals.put(variable);
	}
	
	/**
	 * Removes a variable by name from the topmost frame of the scope.
	 * Note that the topmost frame can be either a local or a global frame,
	 * depending on the current state of the FrameStack.
	 */
	public void remove(String variable) {
		activeGroup().top().remove(variable);
	}
	
	/**
	 * Returns the variable with the specified
	 * name and if it does not exist returns <code>null</code>. Note
	 * that variables in a higher frame shadow variables with
	 * the same name in lower frames. Similarly, local variables
	 * shadow global variables with the same name.
	 *
	 * @param name The name of the variable
	 * @return The variable with the specified name or <code>null</code>
	 */
	public Variable get(String name){
		if (builtInVariables.containsKey(name)) return builtInVariables.get(name);
		
		Variable var = locals.get(name);
		if (var == null) var = globals.get(name);
	
		return var;
	}
	
	/**
	 * <p>Returns the local variable with the specified name
	 * If the local variable does not exist, this method 
	 * returns <code>null</code>.</p>
	 * 
	 * <p><strong>Note:</strong> this method does not respect the 
	 * usual shadowing semantics of the FrameStack, and consequently
	 * most clients should call {@link #get(String)} (i.e., only call 
	 * this method if you really know what you are doing!)</p> 
	 *
	 * @param name The name of the local variable
	 * @return The local variable with the specified name or <code>null</code>
	 */
	public Variable getLocal(String name) {
		return locals.get(name);
	}
	
	/**
	 * <p>Returns the global variable with the specified name
	 * If the global variable does not exist, this method 
	 * returns <code>null</code>.</p>
	 * 
	 * <p><strong>Note:</strong> this method does not respect the 
	 * usual shadowing semantics of the FrameStack, and consequently
	 * most clients should call {@link #get(String)} (i.e., only call 
	 * this method if you really know what you are doing!)</p> 
	 *
	 * @param name The name of the global variable
	 * @return The global variable with the specified name or <code>null</code>
	 */
	public Variable getGlobal(String name) {
		return globals.get(name);
	}
	
	public boolean isInLoop() {
		return locals.isInLoop() || globals.isInLoop();
	}
	
	/**
	 * Returns true if a variable with the
	 * specified name exists in the scope
	 * @param name
	 * @return
	 */
	public boolean contains(String name){
		return get(name) != null;
	}
	
	/**
	 * Returns true if a local variable with the 
	 * specified name exists.
	 * 
	 * <p><strong>Note:</strong> this method does not respect the 
	 * usual shadowing semantics of the FrameStack, and consequently
	 * most clients should call {@link #contains(String)} (i.e., only call 
	 * this method if you really know what you are doing!)</p> 
	 * 
	 * @param name
	 * @return 
	 */
	public boolean containsLocal(String name){
		return locals.get(name) != null;
	}
	
	/**
	 * Returns true if a global variable with the 
	 * specified name exists.
	 * 
	 * <p><strong>Note:</strong> this method does not respect the 
	 * usual shadowing semantics of the FrameStack, and consequently
	 * most clients should call {@link #contains(String)} (i.e., only call 
	 * this method if you really know what you are doing!)</p> 
	 * 
	 * @param name
	 * @return 
	 */
	public boolean containsGlobal(String name){
		return globals.get(name) != null;
	}
	
	/**
	 * Returns a single frame containing all global variables. Note that this
	 * representation does not allow clients to determine in which global frame
	 * a variable resides. This method is provided only for
	 * backwards-compatibility reasons: previous version of EOL did not support
	 * multiple global variable frames.
	 * 
	 * @deprecated Use the designated methods for manipulating global variables
	 *             (e.g. {@link #enterGlobal(FrameType, AST, Variable...)},
	 *             {@link #putGlobal(Variable)} and {@link #getGlobal(String)}).
	 *             If no appropriate method exists, please open a bug report to
	 *             request it. This method will be removed in a future version
	 *             of Epsilon.
	 */
	@Deprecated
	public Frame getGlobals() {
		return new GlobalFrame();
	}

	/**
	 * Returns a list with all local (from top to bottom) and global (from top
	 * to bottom) stack frames, in that order.
	 */
	public List<SingleFrame> getFrames() {
		final List<SingleFrame> frames = new ArrayList<SingleFrame>();
		frames.addAll(locals.getFrames());
		frames.addAll(globals.getFrames());
		return frames;
	}
	
	public int getDepth() {
		return locals.frameCount() + globals.frameCount();
	}
	
	@Override
	public FrameStack clone() {
		FrameStack clone = new FrameStack();
		clone.locals = locals.clone();
		clone.globals = globals.clone();
		return clone;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("-----------SCOPE------------\r\n");
		buffer.append(locals.toString());
		buffer.append("----------GLOBALS-----------\r\n");
		buffer.append(globals.toString());
		return buffer.toString();
	}

	public Frame getTopFrame() {
		return activeGroup().top();
	}
	
	public ModuleElement getCurrentStatement() {
		return activeGroup().top().getCurrentStatement();
	}

	public void setCurrentStatement(ModuleElement ast) {
		activeGroup().top().setCurrentStatement(ast);
	}

	protected int countGlobalFrames()  {
		return globals.frameCount();
	}
	
	private FrameStackRegion activeGroup() {
		return locals.isEmpty() ? globals : locals;
	}
}
