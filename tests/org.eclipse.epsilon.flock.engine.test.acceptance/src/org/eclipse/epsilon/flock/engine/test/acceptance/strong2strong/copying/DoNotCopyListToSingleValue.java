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
package org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying;

import static org.eclipse.epsilon.test.util.builders.emf.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EReferenceBuilder.anEReference;
import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class DoNotCopyListToSingleValue extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "";

	private static final String originalModel = "Families {"                        +
	                                            "   Family \"f\" {"                 +
	                                            "		members: Person \"p1\" {}," +
	                                            "		         Person \"p2\" {}"  +
	                                            "	}"                              +
	                                            "}";
	
	private static final EClass personClass = anEClass()
	                                          	.named("Person")
	                                          	.with(anEAttribute()
	                                          			.named("name")
	                                          			.withType(EcorePackage.eINSTANCE.getEString())
	                                          	      )
	                                          .build();

	private static final EPackage evolvedMetamodel = aMetamodel()
	                                                 	.named("families")
	                                                 	.with(personClass)
	                                                 	.with(anEClass().named("Family")
	                                                 		.with(anEReference()
	                                                 			.named("members")
	                                                 			.contains(0, 1, personClass)
	                                                 		)
	                                                 	)
	                                                 .build();
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesTo(evolvedMetamodel, strategy, originalModel);
		
		migrated.setVariable("family", "Family.all.first");
	}
	
	@Test
	public void shouldProduceOneFamily() {
		migrated.assertEquals(1, "Family.all.size");
	}
	
	@Test
	public void membersShouldNotBeCopied() {
		migrated.assertUndefined("family.members");
	}
}
