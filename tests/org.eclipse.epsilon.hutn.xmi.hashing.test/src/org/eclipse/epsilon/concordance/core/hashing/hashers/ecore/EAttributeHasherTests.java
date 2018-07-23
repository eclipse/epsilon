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

import static org.eclipse.epsilon.test.util.builders.emf.EAttributeBuilder.MANY;
import static org.eclipse.epsilon.test.util.builders.emf.EAttributeBuilder.anEAttribute;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.concordance.core.hashing.hashers.ecore.EAttributeHasher;
import org.junit.Test;


public class EAttributeHasherTests {

	private final EAttributeHasher hasher = EAttributeHasher.getInstance();
	
	@Test
	public void attributesWithSameNameHaveSameHashCode() {
		final EAttribute age1 = anEAttribute().named("age").build();
		final EAttribute age2 = anEAttribute().named("age").build();
		
		assertThat(hashOf(age1), equalTo(hashOf(age2)));
	}
	
	@Test
	public void attributesWithNoNameHaveSameHashCode() {
		final EAttribute unnamed1 = anEAttribute().build();
		final EAttribute unnamed2 = anEAttribute().build();
		
		assertThat(hashOf(unnamed1), equalTo(hashOf(unnamed2)));
	}
	
	@Test
	public void attributesWithDifferentNameHaveDifferentHashCodes() {
		final EAttribute age = anEAttribute().named("age").build();
		final EAttribute dob = anEAttribute().named("dob").build();
		
		assertThat(hashOf(age), not(equalTo(hashOf(dob))));
	}
	
	@Test
	public void attributesWithSameNameAndSameMultiplicityHaveSameHashCode() {
		final EAttribute age1 = anEAttribute().named("age").withBounds(1, MANY).build();
		final EAttribute age2 = anEAttribute().named("age").withBounds(1, MANY).build();
		
		assertThat(hashOf(age1), equalTo(hashOf(age2)));
	}
	
	@Test
	public void attributesWithSameNameAndDifferentLowerBoundHaveDifferentHashCodes() {
		final EAttribute mandatory = anEAttribute().named("age").withBounds(1, MANY).build();
		final EAttribute optional  = anEAttribute().named("age").withBounds(0, MANY).build();
		
		assertThat(hashOf(mandatory), not(equalTo(hashOf(optional))));
	}
	
	@Test
	public void attributesWithSameNameAndDifferentUpperBoundHaveDifferentHashCodes() {
		final EAttribute single = anEAttribute().named("age").withBounds(1, 1).build();
		final EAttribute many   = anEAttribute().named("age").withBounds(1, MANY).build();
		
		assertThat(hashOf(single), not(equalTo(hashOf(many))));
	}
	
	@Test
	public void attributesWithSameTypeHaveSameHashCode() {
		final EAttribute integer1 = anEAttribute().withType(EcorePackage.eINSTANCE.getEInt()).build();
		final EAttribute integer2 = anEAttribute().withType(EcorePackage.eINSTANCE.getEInt()).build();
		
		assertThat(hashOf(integer1), equalTo(hashOf(integer2)));
	}
	
	@Test
	public void attributesWithDifferentTypeHaveDifferentHashCode() {
		final EAttribute _int   = anEAttribute().withType(EcorePackage.eINSTANCE.getEInt()).build();
		final EAttribute _float = anEAttribute().withType(EcorePackage.eINSTANCE.getEFloat()).build();
		
		assertThat(hashOf(_int), not(equalTo(hashOf(_float))));
	}
	

	private int hashOf(EAttribute attribute) {
		return hasher.hash(attribute);
	}
}
