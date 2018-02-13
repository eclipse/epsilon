package org.eclipse.epsilon.emc.simulink.test.unit;

import static org.junit.Assert.*;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.eclipse.epsilon.emc.simulink.test.util.FileUtils;
import org.junit.Test;

public class SimulinkLineTests extends AbstractSimulinkTest {

	@Test
	public void testGetDestination() {
		modelFile = FileUtils.getModelFile("sf_msg_traffic_light.slx");
		eol = "";
	}

	@Test
	public void testGetSource() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDestinationPort() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSourcePort() {
		fail("Not yet implemented");
	}

	/*
	@Test
	public void testSimulinkLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteElementInModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetType() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAllTypeNamesOf() {
		fail("Not yet implemented");
	}
	*/
	
}
