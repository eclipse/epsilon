package org.eclipse.epsilon.emc.plainxml.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PlainXmlModelConfigurationDialog extends AbstractModelConfigurationDialog {

	@Override
	protected String getModelName() {
		return "Plain XML document";
	}

	@Override
	protected String getModelType() {
		return "PlainXML";
	}
	
	protected Label fileTextLabel;
	protected Text fileText;
	protected Label uriTextLabel;
	protected Text uriText;
	protected Button browseModelFile;
	
	
	@Override
	protected void createGroups(Composite control) {
		createNameAliasGroup(control);
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

	
	@Override
	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;
		fileText.setText(properties.getProperty(PlainXmlModel.PROPERTY_FILE));
		uriText.setText(properties.getProperty(PlainXmlModel.PROPERTY_URI));
	}
	
	@Override
	protected void storeProperties(){
		super.storeProperties();
		properties.put(PlainXmlModel.PROPERTY_URI, uriText.getText());
		properties.put(PlainXmlModel.PROPERTY_FILE, fileText.getText());
	}
}
