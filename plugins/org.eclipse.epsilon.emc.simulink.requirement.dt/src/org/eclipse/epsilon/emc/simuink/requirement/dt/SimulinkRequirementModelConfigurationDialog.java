package org.eclipse.epsilon.emc.simuink.requirement.dt;
/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/


import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.common.dt.util.DialogUtil;
import org.eclipse.epsilon.emc.simulink.model.AbstractSimulinkModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SimulinkRequirementModelConfigurationDialog extends AbstractCachedModelConfigurationDialog {

	protected String getModelName() {
		return "Simulink Dictionary Model";
	}

	protected String getModelType() {
		return "SimulinkDictionary";
	}

	protected Label fileTextLabel;
	protected Text fileText;
	protected Button browseModelFile;

	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFilesGroup(control);
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
		browseModelFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(fileText, "Simulink Dictionary Models in the workspace", "Select a Simulink Dictionary Model"));

		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}

	protected void loadProperties() {
		super.loadProperties();
		if (properties == null) return;
		fileText.setText(properties.getProperty(AbstractSimulinkModel.PROPERTY_FILE));
	}

	protected void storeProperties() {
		super.storeProperties();
		
		properties.put(AbstractSimulinkModel.PROPERTY_FILE, fileText.getText());
	}
	
}
