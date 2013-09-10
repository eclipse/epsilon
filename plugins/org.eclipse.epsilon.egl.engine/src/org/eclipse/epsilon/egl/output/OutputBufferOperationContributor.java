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

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglContextWithFineGrainedTraceability;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglTraceabilityContext;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.Printer;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.PrintsAndTraces;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;

public class OutputBufferOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof OutputBuffer;
	}

	public void print(AST operationAst) throws EolRuntimeException {
		print(operationAst, new OutputBufferPrinterAdaptor.NormalPrinter(getOutputBuffer()));
	}
	
	public void printdyn(AST operationAst) throws EolRuntimeException {
		print(operationAst, new OutputBufferPrinterAdaptor.DynamicPrinter(getOutputBuffer()));
	}
	
	public void println(AST operationAst) throws EolRuntimeException {
		print(operationAst, new OutputBufferPrinterAdaptor.LinePrinter(getOutputBuffer()));
	}

	private void print(AST operationAst, Printer printer) throws EolRuntimeException {
		final AST parametersAst = operationAst.getFirstChild();
		final AST firstParameterAst = parametersAst.getFirstChild();
		
		new PrintsAndTraces(printer, getTraceabilityContext()).forAst(firstParameterAst);
	}
	
	private IOutputBuffer getOutputBuffer() {
		return (IOutputBuffer)target;
	}
	
	private IEglTraceabilityContext getTraceabilityContext() {
		return ((IEglContextWithFineGrainedTraceability)context).getTraceabilityContext();
	}
}
