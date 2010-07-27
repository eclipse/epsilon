package org.eclipse.epsilon.eol.types;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;

public class CollectionAnnotator {
	
	protected HashMap<WeakReference, AnnotatedCollectionType> cache = new HashMap<WeakReference, AnnotatedCollectionType>();
	protected HashSet<WeakReference> toRemove = new HashSet<WeakReference>();
	protected WeakHashMap<Object, Object> fastCache = new WeakHashMap<Object, Object>();
	
	protected static CollectionAnnotator instance = new CollectionAnnotator();
	
	public void annotate(Collection c, AnnotatedCollectionType ct) {
		WeakReference ref = new WeakReference(c);
		fastCache.put(c, null);
		cache.put(ref, ct);
		
		// If the cache grows too much, do a complete
		// clean up (doesn't help too much)
//		if (cache.size() > 2 * fastCache.size()) {
//			for (WeakReference check : cache.keySet()) {
//				if (check.get() == null) {
//					toRemove.add(check);
//				}
//			}
//		}
		
		if (!toRemove.isEmpty()) {
			for (WeakReference remove : toRemove) {
				cache.remove(remove);
			}
			toRemove.clear();
		}
		
	}
	
	public AnnotatedCollectionType getType(Collection c) {
		
		if (!fastCache.containsKey(c)) {
			return null;
		}
		
		for (WeakReference ref : cache.keySet()) {
			Object target = ref.get();
			if (target == c) {
				return cache.get(ref);
			}
			else if (target == null) {
				toRemove.add(ref);
			}
		}
		return null;
	}
	
	public static CollectionAnnotator getInstance() {
		return instance;
	}
	
	public enum AnnotatedCollectionType {
		Bag,
		Sequence,
		Set,
		OrderedSet
	}
	
}
