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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.reporter.metamodel.MetamodelChangeReporter;
import org.eclipse.ui.IStartup;

public class ConcordanceStartup implements IStartup {

	private final MetamodelChangeReporter ePackageRegistryMonitor;
	
	public ConcordanceStartup() {
		try {
			ePackageRegistryMonitor = new MetamodelChangeReporter();
		
		} catch (RuntimeException e) {
			// Integration tests have no access to Error Console, so log any runtime errors
			LogUtil.log("Runtime exception encountered during Concordance early startup", e);
			throw e;
		}
	}
	
	public void earlyStartup() {
		try {
			attachModelChangeListeners();
			attachMetamodelChangeListeners();
			listenForProjectDeletions();
			scheduleEPackageRegistryMonitorUpdateJob();
		
		} catch (Exception e) {
			LogUtil.log("Error encountered during Concordance early startup", e);
		}
	}

	private void attachModelChangeListeners() {
		new ModelChangeListenerInitialiser().attachAll(ConcordancePlugin.getDefault().getModelChangeReporter());
	}
	
	private void attachMetamodelChangeListeners() {
		new MetamodelChangeListenerInitialiser().attachClients(ePackageRegistryMonitor);
	}
	
	private void listenForProjectDeletions() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new ProjectDeletedListener());
	}

	private void scheduleEPackageRegistryMonitorUpdateJob() {
		new PeriodicallyUpdateEPackageRegistryMonitorJob().schedule();
	}
	
	private class PeriodicallyUpdateEPackageRegistryMonitorJob extends Job {
				
		public PeriodicallyUpdateEPackageRegistryMonitorJob() {
			super("Update Concordance EPackage Registry Monitor Job");
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			schedule(1000);
			
			ePackageRegistryMonitor.pollRegistry();
					
			return Status.OK_STATUS;
		}
	}
}
