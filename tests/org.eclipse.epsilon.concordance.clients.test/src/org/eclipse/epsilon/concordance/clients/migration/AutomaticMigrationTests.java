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
package org.eclipse.epsilon.concordance.clients.migration;

import static org.easymock.classextension.EasyMock.eq;
import static org.easymock.classextension.EasyMock.expect;
import static org.easymock.classextension.EasyMock.isA;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.createNiceMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import java.util.Arrays;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.model.ConcordanceModel;
import org.junit.Test;

public class AutomaticMigrationTests {

	@Test
	public void shouldVisitAllInstancesOfOriginalMetamodelAfterAnAddWhenNewMetamodelIsTargetOfMigration() throws MigratorInstantiationException {
		final ConcordanceIndex mockIndex = createMock("mockIndex", ConcordanceIndex.class);
		final EPackage dummyEPackage     = createMock("dummyEPackage", EPackage.class);
		
		final AutomaticMigrator migrator = new AutomaticMigrator(mockIndex, Arrays.asList(createMigrationStub("original", dummyEPackage)));
		
		
		mockIndex.visitAllInstancesOf(eq("original"), isA(AutomaticMigrator.MigratingVisitor.class));
		
		replay(mockIndex, dummyEPackage);
		
		
		migrator.ePackageAdded(dummyEPackage);
		
		verify(mockIndex, dummyEPackage);
	}
	
	@Test
	public void shouldVisitAllInstancesOfBothOriginalMetamodelsAfterAnAddWhenNewMetamodelIsTargetOfTwoMigrations() throws MigratorInstantiationException {
		final ConcordanceIndex mockIndex = createMock("mockIndex", ConcordanceIndex.class);
		final EPackage dummyEPackage     = createMock("dummyEPackage", EPackage.class);

		final AutomaticMigrator migrator = new AutomaticMigrator(mockIndex, Arrays.asList(createMigrationStub("original", dummyEPackage), createMigrationStub("other", dummyEPackage)));
				
		mockIndex.visitAllInstancesOf(eq("original"), isA(AutomaticMigrator.MigratingVisitor.class));
		mockIndex.visitAllInstancesOf(eq("other"),    isA(AutomaticMigrator.MigratingVisitor.class));
		
		replay(mockIndex, dummyEPackage);
		
		
		migrator.ePackageAdded(dummyEPackage);
		
		verify(mockIndex, dummyEPackage);
	}
	
	@Test
	public void shouldNotVisitAfterAnAddWhenNewMetamodelIsNotATargetOfMigration() {
		final ConcordanceIndex mockIndex = createMock("mockIndex", ConcordanceIndex.class);
		final EPackage dummyEPackage     = createMock("dummyEPackage", EPackage.class);

		final AutomaticMigrator migrator = new AutomaticMigrator(mockIndex);
				
		replay(mockIndex, dummyEPackage);
		
		
		migrator.ePackageAdded(dummyEPackage);
		
		verify(mockIndex, dummyEPackage);
	}
	
	private static Migration createMigrationStub(String originalNsUri, EPackage target) throws MigratorInstantiationException {
		final Migration stub = createNiceMock(Migration.class);
		
		expect(stub.createMigrator()).andReturn(createMock(Migrator.class)).anyTimes();
		expect(stub.getOriginalNsUri()).andReturn(originalNsUri).anyTimes();
		expect(stub.targetIs(target)).andReturn(true).anyTimes();
		
		replay(stub);
		
		return stub;
	}
	
	
	@Test
	public void visitorShouldInvokeMigratorOnModel() throws CoreException {
		final Migrator mockMigrator = createMock("mockMigrator", Migrator.class);
		final AutomaticMigrator.MigratingVisitor visitor = new AutomaticMigrator.MigratingVisitor(mockMigrator);
		
		final ConcordanceModel     modelStub     = createMock("modelStub",     ConcordanceModel.class);
		final IResource dummyResource = createMock("dummyResource", IResource.class);
		
		expect(modelStub.getResource()).andReturn(dummyResource).anyTimes();
		mockMigrator.migrate(dummyResource);
		
		replay(mockMigrator, modelStub, dummyResource);

		
		visitor.visit(modelStub);
		
		verify(mockMigrator, modelStub, dummyResource);
	}	
}
