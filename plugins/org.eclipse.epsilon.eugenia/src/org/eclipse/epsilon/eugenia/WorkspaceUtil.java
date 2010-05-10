package org.eclipse.epsilon.eugenia;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;

public class WorkspaceUtil {
	
	public static IFile getFile(String path) {
		try {
			return ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(
					new java.net.URI(path))[0];
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public static void waitFor(String path) {
		try {
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(new java.net.URI(path));
			for (IFile file : files) {
				while (!file.exists()) {
				}
			}
			return;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
