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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionUtil {
	
	public static Collection asCollection(Object o) {
		if (o instanceof Collection) {
			return (Collection) o;
		}
		else {
			ArrayList list = new ArrayList<Object>();
			list.add(o);
			return list;
		}
	}
	
	public static List asList(Object o) {
		if (o instanceof List) {
			return (List) o;
		}
		else if (o instanceof Collection) {
			List list = createDefaultList();
			list.addAll((Collection)o);
			return list;
		}
		else {
			List list = createDefaultList();
			list.add(o);
			return list;
		}
	}
	
	public static Set asSet(Object o) {
		if (o instanceof Set) {
			return (Set) o;
		}
		else if (o instanceof Collection) {
			Set set = createDefaultSet();
			set.addAll((Collection)o);
			return set;
		}
		else {
			Set set = createDefaultSet();
			set.add(o);
			return set;
		}
	}
	
	
	public static Collection clone(Collection original) {
		Collection clone = createCollection(original);
		clone.addAll(original);
		return clone;
	}
	
	public static Collection flatten(Collection original) {
		// First see if there are no nested collections
		// and in this case just return this
		
		boolean hasNested = false;
		for (Object o : original) {
			if (o instanceof Collection) {
				hasNested = true;
				break;
			}
		}
		
		if (!hasNested) return original;
		
		// If there are nested collections
		
		Collection flattened = createDefaultList();
		for (Object next : original) {
			if (next instanceof Collection){
				flattened.addAll(flatten((Collection)next));
			}
			else {
				flattened.add(next);
			}
		}
		return flattened;
	}
	
	public static Collection createCollection(Collection original) {
		if (original instanceof Set)
			return createDefaultSet();
		else 
			return createDefaultList();
	}
	
	public static Set createDefaultSet() {
		return new LinkedHashSet();
	}
	
	public static List createDefaultList() {
		return new ArrayList();
	}
	
	public static List asList(Collection c) {
		if (c instanceof List) {
			return (List) c;
		}
		else {
			ArrayList copy = new ArrayList();
			copy.addAll(c);
			return copy;
		}
	}
	
	public static Object getFirst(Collection c) {
		
		if (c.size() == 0) return null;
		
		if (c instanceof List) {
			return ((List) c).get(0);
		}
		else {
			return c.iterator().next();
		}
		
	}
	
	public static List iterate(Iterable iterable) {
		List filled = createDefaultList();
		Iterator iterator = iterable.iterator();
		while (iterator.hasNext()) {
			filled.add(iterator.next());
		}
		return filled;
	}
	
	public static Collection join(Collection c1, Collection c2) {
		Collection joined = createCollection(c1);
		joined.addAll(c1);
		joined.addAll(c2);
		return joined;
	}
	
}
