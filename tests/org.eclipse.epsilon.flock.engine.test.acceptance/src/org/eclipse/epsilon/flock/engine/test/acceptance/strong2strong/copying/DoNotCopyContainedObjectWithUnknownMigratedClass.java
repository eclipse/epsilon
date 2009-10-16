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

import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EReferenceBuilder.anEReference;
import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class DoNotCopyContainedObjectWithUnknownMigratedClass extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "";
	
	private static final String originalModel = "Families {"                         +
	                                            "	Family {"                        +
	                                            "		members: Person \"John\" {}" +
	                                            "	}"                               +
	                                            "}";
	
	private static final EClass memberClass = anEClass().named("Member").build();
	
	private static final EPackage evolvedMetamodel = aMetamodel()
	                                                 	.with(anEClass().named("Family")
	                                                 		.with(anEReference()
	                                                 			.named("members")
	                                                 			.contains(0, -1, memberClass)
	                                                 	)
	                                                 ).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesTo(evolvedMetamodel, strategy, originalModel);
		
		migrated.setVariable("family", "Family.all.first");
	}
	
	@Test
	public void familyShouldBeCopied() {
		migrated.assertDefined("family");
	}
	
	@Test
	public void membersShouldBeEmpty() {
		migrated.assertEquals(0, "family.members.size()");
	}
}
