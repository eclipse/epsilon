/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.simulink.dt;

import org.eclipse.epsilon.emc.simulink.common.dt.AbstractSimulinkModelConfigurationDialog;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SimulinkModelConfigurationDialog extends AbstractSimulinkModelConfigurationDialog {

	@Override
	protected String getModelName() {
		return "Simulink Model";
	}

	@Override
	protected String getModelType() {
		return "Simulink";
	}

	protected Button currentSimulinkCheckbox;
	protected Button showInMatlabEditorCheckbox;
	protected Label followLinksLabel;
	protected Button followLinksCheckbox;
	
	@Override
	protected Composite createFilesGroup(Composite parent) {
		Composite createFilesGroup = super.createFilesGroup(parent);
		modelFileTextLabel.setText("Model file: ");
		
		followLinksLabel = new Label(createFilesGroup, SWT.NONE);
		followLinksLabel.setText("Follow Block Links: ");
		followLinksLabel.setToolTipText("Set the 'FollowLinks' flag to 'on' of the 'find_system' method "
				+ "used when calling all elements of a type in Epsilon e.g. ModelType.all;");
		
		followLinksCheckbox = new Button(createFilesGroup, SWT.CHECK);
		followLinksCheckbox.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		followLinksCheckbox.setSelection(false);
		
		createFilesGroup.layout();
		createFilesGroup.pack();
		return createFilesGroup;
	}
	
	@Override
	protected Composite createEngineGroup(Composite parent) {
		Composite engineGroup = super.createEngineGroup(parent);
		
		GridData buttonData = new GridData(GridData.FILL_HORIZONTAL);
		buttonData.horizontalSpan = 1;

		currentSimulinkCheckbox = new Button(engineGroup, SWT.CHECK);
		currentSimulinkCheckbox.setText(" Use current model");
		currentSimulinkCheckbox.setSelection(false);
		currentSimulinkCheckbox.setToolTipText("If selected, disregards any specified simulink model file and instead works with the current open model in a shared MATLAB session.");
		currentSimulinkCheckbox.setLayoutData(buttonData);
		
		currentSimulinkCheckbox.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button source = (Button) e.getSource();
				disableOnSelect(source, modelFileText);
				disableOnSelect(source, browseModelFile);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				Button source = (Button) e.getSource();
				disableOnSelect(source, modelFileText);
				disableOnSelect(source, browseModelFile);
			}
		});
		
		showInMatlabEditorCheckbox = new Button(engineGroup, SWT.CHECK);
		showInMatlabEditorCheckbox.setSelection(false);
		showInMatlabEditorCheckbox.setText(" Force MATLAB to open");		
		showInMatlabEditorCheckbox.setToolTipText("If selected, the model will be shown in the MATLAB Editor. "
				+ "If the model is already loaded, it will not open it again. "
				+ "If unchecked, the model will not be open in the MATLAB editor, "
				+ "but won't close an already open model");

		showInMatlabEditorCheckbox.setLayoutData(buttonData);
				
		engineGroup.layout();
		engineGroup.pack();
		return engineGroup;
	}
	
	@Override
	protected void restoreStateOfNonSharedEngineFields() {
		super.restoreStateOfNonSharedEngineFields();
		currentSimulinkCheckbox.setEnabled(false);
		currentSimulinkCheckbox.setSelection(false);
		modelFileText.setEnabled(true);
		modelFileText.setEditable(true);
		browseModelFile.setEnabled(true);
		showInMatlabEditorCheckbox.setEnabled(true);
	}
	
	@Override
	protected void enableSharedEngineRelatedFields() {
		super.enableSharedEngineRelatedFields();
		//enableOnSelect(isSharedButton, currentSimulinkButton);
		//disableOnSelect(isSharedButton, showInMatlabEditorCheckbox);
	}

	@Override
	protected void loadProperties() {
		super.loadProperties();
		if (properties == null) return;
		if (showInMatlabEditorCheckbox != null) {
			showInMatlabEditorCheckbox.setSelection(new Boolean(properties.getProperty(SimulinkModel.PROPERTY_SHOW_IN_MATLAB_EDITOR,"true")).booleanValue());
		}
		if (currentSimulinkCheckbox != null) {
			currentSimulinkCheckbox.setSelection(new Boolean(properties.getProperty(SimulinkModel.PROPERTY_CURRENT_SIMULINK_MODEL,"false")).booleanValue());
			if (currentSimulinkCheckbox.getSelection()) {
				disableOnSelect(currentSimulinkCheckbox, modelFileText);
				disableOnSelect(currentSimulinkCheckbox, browseModelFile);
			}
		}
		if (followLinksCheckbox != null) {
			followLinksCheckbox.setSelection(new Boolean(properties.getProperty(SimulinkModel.PROPERTY_FOLLOW_LINKS,"true")).booleanValue());
		}
	}

	@Override
	protected void storeProperties() {
		super.storeProperties();
		if (showInMatlabEditorCheckbox != null) {
			properties.put(SimulinkModel.PROPERTY_SHOW_IN_MATLAB_EDITOR, showInMatlabEditorCheckbox.getSelection() + "");
		}
		if (followLinksCheckbox != null) {
			properties.put(SimulinkModel.PROPERTY_FOLLOW_LINKS, followLinksCheckbox.getSelection() + "");
		}
		if (currentSimulinkCheckbox != null) {
			properties.put(SimulinkModel.PROPERTY_CURRENT_SIMULINK_MODEL, currentSimulinkCheckbox.getSelection() + "");
		}
	}
	
}
