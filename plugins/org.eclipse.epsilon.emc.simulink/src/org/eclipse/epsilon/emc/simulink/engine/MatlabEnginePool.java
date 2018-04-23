/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.simulink.engine;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedHashSet;
import java.util.Set;

public class MatlabEnginePool {

	private static final String JAVA_LIBRARY_PATH = "java.library.path";
	private static final String MATLAB_ENGINE_CLASS = "com.mathworks.engine.MatlabEngine";
	private static final String SYS_PATHS = "sys_paths";

	protected static MatlabEnginePool instance;

	protected Set<MatlabEngine> pool = new LinkedHashSet<MatlabEngine>();
	protected Class<?> matlabEngineClass;
	protected String libraryPath = "";
	protected String engineJarPath = "";

	private MatlabEnginePool(String libraryPath, String engineJarPath) {

		this.libraryPath = libraryPath;
		this.engineJarPath = engineJarPath;

		try {
            System.setProperty(JAVA_LIBRARY_PATH, libraryPath + ";" + System.getProperty(JAVA_LIBRARY_PATH));

			final Field sysPathsField = ClassLoader.class.getDeclaredField(SYS_PATHS);
			final Class[] urlClass = new Class[]{URL.class};
			Class urlClassLoaderClass = URLClassLoader.class;

			sysPathsField.setAccessible(true);
			sysPathsField.set(null, null);

			URL engineJarPathURL = new File(engineJarPath).toURI().toURL();

			URLClassLoader systemURLClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();

			Method method = urlClassLoaderClass.getDeclaredMethod("addURL", urlClass);
			method.setAccessible(true);
			method.invoke(systemURLClassLoader, engineJarPathURL);

			matlabEngineClass = systemURLClassLoader.loadClass(MATLAB_ENGINE_CLASS);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static MatlabEnginePool getInstance(String libraryPath, String engineJarPath) {
		if (instance == null || (instance != null && (!libraryPath.equalsIgnoreCase(instance.getLibraryPath())
				|| !engineJarPath.equalsIgnoreCase(instance.getEngineJarPath())))) {
			instance = new MatlabEnginePool(libraryPath, engineJarPath);
		}
		return instance;
	}

	public static void reset() {
		instance = null;
	}

	public MatlabEngine getMatlabEngine() throws Exception {
		if (pool.isEmpty()) {
			return new MatlabEngine(matlabEngineClass);
		} else {
			MatlabEngine engine = pool.iterator().next();
			pool.remove(engine);
			return engine;
		}
	}

	public void release(MatlabEngine engine) {
		pool.add(engine);
	}

	public String getEngineJarPath() {
		return engineJarPath;
	}

	public String getLibraryPath() {
		return libraryPath;
	}

}
