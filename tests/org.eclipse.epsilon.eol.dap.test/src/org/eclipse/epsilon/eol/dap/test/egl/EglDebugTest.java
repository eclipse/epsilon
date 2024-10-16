/*******************************************************************************
 * Copyright (c) 2024 The University of York.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.epsilon.eol.dap.test.egl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Map;

import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.eol.dap.test.AbstractEpsilonDebugAdapterTest;
import org.eclipse.lsp4j.debug.ContinueArguments;
import org.eclipse.lsp4j.debug.SetBreakpointsResponse;
import org.eclipse.lsp4j.debug.StackTraceResponse;
import org.eclipse.lsp4j.debug.StoppedEventArgumentsReason;
import org.eclipse.lsp4j.debug.Variable;
import org.junit.Test;

public class EglDebugTest extends AbstractEpsilonDebugAdapterTest {

	private static final File SCRIPT_FILE = new File(BASE_RESOURCE_FOLDER, "08-hello.egl");

	@Override
	protected void setupModule() throws Exception {
		this.module = new EglModule();
		module.parse(SCRIPT_FILE);
	}

	@Test
	public void canStopOnFirstLine() throws Exception {
		SetBreakpointsResponse stopResult = adapter.setBreakpoints(
			createBreakpoints(createBreakpoint(1))).get();
		assertTrue("The breakpoint at line 2 was verified",
			stopResult.getBreakpoints()[0].isVerified());
		attach();
		assertStoppedBecauseOf(StoppedEventArgumentsReason.BREAKPOINT);

		adapter.continue_(new ContinueArguments()).get();
		assertProgramCompletedSuccessfully();
	}

	@Test
	public void canStopToSeeVariable() throws Exception {
		SetBreakpointsResponse stopResult = adapter.setBreakpoints(
			createBreakpoints(createBreakpoint(2))).get();
		assertTrue("The breakpoint at line 2 was verified",
			stopResult.getBreakpoints()[0].isVerified());
		attach();

		// Break on the first static segment of line 2
		assertStoppedBecauseOf(StoppedEventArgumentsReason.BREAKPOINT);

		StackTraceResponse stackTrace = getStackTrace();
		assertEquals("Should be stopped at the second line", 2, getCurrentLine(stackTrace));
		assertEquals("Should be stopped from the first column", 1, getCurrentStartColumn(stackTrace));
		assertEquals("Should be stopped until column 7", 7, getCurrentEndColumn(stackTrace));

		Map<String, Variable> topVariables = getVariablesFromTopStackFrame();
		Variable numbersVariable = topVariables.get("name");
		assertNotNull("The top scope should have a 'name' variable", numbersVariable);
		assertEquals("String", numbersVariable.getType());
		assertEquals("Joe", numbersVariable.getValue());

		// Continue: it should stop in the dynamic region
		adapter.continue_(new ContinueArguments()).get();
		assertStoppedBecauseOf(StoppedEventArgumentsReason.BREAKPOINT);
		stackTrace = getStackTrace();
		assertEquals("Should be stopped at the second line", 2, getCurrentLine(stackTrace));
		assertEquals("Should be stopped from column 10", 10, getCurrentStartColumn(stackTrace));
		assertEquals("Should be stopped until column 14", 14, getCurrentEndColumn(stackTrace));

		// Continue: it should stop in the trailing static region
		adapter.continue_(new ContinueArguments()).get();
		assertStoppedBecauseOf(StoppedEventArgumentsReason.BREAKPOINT);
		stackTrace = getStackTrace();
		assertEquals("Should be stopped at the second line", 2, getCurrentLine(stackTrace));
		assertEquals("Should be stopped from column 16", 16, getCurrentStartColumn(stackTrace));
		assertEquals("Should be stopped until column 17", 17, getCurrentEndColumn(stackTrace));

		// Continue: it should stop in the newline part
		adapter.continue_(new ContinueArguments()).get();
		assertStoppedBecauseOf(StoppedEventArgumentsReason.BREAKPOINT);
		stackTrace = getStackTrace();
		assertEquals("Should be stopped at the second line", 2, getCurrentLine(stackTrace));
		assertEquals("Should be stopped at column 17", 17, getCurrentStartColumn(stackTrace));
		assertEquals("Should be stopped until column 17", 17, getCurrentEndColumn(stackTrace));

		// Continue: it should complete
		adapter.continue_(new ContinueArguments()).get();
		assertProgramCompletedSuccessfully();
	}
}
