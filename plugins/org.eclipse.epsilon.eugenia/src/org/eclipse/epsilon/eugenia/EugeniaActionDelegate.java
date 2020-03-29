/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.concurrent.EolModuleParallel;
import org.eclipse.epsilon.eol.dt.ExtensionPointToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public abstract class EugeniaActionDelegate implements IObjectActionDelegate {

	private Shell shell;
	private IResource selection;
	private List<IModel> extraModels = null;

	protected GmfFileSet gmfFileSet;
	protected boolean clearConsole = true;

	public boolean isClearConsole() {
		return clearConsole;
	}
	
	public EugeniaActionDelegate setClearConsole(boolean clearConsole) {
		this.clearConsole = clearConsole;
		return this;
	}
	
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.shell = targetPart.getSite().getShell();
	}
	
	public GmfFileSet getGmfFileSet() {
		return gmfFileSet;
	}

	public abstract String getTitle();
	
	public abstract EugeniaActionDelegateStep getStep();
	
	public boolean requiresUIThread() {
		return false;
	}
	
	@Override
	public void run(final IAction action) {
		Job job = new Job(getTitle()) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					runImpl(action);
				} catch (Exception ex) {
					// Produce log message before displaying message
					// Swapping the order seems to prevent the message
					// from being logged
					LogUtil.log(ex);
					
					PlatformUI.getWorkbench().getDisplay().syncExec(() -> MessageDialog.openError(shell, "Error",
					"An error has occured. Please see the Error Log."));
				}
				return Status.OK_STATUS;
			}
		};
		job.setPriority(Job.SHORT);
		job.schedule(); // start as soon as possible*/
	}
	
	public abstract List<IModel> getModels() throws Exception;
	
	public IFile getSelectedFile() {
		return (selection instanceof IFile) ? (IFile)selection : null;
	}
	
	public IResource getSelection() {
		return selection;
	}
	
	public void setSelection(IResource selection) {
		this.selection = selection;
		// The following doesn't work with Jazz - see bug #407183
		//this.gmfFileSet   = new GmfFileSet(selectedFile.getLocationURI().toString());
		this.gmfFileSet = createGmfFileSetFromSelection(selection);		
	}

	protected GmfFileSet createGmfFileSetFromSelection(IResource selection) {
		return new GmfFileSet(selection.getLocation().toFile().toURI().toString());
	}

	public IEolModule createBuiltinModule() throws EolRuntimeException {
		return new EolModuleParallel();
	}
	
	public IEolModule createCustomizationModule() throws EolRuntimeException {
		return new EolModule();
	}
	
	public abstract String getBuiltinTransformation();
	
	public abstract String getCustomizationTransformation();
	
	public List<Variable> getExtraVariables() {
		return new ArrayList<>();
	}
	
	public boolean isApplicable() {
		return true;
	}
	
	public void runImpl(IAction action) throws Exception {
					  
		IEolModule builtin = createBuiltinModule();
		IEolModule customization = createCustomizationModule();

		URI uri = Activator.getDefault().getBundle().getResource(getBuiltinTransformation()).toURI();
		builtin.parse(uri);
		if (!builtin.getParseProblems().isEmpty()) {
			throw new Exception("Syntax error(s) in the built-in transformation " + uri + ": " + builtin.getParseProblems());
		}
		
		builtin.getContext().getFrameStack().put(getExtraVariables());
		builtin.getContext().getModelRepository().addModels(getModels());
		builtin.getContext().setErrorStream(EpsilonConsole.getInstance().getErrorStream());
		builtin.getContext().setOutputStream(EpsilonConsole.getInstance().getDebugStream());
		builtin.getContext().getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());
		
		if (clearConsole) EpsilonConsole.getInstance().clear();
		
		try {
			builtin.execute();
			if (getCustomizationTransformation() != null) {
				String customizationPath = getSelectedFile().getParent().getFile(new Path(getCustomizationTransformation())).getLocation().toOSString();
				File customizationFile = new File(customizationPath);
				if (customizationFile.exists()) {
					customization.parse(customizationFile);
					if (customization.getParseProblems().isEmpty()) {
						customization.getContext().getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());
						customization.getContext().setModelRepository(builtin.getContext().getModelRepository());
						customization.getContext().setErrorStream(EpsilonConsole.getInstance().getErrorStream());
						customization.getContext().setOutputStream(EpsilonConsole.getInstance().getDebugStream());
						customization.getContext().setExtendedProperties(builtin.getContext().getExtendedProperties());
						customization.getContext().getFrameStack().put(getExtraVariables());
						customization.getContext().getModelRepository().addModels(getExtraModels());
						preExecuteCustomisation(customization);
						customization.execute();
					}
					else {
						throw new Exception("Syntax error(s) in the custom transformation " + customizationPath + ": " + customization.getParseProblems());
					}
				}
			}
		}
		catch (Exception ex) {
			throw ex;
		}
		finally {
			for (IModel model : builtin.getContext().getModelRepository().getModels()) {
				disposeModel(model);
			}
			builtin.getContext().dispose();
			customization.getContext().dispose();
			refresh();
		}
	}
	
	protected void disposeModel(IModel model) {
		model.dispose();
		//if (!(model.getName().equals("Ecore") || model.getName().equals("ECore"))) { model.dispose(); }
	}
	
	public void refresh() {
		try {
			getSelectedFile().getParent().refreshLocal(IResource.DEPTH_INFINITE, null);
		}
		catch (Exception ex) {
			// Ignore
		}
	}
	
	public EmfModel loadModel(String name, String path, String nsUri, boolean readOnLoad, boolean storeOnDisposal, boolean expand) throws Exception {
		EmfModel model = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_MODEL_URI, org.eclipse.emf.common.util.URI.createURI(path, true));
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, nsUri);
		properties.put(Model.PROPERTY_READONLOAD, readOnLoad + "");
		properties.put(Model.PROPERTY_STOREONDISPOSAL, storeOnDisposal + "");
		properties.put(AbstractEmfModel.PROPERTY_EXPAND, expand + "");
		properties.put(Model.PROPERTY_NAME, name);
		//model.load(properties, EclipseUtil.getWorkspacePath());
		model.load(properties);
		return model;
	}
	
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		Iterator<?> it = ((IStructuredSelection) selection).iterator();
		if (it.hasNext()) {
			setSelection((IResource) it.next());
		}
	}

	public List<IModel> getExtraModels() {
		return extraModels;
	}

	public void setExtraModels(List<IModel> extraModels) {
		this.extraModels = extraModels;
	}
	
	protected void preExecuteCustomisation(IEolModule module) {}
	
}
