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

import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.IEtlModule;

public class EtlTask extends ExecutableModuleTask {
	
	protected String exportTransformationTrace;
	
	public String getExportTransformationTrace() {
		return exportTransformationTrace;
	}

	public void setExportTransformationTrace(String exportTransformationTrace) {
		this.exportTransformationTrace = exportTransformationTrace;
	}

	@Override
	protected void initialize() throws Exception {
		IEtlModule etlModule = (IEtlModule) module;
		
	}
	
	@Override
	protected IEtlModule createModule() {
		return new EtlModule();
	}
	
	@Override
	protected void examine() throws Exception {
		if (exportTransformationTrace != null) {
			getProjectStackFrame().put(exportTransformationTrace,
					((IEtlModule) module).getContext().getTransformationTrace());
		}
	}

	
}
