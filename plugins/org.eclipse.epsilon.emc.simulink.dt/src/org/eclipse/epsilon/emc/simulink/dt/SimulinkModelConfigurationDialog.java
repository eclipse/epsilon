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
package org.eclipse.epsilon.emc.simulink.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.emc.simulink.SimulinkModel;
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
	
	
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createFilesGroup(control);
		createLoadStoreOptionsGroup(control);
	}
	
	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Files/URIs", 3);
		
		fileTextLabel = new Label(groupContent, SWT.NONE);
		fileTextLabel.setText("File: ");
		
		fileText = new Text(groupContent, SWT.BORDER);
		fileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse Workspace...");
		browseModelFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener(fileText, "XML Documents in the workspace", "Select an XML document"));
		
		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}
	
	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;
		fileText.setText(properties.getProperty(SimulinkModel.PROPERTY_FILE));
	}
	
	
	protected void storeProperties(){
		super.storeProperties();
		properties.put(SimulinkModel.PROPERTY_FILE, fileText.getText());
	}
}
