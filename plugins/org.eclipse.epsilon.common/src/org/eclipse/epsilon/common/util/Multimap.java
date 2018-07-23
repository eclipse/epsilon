/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Multimap<K, V> {
	
	private final Map<K, Collection<V>> storage = new HashMap<K, Collection<V>>();
	
	public Collection<V> get(K key) {
		return valueStoreFor(key);
	}

	public void put(K key, V value) {
		if (!storage.containsKey(key)) {
			storage.put(key, new LinkedList<V>());
		}
		
		storage.get(key).add(value);
	}

	public void remove(K key, V value) {
		valueStoreFor(key).remove(value);
	}

	public void clear() {
		storage.clear();
	}

	public boolean containsKey(K key) {
		return !(valueStoreFor(key).isEmpty());
	}
	
	public void putAll(K key, Collection<V> values) {
		storage.put(key, values);
	}

	private Collection<V> valueStoreFor(K key) {
		return storage.containsKey(key) ? storage.get(key) : new LinkedList<V>();
	}
	
	@Override
	public String toString() {
		return storage.toString();
	}
}
