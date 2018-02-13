package org.eclipse.epsilon.emc.simulink.test.unit.type;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DualBlockTypeTests.class, SimulinkBlockTypeTests.class, SimulinkLineTypeTests.class,
		SimulinkPortTypeTests.class, StateflowBlockTypeTests.class })
public class AllTests {

}
