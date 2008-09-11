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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.dt.launching.dialogs.AbstractModelConfigurationDialog;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class EmfMetaModelConfigurationDialog extends AbstractModelConfigurationDialog {

	@Override
	protected String getModelType() {
		return "EMF_M2";
	}
	
	protected Label metaModelUriLabel;
	protected Combo metaModelUriCombo;
	
	public EmfMetaModelConfigurationDialog(){
		super();
	}
	
	@Override
	protected String getModelName() {
		return "EMF meta-model";
	}
	
	@Override
	protected void createGroups(Composite control) {
		createNameAliasGroup(control);
		createFilesGroup(control);
	}
	
	protected Composite createFilesGroup(Composite parent) {
		final Composite groupContent = createGroupContainer(parent, "Files/URIs", 3);
		
		metaModelUriLabel = new Label(groupContent, SWT.NONE);
		metaModelUriLabel.setText("Meta-model URI: ");
		
		metaModelUriCombo = new Combo(groupContent, SWT.BORDER|SWT.READ_ONLY);
		
		for (String key : EPackage.Registry.INSTANCE.keySet()){
			metaModelUriCombo.add(key);
		}
		
		metaModelUriCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Label emptyLabel = new Label(groupContent, SWT.NONE);
		emptyLabel.setText("");
		
		groupContent.layout();
		groupContent.pack();
		return groupContent;
	}

	
	@Override
	protected void loadProperties(){
		super.loadProperties();
		if (properties == null) return;
		metaModelUriCombo.setText(properties.getProperty(EmfModel.PROPERTY_METAMODEL_URI));
	}
	
	@Override
	protected void storeProperties(){
		super.storeProperties();
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metaModelUriCombo.getText());
	}

}
