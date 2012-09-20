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
package org.eclipse.epsilon.ewl.emf;

import org.eclipse.epsilon.common.dt.util.ResourceFieldEditor;
import org.eclipse.epsilon.emf.dt.BrowseEPackagesListener;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class WizardsExtensionPreferenceDialog extends TitleAreaDialog {
	
	protected StringFieldEditor extensionEditor;
	protected ResourceFieldEditor wizardsEditor;
	protected WizardsExtensionPreference preference;
	
	public WizardsExtensionPreferenceDialog(Shell parentShell) {
		super(parentShell);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite zuper = (Composite) super.createDialogArea(parent);
		
		setTitle("Configure wizards");
		getShell().setText("GMF Wizards");
		setMessage("Configure wizards for an EMF namespace URI");
		
		GridLayout layout = new GridLayout(2, false);
		GridData fillData = new GridData(GridData.FILL_BOTH);
		
		final Composite composite = new Composite(zuper, SWT.FILL);

		composite.setLayout(layout);
		composite.setLayoutData(fillData);
		
		final Composite e = new Composite(composite, SWT.FILL);
		e.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		extensionEditor = new StringFieldEditor("", "Namespace URI", e);
		
		extensionEditor.getTextControl(e).setLayoutData(fillData);
		
		Button browseMetamodelUri = new Button(composite, SWT.NONE);
		browseMetamodelUri.setText("Browse EPackages...");
		browseMetamodelUri.addListener(SWT.Selection, new BrowseEPackagesListener() {

			@Override
			public void selectionChanged(String ePackageUri) {
				extensionEditor.getTextControl(e).setText(ePackageUri);
			}
			
		});
		
		Composite c2 = new Composite(composite, SWT.FILL);
		wizardsEditor = new ResourceFieldEditor("", "Wizards", "EWL Files", "EWL files in the workspace", "ewl", c2);
		fillData = new GridData(GridData.FILL_BOTH);
		fillData.horizontalSpan = 2;
		
		c2.setLayoutData(fillData);
		
		extensionEditor.setStringValue(preference.getNamespaceURI());
		wizardsEditor.setStringValue(preference.getWizards());
		
		return composite;
		
	}

	public WizardsExtensionPreference getPreference() {
		return preference;
	}

	public void setPreference(WizardsExtensionPreference preference) {
		this.preference = preference;
	}

	@Override
	protected void okPressed() {
		preference.setNamespaceURI(extensionEditor.getStringValue());
		preference.setWizards(wizardsEditor.getStringValue());
		super.okPressed();
	}
	
}
