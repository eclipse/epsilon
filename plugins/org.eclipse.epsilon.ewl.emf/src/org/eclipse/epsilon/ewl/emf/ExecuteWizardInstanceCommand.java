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
package org.eclipse.epsilon.ewl.emf;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.ewl.execute.WizardInstance;

public class ExecuteWizardInstanceCommand implements Command{
	
	protected WizardInstance wizardInstance = null;
	protected List<InMemoryEmfModel> models = null;
	protected ChangeDescription changeDescription;
	protected WorkbenchPartRefresher refresher;
	
	public ExecuteWizardInstanceCommand(WizardInstance wizardInstance, List<InMemoryEmfModel> models, WorkbenchPartRefresher refresher) {
		super();
		this.wizardInstance = wizardInstance;
		this.models = models;
		this.refresher = refresher;
	}

	public void execute() {
		// Record changes only for the domain model (the first one): the others are assumed to be extra models (e.g. diagram models)
		ChangeRecorder recorder = new ChangeRecorder(models.get(0).getModelImpl().getResourceSet());
		try {
			//recorder.beginRecording(model.allInstances());
			wizardInstance.process();
		} catch (EolRuntimeException e) {
			e.printStackTrace(EpsilonConsole.getInstance().getErrorStream());
		}
		finally {
			changeDescription = recorder.endRecording();
			refresher.refresh();
		}
	}

	public void redo() {
		if (changeDescription != null) {
			changeDescription.applyAndReverse();
		}
	}

	public boolean canExecute() {
		return true;
	}

	public boolean canUndo() {
		return true;
	}

	public Command chain(Command command) {
		return null;
	}

	public void dispose() {
		for (InMemoryEmfModel model : models) {
			model.dispose();
		}
		changeDescription = null;
		wizardInstance = null;
	}

	public Collection<?> getAffectedObjects() {
		return Collections.emptyList();
	}

	public String getDescription() {
		return getLabel();
	}

	public String getLabel() {
		try {
			return wizardInstance.getTitle();
		} catch (EolRuntimeException e) {
			return null;
		}
	}

	public Collection<?> getResult() {
		return null;
	}

	public void undo() {
		if (changeDescription != null) {
			changeDescription.applyAndReverse();
		}
	}
	
}
