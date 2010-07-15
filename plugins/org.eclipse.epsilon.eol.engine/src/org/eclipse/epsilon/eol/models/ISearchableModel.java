package org.eclipse.epsilon.eol.models;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.types.EolModelElementType;

public interface ISearchableModel {
	
	public Collection find(EolModelElementType type, String property, Object value) throws EolRuntimeException;
	
	public Object findOne(EolModelElementType type, String property, Object value) throws EolRuntimeException;
	
}
