/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.epl.engine.test.acceptance.equivalence;

import static org.eclipse.epsilon.epl.engine.test.acceptance.EplAcceptanceTestUtil.*;
import static org.junit.Assert.assertEquals;
import java.util.Collections;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolEquivalenceTests;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.epl.*;
import org.eclipse.epsilon.epl.launch.EplRunConfiguration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EplModuleEquivalenceTests extends EolEquivalenceTests<EplRunConfiguration> {
	
	public EplModuleEquivalenceTests(EplRunConfiguration configUnderTest) {
		super(configUnderTest);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setUpEquivalenceTest(getScenarios(allInputs, true, Collections.singleton(EplModule::new)));
	}
	
	/**
	 * @return A collection of pre-configured run configurations, each with their own EpllModule.
	 * @see EvlAcceptanceTestSuite.getScenarios
	 */
	@Parameters(name = "0")	// Don't use this as the Eclipse JUnit view won't show failures!
	public static Iterable<EplRunConfiguration> configurations() throws Exception {
		// Used to specify which module configurations we'd like to test in our scenarios
		return getScenarios(
			allInputs,		// All scripts & models
			true,			// Include test.epl
			modules(false) 	// Exclude the standard EplModule
		);
	}
	
	@Test
	public void _0test0() throws Exception {
		super.beforeTests();
	}
	
	@Override
	public void testFrameStacks() throws Exception {
		// Do nothing (for now)
	}
	
	@Test
	public void testPatternMatchModel() {
		IModel
			expectedModel = expectedConfig.getResult(),
			actualModel = testConfig.getResult();
		//TODO: implement
		assertEquals(expectedModel.allContents().size(), actualModel.allContents().size());
	}
}
