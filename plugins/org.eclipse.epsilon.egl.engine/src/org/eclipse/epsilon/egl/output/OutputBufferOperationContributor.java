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

	public void print(AST featureCallAst) throws EolRuntimeException {
		print(featureCallAst, new OutputBufferPrinterAdaptor.NormalPrinter(getOutputBuffer()));
	}
	
	public void printdyn(AST featureCallAst) throws EolRuntimeException {
		print(featureCallAst, new OutputBufferPrinterAdaptor.DynamicPrinter(getOutputBuffer()));
	}
	
	public void println(AST featureCallAst) throws EolRuntimeException {
		print(featureCallAst, new OutputBufferPrinterAdaptor.LinePrinter(getOutputBuffer()));
	}

	private void print(AST featureCallAst, Printer printer) throws EolRuntimeException {
		new PrintsAndTraces(printer, getTraceabilityContext()).execute(featureCallAst.getFirstChild().getFirstChild());
	}
	
	private OutputBuffer getOutputBuffer() {
		return (OutputBuffer)target;
	}
	
	private IEglTraceabilityContext getTraceabilityContext() {
		return ((IEglContextWithFineGrainedTraceability)context).getTraceabilityContext();
	}
}
