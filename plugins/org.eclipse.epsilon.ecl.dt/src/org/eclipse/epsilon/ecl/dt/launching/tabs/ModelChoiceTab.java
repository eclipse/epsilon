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
package org.eclipse.epsilon.ecl.dt.launching.tabs;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.ecl.dt.EclPlugin;
import org.eclipse.epsilon.ecl.dt.launching.EclLaunchConfigurationAttributes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ModelChoiceTab extends AbstractLaunchConfigurationTab implements ModifyListener{
	
	protected Label leftLabel;
	protected Label rightLabel;
	
	protected Combo leftCombo;
	protected Combo rightCombo;
	
	protected Button browse;
	
	public void createControl(Composite parent) {
		
		FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);

		Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		
		GridLayout controlLayout = new GridLayout(2, false);
		GridData comboData = new GridData(GridData.FILL_HORIZONTAL);
		control.setLayout(controlLayout);
		
		leftLabel = new Label(control, SWT.NONE);
		leftLabel.setText("Left model:");
		leftCombo = new Combo(control, SWT.BORDER);
		leftCombo.setLayoutData(comboData);
		
		rightLabel = new Label(control, SWT.NONE);
		rightLabel.setText("Right model:");
		rightCombo = new Combo(control, SWT.BORDER);
		rightCombo.setLayoutData(comboData);
		
		
		leftCombo.addModifyListener(this);
		rightCombo.addModifyListener(this);
		
		control.layout();
		control.pack();
		
		canSave();
		
	}
	
	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		super.activated(workingCopy);
		updateCombos(workingCopy);
	}

	@Override
	public Image getImage() {
		return EclPlugin.getDefault().createImage("icons/modelchoice.gif");
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		updateCombos(configuration);
		try {
			leftCombo.setText(configuration.getAttribute(EclLaunchConfigurationAttributes.LEFT_MODEL, ""));
			rightCombo.setText(configuration.getAttribute(EclLaunchConfigurationAttributes.RIGHT_MODEL,","));
		} catch (CoreException e) {
			return;
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(EclLaunchConfigurationAttributes.LEFT_MODEL, leftCombo.getText());
		configuration.setAttribute(EclLaunchConfigurationAttributes.RIGHT_MODEL, rightCombo.getText());
	}

	public String getName() {
		return "Model Choice";
	}
	
	@Override
	public boolean canSave(){
		
		String errorMessage = "";
		
		if (leftCombo.getText() == ""){
			errorMessage += "left, ";
		}
		
		if (rightCombo.getText() == ""){
			errorMessage += "right, ";
		}
		
		if (errorMessage.length() > 0){
			this.setErrorMessage("Models " + errorMessage + " have not been specified");
			return false;
		}
		else {
			this.setErrorMessage(null);
			return true;
		}
	}
	
	public void modifyText(ModifyEvent e) {
		canSave();
		updateLaunchConfigurationDialog();
	}
	
	public void updateCombos(ILaunchConfiguration configuration){
		List models = new ArrayList();
		
		try {
			models.addAll(configuration.getAttribute("models", new ArrayList()));
		} catch (CoreException e) {
			return;
		}
		
		String[] modelNames = new String[models.size()];
		
		ListIterator li = models.listIterator();
		int i = 0;
		
		while (li.hasNext()){
			StringProperties sp = new StringProperties();
			sp.load(li.next().toString());
			modelNames[i] = sp.getProperty("name");
			i++;
		}
		
		String left = leftCombo.getText();
		String right = rightCombo.getText();
		
		leftCombo.setItems(modelNames);
		rightCombo.setItems(modelNames);
		
		leftCombo.setText(left);
		rightCombo.setText(right);
		
	}
	
}

