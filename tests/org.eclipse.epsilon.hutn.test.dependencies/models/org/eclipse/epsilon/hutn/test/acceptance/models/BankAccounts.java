package org.eclipse.epsilon.hutn.test.acceptance.models;

import org.eclipse.epsilon.commons.util.FileUtil;

import java.io.File;

import org.eclipse.emf.common.util.URI;

public abstract class BankAccounts {

	private BankAccounts() {}
	
	public static File getMetaModelFile() {
		return FileUtil.getFile("BankAccounts.ecore", BankAccounts.class);
	}
	
	public static URI getMetaModelUri() {
		return URI.createFileURI(getMetaModelFile().getAbsolutePath());
	}
}
