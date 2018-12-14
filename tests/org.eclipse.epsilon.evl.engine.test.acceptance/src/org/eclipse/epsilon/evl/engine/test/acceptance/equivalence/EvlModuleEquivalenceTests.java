/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.engine.test.acceptance.equivalence;

import static org.eclipse.epsilon.test.util.EpsilonTestUtil.*;
import static org.eclipse.epsilon.evl.engine.test.acceptance.EvlAcceptanceTestUtil.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolEquivalenceTests;
import org.eclipse.epsilon.evl.*;
import org.eclipse.epsilon.evl.launch.EvlRunConfiguration;
import org.eclipse.epsilon.evl.trace.ConstraintTraceItem;
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
public class EvlModuleEquivalenceTests extends EolEquivalenceTests<EvlRunConfiguration> {
	
	public EvlModuleEquivalenceTests(EvlRunConfiguration configUnderTest) {
		super(configUnderTest);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		expectedConfigs = getScenarios(EvlModule::new);
		setUpEquivalenceTest();
	}
	
	/**
	 * @return A collection of pre-configured run configurations, each with their own IEvlModule.
	 */
	@Parameters//(name = "0")	// Don't use this as the Eclipse JUnit view won't show failures!
	public static Collection<EvlRunConfiguration> configurations() {
		// Used to specify which module configurations we'd like to test in our scenarios
		return getScenarios(
			allInputs,		// All scripts & models
			true,			// Include test.evl
			modules(false) 	// Exclude the standard EvlModule
		);
	}
	
	@Test
	@Override
	public void _test0() {
		super.beforeTests();
	}
	
	@Test
	public void testUnsatisfiedConstraints() {
		onFail(testCollectionsHaveSameElements(
			expectedConfig.getModule().getContext().getUnsatisfiedConstraints(),
			testConfig.getModule().getContext().getUnsatisfiedConstraints(),
			"UnsatisfiedConstraint"
		));
	}
	
	@Test
	public void testConstraintTraces() {
		// Uses Set instead of List for performance reasons when calling containsAll.
		Function<EvlRunConfiguration, Collection<ConstraintTraceItem>> ctContents = cfg ->
			cfg.getModule().getContext().getConstraintTrace().stream().collect(Collectors.toSet());
		
		onFail(testCollectionsHaveSameElements(
			ctContents.apply(expectedConfig),
			ctContents.apply(testConfig),
			"ConstraintTrace"
		));
	}
	
	@Test
	public void testConstraintsDependedOn() {
		onFail(testCollectionsHaveSameElements(
			expectedConfig.getModule().getContext().getConstraintsDependedOn(),
			testConfig.getModule().getContext().getConstraintsDependedOn(),
			"Constraints depended on"
		));
	}
}
