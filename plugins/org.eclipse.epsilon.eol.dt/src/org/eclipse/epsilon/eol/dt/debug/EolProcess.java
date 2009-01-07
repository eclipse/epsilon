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

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

public class EolProcess implements IProcess {
	
	protected ILaunch launch = null;
	protected boolean terminated = false;
	
	public EolProcess(ILaunch launch) {
		this.launch = launch;
	}
	
	public String getAttribute(String key) {
		return null;
	}

	public int getExitValue() throws DebugException {
		return 0;
	}

	public String getLabel() {
		return "EOL Process";
	}

	public ILaunch getLaunch() {
		return launch;
	}

	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	public void setAttribute(String key, String value) {
		
	}

	public Object getAdapter(Class adapter) {
		System.err.println("Asking eol process for adapter " + adapter);
		return null;
	}

	public boolean canTerminate() {
		return true;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() throws DebugException {
		terminated = true;
	}

}
 