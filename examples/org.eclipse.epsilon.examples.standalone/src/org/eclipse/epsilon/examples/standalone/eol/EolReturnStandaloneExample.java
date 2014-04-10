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
package org.eclipse.epsilon.examples.standalone.eol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.examples.standalone.EpsilonStandaloneExample;

/**
 * This example demonstrates using the 
 * Epsilon Object Language, the core language
 * of Epsilon, in a stand-alone manner 
 * @author Dimitrios Kolovos
 */
public class EolReturnStandaloneExample extends EpsilonStandaloneExample {
	
	public static void main(String[] args) throws Exception {
		new EolReturnStandaloneExample().execute();
	}
	
	@Override
	public IEolExecutableModule createModule() {
		return new EolModule();
	}

	@Override
	public List<IModel> getModels() throws Exception {
		List<IModel> models = new ArrayList<IModel>();
		models.add(createEmfModel("Model", "models/Tree.xmi", "models/Tree.ecore", true, true));
		return models;
	}

	@Override
	public String getSource() throws Exception {
		return "eol/Return.eol";
	}
	
	@Override
	protected Object execute(IEolExecutableModule module)
			throws EolRuntimeException {
		EolOperation operation = module.getDeclaredOperations().get(0);
		return operation.execute(null, Collections.emptyList(), module.getContext());
	}
	
	@Override
	public void postProcess() {
		System.err.println(result);
	}
	
}
