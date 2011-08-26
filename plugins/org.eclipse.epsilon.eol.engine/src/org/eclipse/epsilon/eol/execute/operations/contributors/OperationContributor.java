package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.lang.reflect.Method;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

public abstract class OperationContributor {
	
	protected Object target;
	protected IEolContext context;
	
	public abstract boolean contributesTo(Object target);
	
	public ObjectMethod getObjectMethodFor(Object target, String name, Object[] parameters, IEolContext context) {
		// Only include in the search methods defined by the contributor 
		// i.e. ignore Object methods
		Object reflectionTarget = getReflectionTarget(target);
		Method method = ReflectionUtil.getMethodFor(reflectionTarget, name, parameters, includeInheritedMethods()); 
		return createObjectMethod(target, reflectionTarget, method, context);
	}
	
	public ObjectMethod getObjectMethodFor(Object target, String name, AST ast, IEolContext context) {
		// Only include in the search methods defined by the contributor 
		// i.e. ignore Object methods
		Object reflectionTarget = getReflectionTarget(target);
		Method method = ReflectionUtil.getMethodFor(reflectionTarget, name, new Object[]{ast}, includeInheritedMethods(), false); 
		return createObjectMethod(target, reflectionTarget, method, context);
	}

	private ObjectMethod createObjectMethod(Object target, Object reflectionTarget, Method method, IEolContext context) {
		if (method != null) {
			ObjectMethod objectMethod = new ObjectMethod();
			setTarget(target);
			objectMethod.setMethod(method);
			objectMethod.setObject(reflectionTarget);
			setContext(context);
			return objectMethod;
		}
		else {
			return null;
		}
	}
	
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
