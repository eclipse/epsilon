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
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.migration.MigrationContext;
import org.junit.Test;

public class MigrationRuleExecuteTest {
	
	private final MockMigrationContext context = new MockMigrationContext();
	
	@Test
	public void executesBlock() {
		final AST body = new AST();
		final MigrationRule rule = new MigrationRule("Person", "Person", null, body);
				
		final EObject original = createEObject();
		final EObject target   = createEObject();
		
		rule.migrate(original, target, context);
		
		assertEquals(1,    context.timesExecutedBlockCalled);
		assertEquals(body, context.executedBlock);
				
		assertTrue(context.variables.contains(Variable.createReadOnlyVariable("original", original)));
		assertTrue(context.variables.contains(Variable.createReadOnlyVariable("target",   target)));
	}
	
	
	private static class MockMigrationContext extends MigrationContext {

		private int timesExecutedBlockCalled = 0;
		private AST executedBlock;
		private List<Variable> variables;

		@Override
		public Object executeBlock(AST block, Variable... variables) throws EolRuntimeException {
			timesExecutedBlockCalled++;
			executedBlock = block;
			this.variables = Arrays.asList(variables);
			return null; 
		}
	}
	
	
	private static final EObject createEObject() {
		return EcoreFactory.eINSTANCE.createEObject();
	}
}
