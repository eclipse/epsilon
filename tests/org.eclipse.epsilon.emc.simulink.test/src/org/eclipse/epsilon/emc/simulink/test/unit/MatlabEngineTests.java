package org.eclipse.epsilon.emc.simulink.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEnginePool;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.test.util.MatlabEngineFilesEnum;
import org.junit.BeforeClass;
import org.junit.Test;

public class MatlabEngineTests {

	private static MatlabEngine engine;

	@BeforeClass
	public static void setup() {
		try {
			engine = MatlabEnginePool
					.getInstance(MatlabEngineFilesEnum.LIBRARY_PATH.path(), MatlabEngineFilesEnum.ENGINE_JAR.path())
					.getMatlabEngine();
		} catch (Exception e) {
			throw new RuntimeException("could not setup the test class");
		}
	}

	@Test
	public void testEvalNoCommandEnd() {
		try {
			engine.eval("a = 2 + 2");
			assertEquals(4.0, engine.getVariable("a"));
		} catch (MatlabException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testEvalSemiColonEnd() {
		try {
			engine.eval("b = 2 + 2;");
			assertEquals(4.0, engine.getVariable("b"));
		} catch (MatlabException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testEvalLineBreak() {
		try {
			engine.eval("c = 2 + 2\n");
			assertEquals(4.0, engine.getVariable("c"));
		} catch (MatlabException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRuntimeException() {
		try {
			engine.eval("d  2 + 2");
			fail("did not crash");
		} catch (MatlabException e) {
			assertTrue(true);
		} catch (Exception ex) {
			fail("not a matlab Exception");
		}
	}

}
