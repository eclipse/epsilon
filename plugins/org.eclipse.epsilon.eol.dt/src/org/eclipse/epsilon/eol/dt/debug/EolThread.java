package org.eclipse.epsilon.eol.dt.debug;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.epsilon.eol.execute.context.Frame;

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
		return false;
	}

	public boolean canStepReturn() {
		return false;
	}

	public boolean isStepping() {
		return false;
	}

	public void stepInto() throws DebugException {
		((EolDebugTarget) getDebugTarget()).stepInto();
	}

	public void stepOver() throws DebugException {

	}

	public void stepReturn() throws DebugException {

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
		List<Frame> frames = ((EolDebugTarget) getDebugTarget()).getModule().getContext().getFrameStack().getFrames();
		IStackFrame[] stackFrames  = new IStackFrame[frames.size()];
		int i = 0;
		for (Frame frame : frames) {
			stackFrames[i] = new EolStackFrame(this, frame, "[" + i + "]");
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

}
