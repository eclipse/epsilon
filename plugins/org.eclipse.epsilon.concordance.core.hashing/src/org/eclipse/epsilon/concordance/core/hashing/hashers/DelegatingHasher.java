/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.core.hashing.hashers;

import java.util.Arrays;
import java.util.Collection;
import org.eclipse.epsilon.concordance.core.hashing.hashers.ecore.EAttributeHasher;
import org.eclipse.epsilon.concordance.core.hashing.hashers.ecore.EClassHasher;
import org.eclipse.epsilon.concordance.core.hashing.hashers.ecore.EDataTypeHasher;
import org.eclipse.epsilon.concordance.core.hashing.hashers.ecore.EPackageHasher;
import org.eclipse.epsilon.concordance.core.hashing.hashers.ecore.EReferenceHasher;
import org.eclipse.epsilon.concordance.core.hashing.hashers.java.CollectionHasher;
import org.eclipse.epsilon.concordance.core.hashing.hashers.java.JavaObjectHasher;
import org.eclipse.epsilon.concordance.core.hashing.hashers.java.TypeSafeHasher;

public class DelegatingHasher implements Hasher {

	private static DelegatingHasher instance = new DelegatingHasher();
	
	public static DelegatingHasher getInstance() {
		return instance;
	}
	
	private DelegatingHasher() {}
	
	
	private final Collection<TypeSafeHasher<?>> typeSafeHashers = Arrays.asList((TypeSafeHasher<?>)EPackageHasher.getInstance(),
	                                                                         EClassHasher.getInstance(),
	                                                                         EDataTypeHasher.getInstance(),
	                                                                         EAttributeHasher.getInstance(),
	                                                                         EReferenceHasher.getInstance(),
	                                                                         CollectionHasher.getInstance());	
	
	@Override
	public int hash(Object object) {
		return hasherFor(object).hash(object);
	}

	private Hasher hasherFor(Object object) {
		Hasher hasher = null;
		
		for (TypeSafeHasher<?> typeSafeHasher : typeSafeHashers) {
			if (typeSafeHasher.applicableFor(object)) {
				hasher = typeSafeHasher;
			}
		}
		
		if (hasher == null) {
			hasher = JavaObjectHasher.getInstance();
		}
		
		return hasher;
	}
}
