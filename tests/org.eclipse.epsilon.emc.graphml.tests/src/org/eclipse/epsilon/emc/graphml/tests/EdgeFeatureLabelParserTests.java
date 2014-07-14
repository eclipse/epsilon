/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitris Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.graphml.tests;

import static org.junit.Assert.*;

import org.eclipse.epsilon.emc.graphml.LinkFeatureLabelParser;
import org.eclipse.epsilon.emc.muddle.Feature;
import org.junit.Test;

public class EdgeFeatureLabelParserTests {
	
	@Test
	public void testSimpleName() {
		Feature prototype = parse("field");
		assertEquals("field", prototype.getName());
		assertEquals(false, prototype.isMany());
	}
	
	@Test
	public void testNameAndMultiplicity() {
		Feature prototype = parse("fields *");
		assertEquals("fields", prototype.getName());
		assertEquals(true, prototype.isMany());
	}
	
	public Feature parse(String label) {
		return new LinkFeatureLabelParser(label).getFeature();
	}
	
}
