/*******************************************************************************
 * Copyright (c) 2010-2018 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Sina Madani - concurrency support, refactoring, additional methods
 ******************************************************************************/
package org.eclipse.epsilon.common.util;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;
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

	/**
	 * Removes all values associated with the key.
	 * @param key
	 * @return All values associated with the key, or <code>null</code> if the key was not present.
	 * @since 1.6
	 */
	public Collection<V> removeAll(K key) {
		return storage.remove(key);
	}
	
	public void clear() {
		storage.clear();
	}

	/**
	 * 
	 * @param key
	 * @return Whether the given key has one or more values associated with it.
	 */
	public boolean containsKey(K key) {
		Collection<V> col = storage.get(key);
		return col != null && !col.isEmpty();
	}
	
	/**
	 *
	 * @param key
	 * @return Whether the key is present in they keySet.
	 * @since 1.6
	 */
	public boolean hasKey(K key) {
		return storage.containsKey(key);
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
	 * Streams the values for the given key.
	 * @param key
	 * @return The stream of values for the key, or an empty stream if the key is not present.
	 * @since 1.6
	 */
	public Stream<V> stream(K key) {
		Collection<V> colForKey = storage.get(key);
		return colForKey != null ? colForKey.stream() : Stream.empty();
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
