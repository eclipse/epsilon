/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.eol.util.Cache;

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
	
	protected Cache<Object, AnnotatedCollectionType> cache = 
		new Cache<Object, AnnotatedCollectionType>();
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
	
	public void dispose() {
		cache.dispose();
	}
	
}
