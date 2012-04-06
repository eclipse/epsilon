/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt.debug;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class EolStackFrame extends EolDebugElement implements IStackFrame {

	protected IThread thread;
	protected Frame frame;
	protected String name;
	
	public EolStackFrame(IThread thread, Frame frame, String name) {
		super(thread.getDebugTarget());
		this.thread = thread;
		this.frame = frame;
		this.name = name;
	}

	public boolean canStepInto() {
		return thread.canStepInto();
	}

	public boolean canStepOver() {
		return thread.canStepOver();
	}

	public boolean canStepReturn() {
		return thread.canStepReturn();
	}

	public boolean isStepping() {
		return thread.isStepping();
	}

	public void stepInto() throws DebugException {
		thread.stepInto();
	}

	public void stepOver() throws DebugException {
		thread.stepOver();
	}

	public void stepReturn() throws DebugException {
		thread.stepReturn();
	}

	public boolean canResume() {
		return thread.canResume();
	}

	public boolean canSuspend() {
		return thread.canSuspend();
	}

	public boolean isSuspended() {
		return thread.isSuspended();
	}

	public void resume() throws DebugException {
		thread.resume();
	}

	public void suspend() throws DebugException {
		thread.suspend();
	}

	public boolean canTerminate() {
		return thread.canTerminate();
	}

	public boolean isTerminated() {
		return thread.isTerminated();
	}

	public void terminate() throws DebugException {
		thread.terminate();
	}

	public IThread getThread() {
		return thread;
	}

	public IVariable[] getVariables() throws DebugException {
		
		int i = 0;
		EolVariable[] eolVariables = new EolVariable[frame.getAll().size()];
		for (Variable v : frame.getAll().values()) {
			eolVariables[i] = new EolVariable(getDebugTarget(), v.getName(), v.getValue());
			i++;
		}
		return eolVariables;
	}

	public boolean hasVariables() throws DebugException {
		return getVariables().length > 0;
	}

	public int getLineNumber() throws DebugException {
		// TODO Auto-generated method stub
		if (frame.getCurrentStatement() != null) {
			return frame.getCurrentStatement().getLine();
		}
		return -1;
	}

	public int getCharStart() throws DebugException {
		// TODO Auto-generated method stub
		if (frame.getCurrentStatement() != null) {
			return frame.getCurrentStatement().getColumn();
		}
		return -1;
	}

	public int getCharEnd() throws DebugException {
		// TODO Auto-generated method stub
		return -1;
	}

	public String getName() throws DebugException {
		return name;
	}

	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasRegisterGroups() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

}
