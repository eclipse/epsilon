package org.eclipse.epsilon.eol.models;

public class DefaultRelativePathResolver implements IRelativePathResolver {
	
	@Override
	public String resolve(String relativePath) {
		return relativePath;
	}
	
}
