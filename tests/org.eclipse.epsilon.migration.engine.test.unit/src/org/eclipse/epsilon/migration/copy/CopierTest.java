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
package org.eclipse.epsilon.migration.copy;

import static org.eclipse.epsilon.migration.engine.test.util.builders.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;
import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.hutn.test.model.families.Dog;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesFactory;
import org.junit.Test;

public class CopierTest {

	@Test
	public void copiesObject() {
		final EPackage targetMetamodel = aMetamodel()
		                                 	.withNsURI("families2")
                                       		.with(anEClass().named("Dog").
                                         		with(anEAttribute().
                                         			named("name").
                                         			withType(EcorePackage.eINSTANCE.getEString())
                                       			)
                                       		).build();
		
		final Copier copier = new Copier();
		final AbstractEmfModel target = new InMemoryEmfModel("target", EmfUtil.createResource(), targetMetamodel);
		
		final EObject dog = FamiliesFactory.eINSTANCE.createDog();
		
		copier.copy(dog, target);
		
		assertEquals(1, target.allContents().size());
		
		final EObject copiedDog = target.allContents().iterator().next();
		
		assertEquals("Dog", copiedDog.eClass().getName());
		assertEquals("families2", copiedDog.eClass().getEPackage().getNsURI());
	}
	
	
	@Test
	public void copiesSlot() {
		final EPackage targetMetamodel = aMetamodel()
		                                 	.withNsURI("families2")
                                       		.with(anEClass().named("Dog").
                                         		with(anEAttribute().
                                         			named("name").
                                         			withType(EcorePackage.eINSTANCE.getEString())
                                       			)
                                       		).build();
		
		final Copier copier = new Copier();
		final AbstractEmfModel target = new InMemoryEmfModel("target", EmfUtil.createResource(), targetMetamodel);
		
		final Dog dog = FamiliesFactory.eINSTANCE.createDog();
		dog.setName("Lassie");
		
		copier.copy(dog, target);
		
		assertEquals(1, target.allContents().size());
		
		final EObject copiedDog = target.allContents().iterator().next();
		
		assertEquals("Dog", copiedDog.eClass().getName());
		assertEquals("families2", copiedDog.eClass().getEPackage().getNsURI());
		
		assertEquals("Lassie", copiedDog.eGet(copiedDog.eClass().getEStructuralFeature("name")));
	}
}
