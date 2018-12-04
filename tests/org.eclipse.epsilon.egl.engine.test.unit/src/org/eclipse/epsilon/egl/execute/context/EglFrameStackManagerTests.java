/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.execute.context;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.output.IOutputBuffer;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EglFrameStackManagerTests.PrepareTests.class, EglFrameStackManagerTests.RestoreTests.class})
public class EglFrameStackManagerTests {
	
	private static final IOutputBuffer outputBuffer = new OutputBuffer();

	private static final Variable outVariable         = Variable.createReadOnlyVariable("out", outputBuffer);
	private static final Variable firstLocalVariable  = Variable.createReadOnlyVariable("foo", "bar");
	private static final Variable secondLocalVariable = Variable.createReadOnlyVariable("num", 42);
	
	private static final Template templateWithVariables = createTemplateWithVariables();
	private static final ExecutableTemplateSpecification spec = createExecutableTemplateSpecification(templateWithVariables, outputBuffer);

	private static FrameStack frameStack;
	private static EglFrameStackManager manager;		
	
	public static class PrepareTests {
		@Before
		public void clearFrameStack() {
			frameStack = new FrameStack();
			manager    = new EglFrameStackManager();
		}
		
		@Test
		public void prepareShouldSetOutputBufferGlobalVariable() {
			manager.prepareFrameStackFor(spec, frameStack);
			
			assertFrameStackHasGlobal(outVariable);
		}
		
		@Test
		public void prepareShouldOverwriteExitingOutVariable() {
			frameStack.putGlobal(Variable.createReadOnlyVariable("out", new OutputBuffer()));
			
			manager.prepareFrameStackFor(spec, frameStack);
			
			assertFrameStackHasGlobal(outVariable);
		}
		
		@Test
		public void prepareShouldSetTemplateVariablesAsLocals() {
			manager.prepareFrameStackFor(spec, frameStack);
			
			assertFrameStackHasLocal(firstLocalVariable);
			assertFrameStackHasLocal(secondLocalVariable);
		}
		
		@Test
		public void prepareShouldOverwriteLocalVariablesWithTemplateVariables() {
			frameStack.put(firstLocalVariable);
			frameStack.put(secondLocalVariable);
			
			manager.prepareFrameStackFor(spec, frameStack);
			
			assertFrameStackHasLocal(firstLocalVariable);
			assertFrameStackHasLocal(secondLocalVariable);
		}
	}
	
	
	public static class RestoreTests {	
		@Before
		public void clearFrameStack() {
			frameStack = new FrameStack();
			manager    = new EglFrameStackManager();
		}
		
		@Test
		public void restoreShouldRemoveOut() {
			manager.prepareFrameStackFor(spec, frameStack);
			manager.restoreFrameStackToPreviousState();
			
			assertFrameStackHasNoSuchGlobal(outVariable);		
		}
		
		@Test
		public void restoreShouldRestoreExistingOutToFrameStack() {
			final Variable existingOut = Variable.createReadOnlyVariable("out", new OutputBuffer());
			frameStack.putGlobal(existingOut);
			
			manager.prepareFrameStackFor(spec, frameStack);
			manager.restoreFrameStackToPreviousState();
			
			assertFrameStackHasGlobal(existingOut);		
		}
		
		@Test
		public void restoreShouldRemoveLocalVariables() {
			manager.prepareFrameStackFor(spec, frameStack);
			manager.restoreFrameStackToPreviousState();
			
			assertFrameStackHasNoSuchLocal(firstLocalVariable);		
			assertFrameStackHasNoSuchLocal(secondLocalVariable);		
		}
		
		@Test
		public void restoreShouldRestoreExistingLocalVariables() {
			final Variable existingLocal = Variable.createReadOnlyVariable("name", "Franz");
			frameStack.put(existingLocal);
			
			manager.prepareFrameStackFor(spec, frameStack);
			manager.restoreFrameStackToPreviousState();
			
			assertFrameStackHasLocal(existingLocal);
		}
	}
	
	private static void assertFrameStackHasGlobal(Variable variable) {
		assertEquals(variable.getValue(), getGlobalVariable(variable.getName()).getValue());
	}
	
	private static void assertFrameStackHasNoSuchGlobal(Variable variable) {
		assertNull(getGlobalVariable(variable.getName()));
	}
	
	private static void assertFrameStackHasLocal(Variable variable) {
		assertEquals(variable.getValue(), getLocalVariable(variable.getName()).getValue());
	}
	
	private static void assertFrameStackHasNoSuchLocal(Variable variable) {
		assertNull(getLocalVariable(variable.getName()));
	}
	
	private static Variable getGlobalVariable(String name) {
		return frameStack.getGlobal(name);
	}

	private static Variable getLocalVariable(String name) {
		return frameStack.get(name);
	}

	private static Template createTemplateWithVariables() {
		final Template templateWithVariables = new Template();
		templateWithVariables.addVariable(firstLocalVariable.getName(), firstLocalVariable.getValue());
		templateWithVariables.addVariable(secondLocalVariable.getName(), secondLocalVariable.getValue());
		return templateWithVariables;
	}
	
	private static ExecutableTemplateSpecification createExecutableTemplateSpecification(Template template, IOutputBuffer outputBuffer) {
		final EglTemplate t = mock(EglTemplate.class);
		when(t.getTemplate()).thenReturn(template);
		return new ExecutableTemplateSpecification(t, outputBuffer);
	}
}
