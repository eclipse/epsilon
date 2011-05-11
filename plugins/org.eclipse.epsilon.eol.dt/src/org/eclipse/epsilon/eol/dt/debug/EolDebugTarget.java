package org.eclipse.epsilon.eol.dt.debug;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolDebugTarget extends EolDebugElement implements IDebugTarget {

	protected boolean suspended;
	protected boolean termninated;
	protected EolDebugger debugger = null;
	protected ILaunch launch;
	protected IThread[] threads = new IThread[1];
	protected IProcess process;
	protected IEolExecutableModule module;
	protected String lauchConfigurationSourceAttribute;
	
	public EolDebugTarget(ILaunch launch, IEolExecutableModule module, EolDebugger debugger, String lauchConfigurationSourceAttribute) {
		super(null);
		this.launch = launch;
		threads[0] = new EolThread(this);
		this.module = module;
		this.debugger = debugger;
		module.getContext().getExecutorFactory().setExecutionController(debugger);
		this.lauchConfigurationSourceAttribute = lauchConfigurationSourceAttribute;
	}
	
	public IEolExecutableModule getModule() {
		return module;
	}
	
	public void stepInto() throws DebugException {
		fireSuspendEvent(1);
		debugger.step();
		fireResumeEvent(1);
		//fireEvent(new DebugEvent(threads[0], DebugEvent.STEP_INTO));
	}

	public Object debug() throws DebugException, EolRuntimeException {
		fireCreationEvent();
		return debugger.debug(module);
	}

	@Override
	public IDebugTarget getDebugTarget() {
		return this;
	}

	public ILaunch getLaunch() {
		return launch;
	}

	public boolean canTerminate() {
		return !isTerminated();
	}

	public boolean isTerminated() {
		return termninated;
	}

	public void terminate() throws DebugException {
		this.termninated = true;
		this.suspended = false;
		fireTerminateEvent();
	}

	public boolean canResume() {
		return isSuspended() && !isTerminated();
	}

	public boolean canSuspend() {
		return !isSuspended() && !isTerminated();
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void resume() throws DebugException {
		this.suspended = false;
		fireResumeEvent(1);
	}

	public void suspend() throws DebugException {
		this.suspended = true;
		fireSuspendEvent(1);
	}

	public void breakpointAdded(IBreakpoint breakpoint) {
		// TODO Auto-generated method stub

	}

	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		// TODO Auto-generated method stub

	}

	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		// TODO Auto-generated method stub

	}

	public IProcess getProcess() {
		return null;
	}

	public IThread[] getThreads() throws DebugException {
		return threads;
	}

	public boolean hasThreads() throws DebugException {
		return true;
	}

	public String getName() throws DebugException {
		return launch.getAttribute(lauchConfigurationSourceAttribute);
	}

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Irrelevant methods
	 */

	public boolean canDisconnect() {
		return false;
	}

	public void disconnect() throws DebugException {

	}

	public boolean isDisconnected() {
		return false;
	}

	public boolean supportsStorageRetrieval() {
		return false;
	}

	public IMemoryBlock getMemoryBlock(long startAddress, long length)
			throws DebugException {
		return null;
	}

}
