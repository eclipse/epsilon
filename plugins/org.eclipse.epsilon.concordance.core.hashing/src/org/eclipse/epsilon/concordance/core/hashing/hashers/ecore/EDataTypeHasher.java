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


import org.eclipse.emf.ecore.EDataType;
import org.eclipse.epsilon.concordance.core.hashing.hashers.java.TypeSafeHasher;


public class EDataTypeHasher extends TypeSafeHasher<EDataType> {

	private final MetamodelElementHasher hasher;
	
	private EDataTypeHasher() {
		hasher = new MetamodelElementHasher("name");
	}

	private static EDataTypeHasher instance = new EDataTypeHasher();
	
	public static EDataTypeHasher getInstance() {
		return instance;
	}

	@Override
	public int hashSafely(EDataType item) {
		return hasher.hashSafely(item);
	}
}
