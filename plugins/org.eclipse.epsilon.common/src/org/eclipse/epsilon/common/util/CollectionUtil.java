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
package org.eclipse.epsilon.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtil {
	
	public static Collection<?> asCollection(Object o) {
		if (o instanceof Collection) {
			return (Collection<?>) o;
		}
		else {
			ArrayList<Object> list = new ArrayList<Object>();
			list.add(o);
			return list;
		}
	}
	
	public static List<?> asList(Object o) {
		if (o instanceof List) {
			return (List<?>) o;
		}
		else if (o instanceof Collection) {
			List<Object> list = createDefaultList();
			list.addAll((Collection<?>)o);
			return list;
		}
		else {
			List<Object> list = createDefaultList();
			list.add(o);
			return list;
		}
	}
	
	public static Set<?> asSet(Object o) {
		if (o instanceof Set) {
			return (Set<?>) o;
		}
		else if (o instanceof Collection) {
			Set<Object> set = createDefaultSet();
			set.addAll((Collection<?>)o);
			return set;
		}
		else {
			Set<Object> set = createDefaultSet();
			set.add(o);
			return set;
		}
	}
	
	public static <T> Collection<T> flatten(Collection<T> original) {
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
		
		Collection<T> flattened = createDefaultList();
		for (T next : original) {
			if (next instanceof Collection){
				flattened.addAll(flatten((Collection<T>)next));
			}
			else {
				flattened.add(next);
			}
		}
		return flattened;
	}
		
	public static <T> Set<T> createDefaultSet() {
		return new LinkedHashSet<T>();
	}
	
	public static <T> List<T> createDefaultList() {
		return new ArrayList<T>();
	}
	
	public static <T> List<T> asList(Collection<T> c) {
		if (c instanceof List) {
			return (List<T>) c;
		}
		else {
			ArrayList<T> copy = new ArrayList<T>();
			copy.addAll(c);
			return copy;
		}
	}
	
	public static <T> Object getFirst(Iterable<T> c) {
		final Iterator<T> it = c.iterator();
		if (!it.hasNext()) {
			return null;
		} else {
			return it.next();
		}
	}
	
	public static <T> List<T> iterate(Iterable<T> iterable) {
		List<T> filled = createDefaultList();
		Iterator<T> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			filled.add(iterator.next());
		}
		return filled;
	}
	
	public static String join(Iterable<?> collection, String delimiter) {
		return join(collection, delimiter, new ElementPrinter() {
			@Override
			public String print(Object element) {
				return element.toString();
			}
		});
	}
	
	public static String join(Iterable<?> collection, String delimiter, ElementPrinter printer) {
		final StringBuilder result = new StringBuilder();

		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext();) {
			Object next = iterator.next();
			result.append(printer.print(next));
			if (iterator.hasNext()) {
				result.append(delimiter);
			}
		}
		return result.toString();
	}
	
	public static interface ElementPrinter {
		public String print(Object element);
	}
}
