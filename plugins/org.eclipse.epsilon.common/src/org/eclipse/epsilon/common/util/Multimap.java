/*******************************************************************************
 * Copyright (c) 2010-2018 The University of York.
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
import java.util.concurrent.ConcurrentLinkedQueue;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;

public class Multimap<K, V> {
	
	protected final Map<K, Collection<V>> storage;
	protected final boolean isConcurrent;
	
	public Multimap() {
		this(false);
	}
	
	/**
	 * 
	 * @param concurrent Whether this implementation should be thread-safe.
	 * @since 1.6
	 */
	public Multimap(boolean concurrent) {
		storage = (this.isConcurrent = concurrent) == true ?
			ConcurrencyUtils.concurrentMap() : new HashMap<>();
	}
	
	/**
	 * 
	 * @param concurrent Whether this implementation should be thread-safe.
	 * @param other The Multimap to copy from.
	 * @since 1.6
	 */
	public Multimap(boolean concurrent, Multimap<K, V> other) {
		storage = (this.isConcurrent = concurrent) == true ?
			ConcurrencyUtils.concurrentMap(other.storage) : new HashMap<>(other.storage);
	}
	
	public Collection<V> get(K key) {
		return storage.containsKey(key) ? storage.get(key) : new LinkedList<>();
	}

	public void put(K key, V value) {
		Collection<V> colForKey = storage.get(key);
		
		if (colForKey == null) {
			storage.put(key, colForKey = isConcurrent ? new ConcurrentLinkedQueue<>() : new LinkedList<>());
		}
		
		colForKey.add(value);
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
	
	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	public boolean isThreadSafe() {
		return isConcurrent;
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Multimap)) return false;
		
		Multimap<?, ?> other = (Multimap<?, ?>) obj;
		
		return
			this.isConcurrent == other.isConcurrent &&
			Objects.equals(this.storage, other.storage);
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isConcurrent, storage);
	}
	
	@Override
	public String toString() {
		return storage.toString();
	}
}
