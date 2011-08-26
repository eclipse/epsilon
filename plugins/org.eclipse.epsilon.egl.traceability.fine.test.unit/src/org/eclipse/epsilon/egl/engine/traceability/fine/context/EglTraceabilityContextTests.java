/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.engine.traceability.fine.context;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;



public class EglTraceabilityContextTests {

	private final AST argument = mock(AST.class);
	private final IEolContext parent = mock(IEolContext.class);
	private final FeatureAccessRecorder recorder = mock(FeatureAccessRecorder.class);
	private final ExecutorFactory executor = mock(ExecutorFactory.class);	
	private final IEglTraceabilityContext context = new EglTraceabilityContext(parent, recorder);
	
	@Before
	public void setup() {
		when(parent.getExecutorFactory()).thenReturn(executor);		
	}
	
	@Test
	public void shouldDelegateToContextToCapturePropertyAccessesAndToPerformEvaluation() throws Exception {	
		context.recordPropertyAccessesWhileExecuting(argument);
		
		final InOrder verifier = inOrder(recorder, executor);
		
		verifier.verify(recorder).startRecording();
		verifier.verify(executor).executeAST(argument, parent);
		verifier.verify(recorder).stopRecording();
	}
	
	@Test
	public void shouldReturnResultOfEvaluation() throws Exception {
		when(executor.executeAST(argument, parent)).thenReturn("dummyResult");
		
		final Object result = context.recordPropertyAccessesWhileExecuting(argument);
		
		assertEquals("dummyResult", result);
	}
}