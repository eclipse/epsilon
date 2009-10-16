package org.eclipse.epsilon.hutn.xmi.hashing.hashers.ecore;
import static org.eclipse.epsilon.test.util.builders.emf.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.hutn.xmi.hashing.hashers.ecore.EClassHasher;
import org.junit.Test;


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

public class EClassHasherTests {

	private final EClassHasher hasher = EClassHasher.getInstance();

	@Test
	public void classesWithEquivalentFeatureHaveSameHashCode() {
		final EAttribute name1 = anEAttribute().named("name").build();
		final EAttribute name2 = anEAttribute().named("name").build();
		
		final EClass class1 = anEClass().with(name1).build();
		final EClass class2 = anEClass().with(name2).build();
		
		assertThat(hashOf(class1), equalTo(hashOf(class2)));
	}
	
	@Test
	public void classesWithDifferentFeatureHaveDifferentHashCodes() {
		final EAttribute name = anEAttribute().named("name").build();
		final EAttribute nom  = anEAttribute().named("nom").build();
		
		final EClass class1 = anEClass().with(name).build();
		final EClass class2 = anEClass().with(nom).build();
		
		assertThat(hashOf(class1), not(equalTo(hashOf(class2))));
	}
	
	private int hashOf(EClass eClass) {
		return hasher.hash(eClass);
	}
}
