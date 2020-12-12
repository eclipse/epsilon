/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.examples.standalone;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

/**
 * Please use the appropriate subclass of {@link EolRunConfiguration} instead.
 * 
 */
@Deprecated
public abstract class EpsilonStandaloneExample {
	
	protected IEolModule module;
	protected Collection<Variable> parameters = new ArrayList<>();
	
	protected Object result;
	
	protected abstract IEolModule createModule();
	
	protected abstract String getSource() throws Exception;
	
	public abstract Collection<IModel> getModels() throws Exception;
	
	protected void postProcess() {}
	
	protected void preProcess() {}
	
	public void execute() throws Exception {
		
		module = createModule();
		module.parse(getFileURI(getSource()));
		
		Collection<?> parseProblems = module.getParseProblems();
		if (!parseProblems.isEmpty()) {
			System.err.println("Parse errors occured...");
			parseProblems.forEach(System.err::println);
			return;
		}
		
		IEolContext context = module.getContext();
		context.getModelRepository().addModels(getModels());
		context.getFrameStack().put(parameters);
		
		preProcess();
		result = execute(module);
		postProcess();
		
		context.getModelRepository().dispose();
	}
	
	public Collection<Variable> getParameters() {
		return parameters;
	}
	
	protected Object execute(IEolModule module) 
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
				getFileURI(metamodel).toString());
		properties.put(EmfModel.PROPERTY_MODEL_URI, 
				getFileURI(model).toString());
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
				getFileURI(model).toString());
		properties.put(EmfModel.PROPERTY_READONLOAD, readOnLoad + "");
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, 
				storeOnDisposal + "");
		emfModel.load(properties, (IRelativePathResolver) null);
		return emfModel;
	}

	protected java.net.URI getFileURI(String fileName) throws URISyntaxException {
		java.net.URI binUri = EpsilonStandaloneExample.class.getResource(fileName).toURI();
		return binUri.toString().contains("bin") ? new java.net.URI(binUri.toString().replaceAll("bin", "src")) : binUri;
	}
}