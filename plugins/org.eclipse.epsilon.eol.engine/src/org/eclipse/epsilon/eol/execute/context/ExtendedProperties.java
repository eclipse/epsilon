package org.eclipse.epsilon.eol.execute.context;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.eol.util.Cache;

public class ExtendedProperties {
	
	public static void main(String[] args) {
		ExtendedProperties e = new ExtendedProperties();
		e.setPropertyValue(1, "foo", "bar");
		System.err.println(e.getPropertyValue(2, "foo"));
	}
	
	protected Cache<Object, HashMap<String, Object>> cache = new Cache<Object, HashMap<String, Object>>();
	
	public ExtendedProperties() {
		
	}
	
	public Object getPropertyValue(Object o, String property) {
		return getPropertyValues(o).get(property);
	}
	
	public void setPropertyValue(Object o, String property, Object value) {
		getPropertyValues(o, true).put(property, value);
	}
	
	public Map<String, Object> getPropertyValues(Object o) {
		return getPropertyValues(o, false);
	}
	
	protected Map<String, Object> getPropertyValues(Object o, boolean create) {
		
		HashMap<String, Object> propertyValues = cache.get(o);
		
		if (propertyValues == null) {
			propertyValues = new HashMap<String, Object>();
			if (create) cache.put(o, propertyValues);
		}
		
		return propertyValues;
		
	}
	
	public void clear() {
		cache.dispose();
	}
	
}
