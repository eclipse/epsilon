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

import static org.eclipse.epsilon.hutn.test.model.factories.DogFactory.createDog;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anAbstractEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.junit.Test;

public class CopierTest {
	
	private AbstractEmfModel target;
	
	private Copier createCopier(EObject original, EPackage targetMetamodel) {
		target = new InMemoryEmfModel("target", EmfUtil.createResource(), targetMetamodel);
		return new Copier(original, target);
	}
	
	@Test
	public void copiesObject() throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		final EPackage targetMetamodel = aMetamodel()
		                                 	.withNsURI("families2")
                                       		.with(anEClass().named("Dog").
                                         		with(anEAttribute().
                                         			named("name").
                                         			withType(EcorePackage.eINSTANCE.getEString())
                                       			)
                                       		).build();
		
		final EObject copy = createCopier(createDog(), targetMetamodel).copy();
		
		assertEquals(1, target.allContents().size());
		assertTrue(target.allContents().contains(copy));
		
		assertEquals("Dog", copy.eClass().getName());
		assertEquals("families2", copy.eClass().getEPackage().getNsURI());
	}
	
	
	@Test
	public void copiesSlot() throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		final EPackage targetMetamodel = aMetamodel()
		                                 	.with(anEClass().named("Dog")
		                                 		.with(anEAttribute()
		                                 			.named("name")
		                                 			.withType(EcorePackage.eINSTANCE.getEString())
		                                 		)
		                                 	).build();

		final EObject copy = createCopier(createDog("Lassie"), targetMetamodel).copy();
		
		assertEquals(1, target.allContents().size());
		assertTrue(target.allContents().contains(copy));
		
		assertEquals("Dog", copy.eClass().getName());
		
		assertEquals("Lassie", copy.eGet(copy.eClass().getEStructuralFeature("name")));
	}
	
	
	@Test
	public void copiesObjectWhenTypesDiffer() throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		final EPackage targetMetamodel = aMetamodel()
		                                 	.with(anEClass().named("Puppy")
		                                 		.with(anEAttribute()
		                                 			.named("name")
		                                 			.withType(EcorePackage.eINSTANCE.getEString())
		                                 		)
		                                 	).build();
		
		final EObject copy = createCopier(createDog(), targetMetamodel).copy("Puppy");
		
		assertEquals(1, target.allContents().size());
		assertTrue(target.allContents().contains(copy));
		
		assertEquals("Puppy", copy.eClass().getName());
	}
	
	@Test(expected=EolModelElementTypeNotFoundException.class)
	public void errorWhenTargetTypeDoesntExist() throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		final EPackage targetMetamodel = aMetamodel().build();
		
		createCopier(createDog(), targetMetamodel).copy("Puppy");
	}
	
	@Test(expected=EolNotInstantiableModelElementTypeException.class)
	public void errorWhenTargetTypeIsAbstract() throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		final EPackage targetMetamodel = aMetamodel()
		                                 	.with(anAbstractEClass().named("Animal"))
		                                 	.build();
		
		createCopier(createDog(), targetMetamodel).copy("Animal");
	}
}
