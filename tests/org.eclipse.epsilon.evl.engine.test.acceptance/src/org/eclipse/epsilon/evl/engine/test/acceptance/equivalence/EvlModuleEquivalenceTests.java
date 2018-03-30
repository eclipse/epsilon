package org.eclipse.epsilon.evl.engine.test.acceptance.equivalence;

import static org.junit.Assert.*;
import static org.eclipse.epsilon.evl.engine.test.acceptance.EvlAcceptanceTestUtil.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.eclipse.epsilon.erl.engine.launch.ErlRunConfiguration;
import org.eclipse.epsilon.erl.engine.test.util.ErlEquivalenceTests;
import org.eclipse.epsilon.evl.*;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.trace.ConstraintTraceItem;
import org.eclipse.epsilon.test.util.EpsilonTestUtil;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized.Parameters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EvlModuleEquivalenceTests extends ErlEquivalenceTests<IEvlModule, ErlRunConfiguration<IEvlModule>> {
	
	public EvlModuleEquivalenceTests(ErlRunConfiguration<IEvlModule> configUnderTest) {
		super(configUnderTest);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		expectedConfigs = getScenarios(EvlModule::new);
		setUpEquivalenceTest();
	}
	
	/**
	 * @return A collection of pre-configured run configurations, each with their own IEvlModule.
	 * @see EvlAcceptanceTestSuite.getScenarios
	 */
	@Parameters(name = "0")	//Don't use this as the Eclipse JUnit view won't show failures!
	public static Iterable<? extends ErlRunConfiguration<IEvlModule>> configurations() {
		// Used to specify which module configurations we'd like to test in our scenarios
		return getScenarios(
			allInputs,		// All scripts & models
			true,			// Include test.evl
			modules(false) 	// Exclude the standard EvlModule
		);
	}
	
	@Test
	public void _test0() {
		super.beforeTests();
	}
	
	@Test
	public void testUnsatisfiedConstraints() {
		EpsilonTestUtil.testCollectionsHaveSameElements(
			expectedModule.getContext().getUnsatisfiedConstraints(),
			actualModule.getContext().getUnsatisfiedConstraints()
		);
	}
	
	@Test
	public void testConstraintTraces() {
		// Uses Set instead of List for performance reasons when calling containsAll.
		Function<IEvlModule, Set<ConstraintTraceItem>> ctContents = module ->
			module.getContext().getConstraintTrace().stream().collect(Collectors.toSet());
			
		EpsilonTestUtil.testCollectionsHaveSameElements(
			ctContents.apply(expectedModule),
			ctContents.apply(actualModule)
		);
	}
	
	@Test
	public void testConstraintsDependedOn() {
		Set<Constraint>
			expectedDependents = expectedModule.getContext().getConstraintsDependedOn(),
			actualDependents = expectedModule.getContext().getConstraintsDependedOn();
		
		assertEquals("Same ConstraintsDependedOn", expectedDependents, actualDependents);
	}
}
