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

import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.annotateAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createDeletionAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createGuard;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.model.domain.typemappings.Deletion;
import org.junit.Test;

public class DeletionLoaderTest {
	
	@Test
	public void deletion() {
		final AST deletionAst = createDeletionAst("Person");
		
		assertEquals(createDeletion(deletionAst, "Person"), runDeletionLoaderOn(deletionAst));
	}
	
	@Test
	public void deletionWithGuard() {
		final AST guard       = createGuard();
		final AST deletionAst = createDeletionAst("Person", guard);
		
		assertEquals(createDeletionWithGuard(deletionAst, "Person", guard.getFirstChild()), runDeletionLoaderOn(deletionAst));
	}
	
	@Test
	public void strictDeletion() {
		final AST deletionAst = annotateAst(createDeletionAst("Person"), "@strict");
		
		assertEquals(createDeletionWithAnnotations(deletionAst, "Person", "strict"), runDeletionLoaderOn(deletionAst));
	}
	
	
	private static Deletion createDeletion(AST ast, String type) {
		return createDeletionWithGuard(ast, type, null);
	}	
	
	private static Deletion createDeletionWithGuard(AST ast, String type, AST guard) {
		return new Deletion(ast, new LinkedList<String>(), type, guard);
	}
	
	private static Deletion createDeletionWithAnnotations(AST ast, String type, String... annotations) {
		return new Deletion(ast, Arrays.asList(annotations), type, null);
	}
	
	private static Deletion runDeletionLoaderOn(AST rule) {
		return new DeletionLoader(rule).run();
	}
}
