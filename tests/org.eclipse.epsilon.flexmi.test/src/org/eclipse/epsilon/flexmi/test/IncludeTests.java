package org.eclipse.epsilon.flexmi.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IncludeTests extends FlexmiTests {
	
	@Test
	public void testNoWarnings() throws Exception {
		assertEquals(loadResource("include/valid-main.flexmi").getWarnings().size(), 0);
	}
	
	@Test
	public void testFlexmiRootNode() throws Exception {
		assertEval("EPackage.all.first().eClassifiers.size()", 2, "include/include-datatypes.flexmi");
	}
	
	
	@Test
	public void testESuperType() throws Exception {
		assertEval("EClass.all.first().eSuperTypes.first().name", "c2", "include/valid-main.flexmi");
	}
	
}
