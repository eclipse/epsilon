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
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;

public class CsvPropertyGetter extends AbstractPropertyGetter implements
		IPropertyGetter {

	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {

		Map<String, String> row = (Map<String, String>) object;
		if (!row.keySet().contains(property)) {
			throw new EolIllegalPropertyException(object, property, ast, context);
		} else {
			return row.get(property);
		}
	}

}
