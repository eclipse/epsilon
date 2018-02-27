package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.eclipse.epsilon.emc.simulink.test.util.FileUtils;
import org.junit.Ignore;
import org.junit.Test;

public class ExampleTests extends AbstractSimulinkTest {

private static final String ROOT = "examples/"; 
	
	@Test
	public void testCreateFeedbackController() { 
		eolResourceFile = ROOT + "createFeedbackController.eol";
	}

	@Test
	public void testCreateFunctionWithScript() {
		eolResourceFile = ROOT + "createFunctionWithScript.eol";
	}
	
	@Test
	public void testCreateSimpleSimulation() {
		eolResourceFile = ROOT + "createSimpleSimulation.eol";
	}
	
	@Test
	public void testCreateStateflowStateTransitions() {
		eolResourceFile = ROOT + "createStateflowStateTransitions.eol";
	}
	
	@Test
	public void testRobustTest() {
		eolResourceFile = ROOT + "robustTest.eol";
	}
	
	@Test
	@Ignore
	public void testQueryFeedbackController() { // FAILS
		eolResourceFile = ROOT + "queryFeedbackController.eol";
		modelFile = FileUtils.getModelFile("feedbackController.slx");
	}
	
}
