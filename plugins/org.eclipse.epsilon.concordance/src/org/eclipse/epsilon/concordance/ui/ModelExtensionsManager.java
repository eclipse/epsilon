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

package org.eclipse.epsilon.concordance.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

import org.eclipse.epsilon.concordance.Activator;

public class ModelExtensionsManager {
	
	protected static ModelExtensionsManager instance;

	protected ArrayList<String> extensions = new ArrayList<String>();
	
	public ArrayList<String> getExtensions() {
		ArrayList<String> metamodels = new ArrayList();
		String concat = Activator.getDefault().getPreferenceStore()
				.getString("extensions");
		StringTokenizer st = new StringTokenizer(concat, ";");
		while (st.hasMoreTokens()) {
			metamodels.add(st.nextToken());
		}
		
		if (metamodels.isEmpty()) {
			metamodels.add("ecore");
			metamodels.add("uml");
			metamodels.add("model");
			metamodels.add("xmi");
			metamodels.add("ecore_diagram");
		}
		
		return metamodels;
	}

	public void setExtensions(ArrayList<String> extensions) {
		StringBuffer sb = new StringBuffer();
		ListIterator li = extensions.listIterator();
		while (li.hasNext()) {
			sb.append(li.next());
			if (li.hasNext()) {
				sb.append(";");
			}
		}
		Activator.getDefault().getPreferenceStore().setValue("extensions",
				sb.toString());
	}

	public static ModelExtensionsManager getInstance() {
		if (instance == null) {
			instance = new ModelExtensionsManager();
		}
		return instance;
	}
	
}
 