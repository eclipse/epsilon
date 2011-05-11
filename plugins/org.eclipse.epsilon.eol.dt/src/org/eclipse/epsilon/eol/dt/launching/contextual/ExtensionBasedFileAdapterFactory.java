package org.eclipse.epsilon.eol.dt.launching.contextual;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdapterFactory;

public abstract class ExtensionBasedFileAdapterFactory implements IAdapterFactory {

	protected boolean supportsExtension(String extension) {
		return getExtension().equals(extension);
	}
	
	protected abstract String getExtension();
	
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof IFile) {
			IFile file = ((IFile) adaptableObject);
			if (supportsExtension(file.getFileExtension())) {
				return new EolFile();
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return null;
	}
	
}
