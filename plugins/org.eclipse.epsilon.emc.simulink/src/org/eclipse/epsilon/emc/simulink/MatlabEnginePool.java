package org.eclipse.epsilon.emc.simulink;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedHashSet;
import java.util.Set;

public class MatlabEnginePool {
	
	protected static MatlabEnginePool instance;
	protected Set<MatlabEngine> pool = new LinkedHashSet<MatlabEngine>();
	protected Class<?> matlabEngineClass;
	protected String libraryPath = "";
	protected String engineJarPath = "";
	
	private MatlabEnginePool(String libraryPath, String engineJarPath) {

		this.libraryPath = libraryPath;
		this.engineJarPath = engineJarPath;
		
		try {
			System.setProperty("java.library.path", libraryPath);
			final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
		    sysPathsField.setAccessible(true);
		    sysPathsField.set(null, null);

			URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new File(engineJarPath).toURI().toURL()});
			matlabEngineClass = classLoader.loadClass("com.mathworks.engine.MatlabEngine");
		}
		catch (Exception ex) {
			
		}
	}
	
	public static MatlabEnginePool getInstance(String libraryPath, String engineJarPath) {
		if (instance == null || (instance !=null && (!libraryPath.equalsIgnoreCase(instance.getLibraryPath()) || !engineJarPath.equalsIgnoreCase(instance.getEngineJarPath())))) {
			instance = new MatlabEnginePool(libraryPath, engineJarPath);
		}
		return instance;
	}
	
	public static void reset() {
		instance = null;
	}
	
	public MatlabEngine getMatlabEngine() {
		if (pool.isEmpty()) {
			return new MatlabEngine(matlabEngineClass);
		}
		else {
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
