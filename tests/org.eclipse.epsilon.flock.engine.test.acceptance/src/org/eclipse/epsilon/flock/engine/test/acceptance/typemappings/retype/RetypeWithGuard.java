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
package org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.retype;

import static org.eclipse.epsilon.test.util.builders.emf.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.flock.engine.test.acceptance.util.FlockAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class RetypeWithGuard extends FlockAcceptanceTest {

	private static final String strategy = "retype Person to Salesperson when: original.name == 'John'";
	
	private static final String originalModel = "Families {"             +
	                                            "	Person {"            +
	                                            "		name: \"John\""  +
	                                            "	}"                   +
	                                            "   Person {"            +
	                                            "		name: \"Jane\""	 +
	                                            "	}"                   +
	                                            "}";
	
	private static final EPackage evolvedMetamodel = aMetamodel().named("families")
	                                                 	.with(anEClass().named("Person")
	                                                 		.with(anEAttribute()
	                                                 			.named("name")
	                                                 			.withType(EcorePackage.eINSTANCE.getEString())
	                                               			)
	                                               		).
	                                               		with(anEClass().named("Salesperson")
		                                                	.with(anEAttribute()
		                                                		.named("name")
		                                                		.withType(EcorePackage.eINSTANCE.getEString())
		                                                	)
		                                               	).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesTo(evolvedMetamodel, strategy, originalModel);
		
		migrated.setVariable("sp", "Salesperson.all.first");
		migrated.setVariable("p",  "Person.all.first");
	}
	
	@Test
	public void salespersonShouldBeJohn() {
		migrated.assertEquals("John", "sp.name");
	}
	
	@Test
	public void personShouldBeJane() {
		migrated.assertEquals("Jane", "p.name");
	}
}
