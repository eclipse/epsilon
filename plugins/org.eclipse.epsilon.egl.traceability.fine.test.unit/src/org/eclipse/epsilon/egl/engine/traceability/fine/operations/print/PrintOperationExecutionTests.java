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
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.PrintOperationExecution.BasicPrintOperationExecution;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.PrintOperationExecution.DynamicPrintOperationExecution;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.RegionBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PrintOperationExecutionTests.BasicPrintOperationExecutionTests.class,
               PrintOperationExecutionTests.DynamicPrintOperationExecutionTests.class})
public class PrintOperationExecutionTests {
	
	public static class BasicPrintOperationExecutionTests extends AbstractPrintOperationExecutionTests {
		@Test public void shouldPrintTheEvaluatedArgument() throws Exception {
			verify(printer).print(eq("dummyEvaluation"), any(RegionBuilder.class));
		}

		@Override
		protected PrintOperationExecution createExecution(Printer printer, Arguments arguments, IEglTraceabilityContext context) {
			return new BasicPrintOperationExecution(printer, arguments, context);
		}
	}
	
	public static class DynamicPrintOperationExecutionTests extends AbstractPrintOperationExecutionTests {
		@Test public void shouldDynamicallyPrintTheEvaluatedArgument() throws Exception {
			verify(printer).printdyn(eq("dummyEvaluation"), any(RegionBuilder.class));
		}

		@Override
		protected PrintOperationExecution createExecution(Printer printer, Arguments arguments, IEglTraceabilityContext context) {
			return new DynamicPrintOperationExecution(printer, arguments, context);
		}
	}
	
	public static abstract class AbstractPrintOperationExecutionTests {
	
		protected final Printer printer = mock(Printer.class);
		private final Arguments arguments = mock(Arguments.class);
		private final IEglTraceabilityContext context = mock(IEglTraceabilityContext.class);
		
		private final Region dummyRegion = mock(Region.class);
		
		private final PrintOperationExecution printOperationExecution = createExecution(printer, arguments, context);

		protected abstract PrintOperationExecution createExecution(Printer printer, Arguments arguments, IEglTraceabilityContext context);
		
		@Before
		public void invokeExecuteMethod() throws Exception {
			when(arguments.evaluateFirstArgument(context)).thenReturn("dummyEvaluation");
			when(printer.print(eq("dummyEvaluation"), any(RegionBuilder.class))).thenReturn(dummyRegion);
			when(printer.printdyn(eq("dummyEvaluation"), any(RegionBuilder.class))).thenReturn(dummyRegion);
			
			printOperationExecution.execute();
		}
		
		@Test
		public void shouldUpdateTheTrace() throws Exception {
			verify(context).traceLatestPropertyAccesses(dummyRegion);
		}
	}
}