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
package org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.equivalences;

import static org.eclipse.epsilon.flock.engine.test.util.builders.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.flock.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.flock.engine.test.util.builders.EReferenceBuilder.anEReference;
import static org.eclipse.epsilon.flock.engine.test.util.builders.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class EquivalentOfCollectionOfModelElements extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Family { " +
	                                       "	migrated.people := original.members.equivalent();" +
	                                       "}" +
	                                       "migrate Person {" +
	                                       "   migrated.name := original.name + ' Smith';" +
	                                       "}";

	private static final String originalModel = "Families {"                                      +
	                                            "	Family {"                                     +
	                                            "       members: Person \"p\" { name: \"John\"} " +
	                                            "	}"                                            +
	                                            "}";
		
	private static final EClass personClass = anEClass().named("Person")
	                                          	.with(anEAttribute()
	                                          			.named("name")
	                                          			.withType(EcorePackage.eINSTANCE.getEString())
	                                          	)
	                                          .build();
	
	private static final EPackage evolvedMetamodel = aMetamodel()
	                                                    .with(personClass)
	                                                 	.with(anEClass().named("Family")
	                                                 		.with(anEReference()
	                                                 			.named("people")
	                                                 			.contains(0, -1, personClass)
	                                                 	)
	                                                 ).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesTo(evolvedMetamodel, strategy, originalModel);
		
		migrated.setVariable("family", "Family.all.first");
	}
	
	@Test
	public void membersShouldBeCopied() {
		migrated.assertEquals(1,            "family.people.size");
		migrated.assertEquals("John Smith", "family.people.first.name");
	}
}
