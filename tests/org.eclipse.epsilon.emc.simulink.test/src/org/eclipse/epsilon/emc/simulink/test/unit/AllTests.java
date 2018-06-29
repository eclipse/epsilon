package org.eclipse.epsilon.emc.simulink.test.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CRUDTests.class, ExampleTests.class, InheritanceTests.class,
		/*MatlabEngineTests.class,*/ OperationTests.class, PrimitiveTypeTests.class, PropertyTests.class})
public class AllTests {

}
