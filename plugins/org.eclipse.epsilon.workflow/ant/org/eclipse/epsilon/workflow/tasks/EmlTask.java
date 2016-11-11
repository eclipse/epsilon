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

import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eml.EmlModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class EmlTask extends ExecutableModuleTask {

	//protected String eclsrc = null;
	protected String useMatchTrace = null;
	protected String exportMergeTrace = null;
	protected String exportTransformationTrace = null;
	
	public String getExportMergeTrace() {
		return exportMergeTrace;
	}

	public void setExportMergeTrace(String exportMergeTrace) {
		this.exportMergeTrace = exportMergeTrace;
	}

	public String getExportTransformationTrace() {
		return exportTransformationTrace;
	}

	public void setExportTransformationTrace(String exportTransformationTrace) {
		this.exportTransformationTrace = exportTransformationTrace;
	}

	public String getUseMatchTrace() {
		return useMatchTrace;
	}

	public void setUseMatchTrace(String useMatchTrace) {
		this.useMatchTrace = useMatchTrace;
	}

	@Override
	protected IEolModule createModule() {
		return new EmlModule();
	}

	@Override
	protected void examine() throws Exception {
		if (exportTransformationTrace != null) {
			getProjectStackFrame().put(exportTransformationTrace,
					((EmlModule) module).getContext().getTransformationTrace());
		}
		if (exportMergeTrace != null) {
			getProjectStackFrame().put(exportMergeTrace,
					((EmlModule) module).getContext().getMergeTrace());
		}
	}

	@Override
	protected void initialize() throws Exception {
		EmlModule emlModule = (EmlModule) module;
		
		if (useMatchTrace != null) {
			Variable v = getProjectStackFrame().get(useMatchTrace);
			Object matchTraceImpl = v.getValue();
			if (matchTraceImpl instanceof MatchTrace) {
				emlModule.getContext().setMatchTrace(((MatchTrace) matchTraceImpl).getReduced());
			}
		}
	
	}

	//public String getEclsrc() {
	//	return eclsrc;
	//}

	//public void setEclsrc(String eclsrc) {
	//	this.eclsrc = eclsrc;
	//}
}
