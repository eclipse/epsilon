/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.context;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.TraceBuilder;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccessRecorder;


public class EglTraceabilityContext implements IEglTraceabilityContext {

	private final TraceBuilder traceBuilder = new TraceBuilder();
	private final EglPropertyAccessRecorder recorder;
	private final IEolContext parent;
	
	public EglTraceabilityContext(IEolContext parent) {
		this(parent, new EglPropertyAccessRecorder());
	}
	
	public EglTraceabilityContext(IEolContext parent, EglPropertyAccessRecorder recorder) {
		this.parent   = parent;
		this.recorder = recorder;
	}
	
	@Override
	public IPropertyAccessRecorder getPropertyAccessRecorder() {
		return recorder;
	}

	@Override
	public Trace getFineGrainedTrace() {
		return traceBuilder.build();
	}
	
	@Override
	public Object recordPropertyAccessesWhileEvaluating(AST ast) throws EolRuntimeException {
		recorder.startRecording();
		final Object result = parent.getExecutorFactory().executeAST(ast, parent);
		recorder.stopRecording();
		
		return result;
	}

	@Override
	public void addDestinationRegionForLatestPropertyAccesses(Region destination) {
		traceBuilder.fromPropertyAccesses(recorder.getPropertyAccesses(), destination);
	}

	@Override
	public void setCustomDataForFutureTraceLinks(Map<?, ?> customData) {
		recorder.setCustomData(stringifyEntries(customData));
	}
	
	private static Map<String, String> stringifyEntries(Map<?, ?> customData) {
		final Map<String, String> stringifiedCustomData = new HashMap<String, String>();
		
		for (Map.Entry<?, ?> customDataItem : customData.entrySet()) {
			stringifiedCustomData.put(customDataItem.getKey().toString(), customDataItem.getValue().toString());
		}
		
		return stringifiedCustomData;
	}
}
