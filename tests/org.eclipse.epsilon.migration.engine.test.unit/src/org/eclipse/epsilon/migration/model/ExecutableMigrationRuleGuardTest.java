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
package org.eclipse.epsilon.migration.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.eclipse.epsilon.hutn.test.model.factories.DogFactory.createDog;
import static org.eclipse.epsilon.hutn.test.model.factories.FamilyFactory.createFamily;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.eol.parse.EolLexer;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.junit.Test;

public class ExecutableMigrationRuleGuardTest {
	
	@Test
	public void appliesOnlyForObjectOfSourceType() {
		final ExecutableMigrationRule rule = new ExecutableMigrationRule("Dog", "Animal", null, new AST());

		assertTrue(rule.appliesFor(createDog(), new FakeMigrationContext()));
		assertFalse(rule.appliesFor(createFamily(), new FakeMigrationContext()));
	}

	@Test
	public void appliesOnlyWhenObjectSatisfiesGuard() throws RecognitionException {
		final AST guard = parseGuard("original.name = 'Fido'");
		final ExecutableMigrationRule rule = new ExecutableMigrationRule("Dog", "Animal", guard, new AST());
		
		assertTrue(rule.appliesFor(createDog("Fido"), new FakeMigrationContext()));
		assertFalse(rule.appliesFor(createDog("Lassie"), new FakeMigrationContext()));
	}
	
	@Test
	public void falseReturnedWhenErrorExecutingGuard() throws RecognitionException {
		final AST guard = parseGuard("undefined");
		final ExecutableMigrationRule rule = new ExecutableMigrationRule("Dog", "Animal", guard, new AST());
		
		assertFalse(rule.appliesFor(createDog(), new FakeMigrationContext()));
	}
	
	
	private static AST parseGuard(String guard) throws RecognitionException {
		final EolParser parser = new EolParser(new CommonTokenStream(new EolLexer(new ANTLRStringStream(": " + guard))));
		parser.setDeepTreeAdaptor(new EpsilonTreeAdaptor(null));
		
		final AST result = (AST)parser.expressionOrStatementBlock().getTree();
				
		return result;
	}
}
