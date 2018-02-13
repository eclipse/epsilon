package org.eclipse.epsilon.emc.simulink.test.util;

import java.io.File;
import java.net.URL;

public class FileUtils {

	public static File getModelFile(String fileName) {
		String resource = FileUtils.getResource("models/" + fileName);
		return (resource != null) ? new File(resource) : null;
	}

	public static String getScript(String fileName) {
		return FileUtils.getResource("scripts/" + fileName);
	}
	
	public static String getResource(String resourceLocation) {
		URL resource = FileUtils.class.getClassLoader().getResource(resourceLocation);
		return resource != null ? resource.getFile() : null;
	}
}
