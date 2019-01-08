package org.eclipse.epsilon.flexmi.test;

import org.junit.Test;

public class ComputationTests extends FlexmiTests {
	
	@Test
	public void testReferenceFeatures() throws Exception {
		assertEval("EReference.all.first().eType.name", "C", "computations/model-with-computations.flexmi");
		assertEval("EReference.all.first().name", "r1", "computations/model-with-computations.flexmi");
	}
	
	@Test
	public void testClassFeatures() throws Exception {
		assertEval("EClass.all.first().isAbstract", true, "computations/model-with-computations.flexmi");
	}
	
}
