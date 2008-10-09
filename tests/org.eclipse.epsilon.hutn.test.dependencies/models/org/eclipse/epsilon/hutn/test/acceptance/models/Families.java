package org.eclipse.epsilon.hutn.test.acceptance.models;

import org.eclipse.epsilon.commons.util.FileUtil;

import java.io.File;

import org.eclipse.emf.common.util.URI;

public abstract class Families {

	private Families() {}
	
	public static File getMetaModelFile() {
		return FileUtil.getFile("Families.ecore", Families.class);
	}
	
	public static URI getMetaModelUri() {
		return URI.createFileURI(getMetaModelFile().getAbsolutePath());
	}
}
