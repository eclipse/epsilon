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
package org.eclipse.epsilon.flock.model;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.model.MigrationRule;
import org.junit.Test;

public class MigrationRuleIsOfOriginalTypeTests {
	
	private static final MigrationRule rule = new MigrationRule("Dog", "Animal", new AST(), new AST());
	
	@Test
	public void isOfOriginalTypeShouldReturnTrueOnlyWhenTypeNamesMatch() {
		final ModelElement dog = createMock(ModelElement.class);
		expect(dog.getTypeName()).andReturn("Dog");
		
		replay(dog);
		
		assertTrue(rule.isOfOriginalType(dog));
	}
	
	@Test
	public void isOfOriginalTypeShouldReturnFalseWhenTypeNamesDoNotMatch() {
		final ModelElement family = createMock(ModelElement.class);
		expect(family.getTypeName()).andReturn("Family");
		
		replay(family);

		assertFalse(rule.isOfOriginalType(family));
	}
}
