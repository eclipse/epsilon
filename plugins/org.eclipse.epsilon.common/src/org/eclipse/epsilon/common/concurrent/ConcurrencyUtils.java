package org.eclipse.epsilon.common.concurrent;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrencyUtils {
	
	/**
	 * The number of logical cores in the system.
	 */
	public static final int DEFAULT_PARALLELISM = Runtime.getRuntime().availableProcessors();
	
	//Should be a power of 2.
	private static final int DEFAULT_CAPACITY = 16;
	//@see https://stackoverflow.com/questions/10901752/what-is-the-significance-of-load-factor-in-hashmap
	private static final float DEFAULT_LOAD_FACTOR = 0.7f;
	
	public static <T> Set<T> concurrentSet() {
		return concurrentSet(-1, -1);
	}
	
	public static <T> Set<T> concurrentSet(Collection<T> initial) {
		Set<T> cs = ConcurrencyUtils.<T, Boolean>newConcurrentHashMap(
				null, initial != null ? initial.size() : -1, -1
			).keySet(Boolean.TRUE);
		cs.addAll(initial);
		return cs;
	}
	
	public static <T> Set<T> concurrentSet(int initialCapacity, int parallelism) {
		return ConcurrencyUtils.<T, Boolean>newConcurrentHashMap(null, initialCapacity, parallelism).keySet(Boolean.TRUE);
	}
	
	public static <K, V> ConcurrentMap<K, V> concurrentMap() {
		return newConcurrentHashMap(null, -1, -1);
	}
	
	public static <K, V> ConcurrentMap<K, V> concurrentMap(Map<K, V> initial) {
		return newConcurrentHashMap(initial, -1, -1);
	}
	
	public static <K, V> ConcurrentMap<K, V> concurrentMap(int initialCapacity, int parallelism) {
		return newConcurrentHashMap(null, initialCapacity, parallelism);
	}
	
	private static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap(Map<K, V> initial, int initialCapacity, int parallelism) {
		if (initial != null) return new ConcurrentHashMap<>(initial);
		else return new ConcurrentHashMap<>(
			initialCapacity >= 0 ? initialCapacity : DEFAULT_CAPACITY,
			DEFAULT_LOAD_FACTOR,
			parallelism > 0 ? parallelism : 1+DEFAULT_PARALLELISM/2
		);
	}
}
