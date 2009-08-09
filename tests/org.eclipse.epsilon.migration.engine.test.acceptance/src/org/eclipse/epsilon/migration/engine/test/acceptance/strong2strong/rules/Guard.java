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
package org.eclipse.epsilon.migration.engine.test.acceptance.strong2strong.rules;

import static org.eclipse.epsilon.migration.engine.test.util.builders.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.migration.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class Guard extends Strong2StrongMigrationAcceptanceTest {


	private static final String strategy = "migrate Person when: original.name.isDefined() {" +
	                                       "	migrated.name := original.name + ' Smith';" +
	                                       "}";
	
	private static final String originalModel = "Families {"             +
	                                            "	Person {"            +
	                                            "		name: \"John\""  +
	                                            "	}"                   +
	                                            "	Person {"            +
	                                            "	}"                   +
	                                            "}";
	
	private static final EPackage evolvedMetamodel = aMetamodel()
	                                                 	.with(anEClass().named("Person")
	                                                 		.with(anEAttribute()
	                                                 			.named("name")
	                                                 			.withType(EcorePackage.eINSTANCE.getEString())
	                                               			)
	                                               		).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesTo(evolvedMetamodel, strategy, originalModel);
		
		migrated.setVariable("named",     "Person.all.at(0)");
		migrated.setVariable("anonymous", "Person.all.at(1)");
	}
	
	@Test
	public void namedHasSurname() {
		migrated.assertEquals("John Smith", "named.name");
	}
	
	@Test
	public void anonymousHasNoName() {
		migrated.assertUndefined("anonymous.name");
	}
}
