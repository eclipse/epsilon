package org.eclipse.epsilon.emc.uml.dt;

import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractCachedModelConfigurationDialog;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.dt.EmfModelConfigurationDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.UMLPackage;

public class UmlModelConfigurationDialog extends AbstractCachedModelConfigurationDialog {
	
	protected Button expandButton;
	protected Text modelFileText;
	
	@Override
	protected void createGroups(Composite control) {
		super.createGroups(control);
		createEmfGroup(control);
		createFilesGroup(control);
		createLoadStoreOptionsGroup(control);
	}
	
	protected void createEmfGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "EMF", 3);
	
		expandButton = new Button(groupContent, SWT.CHECK);
		expandButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		expandButton.setText("Include external references");
		expandButton.setSelection(true);
	
		GridData expandButtonData = new GridData();
		expandButtonData.horizontalSpan = 2;
		expandButton.setLayoutData(expandButtonData);
		
		groupContent.layout();
		groupContent.pack();
	}
	
	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Files/URIs", 3);
		((GridData)groupContent.getParent().getLayoutData()).grabExcessVerticalSpace = true;

		final Label modelFileLabel = new Label(groupContent, SWT.NONE);
		modelFileLabel.setText("Model file: ");
		
		modelFileText = new Text(groupContent, SWT.BORDER);
		modelFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		final Button browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse Workspace...");
		browseModelFile.addListener(SWT.Selection, 
				new BrowseWorkspaceForModelsListener(modelFileText, "UML models in the workspace", "Select a UML model"));
		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}
	
	@Override
	protected String getModelName() {
		return "UML model";
	}
	
	@Override
	protected String getModelType() {
		return "UML";
	}
	
	@Override
	protected void loadProperties() {
		super.loadProperties();
		if (properties == null) return;
		modelFileText.setText(properties.getProperty(EmfModel.PROPERTY_MODEL_FILE));
		expandButton.setSelection(new Boolean(properties.getProperty(EmfModel.PROPERTY_EXPAND)).booleanValue());
	}
	
	@Override
	protected void storeProperties() {
		super.storeProperties();
		properties.put(EmfModel.PROPERTY_MODEL_FILE, modelFileText.getText());
		properties.put(EmfModel.PROPERTY_EXPAND, expandButton.getSelection() + "");
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, UMLPackage.eINSTANCE.getNsURI());
	}
	
	
}
