/*********************************************************************
* Copyright (c) 2019 The University of York.
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
import org.eclipse.epsilon.emc.simulink.types.CellStr;
import org.eclipse.epsilon.emc.simulink.types.Complex;
import org.eclipse.epsilon.emc.simulink.types.HandleObject;
import org.eclipse.epsilon.emc.simulink.types.Struct;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

public abstract class AbstractSimulinkModel extends CachedModel<ISimulinkModelElement> implements IGenericSimulinkModel {

	public static final String PROPERTY_FILE = "file";
	public static final String PROPERTY_MATLAB_PATH = "matlab_path";
	public static final String PROPERTY_LIBRARY_PATH = "library_path";
	public static final String PROPERTY_ENGINE_JAR_PATH = "engine_jar_path";
	public static final String ENV_MATLAB_PATH = ENV_PREFIX + PROPERTY_MATLAB_PATH;
	public static final String ENV_LIBRARY_PATH = ENV_PREFIX + PROPERTY_LIBRARY_PATH;
	public static final String ENV_ENGINE_JAR_PATH = ENV_PREFIX + PROPERTY_ENGINE_JAR_PATH;
		
	protected File file;
	protected SimulinkPropertyGetter propertyGetter;
	protected SimulinkPropertySetter propertySetter;
	
	protected String matlabPath;
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
	
	@Override
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
	
	@Override
	public String getMatlabPath() {
		return matlabPath;
	}
	
	@Override
	public void setMatlabPath(String matlabPath) {
		this.matlabPath = matlabPath;
	}
	
	public Object parseMatlabEngineVariable(String variableName) throws MatlabException { 
		return MatlabEngineUtil.parseMatlabEngineVariable(engine, variableName);
	}
	
	public void statement(String statement) throws EolRuntimeException {
		try {
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
			return MatlabEngineUtil.parseMatlabEngineVariable(engine, value);
		} catch (MatlabException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean owns(Object instance) {
		return instance instanceof Struct || instance instanceof Complex
				|| instance instanceof HandleObject || instance instanceof CellStr;
	}
	
	@Override
	public boolean isInstantiable(String type) {
		return Arrays.asList("Struct", "Complex", "CellStr").contains(type);
	}
	
	@Override
	protected ISimulinkModelElement createInstanceInModel(String type)
			throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		switch (type) {
			case "Struct":
				return new Struct(getEngine());
			case "Complex":
				return new Complex(getEngine());
			case "CellStr":
				return new CellStr(getEngine());	
		}
		throw new EolModelElementTypeNotFoundException(this.getName(), type);
	}
	
	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		super.load(properties, resolver);
		
		String filePath = properties.getProperty(PROPERTY_FILE);
		if (filePath != null && filePath.trim().length() > 0)
			file = new File(resolver.resolve(filePath));
		if (file == null) throw new IllegalStateException(
			"File cannot be null! Please ensure the '"+PROPERTY_FILE+"' property is set."
		);
		
		if (properties.hasProperty(PROPERTY_MATLAB_PATH))
			matlabPath = properties.getProperty(PROPERTY_MATLAB_PATH);
		if (properties.hasProperty(PROPERTY_LIBRARY_PATH))
			libraryPath = properties.getProperty(PROPERTY_LIBRARY_PATH);
		if (properties.hasProperty(PROPERTY_ENGINE_JAR_PATH))
			engineJarPath = properties.getProperty(PROPERTY_ENGINE_JAR_PATH);
		
		String[] allPaths = {matlabPath, libraryPath, engineJarPath};
		MatlabEngineUtil.resolvePaths(allPaths);
		matlabPath = allPaths[0];
		libraryPath = allPaths[1];
		engineJarPath = allPaths[2];
	}

}
