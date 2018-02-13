package org.eclipse.epsilon.emc.simulink.test.util;

import java.io.File;

public enum MatlabEngineFilesEnum {

	// Default windows and osx locations for test version R2017a
	
	ENGINE_JAR(
			"C:/Program Files/MATLAB/R2017b/extern/engines/java/jar/engine.jar",
			"/Applications/MATLAB_R2017b.app/extern/engines/java/jar/engine.jar",
			""), // TODO
	
	LIBRARY_PATH(
			"C:/Program Files/MATLAB/R2017b/bin/win64", 
			"/Applications/MATLAB_R2017b.app/bin/maci64",
			""); // TODO

	private static final String OS_PROPERTY = "os.name";
	private static final String WINDOWS = "windows";
	private static final String MAC = "mac";

	private String win;
	private String osx;
	private String lin;
	
	private String os;

	MatlabEngineFilesEnum(String win, String osx, String lin){
		this.win = win;
		this.osx = osx;
		this.lin = lin;
		this.os = System.getProperty(OS_PROPERTY).toLowerCase();
	}

	public File file(){
		if (os.contains(WINDOWS)) {
			return getWindowsFile();
		} else if (os.contains(MAC)){
			return getMacOSFile();
		} else {
			return getLinuxFile();
		}
	}
	
	public String path(){
		if (os.contains(WINDOWS)) {
			return getWindowsPath();
		} else if (os.contains(MAC)){
			return getMacOSPath();
		} else {
			return getLinuxPath();
		}
	}

	public String getWindowsPath() {
		return this.win;
	}
	
	public String getMacOSPath() {
		return this.osx;
	}
	
	public String getLinuxPath() {
		return this.lin;
	}
	
	public File getWindowsFile() {
		return new File(getWindowsPath());
	}

	public File getMacOSFile() {
		return new File(getMacOSPath());
	}
	
	public File getLinuxFile() {
		return new File(getLinuxPath());
	}
	
}