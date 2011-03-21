package org.eclipse.epsilon.eol.execute.context;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.epsilon.eol.util.IdentityBasedWeakHashMap;

public class ExtendedProperties {
	
	
	public static void main(String[] args) throws Exception {
		
		ExtendedProperties ep = new ExtendedProperties();
		
		ArrayList list = new ArrayList();
		
		ep.put(list, "foo", "bar");
		ep.put(list, "zoo", "zar");
		
		System.err.println(ep.get(list, "foo"));
		System.err.println(ep.get(list, "zoo"));
		
		System.err.println(ep.get(list, "bar"));
		
		list = null;
		
		System.gc();
		Thread.sleep(1000);
		
		System.err.println(ep.cacheSize());
		
	}
	
	protected IdentityBasedWeakHashMap<Object, Map<String, Object>> cache = new IdentityBasedWeakHashMap<Object, Map<String, Object>>();
	
	public int cacheSize() {
		return cache.size();
	}
	
	public void put(Object o, String property, Object value) {
		Map<String, Object> properties = cache.get(o);
		if (properties == null) {
			properties = new HashMap<String, Object>();
		}
		properties.put(property, value);
		cache.put(o, properties);
	}
	
	public Object get(Object o, String property) {
		Map<String, Object> properties = cache.get(o);
		if (properties == null) {
			return null;
		}
		else {
			return properties.get(property);
		}
	}
		
}
