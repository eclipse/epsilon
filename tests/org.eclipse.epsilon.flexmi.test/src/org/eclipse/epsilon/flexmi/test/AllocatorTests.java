/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

import org.eclipse.epsilon.flexmi.AttributeStructuralFeatureAllocator;
import org.junit.Test;

public class AllocatorTests {
	
	@Test
	public void testMoreValues() {
		assertAllocation(Arrays.asList("a", "b", "c"), Arrays.asList("a", "b"), 2, Arrays.asList("a", "a"), Arrays.asList("b", "b"));
	}
	
	@Test
	public void testMoreSlots() {
		assertAllocation(Arrays.asList("a", "b"), Arrays.asList("a", "b", "c"), 2, Arrays.asList("a", "a"), Arrays.asList("b", "b"));
	}
	
	@Test
	public void testNoSlots() {
		assertAllocation(Arrays.asList("a", "b"), Arrays.asList(), 0);
	}

	@Test
	public void testNoValues() {
		assertAllocation(Arrays.asList(), Arrays.asList("a", "b"), 0);
	}	
	
	protected void assertAllocation(List<String> values, List<String> slots, int expectedAllocationCount, List<String>... expextedAllocations) {
		AttributeStructuralFeatureAllocator allocator = new AttributeStructuralFeatureAllocator();
		Map<String, String> allocation = allocator.allocate(values, slots);
		assertEquals(expectedAllocationCount, allocation.size());
		for (List<String> expected : expextedAllocations) {
			assertEquals(expected.get(1), allocation.get(expected.get(0)));
		}
	}
	
}
