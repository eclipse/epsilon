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
package org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance.extend;

import java.util.Collection;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ExtendInvalidWithoutRule extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "\n" +
	                                       "    migrate Person extends NamedElement\n";

	private static Collection<ParseProblem> parseProblems;
	private static ParseProblem firstProblem;
	
	@BeforeClass
	public static void setup() throws Exception {
		parseProblems = null;//parseProblemsFor(strategy); // FIXME shouldn't be null
		firstProblem  = parseProblems.iterator().next();
	}
	
	@Test
	public void thereShouldBeOneParseProblem() {
		assertEquals(1, parseProblems.size());
	}
	
	@Test
	public void theParseProblemShouldHaveAnAppropriateReason() {
		assertEquals("Cannot extend NamedElement, as no migrate rules are defined for NamedElement",
		             firstProblem.getReason());
	}
	
	@Test
	public void theParseProblemShouldHaveTheCorrectLineNumber() {
		assertEquals(2, firstProblem.getLine());
	}
	
	@Test
	public void theParseProblemShouldHaveTheCorrectColumnNumber() {
		assertEquals(4, firstProblem.getColumn());
	}
}
