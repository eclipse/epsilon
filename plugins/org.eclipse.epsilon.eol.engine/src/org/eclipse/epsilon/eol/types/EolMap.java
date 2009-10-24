/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EolMap implements Map {

	public static void main(String[] args) {
		
		EolMap m = new EolMap();
		m.put(new EolInteger(1), 2);
		System.err.println(m.get(1));
		
	}
	
	protected HashMap internal = new HashMap();
	protected HashMap keyMap = new HashMap();
	
	public void clear() {
		internal.clear();
	}
	
	public boolean equals(Object o1, Object o2) {
		if (o1 == null && o2 == null) { return true; }
		if (o1 == null || o2 == null) { return false; }
		
		if (o1 == o2) return true;
		if (o1.equals(o2) || o2.equals(o1)) return true;
		
		return false;
	}
	
	public boolean containsKey(Object key) {
		return internal.containsKey(getRealKey(key));
	}

	public boolean containsValue(Object value) {
		if (internal.containsValue(value)) {
			return true;
		}
		else {
			DualStateObject dso = new DualStateObject(value);
			for (Object v : values()) {
				if (equals(new DualStateObject(v), dso)) return true;
			}
		}
		return false;
	}

	public Set entrySet() {
		return internal.entrySet();
	}

	public Object get(Object key) {
		return internal.get(getRealKey(key));
	}

	public Object getRealKey(Object key) {
		if (internal.containsKey(key)) {
			return key;
		}
		else if (keyMap.containsKey(key)) {
			return keyMap.get(key);
		}
		else {
			DualStateObject dso = new DualStateObject(key);
			for (Object k : internal.keySet()) {
				if (equals(new DualStateObject(k), dso)) {
					keyMap.put(key, k);
					return k;
				}
			}
			return key;
		}
	}
	
	public boolean isEmpty() {
		return internal.isEmpty();
	}

	public Set keySet() {
		return internal.keySet();
	}

	public Object put(Object key, Object value) {
		return internal.put(getRealKey(key), value);
	}

	public void putAll(Map m) {
		internal.putAll(m);
	}

	public Object remove(Object key) {
		return internal.remove(getRealKey(key));
	}

	public int size() {
		return internal.size();
	}

	public Collection values() {
		return internal.values();
	}

}
