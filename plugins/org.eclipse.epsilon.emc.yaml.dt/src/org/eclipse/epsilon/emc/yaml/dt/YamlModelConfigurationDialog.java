/*******************************************************************************
 * Copyright (c) 2022 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Ionut Predoaia - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.yaml.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.common.dt.util.DialogUtil;
import org.eclipse.epsilon.emc.yaml.YamlProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class YamlModelConfigurationDialog extends AbstractCachedModelConfigurationDialog {

	protected Label fileTextLabel;
	protected Text fileText;
	protected Label uriTextLabel;
	protected Text uriText;
	protected Button browseModelFile;
	protected Button filebasedButton;

	protected String getModelName() {
		return "YAML Document";
	}

	protected String getModelType() {
		return "YAML";
	}

	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFilesGroup(control);
		createLoadStoreOptionsGroup(control);
		toggleEnabledFields();
	}

	protected void toggleEnabledFields() {
		if (filebasedButton.getSelection()) {
			fileTextLabel.setEnabled(true);
			fileText.setEnabled(true);
			uriTextLabel.setEnabled(false);
			uriText.setEnabled(false);
			uriText.setText("");
		}
		else {
			fileTextLabel.setEnabled(false);
			fileText.setEnabled(false);
			uriTextLabel.setEnabled(true);
			uriText.setEnabled(true);
			fileText.setText("");
			storeOnDisposalCheckbox.setSelection(false);
		}
	}
	
	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = DialogUtil.createGroupContainer(parent, "Files/URIs", 3);
		
		filebasedButton = new Button(groupContent, SWT.CHECK);
		GridData filebasedButtonGridData = new GridData(GridData.FILL_HORIZONTAL);
		filebasedButtonGridData.horizontalSpan = 3;
		filebasedButton.setSelection(true);
		filebasedButton.setText("Workspace file");
		filebasedButton.setLayoutData(filebasedButtonGridData);
		filebasedButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				toggleEnabledFields();
			}
		});
		
		fileTextLabel = new Label(groupContent, SWT.NONE);
		fileTextLabel.setText("File: ");
		
		fileText = new Text(groupContent, SWT.BORDER);
		fileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse Workspace...");
		browseModelFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(fileText, "YAML Documents in the workspace", "Select an YAML document"));

		uriTextLabel = new Label(groupContent, SWT.NONE);
		uriTextLabel.setText("URI: ");
		
		uriText = new Text(groupContent, SWT.BORDER);
		GridData uriTextGridData = new GridData(GridData.FILL_HORIZONTAL);
		uriTextGridData.horizontalSpan = 2;
		uriText.setLayoutData(uriTextGridData);
		
		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}
	
	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;
		fileText.setText(properties.getProperty(YamlProperty.PROPERTY_FILE));
		filebasedButton.setSelection(properties.getBooleanProperty("fileBased", true));
		toggleEnabledFields();
	}
	
	protected void storeProperties(){
		super.storeProperties();
		properties.put(YamlProperty.PROPERTY_FILE, fileText.getText());
		properties.put("fileBased", filebasedButton.getSelection() + "");
	}
}