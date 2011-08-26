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


import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglTraceabilityContext;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.RegionBuilder;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;




abstract class PrintOperationExecution {
	
	protected final Printer printer;
	private final Arguments arguments;
	private final IEglTraceabilityContext context;
	
	public PrintOperationExecution(Printer printer, Arguments arguments, IEglTraceabilityContext context) {
		this.printer = printer;
		this.arguments = arguments;
		this.context = context;
	}
	
	public void execute() throws EolRuntimeException {	
		final Object printee = arguments.evaluateFirstArgument(context);
		final Region destinationOfPrintee = print(printee, new RegionBuilder());
		
		context.traceLatestPropertyAccesses(destinationOfPrintee);
	}

	protected abstract Region print(Object printee, RegionBuilder builder);
	
	
	static class BasicPrintOperationExecution extends PrintOperationExecution {		
		public BasicPrintOperationExecution(Printer printer, Arguments arguments, IEglTraceabilityContext context) {
			super(printer, arguments, context);
		}

		@Override
		protected Region print(Object printee, RegionBuilder builder) {
			return printer.print(printee, builder);
		}
	}
	
	static class DynamicPrintOperationExecution extends PrintOperationExecution {
		public DynamicPrintOperationExecution(Printer printer, Arguments arguments, IEglTraceabilityContext context) {
			super(printer, arguments, context);
		}

		@Override
		protected Region print(Object printee, RegionBuilder builder) {
			return printer.printdyn(printee, builder);
		}
	}
}