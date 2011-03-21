package org.eclipse.epsilon.eol.types;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.eol.util.IdentityBasedWeakHashMap;

public class CollectionAnnotator {
	
	
	public static void main(String[] args) throws Exception {
		
		for (int i=1;i<1000;i++){
			CollectionAnnotator.getInstance().annotate(new ArrayList(), AnnotatedCollectionType.Sequence);
		}
		
		System.gc();
		
		Thread.sleep(1000);
		
		System.err.println(CollectionAnnotator.getInstance().cacheSize());
		
	}
	
	public int cacheSize() {
		return cache.size();
	}
	
	protected IdentityBasedWeakHashMap<Object, AnnotatedCollectionType> cache = 
		new IdentityBasedWeakHashMap<Object, AnnotatedCollectionType>();
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
