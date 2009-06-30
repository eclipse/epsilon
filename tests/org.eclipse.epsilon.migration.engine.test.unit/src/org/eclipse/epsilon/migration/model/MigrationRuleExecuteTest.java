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

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.migration.MigrationContext;
import org.junit.Test;

public class MigrationRuleExecuteTest {
	
	@Test
	public void executesBlock() {
		final AST ast = new AST();
		final MigrationRule rule = new MigrationRule("Person", "Person", null, ast);
		final MockMigrationContext context = new MockMigrationContext(1);		
		rule.migrate(EcoreFactory.eINSTANCE.createEObject(), context);
		
		assertEquals(1, context.timesExecutedBlockCalled);
		assertEquals(ast, context.block);

		assertEquals("Person", context.elementCreated);
	}
	
	@Test
	public void createsModelElementOfTargetType() {
		final AST ast = new AST();
		final MigrationRule rule = new MigrationRule("Animal", "Dog", null, ast);
		final MockMigrationContext context = new MockMigrationContext(1);		
		rule.migrate(EcoreFactory.eINSTANCE.createEObject(), context);
		
		assertEquals(1, context.timesExecutedBlockCalled);
		assertEquals(ast, context.block);

		assertEquals("Dog", context.elementCreated);
	}
	
	private static class MockMigrationContext extends MigrationContext {

		private int timesExecutedBlockCalled = 0;
		private AST block;
		private String elementCreated;
		
		private final int numberOfOriginalModelElements;
		
		public MockMigrationContext(int numberOfOriginalModelElements) {
			this.numberOfOriginalModelElements = numberOfOriginalModelElements;
		}

		@Override
		public Collection<EObject> getOriginalModelElements(String type) throws EolModelElementTypeNotFoundException {
			return Collections.nCopies(numberOfOriginalModelElements, EcoreFactory.eINSTANCE.createEObject());
		}
		
		@Override
		public Object createModelElementInTarget(String type) throws EolRuntimeException {
			elementCreated = type;
			
			return EcoreFactory.eINSTANCE.createEObject();
		}

		@Override
		public Object executeBlock(AST block, Variable... variables) throws EolRuntimeException {
			timesExecutedBlockCalled++;
			this.block = block;
			return null; 
		}
	}
}
