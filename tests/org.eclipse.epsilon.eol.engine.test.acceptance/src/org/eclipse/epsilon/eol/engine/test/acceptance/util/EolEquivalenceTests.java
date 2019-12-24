/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.engine.test.acceptance.util;

import static org.eclipse.epsilon.test.util.EpsilonTestUtil.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.eclipse.epsilon.eol.models.IModel;
import org.junit.*;
import org.junit.runner.RunWith;

/**
 * A series of tests which use the standard EolModule as an oracle and test the concurrent implementations
 * in various configurations (different number of threads) against it to ensure identical results
 * and behavioural equivalence. The tests are carried out in the context of scenarios. A scenario
 * is a given combination of script (EOL file) and model to execute the script on. Since each scenario
 * is independent, it requires its own IEolModule. For this reason, each EolRunConfiguration has an
 * identifier so that each scenario can be uniquely identified and different modules under the same
 * scenario can then be compared.
 * <br/><br/>
 * Regarding test ordering, only the testModuleCanExecute() method is required to be run before the others
 * (for obvious reasons). Note that since the expected configurations are our oracles, they are assumed
 * to pass and are exempt from testing; hence being executed in setUpBeforeClass().
 * <br/><br/>
 * This test class is intended to be extended by tests for extensions of EOL. For a reference
 * implementation/example, please see EvlModuleEquivalenceTests.
 * A basic implementation would need to provide the following:
 * <br/><ul>
 * <li> A constructor which calls super(C configUnderTest)
 * 
 * 	<br/> 
 * 
 * <li> A setUpBeforeClass static method (annotated with @BeforeClass) which assigns
 * 	 expectedConfigs and subsequently calls setUpEquivalenceTest()
 * 
 * 	<br/>
 * 
 * <li> A static method returning an Iterable<C> annotated with @Parameters
 * 
 * 	<br/>
 * 
 * <li> An implementation of {@linkplain #_0test0()} which simply calls the #beforeTests() method
 *
 * 	<br/>
 *
 * <li> The class should be annotated with @FixMethodOrder(MethodSorters.NAME_ASCENDING)
 * 
 * 	<br/></ul>
 * 
 * The last two requirements are a workaround for JUnit's inadequate @Before semantics.
 * 
 * @param C The type of run configuration (and thus, module) under test.
 * 
 * @see EolAcceptanceTestUtil
 * @author Sina Madani
 */
@RunWith(org.junit.runners.Parameterized.class)
public abstract class EolEquivalenceTests<C extends IEolRunConfiguration> {

	/**
	 * The oracle configurations
	 */
	protected static Collection<? extends IEolRunConfiguration> expectedConfigs;
	
	/** 
	 * Used to identify which scenario to compare our results with.
	 */
	protected static Map<Integer, IEolRunConfiguration> expectedConfigIDs;
	
	/**
	 *  The scenario and module combination under test. This is the parameterised test variable.
	 */
	protected final C expectedConfig, testConfig;
	
	@SuppressWarnings("unchecked")
	public EolEquivalenceTests(C configUnderTest) {
		this.testConfig = configUnderTest;
		expectedConfig = (C) expectedConfigIDs.get(testConfig.getId());
	}
	
	/**
	 * This should be called in <code>setUpBeforeClass()</code>.
	 * @param expectedConfs The oracle configurations.
	 */
	protected static void setUpEquivalenceTest(Collection<? extends IEolRunConfiguration> expectedConfs) {
		Objects.requireNonNull(expectedConfs);
		expectedConfigs = expectedConfs;
		expectedConfigIDs = new HashMap<>(expectedConfigs.size());
		
		for (IEolRunConfiguration expectedConfig : expectedConfigs) {
			expectedConfigIDs.put(expectedConfig.getId(), expectedConfig);
			expectedConfig.run();
		}
	}
	
	/**
	 * Subclasses should simply call {@link #beforeTests()} in this method.
	 * Additional setup functionality may also be provided here.
	 */
	@Test
	public abstract void _0test0() throws Exception;
	
	@Test
	public void zzz_AfterAll() throws Exception {
		testConfig.dispose();
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		for (IEolRunConfiguration c : expectedConfigs) c.dispose();
	}
	
	/**
	 * Pre-requisite for testing.
	 */
	protected final void beforeTests() throws Exception {
		testModuleCanExecute();
		testScenariosMatch();
		assert expectedConfig.getModule() != testConfig.getModule();
	}
	
	/**
	 * Actions to perform if the message is <code>null</code>.
	 * Generally useful for printing more detailed diagnostics
	 * than is provided by the testing framework.
	 * @param message The message to fail with.
	 * If <code>null</code>, no action is taken.
	 * 
	 * @return whether the message is null, for convenience.
	 */
	protected boolean onFail(String message) {
		if (message != null && !message.isEmpty()) {
			System.err.println(
				testConfig.getModule().getClass().getSimpleName()+
				", "+testConfig.script.getFileName()+
				", "+testConfig.modelsAndProperties
			);
			fail(message);
			return true;
		}
		return false;
	}
	
	protected void testModuleCanExecute() throws Exception {
		try {
			testConfig.run();
		}
		catch (Throwable ex) {
			fail(ex.getMessage());
		}
	}

	protected void testScenariosMatch() throws Exception {
		Function<IEolRunConfiguration, Collection<String>> modelCollector = cfg ->
			cfg.getModule().getContext()
				.getModelRepository().getModels()
				.stream()
				.map(IModel::getName)
				.collect(Collectors.toList());
	
		assertEquals("Same script",
			expectedConfig.getModule().getUri(),
			testConfig.getModule().getUri()
		);
			
		assertEquals("Same models",
			modelCollector.apply(expectedConfig),
			modelCollector.apply(testConfig)
		);
	}
	
	public static List<String> getFrameStackAsString(IEolRunConfiguration config) {
		return config.getModule().getContext().getFrameStack()
			.getFrames().stream()
			.map(Frame::getAll)
			.map(Map::keySet)
			.flatMap(Set::stream)
			.collect(Collectors.toList());
	}
	
	@Test
	public void testFrameStacks() throws Exception {
		onFail(testCollectionsHaveSameElements(
			getFrameStackAsString(expectedConfig),
			getFrameStackAsString(testConfig),
			"FrameStacks"
		));
	}
	
	public static List<ModuleElement> getStackTraceModuleElements(IEolRunConfiguration config) {
		return config.getModule().getContext().getExecutorFactory().getStackTraceManager().getStackTrace();
	}
	
	@Test
	public void testExecutorFactories() throws Exception {
		assertEquals("Same stack traces",
			getStackTraceModuleElements(expectedConfig),
			getStackTraceModuleElements(testConfig)
		);
	}
	
	public static Collection<OperationContributor> getOperationContributors(IEolRunConfiguration config) {
		return config.getModule().getContext().getOperationContributorRegistry().stream().collect(Collectors.toSet());
	}
	
	@Test
	public void testOperationContributorRegistries() throws Exception {
		Collection<OperationContributor>
			expectedOCs = getOperationContributors(expectedConfig),
			actualOCs = getOperationContributors(testConfig);

		onFail(printIfDifferent(
			actualOCs.size() < expectedOCs.size(),
			expectedOCs, actualOCs, "OperationContributorRegistries")
		);
	}
}
