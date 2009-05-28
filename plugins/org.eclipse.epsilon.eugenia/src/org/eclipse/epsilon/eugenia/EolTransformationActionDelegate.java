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
package org.eclipse.epsilon.eugenia;

import java.io.File;
import java.net.URI;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public abstract class EolTransformationActionDelegate implements IObjectActionDelegate {

	private Shell shell;
	protected ISelection selection;
	
	public EolTransformationActionDelegate() {
		super();
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}
	
	public abstract String getTitle();
	
	public void run(final IAction action) {
		
		Job job = new Job(getTitle()) {
			protected IStatus run(IProgressMonitor monitor) {
				try {
					runImpl(action);
				} catch (Exception ex) {
					// Produce log message before displaying message
					// Swapping the order seems to prevent the message
					// from being logged
					LogUtil.log(ex);
					
					PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

						public void run() {
							MessageDialog.openError(shell, "Error",
							"An error has occured. Please see the Error Log.");
						}
						
					});
				}
				return Status.OK_STATUS;
			}
		};
		job.setPriority(Job.SHORT);
		job.schedule(); // start as soon as possible
	}
	
	public abstract List<EmfModel> getModels() throws Exception;
	
	public IFile getSelectedFile() {
		IStructuredSelection selection = (IStructuredSelection) this.selection;
		IFile file = (IFile) selection.iterator().next();
		return file;
	}
	
	public abstract String getBuiltinTransformation();
	
	public abstract String getCustomizationTransformation();
	
	public void runImpl(IAction action) throws Exception {
					  
		EolModule builtin = new EolModule();
		EolModule customization = new EolModule();
		
		URI uri = Activator.getDefault().getBundle().getResource(getBuiltinTransformation()).toURI();
		builtin.parse(uri);
		
		for (EmfModel model : getModels()) {
			builtin.getContext().getModelRepository().addModel(model);
		}
		
		String customizationPath = getSelectedFile().getParent().getFile(new Path(getCustomizationTransformation())).getLocation().toOSString();
		File customizationFile = new File(customizationPath);
		
		builtin.getContext().setErrorStream(EpsilonConsole.getInstance().getErrorStream());
		builtin.getContext().setOutputStream(EpsilonConsole.getInstance().getDebugStream());
		EpsilonConsole.getInstance().clear();
		
		try {
			builtin.execute();
			if (customizationFile.exists()) {
				customization.parse(customizationFile);
				if (customization.getParseProblems().size() == 0) {
					customization.getContext().setModelRepository(builtin.getContext().getModelRepository());
					customization.getContext().setErrorStream(EpsilonConsole.getInstance().getErrorStream());
					customization.getContext().setOutputStream(EpsilonConsole.getInstance().getDebugStream());
					customization.getContext().setExtendedProperties(builtin.getContext().getExtendedProperties());
					customization.execute();
				}
				else {
					LogUtil.log("Syntax error(s) in " + customizationPath, null);
				}
			}
		}
		catch (Exception ex) {
			throw ex;
		}
		finally {
			builtin.getContext().getModelRepository().dispose();
			builtin.getContext().dispose();
			customization.getContext().dispose();
			getSelectedFile().getParent().refreshLocal(1, null);
		}
	}
	
	public EmfModel loadModel(String name, String path, String nsUri, boolean readOnLoad, boolean storeOnDisposal, boolean expand) throws Exception {
		EmfModel model = new EmfModel();
		
		StringProperties properties = new StringProperties();
		
		properties.put(EmfModel.PROPERTY_MODEL_FILE, path);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, nsUri);
		properties.put(EmfModel.PROPERTY_IS_METAMODEL_FILE_BASED, "false");
		properties.put(EmfModel.PROPERTY_READONLOAD, readOnLoad + "");
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, storeOnDisposal + "");
		properties.put(EmfModel.PROPERTY_EXPAND, expand + "");
		properties.put(EmfModel.PROPERTY_NAME, name);
		
		//model.load(properties, EclipseUtil.getWorkspacePath());
		model.load(properties, null);
		return model;
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}
}
