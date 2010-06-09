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
package org.eclipse.epsilon.concordance.core.hashing.hashers.ecore;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.epsilon.concordance.core.hashing.hashers.ecore.Metafeatures;
import org.eclipse.epsilon.test.util.builders.emf.EAttributeBuilder;
import org.junit.Test;

public class FeaturesTests {

	@Test
	public void getsValuesSpecified() {
		final Metafeatures features = new Metafeatures("name", "lowerBound");
		
		final EAttribute age = EAttributeBuilder.anEAttribute().named("age").withBounds(1, 1).build();
		
		assertEquals(Arrays.asList((Object)"age", 1), features.getValuesToHashFrom(age));
	}
	
	@Test
	public void includesNullValues() {
		final Metafeatures features = new Metafeatures("name");
		
		final EAttribute unnamed = EAttributeBuilder.anEAttribute().build();
		
		assertEquals(Arrays.asList((Object)null), features.getValuesToHashFrom(unnamed));
	}
	
	@Test
	public void returnsNullWhenTypeDoesNotHaveFeature() {
		final Metafeatures features = new Metafeatures("multiplicity");
		
		final EAttribute attribute = EAttributeBuilder.anEAttribute().withBounds(1, 1).build();
		
		assertEquals(Arrays.asList((Object)null), features.getValuesToHashFrom(attribute));
	}
}
