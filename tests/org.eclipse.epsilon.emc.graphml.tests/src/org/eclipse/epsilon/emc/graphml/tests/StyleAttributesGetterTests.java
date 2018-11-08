package org.eclipse.epsilon.emc.graphml.tests;

import org.eclipse.epsilon.flexmi.test.FlexmiTests;
import org.junit.Test;

public class StyleAttributesGetterTests extends MuddleTests {
	

	@Test
	public void testShape() throws Exception {
		assertEval("Animal.all().first().style.shape", "rectangle", "styleModel.graphml");
	}

	@Test
	public void testColor() throws Exception {
		assertEval("Animal.all().first().style.color", "#FFCC00", "styleModel.graphml");
	}

	@Test
	public void testWidth() throws Exception {
		assertEval("Animal.all().first().style.width", 130.0, "styleModel.graphml");
	}

	@Test
	public void testHeight() throws Exception {
		assertEval("Animal.all().first().style.height", 30.0, "styleModel.graphml");
	}
	
	@Test
	public void testX() throws Exception {
		assertEval("Animal.all().first().style.x", 220.5, "styleModel.graphml");
	}

	@Test
	public void testY() throws Exception {
		assertEval("Animal.all().first().style.y", -221.2, "styleModel.graphml");
	}
	
	@Test
	public void testlabelFontSize() throws Exception {
		assertEval("Animal.all().first().style.labelFontSize", 12, "styleModel.graphml");
	}

	@Test
	public void testborderWidth() throws Exception {
		assertEval("Animal.all().first().style.borderWidth", 1.0, "styleModel.graphml");
	}

}
