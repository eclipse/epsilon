package org.eclipse.epsilon.egx.engine.test.acceptance.equivalence;

import static org.eclipse.epsilon.egx.engine.test.acceptance.EgxAcceptanceTestUtil.*;
import java.util.*;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolEquivalenceTests;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized.Parameters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EgxModuleEquivalenceTests extends EolEquivalenceTests<IEgxModule, IEolRunConfiguration<IEgxModule, ?>> {

	public EgxModuleEquivalenceTests(IEolRunConfiguration<IEgxModule, ?> configUnderTest) {
		super(configUnderTest);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		expectedConfigs = getScenarios(allInputs, true, Collections.singleton(EgxModule::new));
		setUpEquivalenceTest();
	}
	
	/**
	 * @return A collection of pre-configured run configurations, each with their own IEgxModule.
	 * @see EgxAcceptanceTestSuite.getScenarios
	 */
	@Parameters(name = "0")	//Don't use this as the Eclipse JUnit view won't show failures!
	public static Iterable<? extends IEolRunConfiguration<IEgxModule, ?>> configurations() {
		// Used to specify which module configurations we'd like to test in our scenarios
		return getScenarios(
			allInputs,		// All scripts & models
			true,			// Include test.egx
			modules(false) 	// Exclude the standard EgxModule
		);
	}
	
	@Test
	public void _test0() {
		super.beforeTests();
	}
	
	@Test
	public void testEquivalentOutput() {
		//TODO implement
	}
}
