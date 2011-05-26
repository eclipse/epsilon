/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.parse.problem;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.preprocessor.PreprocessorTrace;

public class EglParseProblem extends ParseProblem {
	
	protected final ParseProblem problem;
	protected final PreprocessorTrace trace;
	
	public EglParseProblem(ParseProblem anomaly, PreprocessorTrace trace) {
		this.setLine(anomaly.getLine());
		this.setReason(anomaly.getReason());
		this.problem = anomaly;
		this.trace = trace;
		setColumn(trace.getEglColumnNumberFor(anomaly.getLine(), anomaly.getColumn()));
	}
	
	@Override
	public int getLine() {
		return trace.getEglLineNumberFor(problem.getLine());
	}
}
