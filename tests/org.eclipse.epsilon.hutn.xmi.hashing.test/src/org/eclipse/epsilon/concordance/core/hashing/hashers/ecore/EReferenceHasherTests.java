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

import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EReferenceBuilder.anEReference;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.epsilon.concordance.core.hashing.hashers.ecore.EReferenceHasher;
import org.junit.Test;


public class EReferenceHasherTests {

	private final EReferenceHasher hasher = EReferenceHasher.getInstance();
	
	@Test
	public void referencesWithSameTypeHaveSameHashCode() {
		final EClass type = anEClass().build();
		final EReference ref1 = anEReference().withType(type).build();
		final EReference ref2 = anEReference().withType(type).build();
		
		assertThat(hashOf(ref1), equalTo(hashOf(ref2)));
	}
	
	
	@Test
	public void referencesWithEquivalentTypesHaveSameHashCode() {
		final EClass type1 = anEClass().named("type").build();
		final EClass type2 = anEClass().named("type").build();
		
		final EReference ref1 = anEReference().withType(type1).build();
		final EReference ref2 = anEReference().withType(type2).build();

		assertThat(hashOf(ref1), equalTo(hashOf(ref2)));
	}
	
	@Test
	public void referencesWithDifferentTypeHaveDifferentHashCodes() {
		final EClass pounds  = anEClass().named("pounds").build();
		final EClass dollars = anEClass().named("dollars").build();
		
		final EReference poundsRef  = anEReference().withType(pounds).build();
		final EReference dollarsRef = anEReference().withType(dollars).build();
		
		assertThat(hashOf(poundsRef), not(equalTo(hashOf(dollarsRef))));
	}
	

	private int hashOf(EReference reference) {
		return hasher.hash(reference);
	}
}
