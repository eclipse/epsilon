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
package org.eclipse.epsilon.egl.output;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglContextWithFineGrainedTraceability;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.Printer;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.RegionBuilder;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;

public class OutputBufferOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof OutputBuffer;
	}

	public void print(AST featureCallAst) throws EolRuntimeException {
		final Object evaluatedParameter = getContext().getTraceabilityContext().recordPropertyAccessesWhileExecuting(featureCallAst.getFirstChild().getFirstChild());
		final Region destination = getPrinter().print(evaluatedParameter, new RegionBuilder());
	
		getContext().getTraceabilityContext().traceLatestPropertyAccesses(destination);
	}
	
	public void printdyn(AST featureCallAst) throws EolRuntimeException {
		final Object evaluatedParameter = getContext().getTraceabilityContext().recordPropertyAccessesWhileExecuting(featureCallAst.getFirstChild().getFirstChild());
		final Region destination = getPrinter().printdyn(evaluatedParameter, new RegionBuilder());
		
		getContext().getTraceabilityContext().traceLatestPropertyAccesses(destination);
	}
	
	public void println(AST featureCallAst) throws EolRuntimeException {
		final Object evaluatedParameter = getContext().getTraceabilityContext().recordPropertyAccessesWhileExecuting(featureCallAst.getFirstChild().getFirstChild());
		final Region destination = getPrinter().println(evaluatedParameter, new RegionBuilder());
		
		getContext().getTraceabilityContext().traceLatestPropertyAccesses(destination);
	}
	
	private Printer getPrinter() {
		return new OutputBufferPrinterAdaptor((OutputBuffer)target);
	}
	
	private IEglContextWithFineGrainedTraceability getContext() {
		return (IEglContextWithFineGrainedTraceability)context;
	}
}
