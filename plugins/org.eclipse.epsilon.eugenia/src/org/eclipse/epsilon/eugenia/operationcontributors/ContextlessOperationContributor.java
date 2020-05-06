/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eugenia.operationcontributors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolNoType.EolNoTypeInstance;

public class ContextlessOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof EolNoTypeInstance;
	}
	
	public Object _package(String name) throws Exception {
		IModel ecoreModel = getContext().getModelRepository().getModelByName("Ecore");
		for (Object o : ecoreModel.getAllOfType("EPackage")) {
			if (name.equals(((EPackage) o).getName())) {
				return o;
			}
		}
		throw new EolRuntimeException("Package " + name + " not found in the Ecore metamodel");
	}
	
	public Object _class(String name) throws Exception {
		IModel ecoreModel = getContext().getModelRepository().getModelByName("Ecore");
		for (Object o : ecoreModel.getAllOfType("EClass")) {
			if (name.equals(((EClass) o).getName())) {
				return o;
			}
		}
		throw new EolRuntimeException("Class " + name + " not found in the Ecore metamodel");
	}

}
