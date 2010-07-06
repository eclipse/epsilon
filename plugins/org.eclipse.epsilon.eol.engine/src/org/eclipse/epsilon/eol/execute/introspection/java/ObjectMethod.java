package org.eclipse.epsilon.eol.execute.introspection.java;

import java.lang.reflect.Method;

public class ObjectMethod {
	
	protected Object object;
	protected Method method;
	
	public ObjectMethod() {}
	
	public ObjectMethod(Object object, Method method) {
		super();
		this.object = object;
		this.method = method;
	}
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	
	
	
}
