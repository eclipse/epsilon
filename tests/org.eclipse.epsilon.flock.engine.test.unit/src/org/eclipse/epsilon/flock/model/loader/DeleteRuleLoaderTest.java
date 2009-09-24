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
package org.eclipse.epsilon.flock.model.loader;

import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createDeleteRuleAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createGuard;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.model.DeleteRule;
import org.junit.Test;

public class DeleteRuleLoaderTest {
	
	@Test
	public void deleteRule() {
		final AST ruleAst = createDeleteRuleAst("Person");
		
		assertEquals(new DeleteRule("Person", null), runDeleteRuleLoaderOn(ruleAst));
	}
	
	@Test
	public void deleteRuleWithGuard() {
		final AST guard   = createGuard();
		final AST ruleAst = createDeleteRuleAst("Person", guard);
		
		assertEquals(new DeleteRule("Person", guard.getFirstChild()), runDeleteRuleLoaderOn(ruleAst));
	}
	
	private static DeleteRule runDeleteRuleLoaderOn(AST rule) {
		return new DeleteRuleLoader(rule).run();
	}
}
