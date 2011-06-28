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

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.Project;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelRepository;

public class ShutdownProjectRepositoryListener extends BuildFinishedListener {

	private static ShutdownProjectRepositoryListener INSTANCE = null;
	private ModelRepository repository;
	
	public static void activate(Project project, ModelRepository repository) {
		if (INSTANCE == null) {
			INSTANCE = new ShutdownProjectRepositoryListener();
			INSTANCE.repository = repository;
			project.addBuildListener(INSTANCE);
		}
	}
	
	private ShutdownProjectRepositoryListener() {
		
	}
	
	@Override
	public void buildFinished(BuildEvent event) {
		if (event.getException() != null) {
			for (IModel model : repository.getModels()) {
				model.setStoredOnDisposal(false);
			}
		}
		repository.dispose();
	}
	
	
	
}
 