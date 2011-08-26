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
package org.eclipse.epsilon.egl.engine.traceability.fine.wrappers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglContextWithFineGrainedTraceability;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglTraceabilityContext;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.junit.Test;


public class TraceablePropertyGetterTests {

	@Test
	public void shouldReportPropertyAccessToContextAndDelegate() throws Exception {	
		final IEglContextWithFineGrainedTraceability parent = mock(IEglContextWithFineGrainedTraceability.class);
		final IEglTraceabilityContext context = mock(IEglTraceabilityContext.class);
		final IPropertyGetter delegate = mock(IPropertyGetter.class);
		final TraceablePropertyGetter traceablePropertyGetter = new TraceablePropertyGetter(delegate);
		final EObject dummyModelElement = mock(EObject.class);
		
		when(delegate.getContext()).thenReturn(parent);
		when(parent.getTraceabilityContext()).thenReturn(context);
		
		traceablePropertyGetter.invoke(dummyModelElement, "dummyFeature");
		
		verify(delegate).invoke(dummyModelElement, "dummyFeature");
		verify(context).recordPropertyAccess(dummyModelElement, "dummyFeature");
	}	
}