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

import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.epl.EplModule;
import org.eclipse.epsilon.epl.PatternMatchModel;

public class EplTask extends ExecutableModuleTask {
	
	protected int maxLoops = -1;
	protected boolean repeatWhileMatches;
	protected String exportAs = null;
	
	@Override
	protected void initialize() {
		EplModule module = (EplModule) this.module;
		module.setMaxLoops(maxLoops);
		module.setRepeatWhileMatches(repeatWhileMatches);
	}

	@Override
	protected IEolExecutableModule createModule() {
		return new EplModule();
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
		return maxLoops;
	}
	
	public void setMaxLoops(int maxLoops) {
		this.maxLoops = maxLoops;
	}
	
	public boolean isRepeatWhileMatches() {
		return repeatWhileMatches;
	}
	
	public void setRepeatWhileMatches(boolean repeatWhileMatches) {
		this.repeatWhileMatches = repeatWhileMatches;
	}
	
	public String getExportAs() {
		return exportAs;
	}
	
	public void setExportAs(String exportAs) {
		this.exportAs = exportAs;
	}
	
}
