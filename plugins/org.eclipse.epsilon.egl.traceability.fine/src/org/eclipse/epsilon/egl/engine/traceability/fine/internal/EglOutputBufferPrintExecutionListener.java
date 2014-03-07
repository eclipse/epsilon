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

import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccess;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccessRecorder;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EglOutputBufferPrintExecutionListener implements IExecutionListener {

	private final IPropertyAccessRecorder recorder;
	private final WeakHashMap<AST, EglOutputBufferPrintExecutionListener.TraceData> cache = new WeakHashMap<AST, EglOutputBufferPrintExecutionListener.TraceData>();
	private final Foo foo;

	public EglOutputBufferPrintExecutionListener(IPropertyAccessRecorder recorder, Foo foo) {
		this.recorder = recorder;
		this.foo = foo;
	}

	@Override
	public void finishedExecuting(AST ast, Object result, IEolContext context) {
		if (result instanceof OutputBuffer && isCallToPrintMethod(ast.getParent())) {
			OutputBuffer buffer = (OutputBuffer)result;
			cache.put(ast.getParent(), new TraceData(buffer, buffer.getOffset()));
			recorder.startRecording();
		}
		
		if (cache.containsKey(ast)) {
			System.out.println(ast.toStringTree());
			
			int offset = cache.get(ast).offset;
			int length = cache.get(ast).buffer.getOffset() - offset;

			Region region = new Region(offset, length);
			
			recorder.stopRecording();
			
			for (IPropertyAccess access : recorder.getPropertyAccesses().all()) {
				final PropertyAccessWithPosition accessWithPosition = new PropertyAccessWithPosition(access, region);
									
				foo.currentLinks.put(foo.templates.peek(), accessWithPosition);
			}
		}
	}

	protected boolean isCallToPrintMethod(AST p) {
		final List<String> printMethods = Arrays.asList("printdyn", "println", "print", "prinx");
		return p.getType() == EolParser.POINT && printMethods.contains(p.getSecondChild().getText());
	}

	@Override
	public void aboutToExecute(AST ast, IEolContext context) {}
	
	private static class TraceData {
		public final OutputBuffer buffer;
		public final int offset;
		
		public TraceData(OutputBuffer buffer, int offset) {
			this.buffer = buffer;
			this.offset = offset;
		}
	}
}