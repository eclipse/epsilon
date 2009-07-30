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
import static org.junit.Assert.fail;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesPackage;
import org.eclipse.epsilon.migration.emc.wrappers.CopyingException;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.Equivalence;
import org.eclipse.epsilon.migration.execution.Equivalences;
import org.eclipse.epsilon.migration.model.NoOpMigrationRule;
import org.junit.Test;

public abstract class AbstractCopyTest {
	
	protected static IModel targetModel;
	protected static EPackage targetMetamodel;
	protected static Equivalences equivalences = new Equivalences();
	protected static Object copy;
	
	protected static Object addEquivalence(EPackage targetMetamodel, Object original, EClass targetType) {
		final Object target = targetMetamodel.getEFactoryInstance().create(targetType);
		
		equivalences.add(new Equivalence(original, target, new NoOpMigrationRule(targetType.getName())));
		
		return target;
	}
	
	protected static void copyTest(EPackage targetMetamodel, String targetType, EObject original) throws CopyingException, EolRuntimeException {
		AbstractCopyTest.targetMetamodel = targetMetamodel;
		targetModel = new InMemoryEmfModel("target", EmfUtil.createResource(), targetMetamodel);
		
		copy = targetModel.createInstance(targetType);
		
		final AbstractEmfModel originalModel = new InMemoryEmfModel("original", EmfUtil.createResource(original), FamiliesPackage.eINSTANCE);
		
		new Copier(originalModel, targetModel, equivalences).copy(new ModelElement(originalModel, original), new ModelElement(targetModel, copy));
		equivalences.clear();
	}
	
	protected static void checkCopy(String type, Slot... slots) {
		assertTrue(targetModel.owns(copy));
		assertEquals(type, targetModel.getTypeNameOf(copy));
		
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
		
		private void checkObjectHasSlot(Object actual) {
			try {
				final ModelElement actualElement = new ModelElement(targetModel, actual);
				final Object actualValue = EolTypeWrapper.getInstance().unwrap(actualElement.getProperty(feature));
				
				assertEquals("Unexpected value for feature '" + feature + "'", value, actualValue);
			
			} catch (EolRuntimeException e) {
				e.printStackTrace();
				fail("Exception during check");
			}
		}
	}
	
	
	@Test
	public void targetContainsCopy() {
		assertTrue(targetModel.allContents().contains(copy));
	}

	@Test
	public void targetContainsOneObject() {
		assertEquals(1, targetModel.allContents().size());
	}
}
