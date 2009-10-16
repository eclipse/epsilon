package org.eclipse.epsilon.hutn.xmi.hashing.hashers.ecore;
import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.hutn.xmi.hashing.hashers.ecore.EPackageHasher;
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

public class EPackageHasherTests {

	private final EPackageHasher hasher = EPackageHasher.getInstance();

	@Test
	public void packagesWithEquivalentClassesHaveSameHashCode() {
		final EClass name1 = anEClass().named("Person").build();
		final EClass name2 = anEClass().named("Person").build();
		
		final EPackage pkg1 = aMetamodel().with(name1).build();
		final EPackage pkg2 = aMetamodel().with(name2).build();
		
		assertThat(hashOf(pkg1), equalTo(hashOf(pkg2)));
	}
	
	@Test
	public void packagesWithDifferentClassesHaveDifferentHashCodes() {
		final EClass person   = anEClass().named("Person").build();
		final EClass employee = anEClass().named("Employee").build();
		
		final EPackage pkg1 = aMetamodel().with(person).build();
		final EPackage pkg2 = aMetamodel().with(employee).build();
		
		assertThat(hashOf(pkg1), not(equalTo(hashOf(pkg2))));
	}
	
	private int hashOf(EPackage ePackage) {
		return hasher.hash(ePackage);
	}
}
