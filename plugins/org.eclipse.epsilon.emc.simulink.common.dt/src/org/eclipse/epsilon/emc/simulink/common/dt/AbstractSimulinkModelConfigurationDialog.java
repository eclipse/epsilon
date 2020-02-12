/*********************************************************************
* Copyright (c) 2019 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.common.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.common.dt.util.DialogUtil;
import org.eclipse.epsilon.emc.simulink.model.AbstractSimulinkModel;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public abstract class AbstractSimulinkModelConfigurationDialog extends AbstractCachedModelConfigurationDialog{

	//protected Button isSharedButton; 
	//protected Text sessionText;
	//protected Label sessionTextLabel;
	protected Button projectFileBrowser;
	protected Button currentProjectButton;
	protected Button browseModelFile;
	protected Text projectFileText;
	protected Text modelFileText;
	protected Text pathsText;
	protected Label projectFileTextLabel;
	protected Label modelFileTextLabel;
	protected Label pathsTextLabel;
	protected DirectoryFieldEditor workingDirBrowser;
	
	@Override
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFilesGroup(control);
		createEngineGroup(control);
		createLoadStoreOptionsGroup(control);
	}
	
	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = DialogUtil.createGroupContainer(parent, "Model", 3);

		modelFileTextLabel = new Label(groupContent, SWT.NONE);
		modelFileTextLabel.setText("File (?): ");

		modelFileText = new Text(groupContent, SWT.BORDER);
		modelFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse...");
		browseModelFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(modelFileText, "Simulink models in the workspace", "Select a Simulink model"));
		
		projectFileTextLabel = new Label(groupContent, SWT.NONE);
		projectFileTextLabel.setText("Project file (?): ");
		projectFileTextLabel.setToolTipText("Project that the model is part of. Leave blank if none.");

		projectFileText = new Text(groupContent, SWT.BORDER);
		projectFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		projectFileBrowser = new Button(groupContent, SWT.NONE);
		projectFileBrowser.setText("Browse...");
		projectFileBrowser.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(projectFileText, "Simulink models in the workspace", "Select a Project"));
		
		workingDirBrowser = new DirectoryFieldEditor(AbstractSimulinkModel.PROPERTY_WORKING_DIR, "Working directory: ", groupContent);
		
		pathsTextLabel = new Label(groupContent, SWT.NONE);
		pathsTextLabel.setText("Additional paths (?): ");
		pathsTextLabel.setToolTipText("Colon (;) separated list");

		pathsText = new Text(groupContent, SWT.BORDER);
		pathsText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		new Label(groupContent, SWT.NONE);

		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}
	
	protected Composite createEngineGroup(Composite parent) {
		final Composite groupContent = DialogUtil.createGroupContainer(parent, "MATLAB Engine", 3);
		
		GridData buttonData = new GridData(GridData.FILL_HORIZONTAL);
		buttonData.horizontalSpan = 1;

		/*isSharedButton = new Button(groupContent, SWT.CHECK);
		isSharedButton.setText(" Connect to engine (?)");
		isSharedButton.setSelection(false);
		isSharedButton.setToolTipText("A *shared* MATLAB instance must be running");
		isSharedButton.setLayoutData(buttonData);
		
		sessionTextLabel = new Label(groupContent, SWT.NONE);
		sessionTextLabel.setText("MATLAB Session Name (?): ");
		sessionTextLabel.setToolTipText("If 'connect to shared engine' is enabled, use this field to specify the name of the MATLAB session to connect to");
		
		sessionText = new Text(groupContent, SWT.BORDER);
		sessionText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		*/
		
		currentProjectButton = new Button(groupContent, SWT.CHECK);
		currentProjectButton.setText(" Use current project (?)");
		currentProjectButton.setSelection(false);
		currentProjectButton.setToolTipText("If selected, disregards any specified project file and instead calls an open project in the shared MATLAB session.");
		currentProjectButton.setLayoutData(buttonData);
		
		/*isSharedButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button source = (Button) e.getSource();
				enableSharedEngineRelatedFields();
				if (!source.getSelection()) {
					restoreStateOfNonSharedEngineFields();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				Button source = (Button) e.getSource();
				enableSharedEngineRelatedFields();
				if (!source.getSelection()) {
					restoreStateOfNonSharedEngineFields();
				}
			}
			
		});*/
		currentProjectButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button source = (Button) e.getSource();
				disableOnSelect(source, projectFileText);
				disableOnSelect(source, projectFileBrowser);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				Button source = (Button) e.getSource();
				disableOnSelect(source, projectFileText);
				disableOnSelect(source, projectFileBrowser);
			}
		});
		
		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}
	
	@Override
	protected void loadProperties() {
		super.loadProperties();
		if (properties == null) return;
		projectFileText.setText(properties.getProperty(AbstractSimulinkModel.PROPERTY_SIMULINK_PROJECT, ""));
		modelFileText.setText(properties.getProperty(AbstractSimulinkModel.PROPERTY_FILE));
		workingDirBrowser.setStringValue(properties.getProperty(AbstractSimulinkModel.PROPERTY_WORKING_DIR));
		pathsText.setText(properties.getProperty(AbstractSimulinkModel.PROPERTY_PATHS));
		if (currentProjectButton != null) {
			currentProjectButton.setSelection(properties.getBooleanProperty(AbstractSimulinkModel.PROPERTY_CURRENT_SIMULINK_PROJECT, false));
			if (currentProjectButton.getSelection()) {
				disableOnSelect(currentProjectButton, projectFileText);
				disableOnSelect(currentProjectButton, projectFileBrowser);
			}
		}
		/*if (isSharedButton != null) {
			isSharedButton.setSelection(properties.getBooleanProperty(AbstractSimulinkModel.PROPERTY_MUST_CONNECT, false));
			if (isSharedButton.getSelection()) {
				enableSharedEngineRelatedFields();
			} else {
				restoreStateOfNonSharedEngineFields();
			}
		}
		sessionText.setText(properties.getProperty(AbstractSimulinkModel.PROPERTY_ENGINE_SHARED_SESSION_NAME, ""));
		*/
	}
		
	@Override
	protected void storeProperties() {
		super.storeProperties();
		if (currentProjectButton != null) {
			properties.put(AbstractSimulinkModel.PROPERTY_CURRENT_SIMULINK_PROJECT, currentProjectButton.getSelection() + "");
		}
		/*if (isSharedButton != null) {
			properties.put(AbstractSimulinkModel.PROPERTY_MUST_CONNECT, isSharedButton.getSelection() + "");
		}
		properties.put(AbstractSimulinkModel.PROPERTY_ENGINE_SHARED_SESSION_NAME, sessionText.getText());*/
		properties.put(AbstractSimulinkModel.PROPERTY_SIMULINK_PROJECT, projectFileText.getText());
		properties.put(AbstractSimulinkModel.PROPERTY_FILE, modelFileText.getText());
		properties.put(AbstractSimulinkModel.PROPERTY_WORKING_DIR, workingDirBrowser.getStringValue());
		properties.put(AbstractSimulinkModel.PROPERTY_PATHS, pathsText.getText());
	}
	
	/** HELPERS */
	
	protected void enableSharedEngineRelatedFields() {
		//enableOnSelect(isSharedButton, sessionText);
		//enableOnSelect(isSharedButton, currentProjectButton);
	}
	
	protected void restoreStateOfNonSharedEngineFields() {
		currentProjectButton.setSelection(false);
		currentProjectButton.setEnabled(false);
		projectFileText.setEnabled(true);
		projectFileText.setEditable(true);
		projectFileBrowser.setEnabled(true);
	}
	
	protected void enableOnSelect(Button source, Text targetText) {
		if (source.getSelection()) {	
			targetText.setEnabled(true);
			targetText.setEditable(true);
		} else {
			targetText.setEditable(false);
			targetText.setEnabled(false);
		}
	}
	protected void disableOnSelect(Button source, Text targetText) {
		if (!source.getSelection()) {	
			targetText.setEnabled(true);
			targetText.setEditable(true);
		} else {
			targetText.setEditable(false);
			targetText.setEnabled(false);
		}
	}
	
	protected void enableOnSelect(Button source, Button targetButton) {
		if (source.getSelection()) {					
			targetButton.setEnabled(true);
		} else {
			targetButton.setEnabled(false);
		}
	}
	
	protected void disableOnSelect(Button source, Button targetButton) {
		if (!source.getSelection()) {					
			targetButton.setEnabled(true);
		} else {
			targetButton.setEnabled(false);
		}
	}
}
