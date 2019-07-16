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

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.common.dt.util.DialogUtil;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SimulinkModelConfigurationDialog extends AbstractCachedModelConfigurationDialog {

	protected String getModelName() {
		return "Simulink Model";
	}

	protected String getModelType() {
		return "Simulink";
	}

	protected Label fileTextLabel;
	protected Text fileText;
	protected Button browseModelFile;

	protected DirectoryFieldEditor workingDirBrowser;
	
	protected Label pathsTextLabel;
	protected Text pathsText;
	
	protected Label showInMatlabEditorLabel;
	protected Button showInMatlabEditorCheckbox;

	protected Label followLinksLabel;
	protected Button followLinksCheckbox;

	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFilesGroup(control);
		createDisplayGroup(control);
		createLoadStoreOptionsGroup(control);
	}

	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = DialogUtil.createGroupContainer(parent, "Files/URIs", 3);

		fileTextLabel = new Label(groupContent, SWT.NONE);
		fileTextLabel.setText("File: ");

		fileText = new Text(groupContent, SWT.BORDER);
		fileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse Workspace...");
		browseModelFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(fileText, "Simulink models in the workspace", "Select a Simulink model"));

		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}

	protected Composite createDisplayGroup(Composite parent) {
		final Composite matlabGroupContent = DialogUtil.createGroupContainer(parent, "MATLAB options", 3);

		workingDirBrowser = new DirectoryFieldEditor(SimulinkModel.PROPERTY_WORKING_DIR, "Working directory: ", matlabGroupContent);

		pathsTextLabel = new Label(matlabGroupContent, SWT.NONE);
		pathsTextLabel.setText("Paths: ");
		pathsTextLabel.setToolTipText("Colon (;) separated list");

		pathsText = new Text(matlabGroupContent, SWT.BORDER);
		pathsText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		new Label(matlabGroupContent, SWT.NONE);

		showInMatlabEditorLabel = new Label(matlabGroupContent, SWT.NONE);
		showInMatlabEditorLabel.setText("Force MATLAB to open (?): ");
		showInMatlabEditorLabel.setToolTipText("If selected, the model will be shown in the MATLAB Editor. "
				+ "If the model is already loaded, it will not open it again. "
				+ "If unchecked, the model will not be open in the MATLAB editor, "
				+ "but won't close an already open model");

		showInMatlabEditorCheckbox = new Button(matlabGroupContent, SWT.CHECK);
		showInMatlabEditorCheckbox.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		showInMatlabEditorCheckbox.setSelection(false);

		new Label(matlabGroupContent, SWT.NONE);
		
		followLinksLabel = new Label(matlabGroupContent, SWT.NONE);
		followLinksLabel.setText("Follow Block Links (?): ");
		followLinksLabel.setToolTipText("Set the 'FollowLinks' flag to 'on' of the 'find_system' method "
				+ "used when calling all elements of a type in Epsilon e.g. ModelType.all;");
		
		followLinksCheckbox = new Button(matlabGroupContent, SWT.CHECK);
		followLinksCheckbox.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		followLinksCheckbox.setSelection(false);

		matlabGroupContent.layout();
		matlabGroupContent.pack();
		return matlabGroupContent;
	}

	protected void loadProperties() {
		super.loadProperties();
		if (properties == null) return;
		if (showInMatlabEditorCheckbox != null) {
			showInMatlabEditorCheckbox.setSelection(new Boolean(properties.getProperty(SimulinkModel.PROPERTY_SHOW_IN_MATLAB_EDITOR,"true")).booleanValue());
		}
		if (followLinksCheckbox != null) {
			followLinksCheckbox.setSelection(new Boolean(properties.getProperty(SimulinkModel.PROPERTY_FOLLOW_LINKS,"true")).booleanValue());
		}
		fileText.setText(properties.getProperty(SimulinkModel.PROPERTY_FILE));
		workingDirBrowser.setStringValue(properties.getProperty(SimulinkModel.PROPERTY_WORKING_DIR));
		pathsText.setText(properties.getProperty(SimulinkModel.PROPERTY_PATHS));
	}

	protected void storeProperties() {
		super.storeProperties();
		if (showInMatlabEditorCheckbox != null) {
			properties.put(SimulinkModel.PROPERTY_SHOW_IN_MATLAB_EDITOR, showInMatlabEditorCheckbox.getSelection() + "");
		}
		if (followLinksCheckbox != null) {
			properties.put(SimulinkModel.PROPERTY_FOLLOW_LINKS, followLinksCheckbox.getSelection() + "");
		}
		properties.put(SimulinkModel.PROPERTY_FILE, fileText.getText());
		properties.put(SimulinkModel.PROPERTY_WORKING_DIR, workingDirBrowser.getStringValue());
		properties.put(SimulinkModel.PROPERTY_PATHS, pathsText.getText());
	}
	
}
