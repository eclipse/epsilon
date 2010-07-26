/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.introspection.java;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

public class JavaPropertySetter extends AbstractPropertySetter implements IReflectivePropertySetter {
	
	protected ObjectMethod getMethodFor(Object object, String property, Object value) {
		ObjectMethod objectMethod = new ObjectMethod();
		objectMethod.setObject(object);
		OperationContributorRegistry registry = context.getOperationContributorRegistry();
		
		// Look for a getX() method
		ObjectMethod om = registry.getContributedMethod(object, "set" + property, new Object[]{value}, context);
		if (om != null) return om;
		
		return objectMethod;
	}
	
	public void invoke(Object value) throws EolRuntimeException{
		
		ObjectMethod objectMethod = getMethodFor(object, property, value);
		
		if (objectMethod.getMethod() == null) {
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
		
		try {
			objectMethod.getMethod().invoke(objectMethod.getObject(), new Object[]{value});
		}
		catch (Exception ex){
			throw new EolInternalException(ex);
		}
		
	}

	public Object coerce(Object value) throws EolIllegalPropertyException {
		return value;
	}

	public boolean conforms(Object value) throws EolIllegalPropertyException {
		// TODO implement this method
		throw new UnsupportedOperationException("Not yet implemented.");
	}

}
