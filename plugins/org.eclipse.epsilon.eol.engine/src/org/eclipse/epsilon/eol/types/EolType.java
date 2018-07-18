/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public abstract class EolType {
	
	public abstract String getName();
	
	public abstract boolean isType(Object o);
	
	public abstract boolean isKind(Object o);
	
	public abstract Object createInstance() throws EolRuntimeException;
	
	public abstract Object createInstance(List<Object> parameters) throws EolRuntimeException;
	
	public boolean isNot(EolType type) {
		return this != type && this != EolAnyType.Instance;
	}
}
