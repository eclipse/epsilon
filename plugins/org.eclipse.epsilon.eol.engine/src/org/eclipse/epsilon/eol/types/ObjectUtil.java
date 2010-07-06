package org.eclipse.epsilon.eol.types;

import java.util.ArrayList;
import java.util.Collection;

public class ObjectUtil {
	
	public static boolean equals(Object o1, Object o2) {
		if (o1 == null && o2 == null) return true;
		if (o1 == null || o2 == null) return false;
		return o1.equals(o2);
	}
	
	public static Collection asCollection(Object o) {
		if (o instanceof Collection) {
			return (Collection) o;
		}
		else {
			ArrayList collection = new ArrayList();
			collection.add(o);
			return collection;
		}
	}
	
}
