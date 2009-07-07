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

import static org.eclipse.epsilon.hutn.test.model.factories.FamilyFactory.createFamily;
import static org.eclipse.epsilon.hutn.test.model.factories.PersonFactory.createPerson;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EReferenceBuilder.anEReference;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.hutn.test.model.families.Family;
import org.eclipse.epsilon.hutn.test.model.families.Person;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContainedObjectsTest extends AbstractCopyTest {
	
	private static Person jack   = createPerson("Jack");
	private static Person jill   = createPerson("Jill");
	private static Family family = createFamily(jack, jill);
		
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
		                                 		.named("Family")
		                                 		.with(anEReference().
		                                 				named("members").
		                                 				contains(0, -1, personClass)
		                                 		)
		                                 	)
		                                 .build();
		
		copyTest(targetMetamodel, family);
	}
	
	@Test
	public void copyIsAFamily() {
		checkObject(family, copy, "Family");
	}
	
	@Test
	public void firstContainedCopyIsPersonNamedJack() {
		checkObject(jack, copy.eContents().get(0), "Person", new Slot("name", "Jack"));
	}
	
	@Test
	public void secondContainedCopyIsPersonNamedJill() {
		checkObject(jill, copy.eContents().get(1), "Person", new Slot("name", "Jill"));
	}
}