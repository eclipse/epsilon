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
package org.eclipse.epsilon.flock.engine.test.acceptance.rules;

import static org.junit.Assert.assertFalse;

import org.eclipse.epsilon.flock.FlockModule;
import org.junit.Test;


public class RuleWithInvalidSyntax {

	@Test
	public void ruleWithToPart() throws Exception {
		assertFalse(parse("rule Person to Employee { name := nom }"));
	}
	
	@Test
	public void ruleWithoutBody() throws Exception {
		assertFalse(parse("rule Person"));
	}
	@Test
	
	public void ruleWithEmptyBody() throws Exception {
		assertFalse(parse("rule Person {}"));
	}

	private boolean parse(String strategy) throws Exception {
		return new FlockModule().parse(strategy);
	}
}
