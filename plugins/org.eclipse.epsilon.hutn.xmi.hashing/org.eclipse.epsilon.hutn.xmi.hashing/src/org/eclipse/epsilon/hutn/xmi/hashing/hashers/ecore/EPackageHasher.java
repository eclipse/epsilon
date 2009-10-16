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
package org.eclipse.epsilon.hutn.xmi.hashing.hashers.ecore;


import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.xmi.hashing.hashers.java.TypeSafeHasher;

public class EPackageHasher extends TypeSafeHasher<EPackage> {
	
	private final MetamodelElementHasher hasher;
	
	private EPackageHasher() {
		hasher = new MetamodelElementHasher("name", "eClassifiers");
	}

	private static EPackageHasher instance = new EPackageHasher();
	
	public static EPackageHasher getInstance() {
		return instance;
	}
	
	@Override
	public int hashSafely(EPackage item) {
		return hasher.hashSafely(item);
	}
}
