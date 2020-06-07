/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks;

import org.eclipse.epsilon.epl.IEplModule;
import org.eclipse.epsilon.epl.concurrent.EplModuleParallelPatterns;
import org.eclipse.epsilon.epl.execute.model.PatternMatchModel;

public class EplTask extends ExecutableModuleTask {
	
	protected String exportAs = null;
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected IEplModule createDefaultModule() {
		return new EplModuleParallelPatterns();
	}

	@Override
	protected void examine() throws Exception {
		if (exportAs != null) {
			PatternMatchModel model = (PatternMatchModel) result;
			model.setName(exportAs);
			getProjectRepository().addModel(model);
		}
		result = null;
	}
	
	public int getMaxLoops() {
		return ((IEplModule) module).getMaxLoops();
	}
	
	public void setMaxLoops(int maxLoops) {
		((IEplModule) module).setMaxLoops(maxLoops);
	}
	
	public boolean isRepeatWhileMatches() {
		return ((IEplModule) module).isRepeatWhileMatches();
	}
	
	public void setRepeatWhileMatches(boolean repeatWhileMatches) {
		((IEplModule) module).setRepeatWhileMatches(repeatWhileMatches);
	}
	
	public String getExportAs() {
		return exportAs;
	}
	
	public void setExportAs(String exportAs) {
		this.exportAs = exportAs;
	}
	
}
