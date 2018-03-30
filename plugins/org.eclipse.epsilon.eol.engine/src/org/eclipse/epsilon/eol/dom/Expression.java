package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

public abstract class Expression extends AbstractExecutableModuleElement {
	
	protected EolType resolvedType = EolAnyType.Instance;
	
	public EolType getResolvedType() {
		return resolvedType;
	}
	
	public boolean hasResolvedType() {
		return resolvedType != null && resolvedType != EolAnyType.Instance;
	}
}
