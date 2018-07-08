package org.eclipse.epsilon.flexmi.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class PerformanceTests extends FlexmiTests {
	
	@Test
	public void testFilesystem() throws Exception {
		assertEquals(0, loadResource("performance/filesystem.flexmi").getWarnings().size());
	}
	
}
