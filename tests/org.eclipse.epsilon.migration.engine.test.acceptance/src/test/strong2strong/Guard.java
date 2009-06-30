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
package test.strong2strong;

import static org.eclipse.epsilon.migration.engine.test.util.builders.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.BeforeClass;
import org.junit.Test;

public class Guard extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Person to NamedPerson "    +
	                                       "when: original.name.isDefined() {" +
	                                       "	target.name := original.name;" +
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
	                                               		)
	                                                 	.with(anEClass().named("NamedPerson")
	                                                 		.with(anEAttribute()
	                                                 			.named("name")
	                                                 			.withType(EcorePackage.eINSTANCE.getEString())
	                                               			)
	                                               		).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		migrate(strategy, originalModel, evolvedMetamodel);
		
		migrated.setVariable("person",      "Person.all.first");
		migrated.setVariable("namedperson", "NamedPerson.all.first");
	}
	
	@Test
	public void personHasNoName() {
		migrated.assertUndefined("person.name");
	}
	
	@Test
	public void namedPersonHasSameName() {
		migrated.assertEquals("John", "namedperson.name");
	}
}
