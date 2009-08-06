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

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.junit.Before;
import org.junit.Test;

public class MigrationRuleSatisfiesGuardTests {
	
	private static final AST dummyGuard     = createMock(AST.class); 
	private static final MigrationRule rule = new MigrationRule("", "", dummyGuard, new AST());
	
	private final Variable dummyVariable                = createMock(Variable.class);
	private final ModelElement mockOriginalModelElement = createMock(ModelElement.class);
	private final IMigrationContext mockContext         = createMock(IMigrationContext.class);
	
	@Before
	public void setup() {
		reset(dummyVariable, mockOriginalModelElement, mockContext);
		
		expect(mockOriginalModelElement.createReadOnlyVariable("original"))
			.andReturn(dummyVariable);		
	}

	@Test
	public void satisfiesGuardReturnsTrueWhenExecuteGuardReturnsTrue() throws MigrationExecutionException {

		// Expectations
		
		expect(mockContext.executeGuard(dummyGuard, dummyVariable))
			.andReturn(true);
		
		replay(mockOriginalModelElement, mockContext);
		
		
		// Verification
		
		assertTrue(rule.satisfiesGuard(mockOriginalModelElement, mockContext));
		
		verify(mockOriginalModelElement, mockContext);
	}
	
	@Test
	public void satisfiesGuardReturnsFalseWhenExecuteGuardReturnsFalse() throws MigrationExecutionException {

		// Expectations
		
		expect(mockContext.executeGuard(dummyGuard, dummyVariable))
			.andReturn(false);
		
		replay(mockOriginalModelElement, mockContext);
		
		
		// Verification
		
		assertFalse(rule.satisfiesGuard(mockOriginalModelElement, mockContext));
		
		verify(mockOriginalModelElement, mockContext);
	}
	
	@Test(expected=MigrationExecutionException.class)
	public void satisfiesGuardThrowsExceptionExecuteGuardThrowsException() throws MigrationExecutionException {
		
		// Expectations
		
		expect(mockContext.executeGuard(dummyGuard, dummyVariable))
			.andThrow(new MigrationExecutionException("Fake exception", null));
		
		replay(mockOriginalModelElement, mockContext);
		
		
		// Verification
		
		rule.satisfiesGuard(mockOriginalModelElement, mockContext);
		
		verify(mockOriginalModelElement, mockContext);
	}
}
