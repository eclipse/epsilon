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
package org.eclipse.epsilon.concordance.core.hashing.hashers.ecore;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.epsilon.concordance.core.hashing.hashers.java.TypeSafeHasher;


public class EAttributeHasher extends TypeSafeHasher<EAttribute> {

	private final MetamodelElementHasher hasher;
	
	private EAttributeHasher() {
		hasher = new MetamodelElementHasher("name", "lowerBound", "upperBound", "eType");
	}
	
	private static EAttributeHasher instance = new EAttributeHasher();
	
	public static EAttributeHasher getInstance() {
		return instance;
	}

	@Override
	public int hashSafely(EAttribute item) {
		return hasher.hashSafely(item);
	}
}
