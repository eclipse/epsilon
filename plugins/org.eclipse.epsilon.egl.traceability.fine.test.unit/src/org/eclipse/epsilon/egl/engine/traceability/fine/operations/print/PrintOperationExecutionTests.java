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

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglTraceabilityContext;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.Arguments;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.PrintOperationExecution;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.Printer;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.RegionBuilder;
import org.junit.Test;




public class PrintOperationExecutionTests {
	
	private final Printer printer = mock(Printer.class);
	private final Arguments arguments = mock(Arguments.class);
	private final IEglTraceabilityContext context = mock(IEglTraceabilityContext.class);
	
	private final Region dummyRegion = mock(Region.class);
	
	private final PrintOperationExecution printOperationExecution = new PrintOperationExecution(printer, arguments, context);
	
	@Test
	public void shouldPrintAndUpdateTheTrace() throws Exception {
		when(arguments.evaluateFirstArgument(context)).thenReturn("dummyEvaluation");
		when(printer.print(eq("dummyEvaluation"), any(RegionBuilder.class))).thenReturn(dummyRegion);
		
		printOperationExecution.execute();
		
		verify(printer).print(eq("dummyEvaluation"), any(RegionBuilder.class));
		verify(context).traceLatestPropertyAccesses(dummyRegion);
	}
}