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
package org.eclipse.epsilon.emc.emf.tools;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.tools.AbstractTool;

public class EmfTool extends AbstractTool{
	
	public void getAllContents(EObject o) {
		
		//System.err.println(o.eAllContents() instanceof List);
		
		Iterator it = o.eAllContents();
		
		while (it.hasNext()) {
			context.getOutputStream().println(it.next());
		}
	}
	
	public void createModel(EObject eObject, String name) {
		IModel model = context.getModelRepository().getModelByNameSafe(name);
		if (model == null) {
			model = new InMemoryEmfModel(name, eObject.eResource());
			context.getModelRepository().addModel(model);
		}
	}
	
	public void registerEPackage(EPackage ePackage) {
		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
	}
	
	public Object validate(EObject eObject) {
		return Diagnostician.INSTANCE.validate(eObject);
	}
	
}
