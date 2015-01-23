package org.eclipse.epsilon.eol.dom;


public abstract class Expression extends AbstractExecutableModuleElement {
	
	protected Object resolvedType;
	
	public Object getResolvedType() {
		return resolvedType;
	}
	
}
