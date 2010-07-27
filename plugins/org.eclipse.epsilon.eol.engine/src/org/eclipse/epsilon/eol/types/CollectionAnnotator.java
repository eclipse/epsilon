package org.eclipse.epsilon.eol.types;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;

public class CollectionAnnotator {
	
	protected HashMap<WeakReference, AnnotatedCollectionType> cache = new HashMap<WeakReference, AnnotatedCollectionType>();
	
	protected static CollectionAnnotator instance = new CollectionAnnotator();
	
	public void annotate(Collection c, AnnotatedCollectionType ct) {
		WeakReference ref = new WeakReference(c);
		cache.put(ref, ct);
	}
	
	public AnnotatedCollectionType getType(Collection c) {
		for (WeakReference ref : cache.keySet()) {
			if (ref.get() == c) {
				return cache.get(ref);
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
