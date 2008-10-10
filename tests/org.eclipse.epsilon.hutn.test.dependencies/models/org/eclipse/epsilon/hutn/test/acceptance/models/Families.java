package org.eclipse.epsilon.hutn.test.acceptance.models;

import org.eclipse.epsilon.commons.util.FileUtil;

import java.io.File;
import java.io.FileFilter;

import org.eclipse.emf.common.util.URI;

public abstract class Families {

	private Families() {}
	
	public static File getMetaModelFile() {
		return FileUtil.getFile("Families.ecore", Families.class);
	}
	
	public static URI getMetaModelUri() {
		return URI.createFileURI(getMetaModelFile().getAbsolutePath());
	}
	
	public static File getBankAccountsModelFile() {
		return FileUtil.getFile("BankAccounts.model", Families.class);
	}
	
	public static URI getBankAccountsModelUri() {
		return URI.createFileURI(getBankAccountsModelFile().getAbsolutePath());
	}
	
	
	public static File getProjectDirectory() {
		File file = getMetaModelFile();
		
		while (file.isFile() || file.listFiles(new DotProjectOnlyFilter()).length == 0) {
			file = file.getParentFile();
			
			if (file == null) {
				throw new IllegalStateException("Could not find an Eclipse project in parent directories.");
			}
		}
		
		return file;
	}
	
	public static URI getProjectDirectoryUri() {
		return URI.createFileURI(getProjectDirectory().getAbsolutePath() + "/");
	}
	
	
	private static class DotProjectOnlyFilter implements FileFilter {
		@Override
		public boolean accept(File file) {
			return ".project".equals(file.getName());
		}
	}
}
