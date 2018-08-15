/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.ecl.engine.test.acceptance.equivalence;

import static org.eclipse.epsilon.ecl.engine.test.acceptance.EclAcceptanceTestUtil.*;
import static org.junit.Assert.assertEquals;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolEquivalenceTests;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.eclipse.epsilon.test.util.EpsilonTestUtil;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized.Parameters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EclModuleEquivalenceTests extends EolEquivalenceTests<IEclModule, IEolRunConfiguration<IEclModule, MatchTrace>> {

	public EclModuleEquivalenceTests(IEolRunConfiguration<IEclModule, MatchTrace> configUnderTest) {
		super(configUnderTest);
	}

	/**
	 * @return A collection of pre-configured run configurations, each with their own IEclModule.
	 */
	@Parameters//(name = "0")	Don't use this as the Eclipse JUnit view won't show failures!
	public static Iterable<? extends IEolRunConfiguration<IEclModule, ?>> configurations() {
		// Used to specify which module configurations we'd like to test in our scenarios
		//TODO implement
		return null;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		expectedConfigs = getScenarios(EclModule::new);
		setUpEquivalenceTest();
	}
	
	@Override
	public void _test0() {
		super.beforeTests();
	}
	
	@Test
	public void testMatchResults() {
		MatchTrace
			expectedTrace = expectedConfig.getResult(),
			actualTrace = testConfig.getResult();
		
		EpsilonTestUtil.testCollectionsHaveSameElements(expectedTrace.getMatches(), actualTrace.getMatches(), "Match trace");
	}
}
