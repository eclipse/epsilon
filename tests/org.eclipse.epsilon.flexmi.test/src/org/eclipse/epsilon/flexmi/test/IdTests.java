package org.eclipse.epsilon.flexmi.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IdTests extends FlexmiTests {
	
	
	@Test
	public void testNoWarnings() throws Exception {
		assertEquals(0, loadResource("standalone/valid-model-with-fully-qualified-ids.flexmi").getWarnings().size());
	}
	
	@Test
	public void testFullyQualifiedIds() throws Exception {
		assertEval("EClass.all.get(1).eSuperTypes.first().eContainer().name", "p1", "standalone/valid-model-with-fully-qualified-ids.flexmi");
		assertEval("EClass.all.get(2).eSuperTypes.first().eContainer().name", "p2", "standalone/valid-model-with-fully-qualified-ids.flexmi");
	}
	
}
