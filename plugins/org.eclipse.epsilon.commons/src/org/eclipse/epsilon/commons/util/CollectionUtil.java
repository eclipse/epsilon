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
package org.eclipse.epsilon.commons.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class CollectionUtil {
	
	public static void main(String[] args) {
		ArrayList<Named> n = new ArrayList<Named>();
		n.add(new Named("a"));
		n.add(new Named("b"));
		n.add(new Named("c"));
		ArrayList<String> names = new ArrayList<String>();
		names.add("a");
		names.add("c");
		System.err.println(CollectionUtil.getObjectsByNames(n, names));
	}
	
	static class Named {
		
		protected String name;
		
		public Named(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	public static Collection getObjectsByNames(Collection source, Collection<String> names) {
		Collection result = new ArrayList();
		for (Object object : source) {
			String name = null;
			try {
				name = (String) ReflectionUtil.invokeMethod(object, "getName", Collections.EMPTY_LIST);
			} catch (Exception e) {
				// Ignore
			}
			if (name!=null && names.contains(name)) {
				result.add(object);
			}
		}
		return result;
	}
	
	public static String toString(Collection col) {
		String ret = "{";
		Iterator it = col.iterator();
		while (it.hasNext()) {
			ret = ret + StringUtil.toString(it.next());
			if (it.hasNext()) {
				ret = ret + ", ";
			}
		}
		return ret;
	}
	
	public static void print(Collection col, Object header) {
		Iterator it = col.iterator();
		System.err.println("-------" + StringUtil.toString(header) + "--------");
		while (it.hasNext()) {
			System.err.println(it.next());
		}
	}
	
	public static void print(Map map, Object header) {
		System.err.println("-------" + StringUtil.toString(header) + "--------");
		for (Object key : map.keySet()) {
			System.err.println(key + " -> " + map.get(key));
		}
	}
	
	public static Collection toCollection(Object o) {
		if (o instanceof Collection) {
			return (Collection) o;
		}
		else {
			ArrayList list = new ArrayList();
			list.add(o);
			return list;
		}
	}
}
