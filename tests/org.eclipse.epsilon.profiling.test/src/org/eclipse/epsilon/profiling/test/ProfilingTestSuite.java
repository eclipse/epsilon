package org.eclipse.epsilon.profiling.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({
	ProfileDiagnosticTest.class
})
public class ProfilingTestSuite {
	
	public static Test suite() {
		return new JUnit4TestAdapter(ProfilingTestSuite.class);
	}
}
