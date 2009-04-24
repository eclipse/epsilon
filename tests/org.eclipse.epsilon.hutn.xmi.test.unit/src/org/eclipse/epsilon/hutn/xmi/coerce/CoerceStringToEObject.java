/*******************************************************************************
 * Copyright (c) 2009 The University of York.
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
package org.eclipse.epsilon.hutn.xmi.coerce;

import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.epsilon.hutn.test.model.families.Family;
import org.eclipse.epsilon.hutn.test.model.families.impl.FamilyImpl;
import org.junit.Test;

public class CoerceStringToEObject extends AbstractCoercionTest {

	private static final MockResource resource = new MockResource();
	
	protected static void coercionTest(Object expected, Object value) {
		coercionTest(expected, value, resource);
	}
	
	@Test
	public void singleId() {
		coercionTest(resource.getEObjects(0, 1), "_4yG-UBiFEd6-Eob-hyWntQ");
	}
	
	@Test
	public void manyIds() {
		coercionTest(resource.getEObjects(), "_4yG-UBiFEd6-Eob-hyWntQ _HiVRYBiGEd6-Eob-hyWntQ");
	}
	
	@Test
	public void unknownId() {
		coercionTest("_HiVRYBiGEd6-Eob-unknow", "_HiVRYBiGEd6-Eob-unknow");
	}
	
	@Test
	public void stringContainingAnId() {
		coercionTest("its id was _4yG-UBiFEd6-Eob-hyWntQ or something", "its id was _4yG-UBiFEd6-Eob-hyWntQ or something");
	}
	
	
	private static class MockResource extends XMLResourceImpl {
		
		private final SortedMap<String, EObject> map = new TreeMap<String, EObject>();
		
		public MockResource() {
			map.put("_4yG-UBiFEd6-Eob-hyWntQ", createFamily("The Smiths"));
			map.put("_HiVRYBiGEd6-Eob-hyWntQ", createFamily("The Does"));
		}
		
		@Override
		public EObject getEObject(String uriFragment) {
			return map.get(uriFragment);
		}

		public EList<EObject> getEObjects() {
			return new BasicEList<EObject>(map.values());
		}
		
		public EList<EObject> getEObjects(int start, int end) {
			return new BasicEList<EObject>(new LinkedList<EObject>(map.values()).subList(start, end));
		}
		
		private static Family createFamily(String name) {
			return new MockFamily(name);
		}
		
		private static class MockFamily extends FamilyImpl {
			
			public MockFamily(String name) {
				setName(name);
			}
			
			@Override
			public boolean equals(Object o) {
				if (!(o instanceof MockFamily)) {
					return super.equals(o);
				}
				
				return ((MockFamily)o).getName().equals(getName());
			}
		}
	}
}
