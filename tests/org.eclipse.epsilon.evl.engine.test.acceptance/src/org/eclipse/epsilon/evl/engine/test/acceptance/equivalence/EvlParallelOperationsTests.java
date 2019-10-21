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

import static org.eclipse.epsilon.evl.engine.test.acceptance.EvlAcceptanceTestUtil.*;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolAcceptanceTestUtil;
import org.eclipse.epsilon.eol.exceptions.concurrent.EolNestedParallelismException;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.concurrent.*;
import org.eclipse.epsilon.evl.engine.test.acceptance.EvlAcceptanceTestUtil;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;
import org.eclipse.epsilon.evl.launch.EvlRunConfiguration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized.Parameters;

/**
 * This class tests the interplay between parallel first-order operations and parallel EVL.
 * The intention is that so long as constraints and constraint contexts which are parallel
 * (as annotated - see {@link EvlModuleParallelAnnotation}) do not make use of parallel variants
 * of first-order operations, there should be no issues. However nested parallelism of any kind
 * is not supported, so parallel constraints or contexts cannot use parallel first-order operations.
 * 
 * @see java_parallelNested.evl
 * @see java_parallel.evl
 * @see java_sequential.evl
 * @author Sina Madani
 * @since 1.6
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EvlParallelOperationsTests extends EvlModuleEquivalenceTests {

	private static final List<String[]>
		inputsWithNesting = addAllInputs(
			new String[]{"java_parallel", "java_parallelNested"},
			javaModels, javaMetamodel
		),
		inputsWithoutNesting = addAllInputs(
			new String[]{"java_sequential", "java_annotated"},
			javaModels, javaMetamodel
		);
	
	static final int[] testThreads = {2, 3};
	static final Function<String[], Integer> idCalculator = inputs -> {
		int scriptHash;
		if (inputs[0].startsWith("java_parallel") || inputs[0].startsWith("java_sequential") || inputs[0].startsWith("java_annotated")) {
			scriptHash = "java_sequential".hashCode(); 
		}
		else {
			scriptHash = inputs[0].hashCode();
		}
		return Objects.hash(scriptHash, inputs[1], inputs[2]);
	};
	
	public EvlParallelOperationsTests(EvlRunConfiguration configUnderTest) {
		super(configUnderTest);
	}
	
	@Rule
    public TestName testName = new TestName();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Collection<EvlRunConfiguration> scenarios = getScenarios(
			inputsWithNesting, false, Collections.singleton(EvlModule::new), idCalculator
		);
		scenarios.addAll(getScenarios(inputsWithoutNesting, false, EvlAcceptanceTestUtil.modules(), idCalculator));
		setUpEquivalenceTest(scenarios);
	}
	
	@Parameters
	public static Collection<EvlRunConfiguration> configurations() {
		Collection<EvlRunConfiguration> scenarios = getScenarios(inputsWithNesting, false,
			EolAcceptanceTestUtil.parallelModules(testThreads, null,
				p -> new EvlModuleParallelAnnotation(new EvlContextParallel(p))
			),
			idCalculator
		);
		scenarios.addAll(getScenarios(inputsWithoutNesting, false, EvlAcceptanceTestUtil.modules(), idCalculator));
		return scenarios;
	}
	
	@Before
	public void assumeLegal() throws Exception {
		boolean isParallelNestedScript = testConfig.script.getFileName().toString().equals("java_parallelNested.evl");
		if (testName.getMethodName().startsWith("testIllegalNesting")) {
			assumeTrue(isParallelNestedScript);
			assumeFalse(testConfig.getModule() instanceof EvlModuleParallelAnnotation);
			expectedConfig.run();
			testConfig.preExecute();
			testScenariosMatch();
		}
		else {
			assumeFalse(isParallelNestedScript);
		}
	}
	
	@Test
	public void testIllegalNesting() throws Exception {
		try {
			testConfig.execute();
		}
		catch (EolNestedParallelismException px) {
			return;
		}
		finally {
			testConfig.postExecute();
		}
		
		fail(
			"Expected "+EolNestedParallelismException.class.getSimpleName()+": "
			+ testConfig.getModule().getClass().getSimpleName()+" "+testConfig.getModule().getContext()
		);
	}
}
