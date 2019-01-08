package org.eclipse.epsilon.flexmi.test;

import java.util.Arrays;

import org.junit.Test;

public class ActionTests extends FlexmiTests {
	
	@Test
	public void testReferenceFeatures() throws Exception {
		assertEval("EReference.all.first().eType.name", "C1", "actions/model-with-actions.flexmi");
		assertEval("EReference.all.first().name", "r1", "actions/model-with-actions.flexmi");
	}
	
	@Test
	public void testClassFeatures() throws Exception {
		assertEval("EClass.all.first().isAbstract", true, "actions/model-with-actions.flexmi");
	}
	
	@Test
	public void testVar() throws Exception {
		assertEval("EReference.all.second().eType.name", "C2", "actions/model-with-actions.flexmi");
		assertEval("EClass.all.third().eSuperTypes.name", Arrays.asList("C1", "C2"), "actions/model-with-actions.flexmi");
		assertEval("EClass.all.fourth().eSuperTypes.name", Arrays.asList("C1", "C2"), "actions/model-with-actions.flexmi");
	}
}
