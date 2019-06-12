/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.model;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEnginePool;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.exception.MatlabRuntimeException;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkPropertyGetter;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkPropertySetter;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

public abstract class AbstractSimulinkModel extends CachedModel<ISimulinkModelElement> implements IGenericSimulinkModel {

	public static final String PROPERTY_FILE = "file";
	public static final String PROPERTY_LIBRARY_PATH = "library_path";
	public static final String PROPERTY_ENGINE_JAR_PATH = "engine_jar_path";
		
	protected File file = null;
	protected SimulinkPropertyGetter propertyGetter;
	protected SimulinkPropertySetter propertySetter;
	
	protected String libraryPath;
	protected String engineJarPath;
	protected MatlabEngine engine;
	
	@Override
	protected void loadModel() throws EolModelLoadingException { 
		try {
			engine = MatlabEnginePool.getInstance(libraryPath, engineJarPath).getMatlabEngine();
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	@Override
	protected void disposeModel() { 
		try {
			MatlabEnginePool.getInstance(libraryPath, engineJarPath).release(engine);
		} catch (MatlabRuntimeException e) {
			
		}
	}

	@Override
	protected Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException { 
		return type;		
	}
	
	protected Collection<String> getAllTypeNamesOf(Object instance) { 
		if (instance instanceof ISimulinkModelElement) {
			return ((ISimulinkModelElement) instance).getAllTypeNamesOf();
		} else {
			return Arrays.asList(getTypeNameOf(instance));
		}
	}
	
	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {  
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IPropertySetter getPropertySetter() { 
		if (propertySetter == null) {
			propertySetter = new SimulinkPropertySetter(engine);
		}
		return propertySetter;
	}

	@Override
	public IPropertyGetter getPropertyGetter() { 
		if (propertyGetter == null) {
			propertyGetter = new SimulinkPropertyGetter();
		}
		return propertyGetter;
	}
	
	@Override
	public File getFile() { 
		return file;
	}

	@Override
	public void setFile(File file) { 
		this.file = file;
	}

	@Override
	public MatlabEngine getEngine() { 
		return engine;
	}

	@Override
	public String getLibraryPath() { 
		return libraryPath;
	}

	@Override
	public void setLibraryPath(String libraryPath) { 
		this.libraryPath = libraryPath;
	}

	@Override
	public String getEngineJarPath() { 
		return engineJarPath;
	}

	@Override
	public void setEngineJarPath(String engineJarPath) { 
		this.engineJarPath = engineJarPath;
	}
	
	public Object parseMatlabEngineVariable(String variableName) throws MatlabException { 
		return MatlabEngineUtil.parseMatlabEngineVariable(engine, variableName);
	}
	
	public void statement(String statement) throws EolRuntimeException {
		try{
			engine.eval(statement);
		} catch (MatlabException e) {
			throw new EolRuntimeException(e.getMessage());
		}
	}
	
	public Object statementWithResult(String statement) throws EolRuntimeException {
		try{
			return engine.evalWithResult(statement);
		} catch (MatlabException e) {
			throw new EolRuntimeException(e.getMessage());
		}
	}
	
	public Object getWorkspaceVariable(String value) {
		try {
			return MatlabEngineUtil.parseMatlabEngineVariable(engine,value);
		} catch (MatlabException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		super.load(properties, resolver);
		String filePath = properties.getProperty(PROPERTY_FILE);
		if (filePath != null && filePath.trim().length() > 0)
			file = new File(resolver.resolve(filePath));
		if (properties.hasProperty(PROPERTY_LIBRARY_PATH))
			libraryPath = properties.getProperty(PROPERTY_LIBRARY_PATH);
		if (properties.hasProperty(PROPERTY_ENGINE_JAR_PATH))
			engineJarPath = properties.getProperty(PROPERTY_ENGINE_JAR_PATH);

		
	}

}
