package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.common.test.FileUtils;
import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Ignore;
import org.junit.Test;

public class OperatorTest extends AbstractSimulinkTest {

	@Test
	@Ignore
	public void selectSimulinkBlockTest() throws Exception {
		modelFile = FileUtils.getModelFile("feedbackController.slx");
		eol = "Block.all.select(b|b.name.startsWith('s')).println();";
	}
	
	@Test
	public void collectSimulinkBlockTest() throws Exception {
		modelFile = FileUtils.getModelFile("feedbackController.slx");
		eol = "Block.all.collect(b|b.name).println();";
	}
	
	@Test
	@Ignore
	public void selectStateflowStateTest() throws Exception {
		modelFile = FileUtils.getModelFile("sf_traffic_light.slx");
		eol = "`Stateflow.State`.all.select(b|b.Name.startsWith('s')).println();";
	}
	
	@Test
	public void collectStateflowStateTest() throws Exception {
		modelFile = FileUtils.getModelFile("sf_traffic_light.slx");
		eol = "`Stateflow.State`.all.collect(b|b.Name).println();";
	}
	
}
