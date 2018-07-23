/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt.debug;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.SingleFrame;

public class EolThread extends EolDebugElement implements IThread {

	public EolThread(IDebugTarget target) {
		super(target);
	}

	public boolean canResume() {
		return getDebugTarget().canResume();
	}

	public boolean canSuspend() {
		return getDebugTarget().canSuspend();
	}

	public boolean isSuspended() {
		return getDebugTarget().isSuspended();
	}

	public void resume() throws DebugException {
		getDebugTarget().resume();
	}

	public void suspend() throws DebugException {
		getDebugTarget().suspend();
	}

	public boolean canStepInto() {
		return isSuspended() && !isTerminated();
	}

	public boolean canStepOver() {
		return true;
	}

	public boolean canStepReturn() {
		return true;
	}

	public boolean isStepping() {
		return false;
	}

	public void stepInto() throws DebugException {
		((EolDebugTarget) getDebugTarget()).stepInto();
	}

	public void stepOver() throws DebugException {
		((EolDebugTarget) getDebugTarget()).stepOver();
	}

	public void stepReturn() throws DebugException {
		((EolDebugTarget) getDebugTarget()).stepReturn();
	}

	public boolean canTerminate() {
		return getDebugTarget().canTerminate();
	}

	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	public void terminate() throws DebugException {
		getDebugTarget().terminate();
	}

	public IStackFrame[] getStackFrames() throws DebugException {
		List<SingleFrame> frames = ((EolDebugTarget) getDebugTarget()).getModule().getContext().getFrameStack().getFrames();
		IStackFrame[] stackFrames  = new IStackFrame[frames.size()];
		int i = 0;
		for (Frame frame : frames) {
			stackFrames[i] = new EolStackFrame(this, frame, getStackFrameName(i, frame));
			i++;
		}
		return stackFrames;
	}

	public boolean hasStackFrames() throws DebugException {
		return getStackFrames().length > 0;
	}

	public int getPriority() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	public IStackFrame getTopStackFrame() throws DebugException {
		return getStackFrames()[0];
	}

	public String getName() throws DebugException {
		return getDebugTarget().getName();
	}

	public IBreakpoint[] getBreakpoints() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getStackFrameName(int position, Frame frame) {
		final ModuleElement entryPoint = frame.getEntryPoint();
		if (entryPoint != null) {
			StringBuilder builder = new StringBuilder();
			if (entryPoint instanceof Operation) {
				builder.append(entryPoint.getChildren().get(0).toString());
			} else {
				builder.append(entryPoint.toString());
			}
			builder.append(" at ");
			builder.append(entryPoint.getUri().toString());
			return builder.toString();
		}
		else {
			return "globals";
		}
	}

}
