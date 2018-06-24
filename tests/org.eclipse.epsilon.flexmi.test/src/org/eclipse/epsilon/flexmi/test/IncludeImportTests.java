package org.eclipse.epsilon.flexmi.test;

import org.junit.Test;

public class IncludeImportTests extends FlexmiTests {
	
	@Test
	public void testUniqueC1() throws Exception {
		assertEval("EClass.all.selectOne(c|c.name='C3').eSuperTypes.first() == EClass.all.selectOne(c|c.name='C1')", 
				true, "include-import/valid-main.flexmi");
	}
	
}
