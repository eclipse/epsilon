package org.eclipse.epsilon.emc.emf.decorator.dt;
import org.eclipse.epsilon.emc.emf.dt.EmfModelConfigurationDialog;
import org.eclipse.swt.widgets.Composite;

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

public class DecoratorEmfModelConfigurationDialog extends EmfModelConfigurationDialog {

	@Override
	protected String getModelName() {
		return "EMF Decorator Model";
	}

	@Override
	protected String getModelType() {
		return "EMFDecorator";
	}
	
	@Override
	protected void createEmfGroup(Composite parent) {
		super.createEmfGroup(parent);
		expandButton.setSelection(false);
		expandButton.setEnabled(false);
	}
}
 