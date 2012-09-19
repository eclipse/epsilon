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

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.ExecutionController;

public class DebugExecutionController implements ExecutionController{
	
	boolean suspended = false;
	boolean terminated = false;
	
	public void control(AST ast, IEolContext context) {
//		if (suspended) {
//			return false;
//		}
//		else {
//			return true;
//		}
	}

	public boolean isTerminated() {
		return terminated;
	}
	
	public void report(IEolContext context) {
		
	}

	public void dispose() {
		
	}
	
	public void suspend() {
		suspended = true;
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void terminate() {
		terminated = true;
	}

	public boolean isSuspended() {
		return suspended;
	}

	@Override
	public void done(AST ast, IEolContext context) {
		// do nothing
	}
}
 