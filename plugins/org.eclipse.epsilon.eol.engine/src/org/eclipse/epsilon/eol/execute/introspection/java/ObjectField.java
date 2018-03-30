package org.eclipse.epsilon.eol.execute.introspection.java;

import java.lang.reflect.Field;

public class ObjectField {
	
	protected Object object;
	protected Field field;
	
	public void setValue(Object value) throws Exception {
		field.set(object, value);
	}
	
	public Object getValue() throws Exception {
		return field.get(object);
	}
}
