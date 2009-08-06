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
package test.strong2strong.rules;

import static org.eclipse.epsilon.migration.engine.test.util.builders.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.BeforeClass;
import org.junit.Test;

import test.strong2strong.Strong2StrongMigrationAcceptanceTest;

public class MigrateToDifferentType extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Person to Salesperson {" +
	                                       "	migrated.name := original.name;" +
	                                       "}";
	
	private static final String originalModel = "Families {"             +
	                                            "	Person {"            +
	                                            "		name: \"John\""  +
	                                            "	}"                   +
	                                            "}";
	
	private static final EPackage evolvedMetamodel = aMetamodel()
	                                                 	.with(anEClass().named("Salesperson")
	                                                 		.with(anEAttribute()
	                                                 			.named("name")
	                                                 			.withType(EcorePackage.eINSTANCE.getEString())
	                                               			)
	                                               		).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesTo(evolvedMetamodel, strategy, originalModel);
		
		migrated.setVariable("salesperson", "Salesperson.all.first");
	}
	
	@Test
	public void shouldHaveSameName() {
		migrated.assertEquals("John", "salesperson.name");
	}
}
