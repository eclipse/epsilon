/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.internal;

import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.internal.EglPreprocessorContext;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccess;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccessRecorder;

@SuppressWarnings("restriction")
public class EglOutputBufferPrintExecutionListener implements IExecutionListener {

	private final IPropertyAccessRecorder recorder;
	private final WeakHashMap<ModuleElement, EglOutputBufferPrintExecutionListener.TraceData> cache = new WeakHashMap<>();
	private final TracedPropertyAccessLedger ledger;

	public EglOutputBufferPrintExecutionListener(IPropertyAccessRecorder recorder, TracedPropertyAccessLedger ledger) {
		this.recorder = recorder;
		this.ledger = ledger;
	}

	@Override
	public void finishedExecuting(ModuleElement ast, Object result, IEolContext context) {
		if (result instanceof OutputBuffer && isCallToPrintMethod(ast.getParent())) {
			OutputBuffer buffer = (OutputBuffer)result;
			cache.put(ast.getParent(), new TraceData(buffer, buffer.getOffset()));
			recorder.startRecording();
		}
		
		if (cache.containsKey(ast)) {
			recorder.stopRecording();
			associatePropertyAccessesWithRegionInGeneratedText(ast, ((EglPreprocessorContext)context).getEglContext());
		}
	}
	
	@Override
	public void finishedExecutingWithException(ModuleElement ast, EolRuntimeException exception, IEolContext context) {}
	
	protected boolean isCallToPrintMethod(ModuleElement p) {
		final List<String> printMethods = Arrays.asList("printdyn", "println", "print", "prinx");
		return p instanceof OperationCallExpression && printMethods.contains(((OperationCallExpression) p).getOperationName());
	}
	
	private void associatePropertyAccessesWithRegionInGeneratedText(ModuleElement ast, IEglContext context) {
		final Region region = regionFor(ast);
		
		for (IPropertyAccess access : recorder.getPropertyAccesses().all()) {
			ledger.associate(access, region, context.getCurrentTemplate());
		}
	}

	private Region regionFor(ModuleElement ast) {
		int offset = cache.get(ast).offset;
		int length = cache.get(ast).buffer.getOffset() - offset;

		Region region = new Region(offset, length);
		return region;
	}

	@Override
	public void aboutToExecute(ModuleElement ast, IEolContext context) {}
	
	private static class TraceData {
		public final OutputBuffer buffer;
		public final int offset;
		
		public TraceData(OutputBuffer buffer, int offset) {
			this.buffer = buffer;
			this.offset = offset;
		}
	}
}
