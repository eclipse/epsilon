package org.eclipse.epsilon.flexmi.test;

import org.junit.Test;

public class IntegrationTests extends FlexmiTests {
	
	@Test
	public void testSpeedMonitor() throws Exception {
		assertNoWarnings("integration/speed-monitor/speed-monitor.flexmi", "integration/speed-monitor/comps.ecore");
	}
	
}
