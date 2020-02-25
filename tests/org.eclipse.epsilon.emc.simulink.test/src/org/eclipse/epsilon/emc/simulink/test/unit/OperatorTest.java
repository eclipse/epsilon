package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.common.test.FileUtils;
import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Test;

public class OperatorTest extends AbstractSimulinkTest {

	@Test
	public void selectSimulinkBlockTest() throws Exception {
		modelFile = FileUtils.getModelFile("feedbackController.slx");
		eol = "Block.all.select(b|b.name == 'Controller').println();";
	}
	/*
	@Ignore
	@Test
	public void selectSimulinkBlockTest() throws Exception {
		modelFile = FileUtils.getModelFile("feedbackController.slx");
		eol = "Block.all.select(b|b.name.startsWith('Traffic')).println();";
	}*/
	
	@Test
	public void collectSimulinkBlockTest() throws Exception {
		modelFile = FileUtils.getModelFile("feedbackController.slx");
		eol = "Block.all.collect(b|b.name).println();";
	}
	
	@Test
	public void selectStateflowStateTest() throws Exception {
		modelFile = FileUtils.getModelFile("sf_traffic_light.slx");
		eol = "`Stateflow.State`.all.select(b|b.Name == 'Traffic Light 1').println();";
	}
	
	@Test
	public void collectStateflowStateTest() throws Exception {
		modelFile = FileUtils.getModelFile("sf_traffic_light.slx");
		eol = "`Stateflow.State`.all.collect(b|b.Name).println();";
	}
	
}
