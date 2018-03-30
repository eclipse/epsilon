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
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class CollectionUtil {
	
	private CollectionUtil() {}
	
	@SafeVarargs
	public static <T> ArrayList<T> composeArrayListFrom(Collection<T>... collections) {
		int size = 0;
		for (Collection<T> col : collections) {
			size += col.size();
		}
		ArrayList<T> list = new ArrayList<>(size);
		for (Collection<T> col : collections) {
			list.addAll(col);
		}
		return list;
	}
	
	public static <T, C extends Collection<T>> C mergeCollectionsUnique(Collection<T> c1, Collection<T> c2, Supplier<? extends C> newCollection) {
		return Stream.concat(c1.stream(), c2.stream())
			.distinct()
			.collect(Collectors.toCollection(newCollection));
	}
	
	public static <T> Collection<T> asCollection(T o) {
		if (o instanceof Collection) {
			return (Collection<T>) o;
		}
		else {
			ArrayList<T> list = new ArrayList<>(1);
			list.add(o);
			return list;
		}
	}
	
	public static <T> List<T> asList(T o) {
		if (o instanceof List) {
			return (List<T>) o;
		}
		else {
			List<T> list = createDefaultList();
			
			if (o instanceof Collection)
				list.addAll((Collection<T>)o);
			else
				list.add(o);
			
			return list;
		}
	}
	
	public static <T> Set<T> asSet(T o) {
		if (o instanceof Set) {
			return (Set<T>) o;
		}
		else {
			Set<T> set = createDefaultSet();
			
			if (o instanceof Collection)
				set.addAll((Collection<T>)o);
			else
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
		return new LinkedHashSet<>();
	}
	
	public static <T> List<T> createDefaultList() {
		return new ArrayList<>();
	}
	
	public static <T> List<T> asList(Collection<T> c) {
		return c instanceof List ? (List<T>) c : new ArrayList<>(c);
	}
	
	public static <T> Object getFirst(Iterable<T> c) {
		Iterator<T> it = c.iterator();
		return it.hasNext() ? it.next() : null;
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
		return join(collection, delimiter, Object::toString);
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
		String print(Object element);
	}
}
