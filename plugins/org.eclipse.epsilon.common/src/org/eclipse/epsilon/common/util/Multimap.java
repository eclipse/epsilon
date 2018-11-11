/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Sina Madani - concurrency support
 ******************************************************************************/
package org.eclipse.epsilon.common.util;

import java.util.*;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;

public class Multimap<K, V> {
	
	protected final Map<K, Collection<V>> storage;
	
	public Multimap() {
		this(false);
	}
	
	public Multimap(boolean concurrent) {
		storage = concurrent ? ConcurrencyUtils.concurrentMap() : new HashMap<>();
	}
	
	public Multimap(boolean concurrent, Multimap<K, V> other) {
		storage = concurrent ? ConcurrencyUtils.concurrentMap(other.storage) : new HashMap<>(other.storage);
	}
	
	public Collection<V> get(K key) {
		return storage.containsKey(key) ? storage.get(key) : new LinkedList<>();
	}

	public void put(K key, V value) {
		if (!storage.containsKey(key)) {
			storage.put(key, new LinkedList<V>());
		}
		
		storage.get(key).add(value);
	}

	public boolean remove(K key, V value) {
		Collection<V> col = storage.get(key);
		return col != null && col.remove(value);
	}

	public void clear() {
		storage.clear();
	}

	public boolean containsKey(K key) {
		return containsKey(key, false);
	}
	
	/**
	 * 
	 * @param key
	 * @param includeEmpty Ignores whether the collection is empty if set to <codeE>true</code>.
	 * @return
	 * @since 1.6
	 */
	public boolean containsKey(K key, boolean includeEmpty) {
		Collection<V> col = storage.get(key);
		return col != null && (includeEmpty || !col.isEmpty());
	}
	
	public void putAll(K key, Collection<V> values) {
		storage.put(key, values);
	}
	
	@Override
	public String toString() {
		return storage.toString();
	}
}
