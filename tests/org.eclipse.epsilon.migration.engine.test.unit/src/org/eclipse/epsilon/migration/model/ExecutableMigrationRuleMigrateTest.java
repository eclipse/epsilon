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

import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.expect;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.migration.execution.ExecutionContext;
import org.junit.Test;

public class ExecutableMigrationRuleMigrateTest {
		
	private final ExecutionContext context = createMock(ExecutionContext.class);
	
	@Test
	public void executesBlock() throws EolRuntimeException {
		final AST body = new AST();
		final ExecutableMigrationRule rule = new ExecutableMigrationRule("Person", "Person", null, body);
				
		final EObject original = createEObject();
		final EObject target   = createEObject();
		
		expect(context.executeBlock(body,
		                            createVariable("original", original),
		                            createVariable("target", target)
		                           )
		      ).andReturn(null);
		
		replay(context);
		
		rule.migrate(original, target, context);
		verify(context);
	}

	private Variable createVariable(String name, EObject original) {
		return Variable.createReadOnlyVariable(name, original);
	}
	
	private static final EObject createEObject() {
		return EcoreFactory.eINSTANCE.createEObject();
	}
}
