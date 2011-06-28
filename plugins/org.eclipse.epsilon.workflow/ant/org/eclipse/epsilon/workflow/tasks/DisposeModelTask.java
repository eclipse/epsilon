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

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.models.IModel;
 
public class DisposeModelTask extends EpsilonTask {
	 
	protected String model;
	
	@Override 
	public void executeImpl() throws BuildException {
		if (profile) Profiler.INSTANCE.start("Dispose model : " + model); 
		try {
			IModel eolModel = getProjectRepository().getModelByName(model);
			eolModel.dispose();
			getProjectRepository().getModels().remove(eolModel);
		} catch (EolModelNotFoundException e) {
			throw new BuildException(e);
		}
		finally {
			if (profile) Profiler.INSTANCE.stop("Dispose model : " + model);
		}
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}
