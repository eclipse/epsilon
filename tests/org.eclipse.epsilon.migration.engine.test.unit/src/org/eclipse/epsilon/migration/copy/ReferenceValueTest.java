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

import static org.eclipse.epsilon.hutn.test.model.factories.BikeFactory.createBike;
import static org.eclipse.epsilon.hutn.test.model.factories.FamilyFactory.createFamily;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EReferenceBuilder.anEReference;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.hutn.test.model.families.Bike;
import org.eclipse.epsilon.hutn.test.model.families.Family;
import org.eclipse.epsilon.migration.emc.wrappers.CopyingException;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReferenceValueTest extends AbstractCopyTest {
	
	private static Family theSmiths = createFamily();
	private static Bike   bike      = createBike(theSmiths);
	
	private static Object migratedSmiths;
	
	@BeforeClass
	public static void setup() throws CopyingException, EolRuntimeException {
		final EClass familyClass = anEClass().named("Family").build();

		final EPackage targetMetamodel = aMetamodel()
		                                 	.with(familyClass)
		                                 	.with(anEClass()
		                                 		.named("Bike")
		                                 		.with(anEReference().
		                                 				named("owner").
		                                 				references(0, 1, familyClass)
		                                 		)
		                                 	)
		                                 .build();
		
		migratedSmiths = addEquivalence(targetMetamodel, theSmiths, familyClass);
				
		copyTest(targetMetamodel, "Bike", bike);
	}
	
	@Test
	public void copyIsABikeWithEquivalentOwner() {
		checkCopy("Bike", new Slot("owner", migratedSmiths));
	}
}