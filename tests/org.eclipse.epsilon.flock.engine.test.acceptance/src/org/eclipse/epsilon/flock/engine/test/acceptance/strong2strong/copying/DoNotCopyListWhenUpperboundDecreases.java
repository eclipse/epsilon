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


public class DoNotCopyListWhenUpperboundDecreases extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "";

	private static final String originalModel = "Families {"                                                            +
	                                            "	Person \"mum\" {"                                                   +
	                                            "		name: \"Alice\""                                                +
	                                            "	}"                                                                  +
	                                            "   Person \"dad\" {"                                                   +
	                                            "		name: \"Bob\""                                                  +
	                                            "	}"                                                                  +
	                                            "	Person \"daughter\" {"                                              +
	                                            "		name: \"Carol\""                                                +
	                                            "		allParents: Person \"mum\", Person \"dad\", Person \"stepmum\"" +
	                                            "	}"                                                                  +
	                                            "	Person \"son\" {"                                                   +
	                                            "		name: \"David\""                                                +
	                                            "		allParents: Person \"mum\", Person \"dad\""                     +
	                                            "	}"                                                                  +
	                                            "	Person \"stepmum\" {"                                               +
	                                            "		name: \"Edna\""                                                 +
	                                            "	}"                                                                  +
	                                            "}";
	
	private static final EClass personClass = anEClass()
	                                            .named("Person")
	                                          	.with(anEAttribute()
	                                          			.named("name")
	                                          			.withType(EcorePackage.eINSTANCE.getEString())
	                                          	      )
	                                          	 // with an allParents reference defined below, in setup()
	                                          .build();

	private static final EPackage evolvedMetamodel = aMetamodel().named("families").with(personClass).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		personClass.getEStructuralFeatures().add(anEReference().named("allParents").references(0, 2, personClass).build());
		
		migrateFamiliesTo(evolvedMetamodel, strategy, originalModel);
		
		migrated.setVariable("carol", "Person.all.selectOne(p|p.name = 'Carol')");
		migrated.setVariable("david", "Person.all.selectOne(p|p.name = 'David')");
	}
	
	@Test
	public void shouldProduceFivePeople() {
		migrated.assertEquals(5, "Person.all.size");
	}
	
	@Test
	public void carolsAllParentsShouldNotBeCopied() {
		migrated.assertEquals(0, "carol.allParents.size");
	}
	
	@Test
	public void davidsAllParentsShouldBeCopied() {
		migrated.assertEquals(2,       "david.allParents.size");
		migrated.assertEquals("Alice", "david.allParents.first.name");
		migrated.assertEquals("Bob",   "david.allParents.second.name");
	}
}
