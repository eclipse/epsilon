/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.preferences;

import java.util.ArrayList;

import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PictoPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	
	public static final String ID = "org.eclipse.epsilon.picto.preferences.PictoPreferencePage";
	public static final String PROPERTY_RENDER_VERBATIM = "verbatim.sources";
	public static final String TIMEOUT = "external.timeout";
	public static final int DEFAULT_TIMEOUT = 60;
	
	protected final ArrayList<FieldEditor> fieldEditors = new ArrayList<>();
	protected IPreferenceStore preferences = EpsilonCommonsPlugin.getDefault().getPreferenceStore();
	
	public PictoPreferencePage() {
		preferences.setDefault(TIMEOUT, DEFAULT_TIMEOUT);
	}
	
	@Override
	protected Control createContents(Composite parent) {
		final Composite composite = new Composite(parent, SWT.FILL);
		
		final IntegerFieldEditor timeoutEditor = new IntegerFieldEditor(TIMEOUT, "Rendering timeout (seconds)", composite);
		final BooleanFieldEditor verbatimBooleanEditor = new BooleanFieldEditor(PROPERTY_RENDER_VERBATIM, "Render verbatim sources", composite);
		
		fieldEditors.add(verbatimBooleanEditor);
		fieldEditors.add(timeoutEditor);
		
		for (FieldEditor fieldEditor : fieldEditors) {
			fieldEditor.setPreferenceStore(preferences);
			fieldEditor.load();
		}
				
		return composite;
	}
	
	@Override
	public void init(IWorkbench workbench) {
		for (FieldEditor fieldEditor : fieldEditors) {
			fieldEditor.load();
		}
	}
	
	@Override
	public boolean performOk() {
		for (FieldEditor fieldEditor : fieldEditors) {
			fieldEditor.store();
		}
		return true;
	}

}
