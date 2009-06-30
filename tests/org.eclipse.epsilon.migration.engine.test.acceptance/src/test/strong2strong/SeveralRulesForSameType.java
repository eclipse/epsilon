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

public class SeveralRulesForSameType extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Person " +
	                                       "when: ' '.isSubstringOf(original.name) {" +
	                                       "	target.name := original.name;" +
	                                       "}" +
	                                       "migrate Person " +
	                                       "when: original.name.isDefined() {" +
	                                       "	target.name := original.name + ' Smith';" +
	                                       "}" +
	                                       "migrate Person {" +
	                                       "	target.name := 'John Doe';"   +
	                                       "}";
	
	private static final String originalModel = "Families {"                   +
	                                            "	Person {"                  +
	                                            "		name: \"Jack\""        +
	                                            "	}"                         +
	                                            "	Person {"                  +
	                                            "		name: \"Joe Bloggs\""  +
	                                            "	}"                         +
	                                            "	Person {"                  +
	                                            "	}"                         +
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
		migrate(strategy, originalModel, evolvedMetamodel);
		
		migrated.setVariable("jack", "Person.all.selectOne(p|p.name.startsWith('Jack'))");
		migrated.setVariable("joe",  "Person.all.selectOne(p|p.name.startsWith('Joe'))");
		migrated.setVariable("john", "Person.all.selectOne(p|p.name.startsWith('John'))");
	}
	
	@Test
	public void personWithSurnameIsUnchanged() {
		migrated.assertEquals("Joe Bloggs", "joe.name");
	}
	
	@Test
	public void personWithoutSurnameNowHasSmithAsSurname() {
		migrated.assertEquals("Jack Smith", "jack.name");
	}
	
	@Test
	public void anonymousPersonIsNowNamedJohnDoe() {
		migrated.assertEquals("John Doe", "john.name");
	}
}
