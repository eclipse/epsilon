package org.eclipse.epsilon.eol.engine.test.acceptance.util;

import static org.eclipse.epsilon.test.util.EpsilonTestUtil.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.eclipse.epsilon.eol.models.IModel;
import org.junit.Test;
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
 * <li> An implementation of {@linkplain #_test0()} which simply calls the #beforeTests() method
 *
 * 	<br/>
 *
 * <li> The class should be annotated with @FixMethodOrder(MethodSorters.NAME_ASCENDING)
 * 
 * 	<br/></ul>
 * 
 * The last two requirements are a workaround for JUnit's inadequate @Before semantics.
 * 
 * @see EolAcceptanceTestUtil
 * @author Sina Madani
 */
@RunWith(org.junit.runners.Parameterized.class)
public abstract class EolEquivalenceTests<M extends IEolModule, C extends IEolRunConfiguration<M, ?>> {

	// The oracle configurations
	protected static Collection<? extends IEolRunConfiguration<? extends IEolModule, ?>> expectedConfigs;
	
	// Used to identify which scenario to compare our results with.
	protected static Map<Integer, IEolRunConfiguration<?, ?>> expectedConfigIDs;
	
	// The scenario and module combination under test. This is the parameterised test variable.
	protected final C expectedConfig, testConfig;
	
	// Convenience variables for the tests
	protected final M expectedModule, actualModule;
	
	
	@SuppressWarnings("unchecked")
	public EolEquivalenceTests(C configUnderTest) {
		this.testConfig = configUnderTest;
		expectedConfig = (C) expectedConfigIDs.get(testConfig.getId());
		expectedModule = expectedConfig.module;
		actualModule = testConfig.module;
	}
	
	/**
	 * This should be called after assigning expectedConfigs in
	 * <code>setUpBeforeClass()</code>.
	 */
	protected static void setUpEquivalenceTest() {
		expectedConfigIDs = new HashMap<>(expectedConfigs.size());
		
		for (IEolRunConfiguration<?, ?> expectedConfig : expectedConfigs) {
			expectedConfigIDs.put(expectedConfig.getId(), expectedConfig);
			expectedConfig.run();
		}
	}
	
	/**
	 * Subclasses should simply call {@link #beforeTests()} in this method.
	 * Additional setup functionality may also be provided here.
	 */
	@Test
	public abstract void _test0();
	
	
	/**
	 * Pre-requisite for testing.
	 */
	protected final void beforeTests() {
		testModuleCanExecute();
		testScenariosMatch();
		assert expectedModule != actualModule;
	}
	
	/**
	 * Actions to perform if the message is null.
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
				actualModule.getClass().getSimpleName()+
				", "+testConfig.script.getFileName()+
				", "+testConfig.modelsAndProperties
			);
			fail(message);
			return true;
		}
		return false;
	}
	
	protected void testModuleCanExecute() {
		try {
			testConfig.run();
		}
		catch (Throwable ex) {
			fail(ex.getMessage());
		}
	}

	protected void testScenariosMatch() {
		Function<M, Collection<String>> modelCollector = module -> module
			.getContext().getModelRepository().getModels()
				.stream()
				.map(IModel::getName)
				.collect(Collectors.toList());
	
		assertEquals("Same script",
			expectedModule.getUri(),
			actualModule.getUri()
		);
			
		assertEquals("Same models",
			modelCollector.apply(expectedModule),
			modelCollector.apply(actualModule)
		);
	}
	
	@Test
	public void testFrameStacks() {
		Function<M, List<String>> fsMapper = module -> module
			.getContext().getFrameStack()
			.getFrames().stream()
			.map(Frame::getAll)
			.map(Map::keySet)
			.flatMap(Set::stream)
			.collect(Collectors.toList());
		
		onFail(testCollectionsHaveSameElements(
			fsMapper.apply(expectedModule),
			fsMapper.apply(actualModule),
			"FrameStacks"
		));
	}
	
	@Test
	public void testExecutorFactories() {
		Function<M, List<ModuleElement>> stackTraceGetter =
			module -> module.getContext().getExecutorFactory().getStackTraceManager().getStackTrace();
		
		assertEquals("Same stack traces",
			stackTraceGetter.apply(expectedModule),
			stackTraceGetter.apply(actualModule)
		);
	}
	
	@Test
	public void testOperationContributorRegistries() {
		Function<M, Collection<OperationContributor>> contributors = module ->
			module.getContext().getOperationContributorRegistry().stream().collect(Collectors.toSet());
	
		Collection<OperationContributor>
			expectedOCs = contributors.apply(expectedModule),
			actualOCs = contributors.apply(actualModule);

		onFail(printIfDifferent(
			actualOCs.size() < expectedOCs.size(),
			expectedOCs, actualOCs, "OperationContributorRegistries")
		);
	}
}
