/*******************************************************************************
 * Copyright (c) 2008 The University of York.
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
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.epsilon.eol.IEolModule;

public class EolDebugTarget extends DebugElement implements IDebugTarget {
	
	private ILaunch launch;
	private String name;
	private EolThread thread;
	private IThread[] threads;
	
	public EolDebugTarget(ILaunch launch, IEolModule module) {
		super(null);
		this.launch = launch;
		thread = new EolThread(this, module);
		threads = new IThread[]{thread};
	}
	
	public String getName() throws DebugException {
		return "debug-target";
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

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		// TODO Auto-generated method stub
		return false;
	}

	public IDebugTarget getDebugTarget() {
		return this;
	}

	public ILaunch getLaunch() {
		return launch;
	}

	public String getModelIdentifier() {
		return EolDebugConstants.MODEL_IDENTIFIER;
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

	public void breakpointAdded(IBreakpoint breakpoint) {
		// TODO Auto-generated method stub
		
	}

	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		// TODO Auto-generated method stub
		
	}

	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		// TODO Auto-generated method stub
		
	}

	public boolean canDisconnect() {
		// TODO Auto-generated method stub
		return false;
	}

	public void disconnect() throws DebugException {
		// TODO Auto-generated method stub
		
	}

	public boolean isDisconnected() {
		// TODO Auto-generated method stub
		return false;
	}

	public IMemoryBlock getMemoryBlock(long startAddress, long length)
			throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean supportsStorageRetrieval() {
		// TODO Auto-generated method stub
		return false;
	}

}
 