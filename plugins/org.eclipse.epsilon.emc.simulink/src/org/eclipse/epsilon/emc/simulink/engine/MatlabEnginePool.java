/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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

import org.eclipse.epsilon.emc.simulink.exception.MatlabRuntimeException;

public class MatlabEnginePool {

	private static final String JAVA_LIBRARY_PATH = "java.library.path";
	private static final String MATLAB_ENGINE_CLASS = "com.mathworks.engine.MatlabEngine";
	private static final String SYS_PATHS = "sys_paths";

	protected static MatlabEnginePool instance;

	protected Set<MatlabEngine> pool = new LinkedHashSet<MatlabEngine>();
	protected Class<?> matlabEngineClass;
	protected String libraryPath = "";
	protected String engineJarPath = "";

	private MatlabEnginePool(String libraryPath, String engineJarPath) throws MatlabRuntimeException {

		this.libraryPath = libraryPath;
		this.engineJarPath = engineJarPath;

		try {
			final String SEP = System.getProperty("os.name").toLowerCase().contains("win") ? ";" : ":";
            System.setProperty(JAVA_LIBRARY_PATH, libraryPath + SEP + System.getProperty(JAVA_LIBRARY_PATH));
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
			throw new MatlabRuntimeException("Make sure to properly configure the library path and MATLAB engine Jar in Epsilon/Simulink preferences");
		}
	}

	public static MatlabEnginePool getInstance(String libraryPath, String engineJarPath) throws MatlabRuntimeException {
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
		MatlabEngine engine = null;
		if (pool.isEmpty()) {
			engine = new MatlabEngine(matlabEngineClass);
		} else {
			engine = pool.iterator().next();
			pool.remove(engine);
		}
		return engine;
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
