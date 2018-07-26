/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.introspection.java;

import java.lang.reflect.Field;

public class ObjectField {
	
	protected Object object;
	protected Field field;
	
	public void setValue(Object value) throws Exception {
		field.set(object, value);
	}
	
	public Object getValue() throws Exception {
		return field.get(object);
	}
}
