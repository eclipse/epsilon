package org.eclipse.epsilon.hutn.xmi.hashing.hashers.ecore;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.hutn.xmi.hashing.hashers.java.TypeSafeHasher;

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
