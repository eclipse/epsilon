package org.eclipse.epsilon.emc.simulink.engine;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MatlabClassLoader {

	private static MatlabClassLoader instance;
	
	private String engineJarPath;
	private URLClassLoader urlClassLoader;

	private MatlabClassLoader(String engineJarPath) {
		this.engineJarPath = engineJarPath;

		try {
			URL engineJarPathURL = new File(this.engineJarPath).toURI().toURL();
			ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
			if (systemClassLoader instanceof URLClassLoader) {
				urlClassLoader = (URLClassLoader) systemClassLoader;
				Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
				method.setAccessible(true);
				method.invoke(urlClassLoader, engineJarPathURL);
			} else {
				urlClassLoader = new URLClassLoader(new URL[] {engineJarPathURL}, systemClassLoader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MatlabClassLoader init(String engineJarPath) {
		if (instance == null || !engineJarPath.equalsIgnoreCase(instance.getEngineJarPath())) {
			instance = new MatlabClassLoader(engineJarPath);
		}
		
		return instance;
	}

	public static MatlabClassLoader getInstance() {
		return instance;
	}

	public synchronized Class<?> loadMatlabClass(String classURI) throws ClassNotFoundException {
		return Class.forName(classURI, true, urlClassLoader);
		
//		return urlClassLoader.loadClass(classURI);
	}
	
	public String getEngineJarPath() {
		return engineJarPath;
	}
	
}
