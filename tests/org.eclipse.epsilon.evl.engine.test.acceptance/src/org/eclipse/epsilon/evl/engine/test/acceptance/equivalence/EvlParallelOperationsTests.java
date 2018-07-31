package org.eclipse.epsilon.evl.engine.test.acceptance.equivalence;

import static org.eclipse.epsilon.evl.engine.test.acceptance.EvlAcceptanceTestUtil.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallelAnnotation;
import org.eclipse.epsilon.evl.launch.EvlRunConfiguration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
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
		new String[]{"java_parallel", "java_sequential"},
		javaModels, javaMetamodel
	);
	
	public EvlParallelOperationsTests(EvlRunConfiguration configUnderTest) {
		super(configUnderTest);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		expectedConfigs = getScenarios(inputs, false, Collections.singleton(EvlModule::new));
		setUpEquivalenceTest();
	}
	
	@Parameters
	public static Collection<EvlRunConfiguration> configurations() {
		return getScenarios(inputs, false, Collections.singleton(EvlModuleParallelAnnotation::new));
	}
}
