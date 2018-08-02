package org.eclipse.epsilon.evl.engine.test.acceptance.equivalence;

import static org.eclipse.epsilon.evl.engine.test.acceptance.EvlAcceptanceTestUtil.*;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolAcceptanceTestUtil;
import org.eclipse.epsilon.eol.exceptions.concurrent.EolNestedParallelismException;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallelAnnotation;
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
 * @see java_parallel.evl
 * @see java_sequential.evl
 * @author Sina Madani
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EvlParallelOperationsTests extends EvlModuleEquivalenceTests {

	private static final List<String[]> inputs = addAllInputs(
		new String[]{"java_parallel", "java_sequential", "java_parallelNested"},
		javaModels, javaMetamodel
	);
	
	public EvlParallelOperationsTests(EvlRunConfiguration configUnderTest) {
		super(configUnderTest);
	}
	
	@Rule
    public TestName testName = new TestName();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		expectedConfigs = getScenarios(inputs, false, Collections.singleton(EvlModule::new));
		setUpEquivalenceTest();
	}
	
	@Parameters
	public static Collection<EvlRunConfiguration> configurations() {
		return getScenarios(inputs, false, EolAcceptanceTestUtil.parallelModules(
			new int[]{2, 3, 8, 57}, null, EvlModuleParallelAnnotation::new
		));
	}
	
	@Before
	public void assumeLegal() throws Exception {
		if (testName.getMethodName().startsWith("testIllegalNesting")) {
			assumeTrue(testConfig.script.getFileName().toString().equals("java_parallelNested.evl"));
			expectedConfig.run();
			testConfig.preExecute();
			testScenariosMatch();
		}
		else {
			assumeFalse(testConfig.script.getFileName().toString().equals("java_parallelNested.evl"));
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
		
		fail(
			"Expected "+EolNestedParallelismException.class.getSimpleName()+": "
			+ actualModule.getContext()
		);
	}
}
