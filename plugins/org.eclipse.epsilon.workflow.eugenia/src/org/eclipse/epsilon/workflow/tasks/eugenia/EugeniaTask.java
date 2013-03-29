/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.eugenia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelReference;
import org.eclipse.epsilon.eugenia.GenerateAllDelegate;
import org.eclipse.epsilon.eugenia.GenerateAllStep;
import org.eclipse.epsilon.workflow.tasks.EpsilonTask;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Ant wrapper for Eugenia. It is much simpler than the other Epsilon tasks, so
 * it does <emph>not</emph> inherit from {@link EpsilonTask}.
 */
public class EugeniaTask extends EpsilonTask {

	private File sourceFile;
	private GenerateAllStep firstStep, lastStep;
	private List<EugeniaExtraModel> extraModels = new ArrayList<EugeniaExtraModel>();

	/**
	 * <p>Changes the source file for the Eugenia workflow. If the name of source file
	 * ends in <code>.emf</code>, Eugenia will treat it as an EMFatic specification and
	 * will try to convert it to an <code>.ecore/code> model first. Otherwise, it will
	 * start the Eugenia workflow directly with it, as if it were an Ecore model.</p>
	 * <p><emph>Important note:</emph> the source file must be part of a project in the
	 * current workspace.</p>
	 */
	public void setSrc(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	/**
	 * Returns the source file for the Eugenia workflow.
	 * @see #setSrc(File)
	 */
	public File getSrc() {
		return sourceFile;
	}

	/**
	 * Changes the step at which we will start in the Eugenia workflow. Valid steps are
	 * listed in {@link GenerateAllStep}. By default, we will start by cleaning the
	 * models produced from the .emf or .ecore source. To unset this option, call this
	 * method with <code>null</code>.
	 */
	public void setFirstStep(GenerateAllStep firstStep) {
		this.firstStep = firstStep;
	}

	/**
	 * Returns the step at which we will start, if set. If unset, returns <code>null</code>.
	 */
	public GenerateAllStep getFirstStep() {
		return firstStep;
	}

	/**
	 * Changes the step at which we will stop in the Eugenia workflow. Valid steps are
	 * listed in {@link GenerateAllStep}. By default, we will run all steps. To unset
	 * this option, call this method with <code>null</code>.
	 */
	public void setLastStep(GenerateAllStep lastStep) {
		this.lastStep = lastStep;
	}

	/**
	 * Returns the step at which we will stop, if set. If unset, returns <code>null</code>.
	 */
	public GenerateAllStep getLastStep() {
		return lastStep;
	}

	/**
	 * Creates a new extra model to be used in one of the Eugenia execution steps.
	 */
	public EugeniaExtraModel createModel() {
		EugeniaExtraModel model = new EugeniaExtraModel();
		extraModels .add(model);
		return model;
	}

	@Override
	public void executeImpl() throws BuildException {
		if (sourceFile == null) {
			throw new BuildException("src attribute must be set with the path to the .emf or .ecore file");
		}

		// We will use exactly the same code that is run from the Eclipse GUI
		final GenerateAllDelegate genAll = new GenerateAllDelegate();
		genAll.setShowErrorDialog(false);
		
		if (firstStep != null) {
			genAll.setFirstStep(firstStep);
		}
		if (lastStep != null) {
			genAll.setLastStep(lastStep);
		}

		// Convert the Java File to an Eclipse IFile: this is why only files
		// inside the workspace may be used as sources.
		final Path path = new Path(sourceFile.getAbsolutePath());
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		genAll.setSelectedFile(workspaceRoot.getFileForLocation(path));

		// HACK: Eugenia *needs* an IAction to call the GMF code generator.
		// This is because Eugenia needs to invoke ExecuteTemplatesAction
		// through its menu entry, as is an internal class, unlike the EMF
		// code generation bits, which are part of its public API. Luckily,
		// GMF is happy with the default implementation of IAction in Action.
		final Action action = new Action(){};

		// HACK: normally we would call getActiveWorkbenchWindow(), but that
		// returns null from an Eclipse Ant task. Instead, we need to get the first
		// window. If we're in a headless environment and there are no workbench
		// windows, we won't be able to set an active part. Setting an active part
		// is only required to generate the GMF diagram code: we can still perform
		// all the previous stages safely, up to generating the EMF code.
		IWorkbenchWindow[] workbenchWindows = PlatformUI.getWorkbench().getWorkbenchWindows();
		if (workbenchWindows.length > 0) {
			final IWorkbenchPart activePart = workbenchWindows[0].getActivePage().getActivePart();
			genAll.setActivePart(action, activePart);
		}

		try {
			for (EugeniaExtraModel extraModel : extraModels) {
				final IModel model = getProjectRepository().getModelByName(extraModel.getRef());
				if (model == null) {
					throw new BuildException("Could not find the model named " + extraModel.getRef() + " in the project repository");
				}

				final ModelReference ref = new ModelReference(model);
				if (extraModel.getAs() != null) {
					ref.setName(extraModel.getAs());
				}

				genAll.addExtraModel(extraModel.getStep(), ref);
			}
			genAll.runImpl(action);
			
			if (!genAll.isSuccessful()) {
				throw new BuildException(GenerateAllDelegate.ERROR_MESSAGE);
			}
			
		} catch (Exception e) {
			throw new BuildException(e);
		}
	}

}
