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
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.StringUtil;
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
	
	/**
	 * Resolves paths. The array is only written to if this method succeeds.
	 * 
	 * @param currentPaths Contains the paths to determine in the following order: <br/>
	 * - {@link #PROPERTY_MATLAB_PATH}
	 * - {@link #PROPERTY_LIBRARY_PATH}
	 * - {@value #PROPERTY_ENGINE_JAR_PATH}
	 * 
	 * @throws IllegalArgumentException If the paths array is null or not length 3.
	 * @throws IllegalStateException If the paths couldn't be resolved.
	 */
	public static void resolvePaths(String[] currentPaths) throws IllegalStateException, IllegalArgumentException {
		if (currentPaths == null || currentPaths.length < 3)
			throw new IllegalArgumentException("Must provide ["
				+PROPERTY_MATLAB_PATH+"], ["
				+PROPERTY_LIBRARY_PATH+"], ["
				+PROPERTY_ENGINE_JAR_PATH+"]."
			);
		
		String
			matlabPath = currentPaths[0],
			libraryPath = currentPaths[1],
			engineJarPath = currentPaths[2];
		
		boolean emptyMatlabPath = StringUtil.isEmpty(matlabPath);
		boolean emptyLibraryPath = StringUtil.isEmpty(libraryPath);
		boolean emptyEngineJarPath = StringUtil.isEmpty(engineJarPath);
		
		if (emptyMatlabPath) {
			emptyMatlabPath = StringUtil.isEmpty(matlabPath = getMatlabPathFromEnv());
		}
		if (!emptyMatlabPath) {
			if (emptyLibraryPath) {
				emptyLibraryPath = StringUtil.isEmpty(libraryPath = getLibraryPathFromRoot(matlabPath));
			}
			if (emptyEngineJarPath) {
				emptyEngineJarPath = StringUtil.isEmpty(engineJarPath = getEngineJarPathFromRoot(matlabPath));
			}
		}
		if (emptyLibraryPath) {
			emptyLibraryPath = StringUtil.isEmpty(libraryPath = getLibraryPathFromEnv());
		}
		if (emptyEngineJarPath) {
			emptyEngineJarPath = StringUtil.isEmpty(engineJarPath = getEngineJarPathFromEnv());
		}
		if (emptyLibraryPath || emptyEngineJarPath) {
			String errMsg = "Unresolved MATLAB environment variables."
				+ "Please ensure that '"+PROPERTY_MATLAB_PATH+"' points to a valid MATLAB installation."
				+ "Alternatively, specify the '",
				singleSuffix = "' property.",
				multiSuffix = "' properties.";
			
			if (emptyEngineJarPath && !emptyLibraryPath) {
				errMsg += PROPERTY_ENGINE_JAR_PATH + singleSuffix;
			}
			if (emptyLibraryPath && !emptyEngineJarPath) {
				errMsg += PROPERTY_LIBRARY_PATH + singleSuffix;
			}
			if (emptyEngineJarPath && emptyLibraryPath) {
				errMsg += PROPERTY_ENGINE_JAR_PATH + " and " + PROPERTY_LIBRARY_PATH + multiSuffix;
			}
			
			throw new IllegalStateException(errMsg);
		}
		else {
			currentPaths[0] = matlabPath;
			currentPaths[1] = libraryPath;
			currentPaths[2] = engineJarPath;
		}
	}
	
	public static String getLibraryPathFromRoot(String matlabPath) {
		String osBin;
		if (OperatingSystem.isMac())
			osBin = "maci64";
		else if (OperatingSystem.isWindows())
			osBin = "win64";
		else
			osBin = "";
		
		return Paths.get(
			matlabPath, "bin", osBin
		).toAbsolutePath().toString();
	}
	
	public static String getEngineJarPathFromRoot(String matlabPath) {
		return Paths.get(
			matlabPath, "extern", "engines", "java", "jar", "engine.jar"
		).toAbsolutePath().toString();
	}
	
	public static String getLibraryPathFromEnv() {
		return System.getenv(ENV_LIBRARY_PATH);
	}
	
	public static String getEngineJarPathFromEnv() {
		return System.getenv(ENV_ENGINE_JAR_PATH);
	}
	
	public static String getMatlabPathFromEnv() {
		String matlabPath = null;
		if (StringUtil.isEmpty(matlabPath = System.getenv(ENV_MATLAB_PATH)))
			// No harm in trying I suppose...
			if (StringUtil.isEmpty(matlabPath = System.getenv("MATLAB_HOME")))
				return System.getenv("matlabroot");
		return matlabPath;
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
		resolvePaths(allPaths);
		matlabPath = allPaths[0];
		libraryPath = allPaths[1];
		engineJarPath = allPaths[2];
	}

}
