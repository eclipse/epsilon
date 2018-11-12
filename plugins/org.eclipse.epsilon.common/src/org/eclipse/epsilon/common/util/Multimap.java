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

/**
 * A {@linkplain Map} which allows each to be associated with multiple values.
 * @param <K> The key type.
 * @param <V> The type of values.
 */
public class Multimap<K, V> {
	
	protected final Map<K, Collection<V>> storage;
	protected final boolean isConcurrent;
	
	/**
	 * Creates a non-concurrent Multimap.
	 */
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
	
	/**
	 * Returns all values associated with the key.
	 * @param key
	 * @return The associated values, or an empty collection if the key was not present.
	 */
	public Collection<V> get(K key) {
		return storage.containsKey(key) ? storage.get(key) : Collections.emptyList();
	}
	
	/**
	 * Returns all values associated with the key.
	 * @param key
	 * @return An empty Optional if no mapping was present.
	 * @since 1.6
	 */
	public Optional<Collection<V>> getOptional(K key) {
		return Optional.ofNullable(storage.get(key));
	}
	
	/**
	 * Returns all values associated with the key.
	 * @param key
	 * @return A collection of the associated values, or <code>null</code> if no mapping was present.
	 * @since 1.6
	 */
	public Collection<V> getNullable(K key) {
		return storage.get(key);
	}

	/**
	 * Adds the given value to the associations for the key.
	 * @param key
	 * @param value
	 * @return Whether a mapping existed for the key.
	 */
	public boolean put(K key, V value) {
		Collection<V> values = storage.get(key);
		boolean wasPresent = true;
		
		if (values == null) {
			wasPresent = false;
			storage.put(key, values = isConcurrent ? new ConcurrentLinkedQueue<>() : new LinkedList<>());
		}
		
		values.add(value);
		return wasPresent;
	}

	/**
	 * Removes the specified value associated with the given key.
	 * @param key
	 * @param value
	 * @return Whether the key was present and the associated collection of values was changed.
	 */
	public boolean remove(K key, V value) {
		Collection<V> col = storage.get(key);
		return col != null && col.remove(value);
	}

	/**
	 * Removes all values associated with the key, leaving the key itself in place,
	 * by calling {@link Collection#clear()} if the mapping is present.
	 * @param key
	 * @return Whether the key was present and the collection changed as a result.
	 * @since 1.6
	 */
	public boolean removeAll(K key) {
		Collection<V> values = storage.get(key);
		boolean changed = false;
		if (values != null) {
			changed = !values.isEmpty();
			values.clear();
		}
		return changed;
	}
	
	/**
	 * Deletes the specified key from this map.
	 * @param key
	 * @return The values associated with the key, or <code>null</code> if no mapping was present.
	 */
	public Collection<V> removeKey(K key) {
		return storage.remove(key);
	}
	
	/**
	 * Removes all mappings.
	 */
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
	
	/**
	 * Associates all of the specified values for the given key.
	 * @param key
	 * @param values The additional values to associate with the key.
	 * @return Whether the key was present.
	 */
	public boolean putAll(K key, Collection<V> values) {
		boolean wasPresent = storage.containsKey(key) && storage.get(key).addAll(values);
		if (!wasPresent) {
			storage.put(key, values);
		}
		return wasPresent;
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
		
		return this.storage.equals(other.storage);
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(storage);
	}
	
	@Override
	public String toString() {
		return storage.toString();
	}
}
