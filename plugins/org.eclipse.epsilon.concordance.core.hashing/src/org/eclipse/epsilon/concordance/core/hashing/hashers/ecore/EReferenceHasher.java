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


import static java.util.Arrays.asList;

import java.util.Collection;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.epsilon.concordance.core.hashing.hashers.java.TypeSafeHasher;


public class EReferenceHasher extends TypeSafeHasher<EReference> {

	private final MetamodelElementHasher hasher;
	
	private EReferenceHasher() {
		hasher = new MetamodelElementHasher("name", "lowerBound", "upperBound", "containment");
	}
	
	private static EReferenceHasher instance = new EReferenceHasher();
	
	public static EReferenceHasher getInstance() {
		return instance;
	}

	@Override
	public int hashSafely(EReference item) {
		return hasher.hashSafely(item, calculateExtraValuesToHash(item));
	}

	private Collection<String> calculateExtraValuesToHash(EReference item) {
		return asList(fullyQualifiedNameOf(item.getEType()), fullyQualifiedNameOf(item.getEOpposite()));
	}
	
	private static String fullyQualifiedNameOf(ENamedElement metamodelElement) {
		if (metamodelElement == null)
			return "";
		
		String prefix = "";
		
		if (metamodelElement.eContainer() instanceof ENamedElement) {
			prefix = fullyQualifiedNameOf((ENamedElement)metamodelElement.eContainer()) + ".";
		}
		
		return prefix + metamodelElement.getName();
	}
}
