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
package org.eclipse.epsilon.migration.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.junit.Test;

public abstract class AbstractCopyTest {
	
	protected static AbstractEmfModel targetModel;
	protected static EPackage targetMetamodel;
	protected static List<Equivalence> equivalences;
	protected static EObject copy;
	
	private static Copier createCopier(EPackage targetMetamodel) {
		AbstractCopyTest.targetMetamodel = targetMetamodel;
		targetModel = new InMemoryEmfModel("target", EmfUtil.createResource(), targetMetamodel);
		return new Copier(targetModel);
	}
	
	protected static void copyTest(EPackage targetMetamodel, EObject original) throws CopyingException {
		equivalences = createCopier(targetMetamodel).deepCopy(original);
		copy         = equivalences.get(0).getCopy();
	}
	
	protected static void checkObject(EObject original, EObject copy, String type, Slot... slots) {
		final Equivalence equivalence = new Equivalence(original, copy);
		assertTrue("equivalences did not contain: " + equivalence, equivalences.contains(equivalence));
		
		assertEquals(targetMetamodel, copy.eClass().getEPackage());
		assertEquals(type, copy.eClass().getName());
		
		for (Slot slot : slots) {
			slot.checkObjectHasSlot(copy);
		}
	}
	
	protected static class Slot {
		private String feature;
		private Object value;

		protected Slot(String feature, Object value) {
			this.feature = feature;
			this.value   = value;
		}
		
		private void checkObjectHasSlot(EObject actual) {
			assertEquals("Unexpected value for feature '" + feature + "'", value, actual.eGet(actual.eClass().getEStructuralFeature(feature)));
		}
	}
	
	
	@Test
	public void targetContainsCopy() {
		assertTrue(targetModel.allContents().contains(copy));
	}

	@Test
	public void targetContainsOneObject() {
		assertEquals(1, targetModel.getModelImpl().getContents().size());
	}
}
