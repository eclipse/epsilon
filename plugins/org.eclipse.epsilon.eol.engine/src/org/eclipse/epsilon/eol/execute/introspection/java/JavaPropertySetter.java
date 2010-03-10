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
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetterWithReflexiveAccess;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

public class JavaPropertySetter extends AbstractPropertySetter implements IPropertySetterWithReflexiveAccess {
	
	public void invoke(Object value) throws EolRuntimeException {
		
		//if (object instanceof EolMap){
		//	((EolMap) object).put(new EolString(property),value);
		//	return;
		//}
		
		//TODO : Add support for public, then private fields
		
		Method setter = null;
		Method getter = null;
		String methodName = "";
		
		// First try to find a setter
		methodName = "set" + StringUtil.firstToUpper(property);
		setter = ReflectionUtil.getMethodFor(object, methodName, 1);
		
		if (setter == null) {
			methodName = property;
			setter = ReflectionUtil.getMethodFor(object, methodName, 1);
		}
		
		if (setter != null){
			try {
				setter.invoke(object, new Object[]{EolTypeWrapper.getInstance().unwrap(value)});
				return;
			} catch (Exception ex) {
				throw new EolInternalException(ex);
			}
		}
		
		// Then try to find a setter with the name as-is (applies to isXXX of MDR)
		if (property.startsWith("is")){
			methodName = "set" + property.substring(2, property.length());
			setter = ReflectionUtil.getMethodFor(object, methodName, 1);
			
			if (setter == null) {
				methodName = property;
				setter = ReflectionUtil.getMethodFor(object, methodName, 1);
			}
			
			if (setter != null){
				try {
					setter.invoke(object, new Object[]{EolTypeWrapper.getInstance().unwrap(value)});
					return;
				} catch (Exception ex) {
					throw new EolInternalException(ex);
				}
			}
		}
		
		// Since no setter has been found try to get
		// a getter and if it returns a collection and
		// the value is a collection, clear it and add
		// the contents of the value
		
		if (setter == null) {
			methodName = "get" + StringUtil.firstToUpper(property);
			getter = ReflectionUtil.getMethodFor(object, methodName, 0);
		
			if (getter != null) {
				Object result = null;
				try {
					result = getter.invoke(object, new Object[]{});
				} catch (Exception e) {
					throw new EolInternalException(e);
				}
				
				if (result != null && result instanceof Collection){
					Collection source = (Collection) result;
					
					if (value instanceof EolCollection) {
						EolCollection eolCollection = (EolCollection) value;
						Iterator it = eolCollection.getStorage().iterator();
						while (it.hasNext()){
							try {
								Object next = it.next();
								if (!source.contains(next)){
									source.add(next);
								}
							}
							catch (Exception ex){
								throw new EolInternalException(ex);
							}
						}
						return;
					}
				}
			}
		}
		
		throw new EolIllegalPropertyException(object, property, ast, context);
		
	}

	public Object coerce(Object value) throws EolIllegalPropertyException {
		return value;
	}

	public boolean conforms(Object value) throws EolIllegalPropertyException {
		// TODO implement this method
		throw new UnsupportedOperationException("Not yet implemented.");
	}

}
