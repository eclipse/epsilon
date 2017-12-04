package org.eclipse.epsilon.emc.simulink.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEnginePool;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class MatlabEngineTests {

	private static String libraryPath = "/Applications/MATLAB_R2017a.app/bin/maci64"; 
	private static String engineJarPath = "/Applications/MATLAB_R2017a.app/extern/engines/java/jar/engine.jar";
	
	private static MatlabEngine engine;
	
	@BeforeClass
	public static void setup(){
		engine = MatlabEnginePool.getInstance(libraryPath, engineJarPath).getMatlabEngine();
	}
	
	@Test
	public void testEvalNoCommandEnd() {
		engine.eval("a = 2 + 2");
		assertEquals(4.0, engine.getVariable("a")); 
	}
	
	@Test
	public void testEvalSemiColonEnd() {
		engine.eval("b = 2 + 2;");
		assertEquals(4.0, engine.getVariable("b")); 
	}
	
	@Test
	public void testEvalLineBreak() {
		engine.eval("c = 2 + 2\n");
		assertEquals(4.0, engine.getVariable("c")); 
	}
	
	@Test
	public void testRuntimeException() {
		try {
			engine.eval("d  2 + 2");
			fail();
		} catch (RuntimeException e){
			assertTrue(MatlabEngineUtil.isMatlabException(e.getCause()));
		} catch (Exception ex) {
			fail();
		}
	}
	
}
