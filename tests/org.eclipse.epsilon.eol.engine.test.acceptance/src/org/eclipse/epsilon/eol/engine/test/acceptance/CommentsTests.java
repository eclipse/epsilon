package org.eclipse.epsilon.eol.engine.test.acceptance;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.eol.EolModule;
import org.junit.Test;

public class CommentsTests {
	
	@Test
	public void testSingleLineComment() throws Exception {
		EolModule module = new EolModule();
		module.parse("//c1\nif (true){}");
		assertEquals("c1", module.getMain().getStatements().get(0).getComments().get(0).toString());
	}
	
	@Test
	public void testMultiLineComment() throws Exception {
		EolModule module = new EolModule();
		module.parse("/*c1*/\nif (true){}");
		assertEquals("c1", module.getMain().getStatements().get(0).getComments().get(0).toString());
	}
}
