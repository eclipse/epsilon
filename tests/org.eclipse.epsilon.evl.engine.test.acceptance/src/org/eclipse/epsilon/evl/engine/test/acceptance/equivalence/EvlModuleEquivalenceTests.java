package org.eclipse.epsilon.evl.engine.test.acceptance.equivalence;

import static org.eclipse.epsilon.test.util.EpsilonTestUtil.*;
import static org.eclipse.epsilon.evl.engine.test.acceptance.EvlAcceptanceTestUtil.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.eclipse.epsilon.erl.engine.test.util.ErlEquivalenceTests;
import org.eclipse.epsilon.evl.*;
import org.eclipse.epsilon.evl.trace.ConstraintTraceItem;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized.Parameters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EvlModuleEquivalenceTests extends ErlEquivalenceTests<IEvlModule, IEolRunConfiguration<IEvlModule>> {
	
	public EvlModuleEquivalenceTests(IEolRunConfiguration<IEvlModule> configUnderTest) {
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
	@Parameters//(name = "0")	Don't use this as the Eclipse JUnit view won't show failures!
	public static Iterable<? extends IEolRunConfiguration<IEvlModule>> configurations() {
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
		onFail(testCollectionsHaveSameElements(
			expectedModule.getContext().getUnsatisfiedConstraints(),
			actualModule.getContext().getUnsatisfiedConstraints(),
			"Unsatisfied constraints"
		));
	}
	
	@Test
	public void testConstraintTraces() {
		// Uses Set instead of List for performance reasons when calling containsAll.
		Function<IEvlModule, Collection<ConstraintTraceItem>> ctContents = module ->
			module.getContext().getConstraintTrace().stream().collect(Collectors.toSet());
			
		onFail(testCollectionsHaveSameElements(
			ctContents.apply(expectedModule),
			ctContents.apply(actualModule),
			"Constraint traces"
		));
	}
	
	@Test
	public void testConstraintsDependedOn() {
		onFail(testCollectionsHaveSameElements(
			expectedModule.getContext().getConstraintsDependedOn(),
			actualModule.getContext().getConstraintsDependedOn(),
			"Constraints depended on"
		));
	}
}
