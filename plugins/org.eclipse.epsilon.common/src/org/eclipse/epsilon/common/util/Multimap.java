/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
		Collection<V> col = storage.get(key);
		return col != null && !col.isEmpty();
	}
	
	public void putAll(K key, Collection<V> values) {
		storage.put(key, values);
	}
	
	@Override
	public String toString() {
		return storage.toString();
	}
}
