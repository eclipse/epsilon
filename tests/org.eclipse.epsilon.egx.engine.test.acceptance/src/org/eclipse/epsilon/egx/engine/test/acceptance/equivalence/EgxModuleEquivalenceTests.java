/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egx.engine.test.acceptance.equivalence;

import static org.eclipse.epsilon.egx.engine.test.acceptance.EgxAcceptanceTestUtil.*;
import java.util.*;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.egl.launch.EgxRunConfiguration;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolEquivalenceTests;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.junit.AfterClass;
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
public class EgxModuleEquivalenceTests extends EolEquivalenceTests<IEgxModule, EgxRunConfiguration> {

	public EgxModuleEquivalenceTests(EgxRunConfiguration configUnderTest) {
		super(configUnderTest);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		expectedConfigs = getScenarios(thriftInputs, Collections.singleton(EgxModule::new));
		setUpEquivalenceTest();
	}
	
	/**
	 * Deletes output files.
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		deleteOutputDirectories();
	}
	
	/**
	 * @return A collection of pre-configured run configurations, each with their own IEgxModule.
	 * @see EgxAcceptanceTestSuite.getScenarios
	 */
	@Parameters(name = "0")	//Don't use this as the Eclipse JUnit view won't show failures!
	public static Iterable<? extends IEolRunConfiguration<IEgxModule, ?>> configurations() {
		// Used to specify which module configurations we'd like to test in our scenarios
		return getScenarios(thriftInputs, modules(false));
	}
	
	@Test
	public void _test0() {
		super.beforeTests();
	}
	
	@Test
	public void testEquivalentOutput() {
		//TODO implement
	}
}
