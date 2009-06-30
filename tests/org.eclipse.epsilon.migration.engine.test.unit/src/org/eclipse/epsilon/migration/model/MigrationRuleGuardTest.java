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

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.eol.parse.EolLexer;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.hutn.test.model.families.Dog;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesFactory;
import org.eclipse.epsilon.migration.MigrationContext;
import org.junit.Test;

public class MigrationRuleGuardTest {
	
	@Test
	public void appliesOnlyForObjectOfSourceType() {
		final MigrationRule rule = new MigrationRule("Dog", "Animal", null, new AST());

		assertTrue(rule.appliesFor(FamiliesFactory.eINSTANCE.createDog(), new MigrationContext()));
		assertFalse(rule.appliesFor(FamiliesFactory.eINSTANCE.createFamily(), new MigrationContext()));
	}

	@Test
	public void appliesOnlyWhenObjectSatisfiesGuard() throws RecognitionException {
		final AST guard = parseGuard("original.name = 'Fido'");
		final MigrationRule rule = new MigrationRule("Dog", "Animal", guard, new AST());
		
		assertTrue(rule.appliesFor(createDog("Fido"), new MigrationContext()));
		assertFalse(rule.appliesFor(createDog("Lassie"), new MigrationContext()));
	}
	
	@Test
	public void falseReturnedWhenErrorExecutingGuard() throws RecognitionException {
		final AST guard = parseGuard("undefined");
		final MigrationRule rule = new MigrationRule("Dog", "Animal", guard, new AST());
		
		assertFalse(rule.appliesFor(FamiliesFactory.eINSTANCE.createDog(), new MigrationContext()));
	}
	
	
	private static AST parseGuard(String guard) throws RecognitionException {
		final EolParser parser = new EolParser(new CommonTokenStream(new EolLexer(new ANTLRStringStream(": " + guard))));
		parser.setDeepTreeAdaptor(new EpsilonTreeAdaptor(null));
		
		final AST result = (AST)parser.expressionOrStatementBlock().getTree();
				
		return result;
	}
	
	
	private static Dog createDog(String name) {
		final Dog dog = FamiliesFactory.eINSTANCE.createDog();
		dog.setName(name);
		return dog;
	}
}
