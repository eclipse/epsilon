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
import org.eclipse.epsilon.eol.models.IModel;

public class DisposeModelsTask extends EpsilonTask {

	@Override
	public void executeImpl() throws BuildException {
		for (IModel model : getProjectRepository().getModels()) {
			model.dispose();
		}
		getProjectRepository().getModels().clear();
	}

}
