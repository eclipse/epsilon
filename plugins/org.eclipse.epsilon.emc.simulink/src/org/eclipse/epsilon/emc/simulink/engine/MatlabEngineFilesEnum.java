package org.eclipse.epsilon.emc.simulink.engine;

import java.io.File;

public enum MatlabEngineFilesEnum {

	// Default windows and osx locations for test version R2017a
	
	ENGINE_JAR(
			"C:/Program Files/MATLAB/R2017a/extern/engines/java/jar/engine.jar",
			"/Applications/MATLAB_R2017a.app/extern/engines/java/jar/engine.jar"),
	
	LIBRARY_PATH(
			"C:/Program Files/MATLAB/R2017a/bin/win64", 
			"/Applications/MATLAB_R2017a.app/bin/maci64");

	private static final String OS_PROPERTY = "os.name";
	private static final String WINDOWS = "windows";

	private String win;
	private String osx;

	MatlabEngineFilesEnum(String win, String osx){
		this.win = win;
		this.osx = osx;
	}

	public File file(){
		if (System.getProperty(OS_PROPERTY).toLowerCase().contains(WINDOWS)) {
			return getWindowsFile();
		} else {
			return getMacOSFile();
		}
	}
	
	public String path(){
		if (System.getProperty(OS_PROPERTY).toLowerCase().contains(WINDOWS)) {
			return getWindowsPath();
		} else {
			return getMacOSPath();
		}
	}

	public String getWindowsPath() {
		return this.win;
	}
	
	public String getMacOSPath() {
		return this.osx;
	}
	
	public File getWindowsFile() {
		return new File(getWindowsPath());
	}

	public File getMacOSFile() {
		return new File(getMacOSPath());
	}

}