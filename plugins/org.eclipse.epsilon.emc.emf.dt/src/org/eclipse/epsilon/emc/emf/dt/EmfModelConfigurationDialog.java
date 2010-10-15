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
package org.eclipse.epsilon.emc.emf.dt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.util.emf.BrowseEPackagesListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class EmfModelConfigurationDialog extends AbstractModelConfigurationDialog {
	 
	//private StringProperties properties;
	//private Label nameLabel;
	//private Text nameText;
	//private Label aliasesLabel;
	//private Text aliasesText;
	//protected Button isMetamodelButton;
	protected Button expandButton;
	protected Button isMetamodelFileBasedButton;
	//protected Button useExtendedMetadataButton;
	protected Button browseModelFile;
	protected Button browseMetamodelFile;
	protected Text modelFileText;
	protected Label metaModelFileLabel;
	protected Text metaModelFileText;
	protected Label metaModelUriLabel;
	//protected Combo metaModelUriCombo;
	protected Text metaModelUriText;
	protected Button browseMetamodelUri;
	protected Label modelFileLabel;
	
	public EmfModelConfigurationDialog(){
		super();
	}
	
	@Override
	protected String getModelName() {
		return "EMF model";
	}
	
	@Override
	protected void createGroups(Composite control) {
		createNameAliasGroup(control);
		createEmfGroup(control);
		createFilesGroup(control);
		createLoadStoreOptionsGroup(control);
		toggleEnabledFields();
	}
	
	protected void createEmfGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "EMF", 3);
		
		//isMetamodelButton = new Button(groupContent, SWT.CHECK);
		//isMetamodelButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//isMetamodelButton.setText("Model is a meta-model");
		//isMetamodelButton.addListener(SWT.Selection, new IsMetaModelListener());
		
		isMetamodelFileBasedButton = new Button(groupContent, SWT.CHECK);
		isMetamodelFileBasedButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		isMetamodelFileBasedButton.setText("Meta-model is file-based");
		isMetamodelFileBasedButton.addListener(SWT.Selection, new IsMetaModelListener());
		isMetamodelFileBasedButton.setSelection(false);
		
		expandButton = new Button(groupContent, SWT.CHECK);
		expandButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		expandButton.setText("Include external references");
		expandButton.setSelection(true);

		//useExtendedMetadataButton = new Button(groupContent, SWT.CHECK);
		//useExtendedMetadataButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//useExtendedMetadataButton.setText("Use extended metadata");
		//useExtendedMetadataButton.setSelection(false);		
		
		//GridData isMetaModelButtonData = new GridData();
		//isMetaModelButtonData.horizontalSpan = 2;
		//isMetamodelButton.setLayoutData(isMetaModelButtonData);
		
		GridData expandButtonData = new GridData();
		expandButtonData.horizontalSpan = 2;
		expandButton.setLayoutData(expandButtonData);
		
		GridData isMetaModelFileBasedButtonData = new GridData();
		isMetaModelFileBasedButtonData.horizontalSpan = 2;
		isMetamodelFileBasedButton.setLayoutData(isMetaModelFileBasedButtonData);

		GridData useExtendedMetadataButtonData = new GridData();
		useExtendedMetadataButtonData.horizontalSpan = 2;
		//useExtendedMetadataButton.setLayoutData(useExtendedMetadataButtonData);

		
		groupContent.layout();
		groupContent.pack();
				
	}
	
	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Files/URIs", 3);
		
		modelFileLabel = new Label(groupContent, SWT.NONE);
		modelFileLabel.setText("Model file: ");
		
		modelFileText = new Text(groupContent, SWT.BORDER);
		modelFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browseModelFile = new Button(groupContent, SWT.NONE);
		browseModelFile.setText("Browse Workspace...");
		browseModelFile.addListener(SWT.Selection, new BrowseWorkspaceForModelsListener
				(modelFileText, "EMF models in the workspace", "Select an EMF model") {
			@Override
			public void handleEvent(Event event) {
				super.handleEvent(event);
				System.err.println("Here!");
				Collection<EPackage> ePackages = findEPackages(modelFileText.getText());
				if (ePackages.size() > 0) {
					if (!isMetamodelFileBasedButton.getSelection())
						metaModelUriText.setText(getEPackagesUris(ePackages));
				}
			}
		});
		
		metaModelFileLabel = new Label(groupContent, SWT.NONE);
		metaModelFileLabel.setText("Meta-model file: ");
		
		metaModelFileText = new Text(groupContent, SWT.BORDER);
		metaModelFileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		browseMetamodelFile = new Button(groupContent, SWT.NONE);
		browseMetamodelFile.setText("Browse Workspace...");
		browseMetamodelFile.addListener(SWT.Selection, new BrowseWorkspaceForMetaModelsListener(metaModelFileText));
		
		metaModelUriLabel = new Label(groupContent, SWT.NONE);
		metaModelUriLabel.setText("Meta-model URI: ");
		
		metaModelUriText = new Text(groupContent, SWT.BORDER);
		metaModelUriText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		browseMetamodelUri = new Button(groupContent, SWT.NONE);
		browseMetamodelUri.setText("Browse EPackages...");
		browseMetamodelUri.addListener(SWT.Selection, new BrowseEPackagesListener() {

			@Override
			public void selectionChanged(String ePackageUri) {
				//ArrayList<EPackage> ePackages = new ArrayList<EPackage>();
				//ePackages.add(ePackage);
				//String str = getEPackagesUris(ePackages);
				
				//if (metaModelUriText.getText().trim().length() > 0) {
				//	metaModelUriText.setText(metaModelUriText.getText() + ", " + str);
				//}
				//else {
					metaModelUriText.setText(ePackageUri);
				//}
			}
			
		});
		
		//metaModelUriCombo = new Combo(groupContent, SWT.BORDER|SWT.READ_ONLY);
		
		//for (String key : EPackage.Registry.INSTANCE.keySet()){
		//	metaModelUriCombo.add(key);
		//}
		
		//metaModelUriCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		//Label emptyLabel = new Label(groupContent, SWT.NONE);
		//emptyLabel.setText("");
		
		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}

	
	class IsMetaModelListener implements Listener{

		public void handleEvent(Event event) {
			toggleEnabledFields();
		}
		
	}
	
	@Override
	protected String getModelType() {
		return "EMF";
	}
	
	@Override
	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;
		modelFileText.setText(properties.getProperty(EmfModel.PROPERTY_MODEL_FILE));
		metaModelFileText.setText(properties.getProperty(EmfModel.PROPERTY_METAMODEL_FILE));
		metaModelUriText.setText(properties.getProperty(EmfModel.PROPERTY_METAMODEL_URI));
		//isMetamodelButton.setSelection(new Boolean(properties.getProperty("isMetamodel")).booleanValue());
		expandButton.setSelection(new Boolean(properties.getProperty(EmfModel.PROPERTY_EXPAND)).booleanValue());
		isMetamodelFileBasedButton.setSelection(new Boolean(properties.getProperty(EmfModel.PROPERTY_IS_METAMODEL_FILE_BASED)).booleanValue());
		//useExtendedMetadataButton.setSelection(new Boolean(properties.getProperty("useExtendedMetadata")).booleanValue());
		toggleEnabledFields();
	}
	
	@Override
	protected void storeProperties(){
		super.storeProperties();
		properties.put(EmfModel.PROPERTY_MODEL_FILE, modelFileText.getText());
		properties.put(EmfModel.PROPERTY_METAMODEL_FILE, metaModelFileText.getText());
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metaModelUriText.getText());
		//properties.put("isMetamodel", isMetamodelButton.getSelection() + "");
		properties.put(EmfModel.PROPERTY_EXPAND, expandButton.getSelection() + "");
		properties.put(EmfModel.PROPERTY_IS_METAMODEL_FILE_BASED, isMetamodelFileBasedButton.getSelection() + "");
		//properties.put("useExtendedMetadata", useExtendedMetadataButton.getSelection() + "");
	}
	
	protected void toggleEnabledFields(){
		/*
		boolean enabled = !isMetamodelButton.getSelection();
		modelFileText.setEnabled(enabled);
		modelFileLabel.setEnabled(enabled);
		browseModelFile.setEnabled(enabled);
		aliasesText.setEnabled(enabled);
		aliasesLabel.setEnabled(enabled);
		*/
		boolean isFileBased = isMetamodelFileBasedButton.getSelection();
		metaModelFileLabel.setEnabled(isFileBased);
		metaModelFileText.setEnabled(isFileBased);
		browseMetamodelFile.setEnabled(isFileBased);
		metaModelUriText.setEnabled(!isFileBased);
		metaModelUriLabel.setEnabled(!isFileBased);
		browseMetamodelUri.setEnabled(!isFileBased);
	}
	
	protected String getEPackagesUris(Collection<EPackage> ePackages) {
		String str = "";
		Iterator<EPackage> it = ePackages.iterator();
		while (it.hasNext()) {
			str = str + it.next().getNsURI();
			if (it.hasNext()) { str = str + ", ";}
		}
		return str;
	}
	
	protected Collection<EPackage> findEPackages(String resourcePath) {
		Set<EPackage> ePackages = new HashSet<EPackage>();
		
		try {
			ResourceSet rs = new ResourceSetImpl();
			Resource r = rs.createResource(URI.createPlatformResourceURI(resourcePath, true));
			r.load(null);
			if (expandButton.getSelection()) {
				EcoreUtil.resolveAll(r);
			}
			for (Resource res : rs.getResources()) {
				Iterator it = res.getAllContents();
				while (it.hasNext()) {
					Object o = it.next();
					if (o instanceof EObject) {
						EObject eObject = (EObject) o;
						ePackages.add(EmfUtil.getTopEPackage(eObject.eClass().getEPackage()));
					}
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		System.err.println(ePackages.size());
		return ePackages;
	}
	
}
