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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.newExpression_return;

public class EolThread extends EolDebugElement implements IThread{

	protected IEolModule module = null;
	protected boolean terminated = false;
	protected DebugExecutionController controller = new DebugExecutionController();
	
	public EolThread(IDebugTarget target, IEolModule module) {
		super(target);
		this.module = module;
		start();
	}

	@Override
	public Object getAdapter(Class adapter) {
		
		return super.getAdapter(adapter);
	}

	public void start() {
		Job job = new Job("Start"){
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					module.getContext().getExecutorFactory().setExecutionController(controller);
					module.execute();
				} catch (EolRuntimeException e) {
					e.printStackTrace();
				}
				finally {
					try {
						terminate();
					} catch (DebugException e) {
						// Ignore
					}
					DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[]{new DebugEvent(getDebugTarget(), DebugEvent.TERMINATE)});
				}
				return Status.OK_STATUS;
			}
			
		};
		
		job.schedule(1000);

	}
	
	public IBreakpoint[] getBreakpoints() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() throws DebugException {
		return "main";
	}

	public int getPriority() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	public IStackFrame[] getStackFrames() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	public IStackFrame getTopStackFrame() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasStackFrames() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean canResume() {
		return controller.isSuspended() && !controller.isTerminated();
	}

	public boolean canSuspend() {
		return !controller.isSuspended() && !controller.isTerminated();
	}

	public boolean isSuspended() {
		return controller.isSuspended();
	}

	public void resume() throws DebugException {
		controller.resume();
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[]{new DebugEvent(getDebugTarget(), DebugEvent.RESUME)});
	}

	public void suspend() throws DebugException {
		controller.suspend();
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[]{new DebugEvent(getDebugTarget(), DebugEvent.SUSPEND)});
	}

	public boolean canStepInto() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean canStepOver() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean canStepReturn() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStepping() {
		// TODO Auto-generated method stub
		return false;
	}

	public void stepInto() throws DebugException {
		// TODO Auto-generated method stub
		
	}

	public void stepOver() throws DebugException {
		// TODO Auto-generated method stub
		
	}

	public void stepReturn() throws DebugException {
		
	}

	public boolean canTerminate() {
		return !controller.isTerminated();
	}

	public boolean isTerminated() {
		return controller.isTerminated();
	}

	public void terminate() throws DebugException {
		if (isSuspended()) { resume(); }
		controller.terminate();
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[]{new DebugEvent(getDebugTarget(), DebugEvent.TERMINATE)});

	}

}
 