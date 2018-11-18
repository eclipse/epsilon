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
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.concurrent.*;
import org.eclipse.epsilon.ecl.launch.EclRunConfiguration;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolEquivalenceTests;
import org.eclipse.epsilon.test.util.EpsilonTestUtil;
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
public class EclModuleEquivalenceTests extends EolEquivalenceTests<EclRunConfiguration> {

	public EclModuleEquivalenceTests(EclRunConfiguration configUnderTest) {
		super(configUnderTest);
	}

	/**
	 * @return A collection of pre-configured run configurations, each with their own IEclModule.
	 */
	@Parameters//(name = "0")	Don't use this as the Eclipse JUnit view won't show failures!
	public static Iterable<? extends EclRunConfiguration> configurations() {
		return getScenarios(EclModuleParallelRules::new, EclModuleParallelAnnotation::new, EclModuleParallel::new);
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
