/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.dt;

import static org.eclipse.epsilon.emc.simulink.util.SearchPreferences.PROPERTY_FOLLOW_LINKS;
import static org.eclipse.epsilon.emc.simulink.util.SearchPreferences.PROPERTY_INCLUDE_COMMENTED;
import static org.eclipse.epsilon.emc.simulink.util.SearchPreferences.PROPERTY_LOOK_UNDER_MASKS;

import java.util.ArrayList;

import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.emc.simulink.util.SearchPreferences;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class SimulinkSearchPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	protected final ArrayList<FieldEditor> fieldEditors = new ArrayList<>();
	protected IPreferenceStore preferences = EpsilonCommonsPlugin.getDefault().getPreferenceStore();

	@Override
	protected Control createContents(Composite parent) {

		final Composite composite = new Composite(parent, SWT.FILL);
		
		// BooleanFieldEditor lookUnderMasksFieldEditor = new
		// BooleanFieldEditor(PROPERTY_LOOK_UNDER_MASKS, "Look Under Masks", composite);
		String[][] LookUnderMasksValues = new String[][] { { "None", "none" }, { "Graphical", "graphical" },
				{ "All", "all" }, { "Functional", "functional" }, { "On", "on" }, { "Off", "off" } };
		ComboFieldEditor lookUnderMasksFieldEditor = new ComboFieldEditor(PROPERTY_LOOK_UNDER_MASKS, "Look Under Masks",
				LookUnderMasksValues, composite);

		BooleanFieldEditor followLinksFieldEditor = new BooleanFieldEditor(PROPERTY_FOLLOW_LINKS, "Follow Links",
				composite);

		BooleanFieldEditor includeCommentedFieldEditor = new BooleanFieldEditor(PROPERTY_INCLUDE_COMMENTED,
				"Include Commented", composite);

		fieldEditors.add(followLinksFieldEditor);
		fieldEditors.add(lookUnderMasksFieldEditor);
		fieldEditors.add(includeCommentedFieldEditor);

		for (FieldEditor fieldEditor : fieldEditors) {
			fieldEditor.setPreferenceStore(preferences);
			fieldEditor.load();
		}

		return composite;
	}

	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	protected void performApply() {
		super.performApply();
		SearchPreferences searchPrefs = SearchPreferences.getInstance();
		searchPrefs.setFollowLinks(preferences.getBoolean(PROPERTY_FOLLOW_LINKS));
		searchPrefs.setLookUnderMasks(preferences.getString(PROPERTY_LOOK_UNDER_MASKS));
		searchPrefs.setIncludeCommented(preferences.getBoolean(PROPERTY_INCLUDE_COMMENTED));
	}

	@Override
	public boolean performOk() {
		super.performOk();
		for (FieldEditor fieldEditor : fieldEditors) {
			fieldEditor.store();
		}
		return true;
	}

}
