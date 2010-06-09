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
package org.eclipse.epsilon.concordance.db;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.concordance.db.common.H2DatabaseAccessException;
import org.eclipse.epsilon.concordance.db.common.H2Row;
import org.eclipse.epsilon.concordance.db.common.H2Table;
import org.eclipse.epsilon.concordance.db.common.H2Value;
import org.eclipse.epsilon.concordance.model.CrossReference;
import org.eclipse.epsilon.concordance.model.Model;
import org.junit.Before;
import org.junit.Test;

public class ConcordanceH2DatabaseTests {

	private static final H2Table mockModelsTable          = createMock("mockModelsTable",          H2Table.class);
	private static final H2Table mockCrossReferencesTable = createMock("mockCrossReferencesTable", H2Table.class);
	private static final ConcordanceH2Database database   = new ConcordanceH2Database(mockModelsTable, mockCrossReferencesTable);
	
	@Before
	public void setupEachTime() {
		reset(mockModelsTable, mockCrossReferencesTable);
	}
	
	@Test
	public void shouldInsertRowWhenModelIsAdded() throws H2DatabaseAccessException {
		final URI    uri   = URI.createPlatformResourceURI("/project/container/sample.model", true);
		final String nsUri = "families";
		
		final Model modelStub = stub(uri, nsUri);
		
		mockModelsTable.insertRow(new H2Value("URI", uri.toString()), new H2Value("nsUri", nsUri));
		
		replay(mockModelsTable, mockCrossReferencesTable);
		
		
		database.addModel(modelStub);
		
		verify(mockModelsTable, mockCrossReferencesTable);
	}
	
	@Test
	public void shouldInsertCrossReferenceRowWhenModelWithACrossReferenceIsAdded() throws H2DatabaseAccessException {
		final URI    uri   = URI.createPlatformResourceURI("/project/container/sample.model", true);
		final String nsUri = "families";
		
		final URI sourceModel = uri;
		final URI targetModel = URI.createPlatformResourceURI("/project/container/target.model", true);
		
		final Model modelStub = stub(uri, nsUri, new CrossReference(sourceModel, "source_label", targetModel, "target_label", "a_label"));
		
		mockModelsTable.insertRow(new H2Value("uri", uri.toString()), new H2Value("nsUri", nsUri));
		mockCrossReferencesTable.insertRow(new H2Value("sourceModel", sourceModel.toString()),
		                                   new H2Value("targetModel", targetModel.toString()),
		                                   new H2Value("sourceFragment", ""),
		                                   new H2Value("targetFragment", ""),
		                                   new H2Value("sourceLabel", "source_label"),
                                           new H2Value("targetLabel", "target_label"),
		                                   new H2Value("label", "a_label"));
		
		replay(mockModelsTable, mockCrossReferencesTable);
		
		
		database.addModel(modelStub);
		
		verify(mockModelsTable, mockCrossReferencesTable);
	}
	
	@Test
	public void shouldInsertSeveralCrossReferenceRowWhenModelWithACrossReferencesIsAdded() throws H2DatabaseAccessException {
		final URI    uri   = URI.createPlatformResourceURI("/project/container/sample.model", true);
		final String nsUri = "families";
		
		final URI sourceModel = uri;
		final URI target1Uri = URI.createPlatformResourceURI("/project/container/target1.model", true);
		final URI target2Uri = URI.createPlatformResourceURI("/project/container/target2.model", true);
		final URI target3Uri = URI.createPlatformResourceURI("/project/container/target3.model", true);
		
		final Model modelStub = stub(uri, nsUri, new CrossReference(sourceModel, "first_source_label",  target1Uri, "first_target_label",  "first_label"),
		                                         new CrossReference(sourceModel, "second_source_label", target2Uri, "second_target_label", "second_label"),
		                                         new CrossReference(sourceModel, "third_source_label",  target3Uri, "third_target_label",  "third_label"));
		
		mockModelsTable.insertRow(new H2Value("uri", uri.toString()), new H2Value("nsUri", nsUri));
		
		mockCrossReferencesTable.insertRow(new H2Value("sourceModel", sourceModel.toString()),
		                                   new H2Value("targetModel", target1Uri.toString()),
		                                   new H2Value("sourceFragment", ""),
		                                   new H2Value("targetFragment", ""),
		                                   new H2Value("sourceLabel", "first_source_label"),
                                           new H2Value("targetLabel", "first_target_label"),
		                                   new H2Value("label", "first_label"));
		
		mockCrossReferencesTable.insertRow(new H2Value("sourceModel", sourceModel.toString()),
		                                   new H2Value("targetModel", target2Uri.toString()),
		                                   new H2Value("sourceFragment", ""),
		                                   new H2Value("targetFragment", ""),
		                                   new H2Value("sourceLabel", "second_source_label"),
                                           new H2Value("targetLabel", "second_target_label"),
		                                   new H2Value("label", "second_label"));
		
		mockCrossReferencesTable.insertRow(new H2Value("sourceModel", sourceModel.toString()),
		                                   new H2Value("targetModel", target3Uri.toString()),
		                                   new H2Value("sourceFragment", ""),
		                                   new H2Value("targetFragment", ""),
		                                   new H2Value("sourceLabel", "third_source_label"),
                                           new H2Value("targetLabel", "third_target_label"),
		                                   new H2Value("label", "third_label"));
		
		replay(mockModelsTable, mockCrossReferencesTable);
		
		
		database.addModel(modelStub);
		
		verify(mockModelsTable, mockCrossReferencesTable);
	}
	
	
	@Test
	public void shouldDeleteModelsRowWhenModelIsDeleted() throws H2DatabaseAccessException {
		final URI    uri   = URI.createPlatformResourceURI("/project/container/sample.model", true);
		final String nsUri = "families";
		
		final Model modelStub = stub(uri, nsUri);
		
		mockModelsTable.deleteBy(new H2Value("uri", uri.toString()));
		mockCrossReferencesTable.deleteBy(new H2Value("sourceModel", uri.toString()));
		
		replay(mockModelsTable, mockCrossReferencesTable);
		
		
		database.deleteModel(modelStub);
		
		verify(mockModelsTable, mockCrossReferencesTable);
	}
	
	@Test
	public void shouldDeleteCrossReferencesRowWhenModelWithCrossReferenceIsDeleted() throws H2DatabaseAccessException {
		final URI    uri   = URI.createPlatformResourceURI("/project/container/sample.model", true);
		final String nsUri = "families";
		
		final URI sourceModel = uri;
		final URI targetModel = URI.createPlatformResourceURI("/project/container/target.model", true);
		
		final Model modelStub = stub(uri, nsUri, new CrossReference(sourceModel, "first_source_label",  targetModel, "first_target_label",  "first_label"));
		
		
		mockModelsTable.deleteBy(new H2Value("uri", uri.toString()));
		mockCrossReferencesTable.deleteBy(new H2Value("sourceModel", sourceModel.toString()));
		
		replay(mockModelsTable, mockCrossReferencesTable);
		
		
		database.deleteModel(modelStub);
		
		verify(mockModelsTable, mockCrossReferencesTable);
	}
	
	@Test
	public void shouldDeleteAllCrossReferencesRowsWhenModelWithSeveralCrossReferenceIsDeleted() throws H2DatabaseAccessException {
		final URI    uri   = URI.createPlatformResourceURI("/project/container/sample.model", true);
		final String nsUri = "families";
		
		final URI sourceModel = uri;
		final URI target1Uri = URI.createPlatformResourceURI("/project/container/target1.model", true);
		final URI target2Uri = URI.createPlatformResourceURI("/project/container/target2.model", true);
		final URI target3Uri = URI.createPlatformResourceURI("/project/container/target3.model", true);
		
		final Model modelStub = stub(uri, nsUri, new CrossReference(sourceModel, "first_source_label",  target1Uri, "first_target_label",  "first_label"),
		                                         new CrossReference(sourceModel, "second_source_label", target2Uri, "second_target_label", "second_label"),
		                                         new CrossReference(sourceModel, "third_source_label",  target3Uri, "third_target_label",  "third_label"));
		
		
		mockModelsTable.deleteBy(new H2Value("uri", uri.toString()));
		mockCrossReferencesTable.deleteBy(new H2Value("sourceModel", sourceModel.toString()));
		
		replay(mockModelsTable, mockCrossReferencesTable);
		
		
		database.deleteModel(modelStub);
		
		verify(mockModelsTable, mockCrossReferencesTable);
	}
	
	
	@Test
	public void shouldChangeUriColumnsWhenModelMoves() throws H2DatabaseAccessException {
		final URI oldUri = URI.createPlatformResourceURI("/project/container/sample.model", true);
		final URI newUri  = URI.createPlatformResourceURI("/project/container/sample.model", true);

		final URI sourceModel = oldUri;
		final URI target1Uri = URI.createPlatformResourceURI("/project/container/target1.model", true);
		final URI target2Uri = URI.createPlatformResourceURI("/project/container/target2.model", true);
		final URI target3Uri = URI.createPlatformResourceURI("/project/container/target3.model", true);
		
		final Model oldModelStub = stub(oldUri, "families", new CrossReference(sourceModel, "first_source_label",  target1Uri, "first_target_label",  "first_label"),
		                                                    new CrossReference(sourceModel, "second_source_label", target2Uri, "second_target_label", "second_label"),
		                                                    new CrossReference(sourceModel, "third_source_label",  target3Uri, "third_target_label",  "third_label"));
		
		final Model newModelStub = stub(oldUri, "families", new CrossReference(sourceModel, "first_source_label",  target1Uri, "first_target_label",  "first_label"),
		                                                    new CrossReference(sourceModel, "second_source_label", target2Uri, "second_target_label", "second_label"),
		                                                    new CrossReference(sourceModel, "third_source_label",  target3Uri, "third_target_label",  "third_label"));
		
		
		mockModelsTable.updateBy(new H2Value("uri", oldUri.toString()), new H2Value("uri", newUri.toString()));
		mockCrossReferencesTable.updateBy(new H2Value("sourceModel", oldUri.toString()), new H2Value("sourceModel", newUri.toString()));
		mockCrossReferencesTable.updateBy(new H2Value("targetModel", oldUri.toString()), new H2Value("targetModel", newUri.toString()));
		
		replay(mockModelsTable, mockCrossReferencesTable);
		
		
		database.moveModel(oldModelStub, newModelStub);
		
		verify(mockModelsTable, mockCrossReferencesTable);
	}	
	
	
	@Test
	public void findAllInstancesShouldSearchDatabaseUsingNsUri() throws H2DatabaseAccessException {		
		expect(mockModelsTable.findBy(new H2Value("nsUri", "families"), "URI"));
		expectLastCall().andReturn(Arrays.asList("first.model", "second.model"));
		

		replay(mockModelsTable, mockCrossReferencesTable);
		
		assertEquals(Arrays.asList(new Model(URI.createURI("first.model")),
		                           new Model(URI.createURI("second.model"))),
		             database.findAllInstancesOf("families"));
		
		verify(mockModelsTable, mockCrossReferencesTable);
	}
	
	@Test
	public void visitAllCrossReferencesWithTargetShouldSearchDatabaseUsingTargetModel() throws H2DatabaseAccessException {
		final URI targetUri = URI.createURI("target.model");
		
		expect(mockCrossReferencesTable.findBy(new H2Value("targetModel", targetUri)));
		expectLastCall().andReturn(Arrays.asList(createCrossReferenceRow("first.model", "//@members.0", "first",  "target.model", "/", "root",          "first_to_root"),
		                                         createCrossReferenceRow("first.model", "//@members.1", "second", "target.model", "/", "root",          "second_to_root"),
		                                         createCrossReferenceRow("second.model", "/",           "root",   "target.model", "//@pets.0", "first", "root_to_first")));
		
		replay(mockModelsTable, mockCrossReferencesTable);
		
		
		assertEquals(Arrays.asList(new CrossReference(URI.createURI("first.model").appendFragment("//@members.0"),
		                           "first",
		                           URI.createURI("target.model").appendFragment("/"),
		                           "root",
		                           "first_to_root"),
		                           
		                           new CrossReference(URI.createURI("first.model").appendFragment("//@members.1"),
		                           "second",
		                           URI.createURI("target.model").appendFragment("/"),
		                           "root",
		                           "second_to_root"),
		                           
		                           new CrossReference(URI.createURI("second.model").appendFragment("/"),
		                           "root",
		                           URI.createURI("target.model").appendFragment("//@pets.0"),
		                           "first",
		                           "root_to_first")),
		            database.findAllCrossReferencesTo(new Model(targetUri)));
		
		verify(mockModelsTable, mockCrossReferencesTable);
	}
	
	private static H2Row createCrossReferenceRow(String sourceModelUri, String sourceFragment, String sourceLabel, String targetModelUri, String targetFragment, String targetLabel, String label) {
		final List<H2Value> values = new LinkedList<H2Value>();
		
		values.add(new H2Value("sourceModel",    sourceModelUri));
		values.add(new H2Value("sourceFragment", sourceFragment));
		values.add(new H2Value("sourceLabel",    sourceLabel));

		values.add(new H2Value("targetModel",    targetModelUri));
		values.add(new H2Value("targetFragment", targetFragment));
		values.add(new H2Value("targetLabel",    targetLabel));

		values.add(new H2Value("label",          label));
		
		return new H2Row(values);
	}
	
	@Test
	public void visitAllModelsWithCrossReferencesToShouldSearchDatabaseUsingTargetModel() throws H2DatabaseAccessException {
		final URI targetUri = URI.createURI("target.model");
		
		expect(mockCrossReferencesTable.findBy(new H2Value("targetModel", targetUri), "sourceModel"));
		expectLastCall().andReturn(Arrays.asList("first.model", "second.model"));
				
		replay(mockModelsTable, mockCrossReferencesTable);
		
		
		assertEquals(Arrays.asList(new Model(URI.createURI("first.model")),
		                           new Model(URI.createURI("second.model"))),
		             database.findAllModelsWithCrossReferencesTo(new Model(targetUri)));
		
		verify(mockModelsTable, mockCrossReferencesTable);
	}

	
	
	private static int STUB_COUNT = 1;
	
	private static Model stub(URI uri, String nsUri, CrossReference... xrefs) {
		final Model stub = createMock("StubModel" + STUB_COUNT++, Model.class);
		
		expect(stub.getUri()).andReturn(uri).anyTimes();
		expect(stub.getNsUri()).andReturn(nsUri).anyTimes();
		expect(stub.getAllCrossReferences()).andReturn(new HashSet<CrossReference>(Arrays.asList(xrefs))).anyTimes();
		replay(stub);
		
		return stub;
	}
}
