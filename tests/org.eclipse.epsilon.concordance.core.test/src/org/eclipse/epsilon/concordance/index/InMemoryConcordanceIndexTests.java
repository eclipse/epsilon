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
package org.eclipse.epsilon.concordance.index;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.epsilon.concordance.model.Model;
import org.eclipse.epsilon.concordance.model.ModelVisitor;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeReporter;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class InMemoryConcordanceIndexTests {

	private final ModelChangeReporter reporter = new ModelChangeReporter();
	private final ConcordanceIndex index = new InMemoryConcordanceIndex(reporter);
	
	private ModelVisitor mockVisitor = createMock("mockVisitor", ModelVisitor.class);
	
	@Test
	public void shouldVisitModelAfterAddition() {
		final Model modelStub = stub("families");
		
		mockVisitor.visit(modelStub);
		
		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldVisitReferencingModelAfterAddition() {
		final Model dummyTarget = createMock("dummyTarget", Model.class);
		final Model modelStub = stub(dummyTarget);
		
		mockVisitor.visit(modelStub);
		
		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		index.visitAllModelsWithCrossReferencesTo(dummyTarget, mockVisitor);
		
		verify(mockVisitor);
	}

	@Test
	public void shouldVisitSeveralModelsAfterAddition() {
		final Model firstModelStub  = stub("families");
		final Model secondModelStub = stub("families");

		mockVisitor.visit(firstModelStub);
		mockVisitor.visit(secondModelStub);
		
		replay(mockVisitor);
		
		
		reporter.reportAddition(firstModelStub);
		reporter.reportAddition(secondModelStub);
		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldVisitAllReferencingModelsAfterAddition() {
		final Model dummyTarget = createMock("dummyTarget", Model.class);
		
		final Model firstModelStub  = stub(dummyTarget);
		final Model secondModelStub = stub(dummyTarget);
		
		mockVisitor.visit(firstModelStub);
		mockVisitor.visit(secondModelStub);
		
		replay(mockVisitor);
		
		
		reporter.reportAddition(firstModelStub);
		reporter.reportAddition(secondModelStub);
		index.visitAllModelsWithCrossReferencesTo(dummyTarget, mockVisitor);
		
		verify(mockVisitor);
	}
	
	
	@Test
	public void shouldVisitOnlyModelsWithMatchingNsUri() {
		final Model familiesModelStub = stub("families");
		final Model petsModelStub     = stub("pets");
		
		mockVisitor.visit(familiesModelStub);
		
		replay(mockVisitor);
		
		
		reporter.reportAddition(familiesModelStub);
		reporter.reportAddition(petsModelStub);
		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldVisitOnlyModelsWithMatchingTarget() {
		final Model dummyTarget = createMock("dummyTarget", Model.class);
		final Model dummyOtherTarget = createMock("dummyOtherTarget", Model.class);
		
		final Model targetModelStub      = stub(dummyTarget);
		final Model otherTargetModelStub = stub(dummyOtherTarget);
		
		mockVisitor.visit(targetModelStub);
		
		replay(mockVisitor);
		
		
		reporter.reportAddition(targetModelStub);
		reporter.reportAddition(otherTargetModelStub);
		index.visitAllModelsWithCrossReferencesTo(dummyTarget, mockVisitor);
		
		verify(mockVisitor);
	}
	
	
	@Test
	public void shouldNotVisitAnyModelForUnknownNsUri() {
		replay(mockVisitor);
		
		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldNotVisitAnyModelForUnknownTarget() {
		final Model dummyTarget = createMock("dummyTarget", Model.class);
				
		replay(mockVisitor);
		
		index.visitAllModelsWithCrossReferencesTo(dummyTarget, mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldNotVisitDeletedModelViaNsUri() {
		final Model modelStub = stub("families");
				
		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		reporter.reportRemoval(modelStub);

		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldNotVisitAnyTargetOfDeletedModel() {
		final Model dummyTarget = createMock("dummyTarget", Model.class);
		final Model dummyOtherTarget = createMock("dummyOtherTarget", Model.class);
		
		final Model modelStub = stub(dummyTarget, dummyOtherTarget);
				
		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		reporter.reportRemoval(modelStub);

		index.visitAllModelsWithCrossReferencesTo(dummyTarget,      mockVisitor);
		index.visitAllModelsWithCrossReferencesTo(dummyOtherTarget, mockVisitor);

		
		verify(mockVisitor);
	}
	
	
	@Test
	public void shouldVisitNewNsUriWhenModelChanges() {
		final Model modelStub = stub("families", "pets");
		
		mockVisitor.visit(modelStub);

		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		reporter.reportChange(modelStub);

		index.visitAllInstancesOf("pets", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldVisitNewTargetsWhenModelChanges() {
		final Model oldTarget1 = createMock("oldTarget1", Model.class);
		final Model oldTarget2 = createMock("oldTarget2", Model.class);
		final Model newTarget  = createMock("newTarget",  Model.class);
		
		final Model modelStub = stub(Arrays.asList(oldTarget1, oldTarget2),
		                             Arrays.asList(newTarget));
		
		mockVisitor.visit(modelStub);

		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		reporter.reportChange(modelStub);

		index.visitAllModelsWithCrossReferencesTo(newTarget, mockVisitor);
		
		verify(mockVisitor);
	}
	
	
	@Test
	public void shouldNotVisitOldNsUriWhenModelChanges() {
		final Model modelStub = stub("families", "pets");

		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		reporter.reportChange(modelStub);

		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldNotVisitOldTargetsWhenModelChanges() {
		final Model oldTarget1 = createMock("oldTarget1", Model.class);
		final Model oldTarget2 = createMock("oldTarget2", Model.class);
		final Model newTarget  = createMock("newTarget",  Model.class);
		
		final Model modelStub = stub(Arrays.asList(oldTarget1, oldTarget2),
		                             Arrays.asList(newTarget));
		
		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		reporter.reportChange(modelStub);

		index.visitAllModelsWithCrossReferencesTo(oldTarget1, mockVisitor);
		index.visitAllModelsWithCrossReferencesTo(oldTarget2, mockVisitor);

		
		verify(mockVisitor);
	}
	

	@Test
	public void shouldVisitViaNsUriNewLocationOfModelAfterMove() {
		final Model originalModelStub = stub("families");
		final Model movedModelStub    = stub("families");
		
		mockVisitor.visit(movedModelStub);

		replay(mockVisitor);
		
		
		reporter.reportAddition(originalModelStub);
		reporter.reportMove(originalModelStub, movedModelStub);

		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldVisitViaReferenceModelsNewLocationOfModelAfterMove() {
		final Model dummyTarget = createMock("dummyTarget", Model.class);
		
		final Model originalModelStub = stub(dummyTarget);
		final Model movedModelStub    = stub(dummyTarget);
		
		mockVisitor.visit(movedModelStub);

		replay(mockVisitor);
		
		
		reporter.reportAddition(originalModelStub);
		reporter.reportMove(originalModelStub, movedModelStub);

		index.visitAllModelsWithCrossReferencesTo(dummyTarget, mockVisitor);
		
		verify(mockVisitor);
	}
	
	
	
	private static int STUB_COUNT = 1;
	
	private static Model stub(String nsUri) {
		final Model stub = createMock("StubModel" + STUB_COUNT++, Model.class);
		
		expect(stub.getNsUri()).andReturn(nsUri).anyTimes();
		expect(stub.getAllReferencedModels()).andReturn(new HashSet<Model>()).anyTimes();
		replay(stub);
		
		return stub;
	}
	
	private static Model stub(String firstNsUri, String secondNsUri) {
		final Model stub = createMock("StubModel" + STUB_COUNT++, Model.class);
		
		expect(stub.getNsUri()).andReturn(firstNsUri).times(1);
		expect(stub.getNsUri()).andReturn(secondNsUri).anyTimes();
		expect(stub.getAllReferencedModels()).andReturn(new HashSet<Model>()).anyTimes();
		replay(stub);
		
		return stub;
	}
	
	
	private static Model stub(Model... targets) {
		final Model stub = createMock("StubModel" + STUB_COUNT++, Model.class);

		expect(stub.getAllReferencedModels()).andReturn(new HashSet<Model>(Arrays.asList(targets))).anyTimes();
		
		expect(stub.getNsUri()).andReturn("families").anyTimes();
		replay(stub);
		
		return stub;
	}
	
	private Model stub(Collection<Model> firstTargets, Collection<Model> secondTargets) {
		final Model stub = createMock("StubModel" + STUB_COUNT++, Model.class);

		expect(stub.getAllReferencedModels()).andReturn(new HashSet<Model>(firstTargets)).times(1);
		expect(stub.getAllReferencedModels()).andReturn(new HashSet<Model>(secondTargets)).anyTimes();
		
		expect(stub.getNsUri()).andReturn("families").anyTimes();
		replay(stub);
		
		return stub;
	}
}
