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
