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

import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createDeletionAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createGuard;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.model.domain.typemappings.Deletion;
import org.junit.Test;

public class DeletionLoaderTest {
	
	@Test
	public void deletion() {
		final AST deletionAst = createDeletionAst("Person");
		
		assertEquals(new Deletion(deletionAst, "Person", null), runDeletionLoaderOn(deletionAst));
	}
	
	@Test
	public void deletionWithGuard() {
		final AST guard       = createGuard();
		final AST deletionAst = createDeletionAst("Person", guard);
		
		assertEquals(new Deletion(deletionAst, "Person", guard.getFirstChild()), runDeletionLoaderOn(deletionAst));
	}
	
	private static Deletion runDeletionLoaderOn(AST rule) {
		return new DeletionLoader(rule).run();
	}
}
