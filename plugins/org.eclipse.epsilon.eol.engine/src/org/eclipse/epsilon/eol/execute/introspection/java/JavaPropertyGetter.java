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

import java.lang.reflect.Method;
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
		
		return new ObjectMethod(object);
	}
	
	@Override
	public Object invoke(Object object, String property) throws EolRuntimeException {
		ObjectMethod objectMethod = getMethodFor(object, property);
		Method method = objectMethod.getMethod();
		
		if (method == null) {
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
		
		try {
			//TODO: use canAccess(Object)
			if (!method.isAccessible()) {
				method.setAccessible(true);
			}
			return method.invoke(objectMethod.getObject());
		}
		catch (Exception ex) {
			throw new EolInternalException(ex);
		}
	}
}
