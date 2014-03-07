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
package org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder;

import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;

public class TraceManager {

	private final PositionReporter positionInParentReporter;
	private Trace trace = new TraceBuilder().build();
	
	public TraceManager(PositionReporter positionInParentReporter) {
		this.positionInParentReporter = positionInParentReporter;
	}
	
	public Trace getFineGrainedTrace() {
		return trace;
	}

	public void appendToFineGrainedTrace(Trace trace) {
		this.trace = new TraceCombiner().combine(this.trace, trace, positionInParentReporter.getCurrentOffset());
	}

	public interface PositionReporter {
		public int getCurrentOffset();
	}
}
