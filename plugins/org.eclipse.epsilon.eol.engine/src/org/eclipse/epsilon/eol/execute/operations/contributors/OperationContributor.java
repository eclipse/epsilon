/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.lang.reflect.Method;
import java.util.Set;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

public abstract class OperationContributor {
	
	protected Object target;
	protected IEolContext context;
	protected Set<String> cachedMethodNames = null;
	
	public abstract boolean contributesTo(Object target);
	
	public ObjectMethod findContributedMethodForUnevaluatedParameters(Object target, String name, IEolContext context) {
		// Note that the last parameter is false: we only want to retrieve methods that take an AST as an argument
		// and not methods that take a supertype of AST (such as Object)
		Method method = getObjectMethodFor(target, name, new Object[]{new AST()}, false);
		return createObjectMethod(target, method, context);
	}

	public ObjectMethod findContributedMethodForEvaluatedParameters(Object target, String name, Object[] parameters, IEolContext context) {
		Method method = getObjectMethodFor(target, name, parameters, true);
		return createObjectMethod(target, method, context);
	}

	private Method getObjectMethodFor(Object target, String name, Object[] parameters, boolean allowContravariantConversionForParameters) {
		
		// Maintain a cache of method names if the reflection target is this
		// so that we don't iterate through all methods every time
		if (getReflectionTarget(target) == this && cachedMethodNames == null) {
			cachedMethodNames = ReflectionUtil.getMethodNames(this, includeInheritedMethods());
		}
		
		if (cachedMethodNames == null || cachedMethodNames.contains(name)) {
			return ReflectionUtil.getMethodFor(getReflectionTarget(target),
		                                   name,
		                                   parameters,
		                                   includeInheritedMethods(),
		                                   allowContravariantConversionForParameters);
		}
		else {
			return null;
		}
	}

	private ObjectMethod createObjectMethod(Object target, Method method, IEolContext context) {
		if (method != null) {
			ObjectMethod objectMethod = new ObjectMethod();
			setTarget(target);
			objectMethod.setMethod(method);
			objectMethod.setObject(getReflectionTarget(target));
			setContext(context);
			return objectMethod;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Specifies whether methods in the supertype of the contributor
	 * should be included when finding contributed operations. Typically,
	 * this should not be the case and, as such, this method returns 
	 * false by default.
	 */
	protected boolean includeInheritedMethods() {
		return false;
	}
	
	protected Object getReflectionTarget(Object target) {
		return this;
	}
	
	public void setTarget(Object target) {
		this.target = target;
	}
	
	public void setContext(IEolContext context) {
		this.context = context;
	}
	
}
