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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.ewl.EwlWizardInstance;

public class ExecuteWizardInstanceCommand implements Command{
	
	protected EwlWizardInstance wizardInstance = null;
	protected InMemoryEmfModel model = null;
	protected ChangeDescription changeDescription;
	protected WorkbenchPartRefresher refresher;
	
	public ExecuteWizardInstanceCommand(EwlWizardInstance wizardInstance, InMemoryEmfModel model, WorkbenchPartRefresher refresher) {
		super();
		this.wizardInstance = wizardInstance;
		this.model = model;
		this.refresher = refresher;
	}

	public void execute() {
		ChangeRecorder recorder = new ChangeRecorder(model.getModelImpl().getResourceSet());
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
		model.dispose();
		changeDescription = null;
		wizardInstance = null;
	}

	public Collection<?> getAffectedObjects() {
		return Collections.EMPTY_LIST;
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
