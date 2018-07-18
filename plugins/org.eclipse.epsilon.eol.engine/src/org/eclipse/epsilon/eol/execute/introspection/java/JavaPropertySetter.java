/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.introspection.java;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;

public class JavaPropertySetter extends AbstractPropertySetter implements IReflectivePropertySetter {
	
	protected ObjectMethod getMethodFor(Object object, String property, Object value) {
		ObjectMethod objectMethod = new ObjectMethod();
		objectMethod.setObject(object);
		OperationContributorRegistry registry = context.getOperationContributorRegistry();
		
		// Look for a getX() method
		ObjectMethod om = registry.findContributedMethodForEvaluatedParameters(object, "set" + property, new Object[]{value}, context);
		if (om != null) return om;
		
		return objectMethod;
	}
	
	public void invoke(Object value) throws EolRuntimeException{
		
		ObjectMethod objectMethod = getMethodFor(object, property, value);
		
		if (objectMethod.getMethod() == null) {
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
		
		try {
			if (!objectMethod.getMethod().isAccessible()) {
				objectMethod.getMethod().setAccessible(true);
			}
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
