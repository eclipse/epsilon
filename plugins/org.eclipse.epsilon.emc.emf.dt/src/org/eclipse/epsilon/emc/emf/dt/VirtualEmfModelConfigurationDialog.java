/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.emf.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.common.dt.util.DialogUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class VirtualEmfModelConfigurationDialog extends AbstractCachedModelConfigurationDialog {

	protected Button browseModelFile;
	protected Text   modelFileText;
	protected Label  modelFileLabel;
	
	@Override
	protected String getModelType() {
		return "V_EMF";
	}
	
	@Override
	protected String getModelName() {
		return "Virtual EMF Model";
	}
	
	@Override
	protected void createGroups(Composite control) {
		createNameAliasGroup(control);
		createFilesGroup(control);
		createLoadStoreOptionsGroup(control);
	}
	
	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = DialogUtil.createGroupContainer(parent, "Files/URIs", 3);
		
		modelFileLabel = new Label(groupContent, SWT.NONE);
		modelFileLabel.setText("Model file: ");
		
		modelFileText = new Text(groupContent, SWT.BORDER);
		modelFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse Workspace...");
		browseModelFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(modelFileText, "EMF models in the workspace", "Select an EMF model"));
		
		Label emptyLabel = new Label(groupContent, SWT.NONE);
		emptyLabel.setText("");
		
		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}
	
	@Override
	protected void createLoadStoreOptionsGroup(Composite parent) {
		final Composite groupContent = DialogUtil.createGroupContainer(parent, "Load/Store Options", 2);
		
		storeOnDisposalLabel = new Label(groupContent, SWT.NONE);
		storeOnDisposalLabel.setText("Store on disposal: ");
		
		storeOnDisposalCheckbox = new Button(groupContent, SWT.CHECK);
		storeOnDisposalCheckbox.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		storeOnDisposalCheckbox.setSelection(true);
		
		groupContent.layout();
		groupContent.pack();
		
	}

	
	@Override
	protected void loadProperties() {
		super.loadProperties();
		if (properties == null) return;
		modelFileText.setText(properties.getProperty(EmfModel.PROPERTY_MODEL_FILE));
	}
	
	@Override
	protected void storeProperties() {
		super.storeProperties();
		properties.put(EmfModel.PROPERTY_MODEL_FILE, modelFileText.getText());
	}
}
