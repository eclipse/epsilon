package org.eclipse.epsilon.eol.types;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;

public class CollectionAnnotator {
	
	protected Map<IdentityBasedWeakReference, AnnotatedCollectionType> cache = new WeakHashMap<IdentityBasedWeakReference, AnnotatedCollectionType>();
	
	protected static CollectionAnnotator instance = new CollectionAnnotator();
	
	public void annotate(Collection c, AnnotatedCollectionType ct) {
		cache.put(new IdentityBasedWeakReference(c), ct);
	}
	
	public AnnotatedCollectionType getType(Collection c) {		
		return cache.get(new IdentityBasedWeakReference(c));
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
	
	class IdentityBasedWeakReference extends WeakReference<Object> {

		public IdentityBasedWeakReference(Object referent) {
			super(referent);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == null) return false;
			else return this.hashCode() == obj.hashCode();
		}
		
		@Override
		public int hashCode() {
			if (this.get() != null) {
				return System.identityHashCode(this.get());
			}
			else {
				return super.hashCode();
			}
		}
		
	}
}
