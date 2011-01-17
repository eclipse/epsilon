/*******************************************************************************
 * Copyright (c) 2011 The University of York.
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

import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createRetypingAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createGuard;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.model.domain.typemappings.Retyping;
import org.junit.Test;

public class RetypingLoaderTest {
	
	@Test
	public void retyping() {
		final AST retypingAst = createRetypingAst("Person", "Salesperson");
		
		assertEquals(new Retyping(retypingAst, "Person", "Salesperson", null), runRetypingLoaderOn(retypingAst));
	}
	
	@Test
	public void retypingWithGuard() {
		final AST guard       = createGuard();
		final AST retypingAst = createRetypingAst("Person", "Salesperson", guard);
		
		assertEquals(new Retyping(retypingAst, "Person", "Salesperson", guard.getFirstChild()), runRetypingLoaderOn(retypingAst));
	}
	
	private static Retyping runRetypingLoaderOn(AST rule) {
		return new RetypingLoader(rule).run();
	}
}
