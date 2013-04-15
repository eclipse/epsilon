/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.dt;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.ui.IStartup;

public class ConcordanceStartup implements IStartup {
	
	public void earlyStartup() {
		try {
			attachModelChangeListeners();
			attachMetamodelChangeListeners();
			listenForProjectDeletions();
			scheduleMetamodelChangeReporter();
		
		} catch (Exception e) {
			LogUtil.log("Error encountered during Concordance early startup", e);
		}
	}

	private void attachModelChangeListeners() {
		new ModelChangeListenerInitialiser().attachAll(ConcordancePlugin.getDefault().getModelChangeReporter());
	}
	
	private void attachMetamodelChangeListeners() {
		new MetamodelChangeListenerInitialiser().attachClients(ConcordancePlugin.getDefault().getMetamodelChangeReporter());
	}
	
	private void listenForProjectDeletions() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new ProjectDeletedListener());
	}

	private void scheduleMetamodelChangeReporter() throws CoreException {
		ConcordancePlugin.getDefault().getMetamodelChangeReporterScheduler().schedule();
	}
}
