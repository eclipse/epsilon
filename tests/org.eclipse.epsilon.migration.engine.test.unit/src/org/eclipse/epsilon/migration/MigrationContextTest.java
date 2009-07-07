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

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.eclipse.epsilon.hutn.test.model.factories.DogFactory.createDog;
import static org.eclipse.epsilon.hutn.test.model.factories.PersonFactory.createPerson;

import java.util.Arrays;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.migration.copy.Copier;
import org.eclipse.epsilon.migration.copy.CopyingException;
import org.eclipse.epsilon.migration.copy.Equivalence;
import org.eclipse.epsilon.migration.execution.ExecutionContext;
import org.eclipse.epsilon.migration.model.MigrationStrategy;
import org.junit.Test;

public class MigrationContextTest {

	@Test
	public void copiesAndMigratesAllObjects() throws CopyingException {
		executeTest(createPerson(), createDog());
	}

	@Test
	public void copiesAndMigratesWhenNoObjects() throws CopyingException {
		executeTest();
	}
	
	
	private void executeTest(EObject... originals) throws CopyingException {
		final AbstractEmfModel originalModel = createMock(AbstractEmfModel.class);
		
		expect(originalModel.contents()).andReturn(Arrays.asList(originals));
		
		
		final Copier              copier = createMock(Copier.class);
		final MigrationStrategy strategy = createMock(MigrationStrategy.class);
		
		for (EObject original : originals) {
			final EObject copy = EcoreFactory.eINSTANCE.createEObject();
			expect(copier.deepCopy(original)).andReturn(Collections.singletonList(new Equivalence(original, copy)));
			strategy.migrate(eq(original), eq(copy), isA(ExecutionContext.class));
		}
		
		replay(originalModel, copier, strategy);
		
		new MigrationContext(originalModel, null).execute(strategy, copier);
		verify(copier, strategy);
	}
}
