package org.eclipse.epsilon.eol.types;

import java.util.Collection;

public interface IEolCollectionTypeResolver {
	
	public boolean canResolveType(Collection<?> c);
	
	public EolCollectionType resolveType(Collection<?> c);
	
}
