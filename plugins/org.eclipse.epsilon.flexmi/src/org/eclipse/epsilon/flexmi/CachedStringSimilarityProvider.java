package org.eclipse.epsilon.flexmi;

import java.util.HashMap;

public class CachedStringSimilarityProvider implements StringSimilarityProvider {
	
	protected HashMap<String, Integer> cache = new HashMap<String, Integer>();
	protected StringSimilarityProvider delegate;
	
	public CachedStringSimilarityProvider(StringSimilarityProvider delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public int getSimilarity(String one, String other) {
		
		Integer similarity = cache.get(one + "-" + other);
		if (similarity == null) {
			similarity = delegate.getSimilarity(one, other);
			cache.put(one + "-" + other, similarity);
		}
		return similarity;
	}

}
