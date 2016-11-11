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

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolDebugTarget extends EolDebugElement implements IDebugTarget {

	protected boolean suspended;
	protected boolean terminated;
	protected EolDebugger debugger = null;
	protected ILaunch launch;
	protected IThread[] threads = new IThread[1];
	protected IProcess process;
	protected IEolModule module;
	protected String name;
	
	public EolDebugTarget(ILaunch launch, IEolModule module, EolDebugger debugger, String name) {
		super(null);
		this.launch = launch;
		threads[0] = new EolThread(this);
		this.module = module;
		this.debugger = debugger;
		module.getContext().getExecutorFactory().setExecutionController(debugger);
		this.name = name;
	}
	
	public IEolModule getModule() {
		return module;
	}
	
	public void stepInto() throws DebugException {
		fireSuspendEvent(DebugEvent.SUSPEND);
		debugger.step();
		fireResumeEvent(DebugEvent.STEP_INTO);
	}

	public void stepOver() throws DebugException {
		fireSuspendEvent(DebugEvent.SUSPEND);
		debugger.stepOver();
		fireResumeEvent(DebugEvent.STEP_OVER);
	}

	public void stepReturn() {
		fireSuspendEvent(DebugEvent.SUSPEND);
		debugger.stepReturn();
		fireResumeEvent(DebugEvent.STEP_RETURN);
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
		return terminated;
	}

	public void terminate() throws DebugException {
		this.terminated = true;
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
		fireResumeEvent(DebugEvent.RESUME);
	}

	public void suspend() throws DebugException {
		this.suspended = true;
		fireSuspendEvent(DebugEvent.SUSPEND);
	}

	public void breakpointAdded(IBreakpoint breakpoint) {
		// nothing to do
	}

	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		// nothing to do
	}

	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		// nothing to do
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
		return name;
	}

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return false;
	}

	/*
	 * Irrelevant methods
	 */

	public boolean canDisconnect() {
		return false;
	}

	public void disconnect() throws DebugException {
		// do nothing
	}

	public boolean isDisconnected() {
		return false;
	}

	public boolean supportsStorageRetrieval() {
		return false;
	}

	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return null;
	}

}
