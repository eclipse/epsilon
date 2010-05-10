package org.eclipse.epsilon.eugenia;

import org.eclipse.epsilon.commons.util.FileUtil;

public class GmfFileSet {
	
	protected String basePath = "";
	
	public GmfFileSet(String onePath) {
		basePath = FileUtil.replaceExtension(onePath, "");
	}
	
	public String getEcorePath() {
		return basePath + "ecore";
	}
	
	public String getEmfaticPath() {
		return basePath + "emf";
	}
	
	public String getGenModelPath() {
		return basePath + "genmodel";
	}
	
	public String getGmfToolPath() {
		return basePath + "gmftool";
	}
	
	public String getGmfMapPath() {
		return basePath + "gmfmap";
	}
	
	public String getGmfGenPath() {
		return basePath + "gmfgen";
	}
	
	public String getGmfGraphPath() {
		return basePath + "gmfgraph";
	}
	
}
