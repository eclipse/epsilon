package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.lang.reflect.Method;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

public abstract class OperationContributor {
	
	protected Object target;
	protected IEolContext context;
	
	public abstract boolean contributesTo(Object target);
	
	public ObjectMethod getObjectMethodFor(Object target, String name, Object[] parameters, IEolContext context) {
		Method method = ReflectionUtil.getMethodFor(this, name, parameters);
		if (method != null) {
			ObjectMethod objectMethod = new ObjectMethod();
			setTarget(target);
			objectMethod.setMethod(method);
			objectMethod.setObject(this);
			setContext(context);
			return objectMethod;
		}
		else {
			return null;
		}
	}
	
	public void setTarget(Object target) {
		this.target = target;
	}
	
	
	
	public void setContext(IEolContext context) {
		this.context = context;
	}
	
}
