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
package org.eclipse.epsilon.workflow.tasks;

import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.ecl.dt.launching.EclDebugger;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;

public class EclTask extends ExecutableModuleTask{
	
	protected String useMatchTrace = null;
	protected String exportMatchTrace = null;
	
	public String getUseMatchTrace() {
		return useMatchTrace;
	}

	public void setUseMatchTrace(String useMatchTrace) {
		this.useMatchTrace = useMatchTrace;
	}

	public String getExportMatchTrace() {
		return exportMatchTrace;
	}

	public void setExportMatchTrace(String exportMatchTrace) {
		this.exportMatchTrace = exportMatchTrace;
	}

	@Override
	protected IEolExecutableModule createModule() {
		return new EclModule();
	}

	@Override
	protected void initialize() throws Exception {
		IEclModule eclModule = (IEclModule) module;
		if (useMatchTrace != null) {
			eclModule.getContext().setMatchTrace(
					(MatchTrace)getProjectStackFrame().
					get(useMatchTrace).getValue());
		}
	}
	
	@Override
	protected void examine() throws Exception {
		IEclModule eclModule = (IEclModule) module;
		if (exportMatchTrace != null) {
			getProjectStackFrame().put(
				exportMatchTrace, 
				eclModule.getContext().getMatchTrace().getReduced());
		}
	}
	
	@Override
	protected EolDebugger createDebugger() {
		return new EclDebugger();
	}
}
