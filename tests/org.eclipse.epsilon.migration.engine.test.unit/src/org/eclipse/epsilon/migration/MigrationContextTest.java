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
package org.eclipse.epsilon.migration;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.migration.model.MigrationStrategy;
import org.eclipse.epsilon.migration.model.NoOpMigrationRule;
import org.junit.Test;

public class MigrationContextTest {

	@Test
	public void createTargetModelElementBasedOnTargetTypeOfApplicableRule() throws EolRuntimeException {
		final Object original = "Dummy model element";
		
		final IModel targetModel = createMock(IModel.class); 
		expect(targetModel.createInstance("Dog")).andReturn("Copied model element");
		replay(targetModel);
		
		final MigrationContext context = new MigrationContext(null, targetModel);
		
		final MigrationStrategy strategy = createMock(MigrationStrategy.class);
		expect(strategy.ruleFor(original, context)).andReturn(new NoOpMigrationRule("Dog"));
		replay(strategy);
		
		context.establishEquivalence(strategy, original);
		
		verify(strategy, targetModel);
	}
}
