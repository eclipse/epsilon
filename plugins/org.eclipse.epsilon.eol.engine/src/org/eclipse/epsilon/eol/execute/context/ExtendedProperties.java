package org.eclipse.epsilon.eol.execute.context;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Supplier;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

public class ExtendedProperties {
	
	public static void main(String[] args) {
		ExtendedProperties e = new ExtendedProperties();
		e.setPropertyValue(1, "foo", "bar");
		System.err.println(e.getPropertyValue(2, "foo"));
	}
	
	protected Table<Object, String, Object> cache = Tables.newCustomTable(
			new MapMaker().weakKeys().<Object, Map<String, Object>>makeMap(),
			new Supplier<Map<String, Object>>() {
				@Override
				public Map<String, Object> get() {
					return new HashMap<String, Object>();
				}
			});
	
	public Object getPropertyValue(Object o, String property) {
		return cache.get(o, property);
	}
	
	public void setPropertyValue(Object o, String property, Object value) {
		cache.put(o, property, value);
	}
	
	public Map<String, Object> getPropertyValues(Object o) {
		return cache.rowMap().get(o);
	}
	
	public void clear() {
		cache.clear();
	}
	
}
