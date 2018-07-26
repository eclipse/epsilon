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
package org.eclipse.epsilon.concordance.core.hashing.hashers.ecore;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.concordance.core.hashing.hashers.java.TypeSafeHasher;


public class EClassHasher extends TypeSafeHasher<EClass> {

	private final MetamodelElementHasher hasher;
	
	private EClassHasher() {
		hasher = new MetamodelElementHasher("name", "eStructuralFeatures");
	}

	private static EClassHasher instance = new EClassHasher();
	
	public static EClassHasher getInstance() {
		return instance;
	}
	
	@Override
	public int hashSafely(EClass item) {
		return hasher.hashSafely(item);
	}
}
