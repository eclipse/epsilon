package org.eclipse.epsilon.emc.jdt.objectpropertygetters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ObjectPropertyGetter<T, R> {
	
	protected Class<?> clazz;
	protected List<String> properties = new ArrayList<String>();
	
	public ObjectPropertyGetter(Class<?> clazz, String... properties) {
		this.clazz = clazz;
		this.properties.addAll(Arrays.asList(properties));
	}
	
	public boolean appliesTo(Object object, String property) {
		return properties.contains(property) && clazz.isInstance(object);
	}
	
	public abstract R getValue(T object, String property);
	
}
