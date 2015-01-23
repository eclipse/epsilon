package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.types.EolAnyType;


public abstract class Expression extends AbstractExecutableModuleElement {
	
	protected Object resolvedType = EolAnyType.Instance;
	
	public Object getResolvedType() {
		return resolvedType;
	}
	
	public boolean hasResolvedType() {
		return resolvedType != null &&
			resolvedType != EolAnyType.Instance;
	}
	
}
