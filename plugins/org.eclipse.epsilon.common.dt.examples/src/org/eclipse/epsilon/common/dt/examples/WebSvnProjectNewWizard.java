/*******************************************************************************
 * Copyright (c) 2006, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.epsilon.common.dt.examples;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;

abstract public class WebSvnProjectNewWizard extends Wizard implements
		INewWizard, IExecutableExtension {

	private WizardNewProjectCreationPage wizardNewProjectCreationPage;
	private String pageName = "page";
	private String pageTitle;
	private String pageDescription;
	private String pageProjectName;
	private String projectUrl;

	public WebSvnProjectNewWizard(String pageTitle, String pageDescription, 
			String pageProjectName, String projectUrl) {
		
		super();

		this.pageTitle = pageTitle;
		this.pageDescription = pageDescription;
		this.pageProjectName = pageProjectName;
		this.projectUrl = projectUrl;
		setNeedsProgressMonitor(true);
	}

	public boolean performFinish() {

		try {
			IRunnableWithProgress operation = new WorkspaceModifyOperation() {

				public void execute(IProgressMonitor monitor)
						throws InterruptedException {
					try {
						monitor.beginTask("Creating project", 120);

						String projectName = wizardNewProjectCreationPage.getProjectName();

						IWorkspace workspace = ResourcesPlugin.getWorkspace();
						IProject project = workspace.getRoot().getProject(projectName);

						// If the project does not exist, we will create it
						// and populate it.
						if (!project.exists()) {
							monitor.worked(10);

							WebSvnFolder exampleFolder = new WebSvnFolder(projectUrl.toString());
							WebSvnImportStructureProvider structureProvider = new WebSvnImportStructureProvider();
							
							ImportOperation op = new ImportOperation(project.getFullPath(), exampleFolder, 
									structureProvider,
									new IOverwriteQuery() {
										
										@Override
										public String queryOverwrite(String pathString) {
											return pathString;
										}
									}, structureProvider.getChildren(exampleFolder));
							
							op.setContext(getShell());
							try {
								op.run(monitor);
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
							
						}

						// Now, we ensure that the project is open.
						project.open(monitor);
						monitor.worked(10);
						
						if (monitor.isCanceled()) {
							throw new InterruptedException();
						}

					} catch (CoreException e) {
						throw new RuntimeException(e);
					} finally {
						monitor.done();
					}
				}
			};

			getContainer().run(false, true, operation);

		} catch (InterruptedException e) {
			return false;

		} catch (Exception e) {
			LogUtil.log(e);
			return false;
		}

		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {

		wizardNewProjectCreationPage = new WizardNewImmuatableProjectCreationPage(getPageName());
		wizardNewProjectCreationPage.setTitle(getPageTitle());
		wizardNewProjectCreationPage.setDescription(getPageDescription());
		wizardNewProjectCreationPage.setInitialProjectName(getPageProjectName());

		this.addPage(wizardNewProjectCreationPage);
	}

	private String getPageName() {
		return pageName;
	}

	private String getPageTitle() {
		return pageTitle;
	}

	private String getPageDescription() {
		return pageDescription;
	}

	private String getPageProjectName() {
		return pageProjectName;
	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {}
	
}