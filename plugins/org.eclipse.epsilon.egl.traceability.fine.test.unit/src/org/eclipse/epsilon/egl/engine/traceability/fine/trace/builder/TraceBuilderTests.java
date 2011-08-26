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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.pojo.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.pojo.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.pojo.TraceElement;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.ModelLocationBuilder;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.RegionBuilder;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.TraceBuilder;
import org.junit.Test;


public class TraceBuilderTests {

	private final TraceBuilder builder = new TraceBuilder();
	
	private final EObject someModelElement = mock(EObject.class);
	private final EObject anotherElement   = mock(EObject.class);

	private final ModelLocation nameOfAnElement      = new ModelLocationBuilder().buildModelLocation(someModelElement, "name");
	private final ModelLocation nameOfAnotherElement = new ModelLocationBuilder().buildModelLocation(anotherElement,   "name");
	
	private final Region partOfFirstTwoLines = new RegionBuilder()
	                                                 .aRegion()
	                                                 .startingAt(1, 10)
	                                                 .endingAt(2, 50)
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
	
	@Test
	public void withResourceAddsToEveryTextLocation() throws Exception {
		builder.withTraceElements(Arrays.asList(nameOfAnElement, nameOfAnotherElement), partOfFirstTwoLines);
		builder.withResource("aFileOnDisk.txt");
	
		assertCollectionEquals(Arrays.asList("aFileOnDisk.txt"), builder.build().elements.get(0).destination.resources);	
		assertCollectionEquals(Arrays.asList("aFileOnDisk.txt"), builder.build().elements.get(1).destination.resources);	
	}
	
	@Test
	public void withResourceAppendsToExistingResources() throws Exception {
		builder.withTraceElements(Arrays.asList(nameOfAnElement, nameOfAnotherElement), partOfFirstTwoLines);
		builder.withResource("aFileOnDisk.txt");
		builder.withResource("anotherFileOnDisk.txt");
	
		assertCollectionEquals(Arrays.asList("aFileOnDisk.txt", "anotherFileOnDisk.txt"), builder.build().elements.get(0).destination.resources);	
		assertCollectionEquals(Arrays.asList("aFileOnDisk.txt", "anotherFileOnDisk.txt"), builder.build().elements.get(1).destination.resources);	
	}
	
	private static void assertTraceElementEquals(ModelLocation expectedFeatureAccess, Region expectedRegion, TraceElement actual) {
		assertEquals(expectedFeatureAccess, actual.source);
		assertEquals(expectedRegion,        actual.destination.region);
	}
	
	
	private static <T> void assertCollectionEquals(Collection<? extends T> expected, Collection<? extends T> actual) {
		assertEquals(expected.size(), actual.size());
		
		final Iterator<? extends T> expectedIterator = expected.iterator();
		final Iterator<? extends T> actualIterator   = actual.iterator();
				
		while (expectedIterator.hasNext()) {
			final T expectedElement = expectedIterator.next();
			final T actualElement   = actualIterator.next();
			
			assertEquals(expectedElement, actualElement);
		}
	}
}
