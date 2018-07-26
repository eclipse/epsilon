/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.csv;

import java.util.Map;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;

public class CsvPropertySetter extends AbstractPropertySetter implements
		IReflectivePropertySetter {

	@Override
	public void invoke(Object value) throws EolRuntimeException {
		
		String key = getKey();
		getMap().put(key, (String) value);
	}

	@Override
	public boolean conforms(Object value) throws EolIllegalPropertyException {
		// In theory all objects that can be serialised to strings can be
		// stored. This may cause issues is the string contains CSV
		// delimiters or in the other hand it may be desired.
		// FIXME If the value is a string and has a "," add the quotes? Or is this something that the
		// CSV library automatically does?
		return true;
	}

	@Override
	public Object coerce(Object value) throws EolIllegalPropertyException {
		// TODO Auto-generated method stub
		return value;
	}
	
	private String getKey() throws EolIllegalPropertyException {
		Map<String, String> row = getMap();
		if (!row.keySet().contains(property)) {
			throw new EolIllegalPropertyException(object, property, ast, context);
		} else {
			return property;
		}
	}
	
	@SuppressWarnings("unchecked")
	protected Map<String, String> getMap() throws EolIllegalPropertyException {
		if (object instanceof Map<?, ?>)
			return (Map<String, String>) object;
		else
			throw new EolIllegalPropertyException(object, property, ast, context);
	}
	

}
