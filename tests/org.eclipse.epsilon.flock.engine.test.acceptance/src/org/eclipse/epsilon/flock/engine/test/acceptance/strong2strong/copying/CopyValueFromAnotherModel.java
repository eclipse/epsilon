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

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.emc.emf.EmfModelFactory.AccessMode;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.flock.engine.test.acceptance.models.FlockAcceptanceTestModels;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class CopyValueFromAnotherModel extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "";
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, loadModelWithACrossReference());
		
		migrated.setVariable("sally", "Person.all.selectOne(p | p.name = 'Sally')");
		migrated.setVariable("john",  "Person.all.selectOne(p | p.name = 'John')");
	}

	private static EmfModel loadModelWithACrossReference() throws EolModelLoadingException {
		return EmfModelFactory.getInstance().loadEmfModel("Original", FlockAcceptanceTestModels.getDoesModelFile(), "families", AccessMode.READ_ONLY);
	}

	
	@Test
	public void shouldProduceTwoPeople() throws Throwable {
		migrated.assertEquals(2, "Person.all.size");
	}
	
	@Test
	public void friendShouldBeCopied() throws Throwable {
		migrated.assertEquals(1, "sally.friends.size");
		migrated.assertTrue("john == sally.friends.first");
	}
}
