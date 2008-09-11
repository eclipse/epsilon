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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.dt.util.ResourceFieldEditor;
import org.eclipse.epsilon.util.emf.BrowseEPackagesListener;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
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
	protected Rectangle getConstrainedShellBounds(Rectangle preferredSize) {
		preferredSize.height = 210;
		return super.getConstrainedShellBounds(preferredSize);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		
		Composite zuper = (Composite) super.createDialogArea(parent);
		
		GridData fillData = new GridData(GridData.FILL_BOTH);
		
		
		Composite composite = new Composite(zuper, SWT.FILL);
		composite.setLayoutData(fillData);
		
		composite.setLayout(new GridLayout(1, false));
		
		setTitle("Configure wizards");
		getShell().setText("GMF Wizards");
		setMessage("Configure wizards for an EMF namespace URI");
		
		
		final Composite c1 = new Composite(composite, SWT.FILL);
		extensionEditor = new StringFieldEditor("", "Namespace URI", c1);
		c1.setLayoutData(fillData);
		
		//Button browseMetamodelUri = new Button(c1, SWT.NONE);
		//browseMetamodelUri.setText("Browse EPackages...");
		//extensionEditor.getTextControl(c1).addListener(SWT.Activate, new BrowseEPackagesListener() {

		//	@Override
		//	public void selectionChanged(EPackage ePackage) {
		//		extensionEditor.getTextControl(c1).setText(ePackage.getNsURI());
		//	}
			
		//});
		
		Collection<String> namespaceURIs = new ArrayList<String>();
		
		for (Object value : EPackage.Registry.INSTANCE.values()) {
			if (value instanceof EPackage) {
				namespaceURIs.add(((EPackage) value).getNsURI());
			}
		}
		
		String[] arr = new String[namespaceURIs.size()];
		int i = 0;
		for (String namespaceUri : namespaceURIs) {
			arr[i] = namespaceUri;
			i++;
		}
		
		ContentProposalAdapter adapter = new ContentProposalAdapter(
				extensionEditor.getTextControl(c1), 
				new TextContentAdapter(), 
				new SimpleContentProposalProvider(arr),
				null, 
				null);
		
		//browseMetamodelUri.setLayoutData(fillData);
		
		Composite c2 = new Composite(composite, SWT.FILL);
		wizardsEditor = new ResourceFieldEditor("", "Wizards", "EWL Files", "EWL files in the workspace", "ewl", c2);
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
