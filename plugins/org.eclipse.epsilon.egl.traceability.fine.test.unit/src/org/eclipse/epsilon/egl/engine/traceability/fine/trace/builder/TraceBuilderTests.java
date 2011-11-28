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
package org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceLink;
import org.junit.Test;


public class TraceBuilderTests {

	private final TraceBuilder builder = new TraceBuilder();
	
	private final EObject someModelElement = mock(EObject.class);
	private final EObject anotherElement   = mock(EObject.class);

	private final ModelLocation nameOfAnElement      = new ModelLocationBuilder().buildModelLocation(someModelElement, "name");
	private final ModelLocation nameOfAnotherElement = new ModelLocationBuilder().buildModelLocation(anotherElement,   "name");
	
	private final Region partOfFirstTwoLines = new RegionBuilder()
	                                                 .aRegion()
	                                                 .startingAt(10)
	                                                 .endingAt(50)
	                                                 .build();
	
	@Test
	public void createsTraceElementForSingleFeatureAccess() throws Exception {
		builder.withTraceElements(Collections.singleton(nameOfAnElement), partOfFirstTwoLines);
		
		assertEquals(1, builder.build().elements.size());
		assertTraceElementEquals(nameOfAnElement, partOfFirstTwoLines, builder.build().elements.get(0));
	}
	
	@Test
	public void createsTraceElementsWithSameTextLocationForAllFeatureAccesses() throws Exception { 
		builder.withTraceElements(Arrays.asList(nameOfAnElement, nameOfAnotherElement), partOfFirstTwoLines);
		
		assertEquals(2, builder.build().elements.size());
		assertTraceElementEquals(nameOfAnElement,      partOfFirstTwoLines, builder.build().elements.get(0));
		assertTraceElementEquals(nameOfAnotherElement, partOfFirstTwoLines, builder.build().elements.get(1));
	}
	
	@Test
	public void createsNoTraceElementsAndNoLocationsWhenThereAreNoFeatureAccesses() throws Exception { 
		builder.withTraceElements(new LinkedList<ModelLocation>(), partOfFirstTwoLines);
		
		assertEquals(0, builder.build().elements.size());
		assertEquals(0, builder.build().locations.size());
	}
	
	private static void assertTraceElementEquals(ModelLocation expectedFeatureAccess, Region expectedRegion, TraceLink actual) {
		assertEquals(expectedFeatureAccess, actual.source);
		assertEquals(expectedRegion,        actual.destination.region);
	}
}
