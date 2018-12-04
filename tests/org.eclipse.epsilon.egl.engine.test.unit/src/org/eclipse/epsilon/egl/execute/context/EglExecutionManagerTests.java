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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EglExecutionManagerTests.PrepareTests.class, EglExecutionManagerTests.RestoreTests.class})
public class EglExecutionManagerTests {
	
	private static final ExecutableTemplateSpecification firstSpec  = createExecutableTemplateSpecification("First");
	private static final ExecutableTemplateSpecification secondSpec = createExecutableTemplateSpecification("Second");
	private static final ExecutableTemplateSpecification thirdSpec  = createExecutableTemplateSpecification("Third");
	
	private static ExecutableTemplateSpecification createExecutableTemplateSpecification(String name) {
		final EglTemplate template = mock(EglTemplate.class);
		when(template.getTemplate()).thenReturn(new Template(name));
		return new ExecutableTemplateSpecification(template, new OutputBuffer());
	}
	
	public static class PrepareTests {
		private final EglExecutionManager manager = new EglExecutionManager();
		private final FrameStack frameStack = mock(FrameStack.class);
		
		@Before
		public void prepareForSpecs() {
			manager.prepareFor(firstSpec, frameStack);
			manager.prepareFor(secondSpec, frameStack);
			manager.prepareFor(thirdSpec, frameStack);
		}
		
		@Test
		public void setsBaseAsFirstToBePrepared() throws Exception {
			assertEquals(firstSpec, manager.getBase());
		}
		
		@Test
		public void setsCurrentAsLastToBePrepared() throws Exception {
			assertEquals(thirdSpec, manager.getCurrent());
		}
		
		/*@Test
		public void delegatesToFrameStackManager() throws Exception {
			verify(frameStackManager).prepareFrameStackFor(firstSpec);
			verify(frameStackManager).prepareFrameStackFor(secondSpec);
			verify(frameStackManager).prepareFrameStackFor(thirdSpec);
		}*/
	
	}
	
	public static class RestoreTests {
		private final FrameStack frameStack = mock(FrameStack.class);
		private final EglExecutionManager manager = new EglExecutionManager();
		
		@Before
		public void prepareForSpecs() {
			manager.prepareFor(firstSpec, frameStack);
			manager.prepareFor(secondSpec, frameStack);
			manager.prepareFor(thirdSpec, frameStack);
		}
		
		@Test
		public void restoresPreviousAsCurrent() throws Exception {
			manager.restore();
			
			assertEquals(secondSpec, manager.getCurrent());
		}
		
		@Test
		public void restoresTwoAgoAsCurrent() throws Exception {
			manager.restore();
			manager.restore();
			
			assertEquals(firstSpec, manager.getCurrent());
		}
		
		@Test
		public void restoresNullWhenCalledAsManyTimesAsPrepare() throws Exception {
			manager.restore();
			manager.restore();
			manager.restore();
			
			assertNull(manager.getCurrent());
		}
	
		/*@Test
		public void delegatesToFrameStackManager() throws Exception {
			manager.restore();
			manager.restore();
			manager.restore();
			
			verify(frameStackManager, times(3)).restoreFrameStackToPreviousState();
		}*/
		
		@Test
		public void doesNotDestroyBase() throws Exception {
			manager.restore();
			manager.restore();
			manager.restore();
			
			assertEquals(firstSpec, manager.getBase());
		}
	}
}
