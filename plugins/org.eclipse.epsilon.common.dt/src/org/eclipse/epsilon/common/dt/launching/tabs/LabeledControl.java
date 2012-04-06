/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.launching.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;

public abstract class LabeledControl extends Composite {
	
	protected Label label;
	protected Control labeled;
	
	public LabeledControl(Composite parent, int style, String labelText) {
		super(parent, style);
	
		this.setLayout(new GridLayout(2, false));
		
		label = new Label(this, SWT.NONE);
		label.setText(labelText);
		
		labeled = createLabeled(this);
		GridData labeledData = new GridData(GridData.FILL_HORIZONTAL);
		labeled.setLayoutData(labeledData);
		
	}

	protected abstract Control createLabeled(Composite parent);

	public Control getLabeled() {
		return labeled;
	}
	
	public Label getLabel() {
		return label;
	}
	
}