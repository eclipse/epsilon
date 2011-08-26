/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.engine.traceability.fine.operations.print;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglContextWithFineGrainedTraceability;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglTraceabilityContext;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.PrintOperationExecution.BasicPrintOperationExecution;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.PrintOperationExecution.DynamicPrintOperationExecution;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;

public class PrintOperation extends AbstractOperation {
	
	@Override
	public Object execute(Object source, AST operationAst, IEolContext context) throws EolRuntimeException {
		execute(operationAst, (IEglContextWithFineGrainedTraceability)context);
		return null;
	}

	private void execute(AST operationAst, IEglContextWithFineGrainedTraceability context) throws EolRuntimeException {
		final Arguments arguments = new Arguments(operationAst.getFirstChild());
		final IEglTraceabilityContext traceabilityContext = context.getTraceabilityContext();
		
		execute(operationAst.getText(), context, arguments, traceabilityContext);
	}

	private void execute(String operationName, IEglContextWithFineGrainedTraceability context, Arguments arguments, IEglTraceabilityContext traceabilityContext) throws EolRuntimeException {
		if (operationName.equals("printop")) {
			new BasicPrintOperationExecution(context.getPrinter(), arguments, traceabilityContext).execute();
		
		} else if (operationName.equals("printopdyn")) {
			new DynamicPrintOperationExecution(context.getPrinter(), arguments, traceabilityContext).execute();
		
		} else {
			throw new IllegalStateException("PrintOperation cannot be executed for an operation named '" + operationName + "'");
		}
	}
	
	
	@Override
	public boolean isOverridable() {
		// PointExecutor will evaluate the arguments to an operation
		// if it is overridable. Non-overridable operations are free
		// to evaluate their own arguments.
		
		return false;
	}
}