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

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;

public class JavaPropertyGetter extends AbstractPropertyGetter {
	
	@Override
	public boolean hasProperty(Object object, String property) {
		return getMethodFor(object, property).getMethod() != null;
	}
	
	protected ObjectMethod getMethodFor(Object object, String property) {
		ObjectMethod objectMethod = new ObjectMethod();
		objectMethod.setObject(object);
		OperationContributorRegistry registry = context.getOperationContributorRegistry();
		
		// Look for a getX() method
		ObjectMethod om = registry.findContributedMethodForEvaluatedParameters(object, "get" + property, new Object[]{}, context);
		if (om != null) return om;

		// Look for an X() method
		om = registry.findContributedMethodForEvaluatedParameters(object, property, new Object[]{}, context);
		if (om != null) return om;
	
		// Look for an isX() method
		om = registry.findContributedMethodForEvaluatedParameters(object, "is" + property, new Object[]{}, context);
		if (om != null) return om;
		
		return objectMethod;
	}
	
	public Object invoke(Object object, String property) throws EolRuntimeException {
		
		ObjectMethod objectMethod = getMethodFor(object, property);
		
		if (objectMethod.getMethod() == null) {
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
		
		try {
			if (!objectMethod.getMethod().isAccessible()) {
				objectMethod.getMethod().setAccessible(true);
			}
			return objectMethod.getMethod().invoke(objectMethod.getObject(), new Object[]{});
		}
		catch (Exception ex){
			throw new EolInternalException(ex);
		}
		
	}
	
}
