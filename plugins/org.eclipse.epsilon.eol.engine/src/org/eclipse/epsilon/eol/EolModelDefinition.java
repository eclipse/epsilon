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
package org.eclipse.epsilon.eol;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.util.ListSet;

public class EolModelDefinition extends AbstractModuleElement {

	protected String model;
	
	public List<?> getChildren() {
		return Collections.emptyList();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof EolModelDefinition) {
			return ((EolModelDefinition) obj).getModel().equals(this.getModel());
		}
		return false;
	}

	public static void main(String[] args) {
		Set<EolModelDefinition> s = new ListSet<EolModelDefinition>();
		
		EolModelDefinition m1 = new EolModelDefinition();
		m1.setModel("M");
		
		EolModelDefinition m2 = new EolModelDefinition();
		m2.setModel("M1");
		
		s.add(m1);
		s.add(m2);
		s.add(null);
		
		System.err.println(s.size());
	}
	
}
