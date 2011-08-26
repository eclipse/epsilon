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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.TraceBuilder;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class EglTraceabilityContext implements IEglTraceabilityContext {

	private final TraceBuilder traceBuilder = new TraceBuilder();
	private final FeatureAccessRecorder recorder;
	private final IEolContext parent;
	
	public EglTraceabilityContext(IEolContext parent) {
		this(parent, new FeatureAccessRecorder());
	}
	
	public EglTraceabilityContext(IEolContext parent, FeatureAccessRecorder recorder) {
		this.parent   = parent;
		this.recorder = recorder;
	}

	@Override
	public Trace getFineGrainedTrace() {
		return traceBuilder.build();
	}
	
	@Override
	public Object recordPropertyAccessesWhileExecuting(AST ast) throws EolRuntimeException {
		recorder.startRecording();
		final Object result = parent.getExecutorFactory().executeAST(ast, parent);
		recorder.stopRecording();
		
		return result;
	}
	
	@Override
	public void recordPropertyAccess(Object modelElement, String featureName) {
		recorder.record(modelElement, featureName);
	}

	@Override
	public void addDestinationRegionForLatestPropertyAccesses(Region destination) {
		traceBuilder.withTraceElements(recorder.getFeatureAccesses(), destination);
	}
	
	@Override
	public void addDestinationResourceForUnclaimedPropertyAccesses(String resource) {
		traceBuilder.withResource(resource);
	}
}
