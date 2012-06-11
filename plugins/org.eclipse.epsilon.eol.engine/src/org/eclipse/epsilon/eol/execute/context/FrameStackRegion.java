/*******************************************************************************
 * Copyright (c) 2011-2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose, Antonio García-Domínguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.context;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;

/**
 * A region of the FrameStack, which is itself a stack of frames.
 * FrameStackRegions are used to distinguish between different parts
 * of the overall FrameStack.
 * 
 * @author Louis Rose, Antonio García-Domínguez
 * @see org.eclipse.epsilon.eol.execute.context.FrameStack
 */
class FrameStackRegion {

	// We use the newer Deque class rather than a java.util.Stack,
	// as the latter uses the legacy Vector class
	private Deque<SingleFrame> frames = new ArrayDeque<SingleFrame>();

	/**
	 * Clears every frame.
	 */
	public void clear() {
		for (Frame frame : frames) {
			frame.clear();
		}
	}
	
	/**
	 * Disposes every frame.
	 */
	public void dispose() {
		while (!isEmpty()) {
			disposeTopFrame();
		}
	}
	
	/**
	 * Enters a new frame.
	 * 
	 * @param type
	 *            The type of the frame: variables in lower stack frames are
	 *            visible from an {@link FrameType#UNPROTECTED} frame, and
	 *            invisible from a {@link FrameType#PROTECTED} frame.
	 * @param entryPoint
	 *            The AST from which the entry is performed
	 */
	public Frame enter(FrameType type, AST entryPoint, Variable... variables) {
		frames.push(new SingleFrame(type, entryPoint));
		put(variables);
		return top();
	}

	/**
	 * Returns the number of frames in this region.
	 */
	public int frameCount() {
		return frames.size();
	}
	
	/**
	 * Searches for the specified variable in every frame from 
	 * top to bottom until a protected frame is reached (inclusive).
	 * Returns the first matching variable.
	 */
	public Variable get(String name) {
		for (Frame frame : frames) {
			if (frame.contains(name)) {
				return frame.get(name);
			
			} else if (frame.getType() == FrameType.PROTECTED) {
				break;
			}
		}
		
		return null;
	}

	/**
	 * Retrieves all of the variables in this region by searching from 
	 * top to bottom until a protected frame is reached (inclusive).
	 * A variable in a higher frame shadows a variable with the same 
	 * name in a lower frame. 
	 */
	public Map<String, Variable> getAll() {
		final Map<String, Variable> all = new HashMap<String, Variable>();
		for (Frame frame : frames) {
			for (Map.Entry<String, Variable> e : frame.getAll().entrySet()) {
				if (!all.containsKey(e.getKey())) {
					all.put(e.getKey(), e.getValue());
				}
			}
			if (frame.getType() == FrameType.PROTECTED) {
				break;
			}
		}
		return all;
	}

	/**
	 * Returns true if and only if there are no frames in this region.
	 */
	public boolean isEmpty() {
		return frames.isEmpty();
	}

	/**
	 * Returns true if and only if any of the frames in this region
	 * have an entryPoint that signify loop constructs.
	 */
	public boolean isInLoop() {
		for (SingleFrame frame : frames) {
			if (isLoopAst(frame.getEntryPoint())){
				return true;
			} else if (frame.getType() == FrameType.PROTECTED){
				return false;
			}
		}
		return false;
	}

	/**
	 * Leaves all frames in the region until the specified entryPoint is reached.
	 * Note that this method also leaves the frame whose entryPoint is the specified
	 * value. 
	 */
	public void leave(AST entryPoint) {
		leave(entryPoint, true);
	}
	
	/**
	 * Leaves all frames in the region until the specified entryPoint is reached.
	 * 
	 * @param entryPoint
	 * 			the entryPoint of the frame above which all frames will be left
	 * @param disposeFrameWithSpecifiedEntryPoint
	 *          if true, then the frame with the specified entryPoint will be left
	 *          otherwise, the frame with the specified entryPoint will be the topmost frame
	 */
	public void leave(AST entryPoint, boolean disposeFrameWithSpecifiedEntryPoint) {
		if (!isEmpty()) {
			disposeFramesUntil(entryPoint);
			if (disposeFrameWithSpecifiedEntryPoint) disposeTopFrame();
		}
	}
	
	/**
	 * Adds the specified variable to the topmost frame.
	 */
	public void put(String name, Object value) {
		top().put(name, value);
	}
	
	/**
	 * Adds the specified variables to the topmost frame.
	 */
	public void put(Variable... variables) {
		for (Variable variable : variables) {
			put(variable);
		}
	}

	/**
	 * Adds the specified variable to the topmost frame.
	 */
	public void put(Variable variable) {
		top().put(variable);
	}
	
	/**
	 * Adds the specified variables to the topmost frame.
	 */
	public void putAll(Map<String, Variable> variables) {
		top().putAll(variables);
	}
	
	/**
	 * Removes the specified variable from every frame from top
	 * to bottom until a protected frame is reached (inclusive).
	 */
	public void remove(String name) {
		for (Frame frame : frames) {
			frame.remove(name);			
			if (frame.getType() == FrameType.PROTECTED) {
				break;
			}
		}
	}
	
	/**
	 * Returns the topmost frame in this region, or null if this
	 * region is empty.	
	 */
	public Frame top() {
		return frames.peek();
	}
	
	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();
		
		for (SingleFrame frame : frames) {
			result.append(frame.toString());
		}
		
		return result.toString();
	}

	@Override
	protected FrameStackRegion clone() {
		final FrameStackRegion clone = new FrameStackRegion();
		
		for (SingleFrame frame : frames) {
			clone.frames.add(frame.clone());
		}
		
		return clone;
	}

	protected Collection<SingleFrame> getFrames() {
		return frames;
	}

	protected boolean isLoopAst(AST ast) {
		return ast != null && (ast.getType() == EolParser.FOR || ast.getType() == EolParser.WHILE);
	}

	private void disposeFramesUntil(AST entryPoint) {
		while (top().getEntryPoint() != entryPoint)
			disposeTopFrame();
	}

	private void disposeTopFrame() {
		if (!frames.isEmpty())
			frames.pop().dispose();
	}
}
