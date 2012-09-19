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

import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.annotateAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createGuard;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createRetypingAst;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.flock.model.domain.typemappings.Retyping;
import org.junit.Test;

public class RetypingLoaderTest {
	
	@Test
	public void retyping() {
		final AST retypingAst = createRetypingAst("Person", "Salesperson");
		
		assertEquals(createRetyping(retypingAst, "Person", "Salesperson"), runRetypingLoaderOn(retypingAst));
	}
	
	@Test
	public void retypingWithGuard() {
		final AST guard       = createGuard();
		final AST retypingAst = createRetypingAst("Person", "Salesperson", guard);
		
		assertEquals(createRetypingWithGuard(retypingAst, "Person", "Salesperson", guard.getFirstChild()), runRetypingLoaderOn(retypingAst));
	}
	
	@Test
	public void strictRetyping() {
		final AST retypingAst = annotateAst(createRetypingAst("Person", "Salesperson"), "@strict");
		
		assertEquals(createRetypingWithAnnotations(retypingAst, "Person", "Salesperson", "strict"), runRetypingLoaderOn(retypingAst));
	}
	
	
	private static Retyping createRetyping(AST ast, String originalType, String evolvedType) {
		return createRetypingWithGuard(ast, originalType, evolvedType, null);
	}	
	
	private static Retyping createRetypingWithGuard(AST ast, String originalType, String evolvedType, AST guard) {
		return new Retyping(ast, new LinkedList<String>(), originalType, evolvedType, guard);
	}
	
	private static Retyping createRetypingWithAnnotations(AST ast, String originalType, String evolvedType, String... annotations) {
		return new Retyping(ast, Arrays.asList(annotations), originalType, evolvedType, null);
	}
	
	private static Retyping runRetypingLoaderOn(AST rule) {
		return new RetypingLoader(rule).run();
	}
}
