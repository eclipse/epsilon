/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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

import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.model.ConcordanceModel;
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
		final ConcordanceModel modelStub = stub("families");
		
		mockVisitor.visit(modelStub);
		
		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldVisitReferencingModelAfterAddition() {
		final ConcordanceModel dummyTarget = createMock("dummyTarget", ConcordanceModel.class);
		final ConcordanceModel modelStub = stub(dummyTarget);
		
		mockVisitor.visit(modelStub);
		
		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		index.visitAllModelsWithCrossReferencesTo(dummyTarget, mockVisitor);
		
		verify(mockVisitor);
	}

	@Test
	public void shouldVisitSeveralModelsAfterAddition() {
		final ConcordanceModel firstModelStub  = stub("families");
		final ConcordanceModel secondModelStub = stub("families");

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
		final ConcordanceModel dummyTarget = createMock("dummyTarget", ConcordanceModel.class);
		
		final ConcordanceModel firstModelStub  = stub(dummyTarget);
		final ConcordanceModel secondModelStub = stub(dummyTarget);
		
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
		final ConcordanceModel familiesModelStub = stub("families");
		final ConcordanceModel petsModelStub     = stub("pets");
		
		mockVisitor.visit(familiesModelStub);
		
		replay(mockVisitor);
		
		
		reporter.reportAddition(familiesModelStub);
		reporter.reportAddition(petsModelStub);
		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldVisitOnlyModelsWithMatchingTarget() {
		final ConcordanceModel dummyTarget = createMock("dummyTarget", ConcordanceModel.class);
		final ConcordanceModel dummyOtherTarget = createMock("dummyOtherTarget", ConcordanceModel.class);
		
		final ConcordanceModel targetModelStub      = stub(dummyTarget);
		final ConcordanceModel otherTargetModelStub = stub(dummyOtherTarget);
		
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
		final ConcordanceModel dummyTarget = createMock("dummyTarget", ConcordanceModel.class);
				
		replay(mockVisitor);
		
		index.visitAllModelsWithCrossReferencesTo(dummyTarget, mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldNotVisitDeletedModelViaNsUri() {
		final ConcordanceModel modelStub = stub("families");
				
		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		reporter.reportRemoval(modelStub);

		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldNotVisitAnyTargetOfDeletedModel() {
		final ConcordanceModel dummyTarget = createMock("dummyTarget", ConcordanceModel.class);
		final ConcordanceModel dummyOtherTarget = createMock("dummyOtherTarget", ConcordanceModel.class);
		
		final ConcordanceModel modelStub = stub(dummyTarget, dummyOtherTarget);
				
		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		reporter.reportRemoval(modelStub);

		index.visitAllModelsWithCrossReferencesTo(dummyTarget,      mockVisitor);
		index.visitAllModelsWithCrossReferencesTo(dummyOtherTarget, mockVisitor);

		
		verify(mockVisitor);
	}
	
	
	@Test
	public void shouldVisitNewNsUriWhenModelChanges() {
		final ConcordanceModel modelStub = stub("families", "pets");
		
		mockVisitor.visit(modelStub);

		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		reporter.reportChange(modelStub);

		index.visitAllInstancesOf("pets", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldVisitNewTargetsWhenModelChanges() {
		final IConcordanceModel oldTarget1 = createMock("oldTarget1", ConcordanceModel.class);
		final IConcordanceModel oldTarget2 = createMock("oldTarget2", ConcordanceModel.class);
		final IConcordanceModel newTarget  = createMock("newTarget",  ConcordanceModel.class);
		
		final IConcordanceModel modelStub = stub(Arrays.asList(oldTarget1, oldTarget2),
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
		final ConcordanceModel modelStub = stub("families", "pets");

		replay(mockVisitor);
		
		
		reporter.reportAddition(modelStub);
		reporter.reportChange(modelStub);

		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldNotVisitOldTargetsWhenModelChanges() {
		final IConcordanceModel oldTarget1 = createMock("oldTarget1", ConcordanceModel.class);
		final IConcordanceModel oldTarget2 = createMock("oldTarget2", ConcordanceModel.class);
		final IConcordanceModel newTarget  = createMock("newTarget",  ConcordanceModel.class);
		
		final IConcordanceModel modelStub = stub(Arrays.asList(oldTarget1, oldTarget2),
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
		final ConcordanceModel originalModelStub = stub("families");
		final ConcordanceModel movedModelStub    = stub("families");
		
		mockVisitor.visit(movedModelStub);

		replay(mockVisitor);
		
		
		reporter.reportAddition(originalModelStub);
		reporter.reportMove(originalModelStub, movedModelStub);

		index.visitAllInstancesOf("families", mockVisitor);
		
		verify(mockVisitor);
	}
	
	@Test
	public void shouldVisitViaReferenceModelsNewLocationOfModelAfterMove() {
		final ConcordanceModel dummyTarget = createMock("dummyTarget", ConcordanceModel.class);
		
		final ConcordanceModel originalModelStub = stub(dummyTarget);
		final ConcordanceModel movedModelStub    = stub(dummyTarget);
		
		mockVisitor.visit(movedModelStub);

		replay(mockVisitor);
		
		
		reporter.reportAddition(originalModelStub);
		reporter.reportMove(originalModelStub, movedModelStub);

		index.visitAllModelsWithCrossReferencesTo(dummyTarget, mockVisitor);
		
		verify(mockVisitor);
	}
	
	
	
	private static int STUB_COUNT = 1;
	
	private static ConcordanceModel stub(String nsUri) {
		final ConcordanceModel stub = createMock("StubModel" + STUB_COUNT++, ConcordanceModel.class);
		
		expect(stub.getNsUri()).andReturn(nsUri).anyTimes();
		expect(stub.getAllReferencedModels()).andReturn(new HashSet<IConcordanceModel>()).anyTimes();
		replay(stub);
		
		return stub;
	}
	
	private static ConcordanceModel stub(String firstNsUri, String secondNsUri) {
		final ConcordanceModel stub = createMock("StubModel" + STUB_COUNT++, ConcordanceModel.class);
		
		expect(stub.getNsUri()).andReturn(firstNsUri).times(1);
		expect(stub.getNsUri()).andReturn(secondNsUri).anyTimes();
		expect(stub.getAllReferencedModels()).andReturn(new HashSet<IConcordanceModel>()).anyTimes();
		replay(stub);
		
		return stub;
	}
	
	
	private static ConcordanceModel stub(ConcordanceModel... targets) {
		final ConcordanceModel stub = createMock("StubModel" + STUB_COUNT++, ConcordanceModel.class);

		expect(stub.getAllReferencedModels()).andReturn(new HashSet<IConcordanceModel>(Arrays.asList(targets))).anyTimes();
		
		expect(stub.getNsUri()).andReturn("families").anyTimes();
		replay(stub);
		
		return stub;
	}
	
	private ConcordanceModel stub(Collection<IConcordanceModel> firstTargets, Collection<IConcordanceModel> secondTargets) {
		final ConcordanceModel stub = createMock("StubModel" + STUB_COUNT++, ConcordanceModel.class);

		expect(stub.getAllReferencedModels()).andReturn(new HashSet<>(firstTargets)).times(1);
		expect(stub.getAllReferencedModels()).andReturn(new HashSet<>(secondTargets)).anyTimes();
		
		expect(stub.getNsUri()).andReturn("families").anyTimes();
		replay(stub);
		
		return stub;
	}
}
