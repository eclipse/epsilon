package org.eclipse.epsilon.egl.test.acceptance.outdentation;

import static org.eclipse.epsilon.common.util.FileUtil.getFileStandalone;

import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.junit.Test;

public class OutdentationTests {
	
	@Test
	public void testFor() throws Exception {
		test("For");
	}
	
	@Test
	public void testNestedFor() throws Exception {
		test("NestedFor");
	}
	
	@Test
	public void testForDoubleOutdentation() throws Exception {
		test("ForDoubleOutdentation");
	}
	
	@Test
	public void testForIf() throws Exception {
		test("ForIf");
	}
	
	@Test
	public void testForIfDoubleOutdentation() throws Exception {
		test("ForIfDoubleOutdentation");
	}
	
	@Test
	public void testBreak() throws Exception {
		test("Break");
	}
	
	protected void test(String name) throws Exception {
		AcceptanceTestUtil.test(
				getFileStandalone(name + ".egl", OutdentationTests.class),
				getFileStandalone(name + ".txt", OutdentationTests.class)
		);
	}
	
}
