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

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

public class JavaPropertyGetter extends AbstractPropertyGetter{
	
	protected Method getMethodFor(Object object, String property) {
		String methodName = "get" + property;
		Method method = ReflectionUtil.getMethodFor(object, methodName, 0);
		
		if (method == null){
			methodName = property;
			method = ReflectionUtil.getMethodFor(object, methodName, 0);
		}
		
		if (method == null){
			methodName = "is" + property;
			method = ReflectionUtil.getMethodFor(object, methodName, 0);
		}
		return method;
	}
	
	public Object invoke(Object object, String property) throws EolRuntimeException{
		
		//if (object instanceof EolMap) {
		//	return ((EolMap) object).get(new EolString(property));
		//}
		
		//TODO : Add support for public, then private fields
		
		
		/*
		if (method == null){
			methodName = "get";
			method = ReflectionUtil.getMethodFor(object,methodName,1);

			if (method!=null) {
				try {
					return method.invoke(object, new Object[]{property});
				}
				catch (Exception ex) {
					throw new EolInternalException(ex);
				}
			}
		}
		*/
		
		Method method = getMethodFor(object, property);
		
		if (method == null) {
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
		
		Object result = null; 
		
		try {
			result = method.invoke(object, new Object[]{});
			return result;
		}
		catch (Exception ex){
			throw new EolInternalException(ex);
		}
		
	}
	
}
