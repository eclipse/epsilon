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
package org.eclipse.epsilon.examples.standalone;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

public abstract class EpsilonStandaloneExample {
	
	protected IEolExecutableModule module;
	protected List<Variable> parameters = new ArrayList<Variable>();
	
	protected Object result;
	
	public abstract IEolExecutableModule createModule();
	
	public abstract String getSource() throws Exception;
	
	public abstract List<IModel> getModels() throws Exception;
	
	public void postProcess() {};
	
	public void preProcess() {};
	
	public void execute() throws Exception {
		
		module = createModule();
		module.parse(getFile(getSource()));
		
		if (module.getParseProblems().size() > 0) {
			System.err.println("Parse errors occured...");
			for (ParseProblem problem : module.getParseProblems()) {
				System.err.println(problem.toString());
			}
			return;
		}
		
		for (IModel model : getModels()) {
			module.getContext().getModelRepository().addModel(model);
		}
		
		for (Variable parameter : parameters) {
			module.getContext().getFrameStack().put(parameter);
		}
		
		preProcess();
		result = execute(module);
		postProcess();
		
		module.getContext().getModelRepository().dispose();
	}
	
	public List<Variable> getParameters() {
		return parameters;
	}
	
	protected Object execute(IEolExecutableModule module) 
			throws EolRuntimeException {
		return module.execute();
	}
	
	protected EmfModel createEmfModel(String name, String model, 
			String metamodel, boolean readOnLoad, boolean storeOnDisposal) 
					throws EolModelLoadingException, URISyntaxException {
		EmfModel emfModel = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, name);
		properties.put(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,
				getFile(metamodel).toURI().toString());
		properties.put(EmfModel.PROPERTY_MODEL_URI, 
				getFile(model).toURI().toString());
		properties.put(EmfModel.PROPERTY_READONLOAD, readOnLoad + "");
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, 
				storeOnDisposal + "");
		emfModel.load(properties, (IRelativePathResolver) null);
		return emfModel;
	}

	protected EmfModel createEmfModelByURI(String name, String model, 
			String metamodel, boolean readOnLoad, boolean storeOnDisposal) 
					throws EolModelLoadingException, URISyntaxException {
		EmfModel emfModel = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, name);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodel);
		properties.put(EmfModel.PROPERTY_MODEL_URI, 
				getFile(model).toURI().toString());
		properties.put(EmfModel.PROPERTY_READONLOAD, readOnLoad + "");
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, 
				storeOnDisposal + "");
		emfModel.load(properties, (IRelativePathResolver) null);
		return emfModel;
	}
	
	protected File getFile(String fileName) throws URISyntaxException {
		
		URI binUri = EpsilonStandaloneExample.class.
				getResource(fileName).toURI();
		URI uri = null;
		
		if (binUri.toString().indexOf("bin") > -1) {
			uri = new URI(binUri.toString().replaceAll("bin", "src"));
		}
		else {
			uri = binUri;
		}
		
		return new File(uri);
	}
	
}
