/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.core.hashing.hashers.java;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.concordance.core.hashing.hashers.DelegatingHasher;

public class CollectionHasher extends TypeSafeHasher<Collection<?>> {

	private static CollectionHasher instance = new CollectionHasher();
	
	public static CollectionHasher getInstance() {
		return instance;
	}
	
	private CollectionHasher() {}

	@Override
	public int hashSafely(Collection<?> collection) {
		final List<Integer> hashes = new LinkedList<Integer>();
		
		for (Object element : collection) {
			hashes.add(DelegatingHasher.getInstance().hash(element));
		}
		
		return hashes.hashCode();
	}
}
