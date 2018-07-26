/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.examples.standalone.eol;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.examples.standalone.EpsilonStandaloneExample;
import org.eclipse.uml2.uml.UMLPackage;

public class EolStandaloneUmlExample extends EpsilonStandaloneExample{
	
	public static void main(String[] args) throws Exception {
		new EolStandaloneUmlExample().execute();
	}
	
	@Override
	public IEolModule createModule() {
		return new EolModule();
	}

	@Override
	public List<IModel> getModels() throws Exception {
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		System.err.println(UMLPackage.eNS_URI);
		List<IModel> models = new ArrayList<IModel>();
		models.add(createEmfModelByURI("Model", "models/example.uml", UMLPackage.eNS_URI, true, true));
		return models;
	}
	
	@Override
	public String getSource() throws Exception {
		return "eol/Uml.eol";
	}

	@Override
	public void postProcess() {
		
	}
}
