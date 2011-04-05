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
package org.eclipse.epsilon.common.dt.launching;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.ExecutionController;


public class EclipseExecutionController implements ExecutionController {
	
	protected Timer timer;
	protected boolean terminated = false;
	
	
	public EclipseExecutionController(final IProgressMonitor monitor) {
		
		
		TimerTask pollMonitorTask = new TimerTask() {

			@Override
			public void run() {
				setTerminated(monitor.isCanceled());
			}
			
		};
		
		timer = new Timer();
		timer.schedule(pollMonitorTask, 0l, 200l);
	}
	
	public void control(AST ast, IEolContext context) {	}
	
	protected void setTerminated(boolean terminated) {
		this.terminated = terminated;
	}
	
	public boolean isTerminated() {
		return terminated;
	}

	public void report(IEolContext context) {
		
	}

	public void dispose() {
		timer.cancel();
	}
	
	
	
}
