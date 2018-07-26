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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.eol.models.IModel;

public class EolStandaloneMetamodelByUriExample extends EolStandaloneExample {

	public static void main(String[] args) throws Exception {
		new EolStandaloneMetamodelByUriExample().execute();
	}
	
	@Override
	public List<IModel> getModels() throws Exception {
		EmfUtil.register(URI.createURI(getFileURI("models/Tree.ecore").toString()), EPackage.Registry.INSTANCE);
		List<IModel> models = new ArrayList<IModel>();
		models.add(createEmfModelByURI("Model", "models/Tree.xmi", "TreeDsl", true, true));
		return models;
	}

}
