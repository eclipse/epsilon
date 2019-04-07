package org.eclipse.epsilon.flexmi.test;

import org.junit.Test;

public class ActionTests extends FlexmiTests {
	
	@Test
	public void testVar() throws Exception {
		assertEval("EOperation.all.first().name", "createC1", "actions/model-with-actions.flexmi");
		assertEval("EOperation.all.second().name", "createC3", "actions/model-with-actions.flexmi");
		assertEval("EOperation.all.first().eType.name", "C1", "actions/model-with-actions.flexmi");
		assertEval("EOperation.all.second().eType.name", "C3", "actions/model-with-actions.flexmi");
		assertEval("EClass.all.third().name", "C2Clone", "actions/model-with-actions.flexmi");
		
		assertWarning("Undefined variable", 7, "actions/model-with-actions.flexmi");
	}
	
	
	
}
