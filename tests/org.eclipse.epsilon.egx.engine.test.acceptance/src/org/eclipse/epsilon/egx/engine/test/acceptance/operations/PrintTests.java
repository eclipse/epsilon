/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egx.engine.test.acceptance.operations;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.egl.concurrent.EgxModuleParallelAnnotation;
import org.eclipse.epsilon.egl.concurrent.atomic.EgxModuleParallelGenerationRuleAtoms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PrintTests {
	
	@Parameter
	public IEgxModule module;
	
	@Parameters
	public static Iterable<? extends IEgxModule> modules() throws Exception {
		Path base = Paths.get(PrintTests.class.getResource("").toURI());
		return Arrays.asList(
			new EgxModule(base),
			new EgxModuleParallelAnnotation(base),
			new EgxModuleParallelGenerationRuleAtoms(base)
		);
	}
	
	@Test
	public void testPrintFromTemplate() throws Exception {
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
