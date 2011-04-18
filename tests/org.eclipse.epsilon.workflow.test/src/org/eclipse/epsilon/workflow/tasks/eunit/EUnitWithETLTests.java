/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.eunit;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.epsilon.eol.eunit.EUnitModule;
import org.junit.Test;

/**
 * Tests for the EUnit<->ETL integration.
 *
 * @author Antonio Garcia-Dominguez
 */
public class EUnitWithETLTests extends EUnitTestCase {

	@Test
	public void compareEMFWithEMF() throws Exception {
		runTarget(ANT_BUILD_FILE, "emf-emf");
		checkOutput(new File(BASE_DIR, "TEST-default.emf-emf.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{
					"sameModelsAreEqual[1]", "sameModelsAreEqual[2]", "sameModelsAreEqual[3]",
					"modelsFromDifferentMetamodelsAreDifferent[1]",
					"modelsFromDifferentMetamodelsAreDifferent[2]",
					"modelsWithDifferentContentAreDifferent",
					"modelsWithDifferentContentAreDifferentFailing",
					"transformedIsEqualToExpected",
					"transformedIsEqualToExpectedFailing"
				},
				new HashSet<String>(
					Arrays.asList(
						"modelsWithDifferentContentAreDifferentFailing",
						"transformedIsEqualToExpectedFailing")),
				new HashSet<String>());
	}

	@Test
	public void compareEMFWithEMFUsingGeneratedModels() throws Exception {
		runTarget(ANT_BUILD_FILE, "emf-emf-generated");
	}

}
