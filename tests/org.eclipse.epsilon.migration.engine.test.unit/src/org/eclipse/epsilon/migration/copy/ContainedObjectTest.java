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

import static org.eclipse.epsilon.hutn.test.model.factories.BikeFactory.createBike;
import static org.eclipse.epsilon.hutn.test.model.factories.PersonFactory.createPerson;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EReferenceBuilder.anEReference;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.hutn.test.model.families.Bike;
import org.eclipse.epsilon.hutn.test.model.families.Person;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContainedObjectTest extends AbstractCopyTest {
	
	private static Person rider = createPerson("John");
	private static Bike   bike  = createBike(rider);
	
	private static EObject containedCopy;
	
	@BeforeClass
	public static void setup() throws CopyingException {
		final EClass personClass = anEClass()
		                           	.named("Person")
		                           	.with(anEAttribute()
		                           		.named("name")
		                           		.withType(EcorePackage.eINSTANCE.getEString()
		                           	)	
		                           ).build();
       	

		final EPackage targetMetamodel = aMetamodel()
		                                 	.with(personClass)
		                                 	.with(anEClass()
		                                 		.named("Bike")
		                                 		.with(anEReference().
		                                 				named("rider").
		                                 				contains(0, 1, personClass)
		                                 		)
		                                 	)
		                                 .build();
		
		copyTest(targetMetamodel, bike);
		
		containedCopy = ((EObject)copy).eContents().get(0);
	}
	
	@Test
	public void copyIsABike() {
		checkObject(bike, copy, "Bike");
	}
	
	@Test
	public void containedCopyIsAnInstanceOfClassInTargetMetamodel() {
		checkObject(rider, containedCopy, "Person", new Slot("name", "John"));
	}
}