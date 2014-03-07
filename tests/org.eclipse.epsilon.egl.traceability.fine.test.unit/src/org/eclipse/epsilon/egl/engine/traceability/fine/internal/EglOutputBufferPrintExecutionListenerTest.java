/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.internal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccessRecorder;
import org.eclipse.epsilon.eol.execute.introspection.recording.PropertyAccesses;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({EglOutputBufferPrintExecutionListenerTest.StartsRecordingWhenOutputBufferIsAboutToBePrintedTo.class,
               EglOutputBufferPrintExecutionListenerTest.StopsRecordingWhenPrintCallHasBeenExecuted.class})
public class EglOutputBufferPrintExecutionListenerTest {

	public static class StartsRecordingWhenOutputBufferIsAboutToBePrintedTo {
		
		@Test
		public void startsToRecordWhenFinishedExecutingLeftHandSideOfCallToPrintMethodOnOutputBuffer() throws Exception {
			for (String printMethodName : Arrays.asList("print", "prinx", "printdyn", "println")) {
				final IPropertyAccessRecorder recorder = startRecordingTest("out." + printMethodName + "();", new OutputBuffer());
				verify(recorder).startRecording();
			}
		}
		
		@Test
		public void doesNotStartToRecordWhenMethodIsNotPrint() throws Exception {
			final IPropertyAccessRecorder recorder = startRecordingTest("out.chop();", new OutputBuffer());
			
			verify(recorder, never()).startRecording();
		}
		
		@Test
		public void doesNotStartToRecordWhenLeftHandSideIsNotAnOutputBuffer() throws Exception {
			final IPropertyAccessRecorder recorder = startRecordingTest("out.print();", "DummyBuffer");
			
			verify(recorder, never()).startRecording();
		}
		
		private IPropertyAccessRecorder startRecordingTest(String code, Object buffer) throws Exception {
			final IPropertyAccessRecorder recorder = mock(IPropertyAccessRecorder.class);
			final EglOutputBufferPrintExecutionListener listener = new EglOutputBufferPrintExecutionListener(recorder, null);
			final AST ast = parse(code);
			listener.finishedExecuting(ast.getFirstChild(), buffer, null);
			return recorder;
		}
	}
	
	public static class StopsRecordingWhenPrintCallHasBeenExecuted {
		
		@Test
		public void stopsRecordingWhenPrintCallHasBeenExecuted() throws Exception {
			final IPropertyAccessRecorder recorder = mock(IPropertyAccessRecorder.class);
			when(recorder.getPropertyAccesses()).thenReturn(new PropertyAccesses());
			
			final EglOutputBufferPrintExecutionListener listener = new EglOutputBufferPrintExecutionListener(recorder, null);
			final AST ast = parse("out.print();");
			// First prime the cache
			listener.finishedExecuting(ast.getFirstChild(), new OutputBuffer(), null);
			// Now simulate finished execution of point operator
			listener.finishedExecuting(ast, null, null);
			verify(recorder).stopRecording();
		}
		
//		@Test
//		public void doesNotStartToRecordWhenMethodIsNotPrint() throws Exception {
//			final IPropertyAccessRecorder recorder = startRecordingTest("out.chop();", new OutputBuffer());
//			
//			verify(recorder, never()).startRecording();
//		}
//		
//		@Test
//		public void doesNotStartToRecordWhenLeftHandSideIsNotAnOutputBuffer() throws Exception {
//			final IPropertyAccessRecorder recorder = startRecordingTest("out.print();", "DummyBuffer");
//			
//			verify(recorder, never()).startRecording();
//		}
	}

	private static AST parse(String code) throws Exception {
		final EolModule module = new EolModule();
		module.parse(code);
		return module.getAst().getFirstChild().getFirstChild();
	}

}
