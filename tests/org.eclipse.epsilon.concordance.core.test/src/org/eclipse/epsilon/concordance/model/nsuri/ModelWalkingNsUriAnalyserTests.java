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
package org.eclipse.epsilon.concordance.model.nsuri;

import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EPackageBuilder.aMetamodel;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.junit.Test;

public class ModelWalkingNsUriAnalyserTests {

	private static final EClass cat = anEClass().named("Cat").build();
	
	private static final EPackage pets = aMetamodel()
	                                     	.withNsURI("pets")
	                                     	.with(cat)
	                                     	.build();
	
	private static final EClass vet = anEClass().named("Vet").build();
	
	private static final EPackage jobs = aMetamodel()
	                                     	.withNsURI("jobs")
	                                     	.with(vet)
	                                     	.build();
	
	@Test
	public void returnsNsUriOfPackageContainingType() {		
		assertEquals(asSet("pets"), nsUrisFor(createCat()));
	}
	
	@Test
	public void returnsAllNsUrisWhenContainerHasTypesFromMoreThanOneMetamodel() {
		assertEquals(asSet("pets", "jobs"), nsUrisFor(createCat(), createVet()));
	}
	
	@Test
	public void doesNotReturnDuplicateNsUris() {		
		assertEquals(asSet("pets"), nsUrisFor(createCat(), createCat()));
	}
	
	@Test
	public void returnsEmptySetForEmptyContainer() {		
		assertEquals(Collections.emptySet(), nsUrisFor());
	}
	

	@SafeVarargs
	private static <T> Set<T> asSet(T... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}
	
	private static EObject createCat() {
		return pets.getEFactoryInstance().create(cat);
	}
	
	private static EObject createVet() {
		return jobs.getEFactoryInstance().create(vet);
	}
	
	private static Set<String> nsUrisFor(EObject... objects) {
		return new ModelWalkingNsUriAnalyser(new InMemoryEObjectContainer(objects)).determineNsUris();
	}
	
	private static class InMemoryEObjectContainer implements EObjectContainer {

		private final Collection<EObject> eObjects;

		public InMemoryEObjectContainer(EObject... eObjects) {
			this.eObjects = Arrays.asList(eObjects);
		}
		
		public Collection<EObject> getAllContents(boolean resolve) {
			return eObjects;
		}
		
	}
}
