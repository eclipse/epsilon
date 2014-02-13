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
package org.eclipse.epsilon.concordance.dt;

import static org.eclipse.epsilon.concordance.dt.ConcordanceNature.hasConcordanceNature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.model.ConcordanceModelFactory;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeReporter;

public class ProjectDeletedListener implements IResourceChangeListener {

	private final ModelChangeReporter reporter = ConcordancePlugin.getDefault().getModelChangeReporter();
	private final ResourceCategoriser categoriser = new ResourceCategoriser();

	
	public void resourceChanged(IResourceChangeEvent event) {
		if (!(event.getResource() instanceof IProject)) return;
			
		final IProject project = (IProject) event.getResource();
			
		try {
			if (hasConcordanceNature(project)) {
				project.accept(new DeletionReportingVisitor());
				
			}
		} catch (CoreException ex) {
			LogUtil.log("Error encountered while responding to project deletion event.", ex);
		}
	}

	
	private class DeletionReportingVisitor implements IResourceVisitor {

		public boolean visit(final IResource resource) throws CoreException {
			if (categoriser.isModel(resource)) {
				final WorkspaceJob job = new WorkspaceJob("Notify Concordance ModelChangeListeners of project deletion.") {
					
					@Override
					public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
						reporter.reportRemoval(ConcordanceModelFactory.createModel(resource));
						return Status.OK_STATUS;
					}
				};
				
				job.setRule(modifyRule(resource));
				job.schedule();
			}
			return true;
		}
	}
	

	private static ISchedulingRule modifyRule(IResource resource) {
		return ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(resource);
	}

	@SuppressWarnings("unused")
	private static ISchedulingRule modifyRule(IResource[] resources) {
		ISchedulingRule combinedRule = null;
        
        for (int i = 0; i < resources.length; i++) {
        	combinedRule = MultiRule.combine(modifyRule(resources[i]), combinedRule);
        }
        
        return combinedRule;
	}
}
 