/*******************************************************************************
 * Copyright (c) 2024 The University of York.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.epsilon.eol.dap.test.egx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.eol.dap.test.AbstractEpsilonDebugAdapterTest;
import org.eclipse.epsilon.eol.models.java.JavaModel;
import org.eclipse.lsp4j.debug.BreakpointNotVerifiedReason;
import org.eclipse.lsp4j.debug.ContinueArguments;
import org.eclipse.lsp4j.debug.SetBreakpointsResponse;
import org.eclipse.lsp4j.debug.StoppedEventArgumentsReason;
import org.eclipse.lsp4j.debug.Variable;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class EgxDebugTest extends AbstractEpsilonDebugAdapterTest {

	private static final File SCRIPT_FILE = new File(BASE_RESOURCE_FOLDER, "10-orchestration.egx");
	private static final File EGL_FILE = new File(BASE_RESOURCE_FOLDER, "10-person.egl");

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	public static class Person {
		private String name, lastName;

		public Person() {
			// nothing to do
		}

		public Person(String firstName, String lastName) {
			this.name = firstName;
			this.lastName = lastName;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}

	@Override
	protected void setupModule() throws Exception {
		this.module = new EgxModule();
		module.parse(SCRIPT_FILE);
		module.getContext().getFrameStack().put("tempFolder", tempFolder.newFolder());

		final List<Object> instances = Collections.singletonList(new Person("John", "Smith"));
		final List<Class<?>> types = Collections.singletonList(Person.class);
		final JavaModel model = new JavaModel(instances, types);
		module.getContext().getModelRepository().addModel(model);
	}

	@Test
	public void canStopOnOperation() throws Exception {
		SetBreakpointsResponse stopResult = adapter.setBreakpoints(
			createBreakpoints(createBreakpoint(1))).get();
		assertTrue("The breakpoint was verified", stopResult.getBreakpoints()[0].isVerified());
		attach();
		assertStoppedBecauseOf(StoppedEventArgumentsReason.BREAKPOINT);

		Map<String, Variable> topVariables = getVariablesFromTopStackFrame();
		Variable firstNameVariable = topVariables.get("firstName");
		assertNotNull("The top scope should have a 'firstName' variable", firstNameVariable);
		assertEquals("John", firstNameVariable.getValue());

		adapter.continue_(new ContinueArguments());
		assertProgramCompletedSuccessfully();
	}

	@Test
	public void canStopAtBeginningOfTarget() throws Exception {
		SetBreakpointsResponse stopResult = adapter.setBreakpoints(
				createBreakpoints(createBreakpoint(7))).get();
		assertTrue("The breakpoint was verified", stopResult.getBreakpoints()[0].isVerified());
		attach();
		assertStoppedBecauseOf(StoppedEventArgumentsReason.BREAKPOINT);

		Map<String, Variable> topVariables = getVariablesFromTopStackFrame();
		assertNotNull("The top scope should have a 'p' variable", topVariables.get("p"));
		assertNull("The top scope should not have a 't' variable yet", topVariables.get("t"));

		adapter.continue_(new ContinueArguments());
		assertProgramCompletedSuccessfully();
	}

	@Test
	public void canStopWithinTarget() throws Exception {
		SetBreakpointsResponse stopResult = adapter.setBreakpoints(
			createBreakpoints(createBreakpoint(9))).get();
		assertTrue("The breakpoint on the operation was verified",
			stopResult.getBreakpoints()[0].isVerified());
		attach();
		assertStoppedBecauseOf(StoppedEventArgumentsReason.BREAKPOINT);

		Map<String, Variable> topVariables = getVariablesFromTopStackFrame();
		Variable tVariable = topVariables.get("t");
		assertNotNull("The top scope should have a 't' variable", tVariable);

		adapter.continue_(new ContinueArguments());
		assertProgramCompletedSuccessfully();
	}

	@Test
	public void canStopWithinExecutedTemplate() throws Exception {
		SetBreakpointsResponse stopResult = adapter.setBreakpoints(
			createBreakpoints(EGL_FILE.getCanonicalPath(), createBreakpoint(2))).get();
		assertFalse("The breakpoint on the template was not verified",
			stopResult.getBreakpoints()[0].isVerified());
		assertEquals("The breakpoint on the template was left pending",
			BreakpointNotVerifiedReason.PENDING,
			stopResult.getBreakpoints()[0].getReason());
		attach();
		assertStoppedBecauseOf(StoppedEventArgumentsReason.BREAKPOINT);

		Map<String, Variable> topVariables = getVariablesFromTopStackFrame();
		assertNotNull("The top scope should have a 'p' variable", topVariables.get("p"));
		assertNotNull("The top scope should have an 'out' variable", topVariables.get("out"));

		adapter.continue_(new ContinueArguments());
		assertProgramCompletedSuccessfully();
	}

}
