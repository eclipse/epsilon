/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.test.util;

import java.io.File;

public enum MatlabEngineFilesEnum {

	// Default windows and osx locations for test version R2017a
	
	ENGINE_JAR(
			"C:/Program Files/MATLAB/%s/extern/engines/java/jar/engine.jar",
			"/Applications/MATLAB_%s.app/extern/engines/java/jar/engine.jar",
			""), // TODO
	
	LIBRARY_PATH(
			"C:/Program Files/MATLAB/%s/bin/win64", 
			"/Applications/MATLAB_%s.app/bin/maci64",
			""); // TODO

	private static final String OS_PROPERTY = "os.name";
	private static final String WINDOWS = "windows";
	private static final String MAC = "mac";
	
	private static final String VERSION = "R2017b"; // Default value 

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

	
	public File file(String version){
		if (os.contains(WINDOWS)) {
			return getWindowsFile();
		} else if (os.contains(MAC)){
			return getMacOSFile();
		} else {
			return getLinuxFile();
		}
	}
	
	public String path(String version){
		if (os.contains(WINDOWS)) {
			return getWindowsPath(version);
		} else if (os.contains(MAC)){
			return getMacOSPath(version);
		} else {
			return getLinuxPath(version);
		}
	}
	
	public File file(){
		return file(VERSION);
	}
	
	public String path(){
		return path(VERSION);
	}
	
	public String getWindowsPath() {
		return String.format(this.win, VERSION);
	}
	
	public String getMacOSPath() {
		return String.format(this.osx, VERSION);
	}
	
	public String getLinuxPath() {
		return String.format(this.lin, VERSION);
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
	
	public String getWindowsPath(String version) {
		return String.format(this.win, version);
	}
	
	public String getMacOSPath(String version) {
		return String.format(this.osx, version);
	}
	
	public String getLinuxPath(String version) {
		return String.format(this.lin, version);
	}
	
	public File getWindowsFile(String version) {
		return new File(getWindowsPath(version));
	}

	public File getMacOSFile(String version) {
		return new File(getMacOSPath(version));
	}
	
	public File getLinuxFile(String version) {
		return new File(getLinuxPath(version));
	}
	
}