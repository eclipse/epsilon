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

package org.eclipse.epsilon.concordance.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.epsilon.concordance.index.CrossReferenceIndexManager;

public class ProjectDeletedListener implements IResourceChangeListener {

	public void resourceChanged(IResourceChangeEvent event) {
		
		if (! (event.getResource() instanceof IProject)) return;
			
		IProject project = (IProject) event.getResource();
			
		try {
			if (project.getNature(ConcordanceNature.NATURE_ID) != null) {
				CrossReferenceIndexManager.INSTANCE.removeModelsFromIndex(project);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}
 