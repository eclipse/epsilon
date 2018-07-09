package org.eclipse.epsilon.flexmi.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VariableTests extends FlexmiTests {
	
	@Test
	public void testNoWarnings() throws Exception {
		assertEquals(0, loadResource("standalone/valid-model-with-variables.flexmi").getWarnings().size());
		assertEquals(0, loadResource("standalone/valid-model-with-hierarchical-variables.flexmi").getWarnings().size());

	}
	
	@Test
	public void testVariables() throws Exception {
		assertEval("EReference.all.get(0).eOpposite.eContainer().eContainer().name", "p2", "standalone/valid-model-with-variables.flexmi");
		assertEval("EReference.all.get(1).eOpposite.eContainer().eContainer().name", "p2", "standalone/valid-model-with-variables.flexmi");

		assertEval("EReference.all.get(2).eOpposite.eContainer().eContainer().name", "p3", "standalone/valid-model-with-variables.flexmi");
		assertEval("EReference.all.get(3).eOpposite.eContainer().eContainer().name", "p3", "standalone/valid-model-with-variables.flexmi");

	}
	
	@Test
	public void testHierarchicalVariables() throws Exception {
		assertEval("EClass.all.get(2).eSuperTypes.first().eContainer().name", "p2", "standalone/valid-model-with-hierarchical-variables.flexmi");
		assertEval("EClass.all.get(3).eSuperTypes.first().eContainer().name", "p1", "standalone/valid-model-with-hierarchical-variables.flexmi");

	}
}
