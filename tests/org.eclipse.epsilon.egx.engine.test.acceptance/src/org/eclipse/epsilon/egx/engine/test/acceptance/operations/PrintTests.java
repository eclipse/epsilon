package org.eclipse.epsilon.egx.engine.test.acceptance.operations;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Paths;

import org.eclipse.epsilon.egl.EgxModule;
import org.junit.Test;

public class PrintTests {
	
	@Test
	public void testPrintFromTemplate() throws Exception {
		
		// The test passes if EgxModule is replaced with EgxModuleParallelElements
		EgxModule module = new EgxModule(Paths.get(getClass().getResource("").toURI()));
		module.parse(getClass().getResource("print.egx"));
		System.out.println("EGX context " + module.getContext() + " prints to " + module.getContext().getOutputStream());
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		module.getContext().setOutputStream(new MyPrintStream(bos));
		module.execute();
		assertEquals("EGXEGL", bos.toString());

	}
	
	class MyPrintStream extends PrintStream {

		public MyPrintStream(OutputStream out) {
			super(out);
		}
		
	}
	
}
