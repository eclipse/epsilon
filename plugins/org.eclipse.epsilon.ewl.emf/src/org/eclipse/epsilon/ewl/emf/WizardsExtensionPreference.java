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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;

public class WizardsExtensionPreference {
	
	protected String namespaceURI;
	protected String wizards;
	protected boolean enabled = true;
	protected static final String preferenceKey = "wizards.extension.preference";
	
	public String getNamespaceURI() {
		return namespaceURI;
	}
	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}
	public String getWizards() {
		return wizards;
	}
	public void setWizards(String wizards) {
		this.wizards = wizards;
	}
	
	@Override
	public String toString() {
		return namespaceURI + "@" + wizards + "@" + enabled;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public static WizardsExtensionPreference create(String str) {
		WizardsExtensionPreference w = new WizardsExtensionPreference();
		String[] parts = str.split("@");
		w.setNamespaceURI(parts[0]);
		if (parts.length > 1) w.setWizards(parts[1]);
		if (parts.length > 2) w.setEnabled(Boolean.parseBoolean(parts[2]));
		return w;
	}
	
	public static List<WizardsExtensionPreference> getPreferences() {
		List<WizardsExtensionPreference> preferences = new ArrayList<WizardsExtensionPreference>();
		IPreferenceStore preferenceStore = EwlEmfPlugin.getDefault().getPreferenceStore();
		
		for (String str : StringUtil.toString(preferenceStore.getString(preferenceKey),"").split(";")) {
			if (str.trim().length() > 0) {
				preferences.add(WizardsExtensionPreference.create(str));
			}
		}
		
		return preferences;
	}
	
	public static void storePreferences(List<WizardsExtensionPreference> preferences) {
		IPreferenceStore preferenceStore = EwlEmfPlugin.getDefault().getPreferenceStore();
		String preferenceValue = "";
		
		//Set the new value
		for (WizardsExtensionPreference preference : preferences) {
			preferenceValue = preferenceValue + preference.toString() + ";";
		}
		
		preferenceStore.putValue(preferenceKey, preferenceValue);
		
		try {
			((IPersistentPreferenceStore)preferenceStore).save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
