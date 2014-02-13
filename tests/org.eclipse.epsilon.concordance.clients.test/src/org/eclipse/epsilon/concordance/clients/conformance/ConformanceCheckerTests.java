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
package org.eclipse.epsilon.concordance.clients.conformance;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.model.ConcordanceModel;
import org.eclipse.epsilon.hutn.xmi.dt.XmiConformanceChecker;
import org.junit.Test;

public class ConformanceCheckerTests {
	
	@Test
	public void shouldVisitAllInstancesOfNewMetamodelAfterAChange() {
		final ConcordanceIndex mockIndex = createMock("mockIndex", ConcordanceIndex.class);
		final ConformanceChecker checker = new ConformanceChecker(mockIndex);
		
		final EPackage oldEPackageStub = createEPackageStub("old", "families");
		final EPackage newEPackageStub = createEPackageStub("new", "families");
		
		mockIndex.visitAllInstancesOf(eq("families"), isA(ConformanceChecker.ConformanceCheckingVisitor.class));
		
		replay(mockIndex, oldEPackageStub, newEPackageStub);
		
		
		checker.ePackageChanged(oldEPackageStub, newEPackageStub);
		
		verify(mockIndex, oldEPackageStub, newEPackageStub);
	}
	
	private static EPackage createEPackageStub(String name, String nsUri) {
		final EPackage ePackageStub = createMock(name + "EPackageStub", EPackage.class);
		
		expect(ePackageStub.getName()).andReturn(name).anyTimes();
		expect(ePackageStub.getNsURI()).andReturn(nsUri).anyTimes();
		
		return ePackageStub;
	}
	
	
	@Test
	public void visitorShouldInvokeConformanceCheckingOnModel() throws CoreException {
		final XmiConformanceChecker mockXmiConformanceChecker = createMock("mockXmiConformanceChecker", XmiConformanceChecker.class);
		final ConformanceChecker.ConformanceCheckingVisitor visitor = new ConformanceChecker.ConformanceCheckingVisitor(mockXmiConformanceChecker);
		
		final ConcordanceModel     modelStub     = createMock("modelStub",     ConcordanceModel.class);
		final IResource dummyResource = createMock("dummyResource", IResource.class);
		
		expect(modelStub.getResource()).andReturn(dummyResource).anyTimes();
		mockXmiConformanceChecker.reportConformanceOf(dummyResource);
		
		replay(mockXmiConformanceChecker, modelStub, dummyResource);

		
		visitor.visit(modelStub);
		
		verify(mockXmiConformanceChecker, modelStub, dummyResource);
	}
}
