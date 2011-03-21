package org.eclipse.epsilon.eol.util;

import java.util.Map;
import java.util.WeakHashMap;

public class IdentityBasedWeakHashMap<K, V> {
	
	protected WeakHashMap<IdentityBasedWeakReference, V> map = new 
		WeakHashMap<IdentityBasedWeakReference, V>();
	
	public V get(Object key) {
		return map.get(new IdentityBasedWeakReference(key));
	}
	
	public V put(K key, V value) {
		return map.put(new IdentityBasedWeakReference(key), value);
	}
	
	public int size() {
		return map.size();
	}
	
}
