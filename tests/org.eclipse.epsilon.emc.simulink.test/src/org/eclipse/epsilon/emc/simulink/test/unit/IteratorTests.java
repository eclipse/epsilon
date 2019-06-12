package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.common.test.FileUtils;
import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Before;
import org.junit.Test;

public class IteratorTests extends AbstractSimulinkTest {

	@Before
	public  void setup() {
		activeCache = false;
		modelFile = FileUtils.getModelFile("feedbackController.slx");
	}
	
	@Test
	public void test() {
		eol = "Block.all().first().name.println();";
	}
	
	@Test
	public void testFor() {
		eol = "var blocks = Block.all(); "
				+ "for (b in blocks){"
				+ "   b.name.println();"
				+ "}";
	}
	
}
