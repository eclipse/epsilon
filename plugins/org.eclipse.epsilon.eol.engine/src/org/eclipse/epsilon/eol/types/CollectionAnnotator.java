package org.eclipse.epsilon.eol.types;

import java.util.Collection;
import java.util.WeakHashMap;

public class CollectionAnnotator {
	
	protected WeakHashMap<Collection, AnnotatedCollectionType> cache = new WeakHashMap<Collection, AnnotatedCollectionType>();
	protected static CollectionAnnotator instance = new CollectionAnnotator();
	
	public void annotate(Collection c, AnnotatedCollectionType ct) {
		cache.put(c, ct);
	}
	
	public AnnotatedCollectionType getType(Collection c) {
		return cache.get(c);
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
