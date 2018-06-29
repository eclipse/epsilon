package org.eclipse.epsilon.flexmi.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImportTests extends FlexmiTests {
	
	@Test
	public void testNoWarnings() throws Exception {
		assertEquals(loadResource("import/valid-main.flexmi").getWarnings().size(), 0);
	}
	
	@Test
	public void testESuperType() throws Exception {
		assertEval("EClass.all.first().eSuperTypes.first().name", "c2", "import/valid-main.flexmi");
	}
	
	@Test
	public void testUnresolvedReferenceWarning() throws Exception {
		assertEquals(loadResource("import/invalid-main.flexmi").getWarnings().size(), 1);
	}
	
}
