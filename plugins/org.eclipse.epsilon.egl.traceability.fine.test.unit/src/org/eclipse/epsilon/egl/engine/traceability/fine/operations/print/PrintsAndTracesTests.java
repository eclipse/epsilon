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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglTraceabilityContext;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.junit.Test;

public class PrintsAndTracesTests {
	
	private final Printer printer = mock(Printer.class);
	private final IEglTraceabilityContext context = mock(IEglTraceabilityContext.class);
	
	private final AST dummyPrintee = mock(AST.class);
	private final Region dummyRegion = mock(Region.class);
	
	
	@Test
	public void shouldUpdateTheTrace() throws Exception {
		when(context.recordPropertyAccessesWhileEvaluating(dummyPrintee)).thenReturn("dummyEvaluation");
		when(printer.print("dummyEvaluation")).thenReturn(dummyRegion);
		
		new PrintsAndTraces(printer, context).forAst(dummyPrintee);

		verify(context).recordPropertyAccessesWhileEvaluating(dummyPrintee);
		verify(printer).print("dummyEvaluation");
		verify(context).addDestinationRegionForLatestPropertyAccesses(dummyRegion);
	}
}