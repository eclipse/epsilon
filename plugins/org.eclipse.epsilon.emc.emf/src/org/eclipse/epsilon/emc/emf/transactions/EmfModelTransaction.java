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
package org.eclipse.epsilon.emc.emf.transactions;

import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.eol.models.transactions.IModelTransaction;

public class EmfModelTransaction implements IModelTransaction {
	
	protected ChangeRecorder changeRecorder;
	protected AbstractEmfModel model;
	
	public EmfModelTransaction(AbstractEmfModel model) {
		this.model = model;
	}
	
	public void start() {
		if (model.getModelImpl().getResourceSet() != null) {
			this.changeRecorder = new ChangeRecorder(model.getModelImpl().getResourceSet());	
		}
		else {
			this.changeRecorder = new ChangeRecorder(model.getModelImpl());		
		}
	}
	
	public void commit() {
		if (changeRecorder != null) {
			changeRecorder.endRecording();
			changeRecorder = null;
		}
	}
	
	public void rollback() {
		if (changeRecorder != null) {
			changeRecorder.endRecording().applyAndReverse();
			model.clearCache();
			changeRecorder = null;
		}
	}
	
	public void dispose() {
		this.model = null;
	}
}
