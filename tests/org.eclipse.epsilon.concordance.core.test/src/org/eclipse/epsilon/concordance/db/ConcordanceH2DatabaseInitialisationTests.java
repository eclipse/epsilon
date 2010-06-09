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
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.epsilon.concordance.db.common.H2Column;
import org.eclipse.epsilon.concordance.db.common.H2Database;
import org.eclipse.epsilon.concordance.db.common.H2DatabaseAccessException;
import org.eclipse.epsilon.concordance.db.common.H2Table;
import org.eclipse.epsilon.concordance.db.common.H2Column.Type;
import org.junit.Before;
import org.junit.Test;

public class ConcordanceH2DatabaseInitialisationTests {

	private final H2Database mockDatabase = createMock("mockDatabase", H2Database.class);

	@Before
	public void setup() {
		reset(mockDatabase);
	}
	
	@Test
	public void shouldCreateTablesIfNeitherTableExists() throws H2DatabaseAccessException {		
		final H2Table dummyModelsTable = createMock("dummyModelsTable", H2Table.class);
		final H2Table dummyXrefsTable  = createMock("dummyXrefsTable", H2Table.class);
		
		expect(mockDatabase.hasTableNamed("Models"))
			.andReturn(false).anyTimes();
		
		expect(mockDatabase.hasTableNamed("CrossReferences"))
			.andReturn(false).anyTimes();
		
		expect(mockDatabase.createTable("Models", new H2Column("URI", Type.STRING), new H2Column("nsUri", Type.STRING)))
			.andReturn(dummyModelsTable);
		
		expect(mockDatabase.createTable("CrossReferences", Arrays.asList(new H2Column("sourceModel", Type.STRING),
		                                                                 new H2Column("targetModel", Type.STRING),
		                                                                 new H2Column("sourceFragment", Type.STRING),
		                                                                 new H2Column("targetFragment", Type.STRING),
		                                                                 new H2Column("sourceLabel", Type.STRING),
		                                                                 new H2Column("targetLabel", Type.STRING),
		                                                                 new H2Column("label", Type.STRING))))
			.andReturn(dummyXrefsTable);

		replay(mockDatabase);
		
		
		assertEquals(new ConcordanceH2Database(dummyModelsTable, dummyXrefsTable),
		             ConcordanceH2Database.loadFromOrInitialiseIn(mockDatabase));
		
		verify(mockDatabase);
	}
	@Test
	public void shouldCreateTablesIfModelsTableDoesNotExist() throws H2DatabaseAccessException {		
		final H2Table dummyModelsTable = createMock("dummyModelsTable", H2Table.class);
		final H2Table dummyXrefsTable  = createMock("dummyXrefsTable", H2Table.class);
		
		expect(mockDatabase.hasTableNamed("Models"))
			.andReturn(false).anyTimes();;
		
		expect(mockDatabase.hasTableNamed("CrossReferences"))
			.andReturn(true).anyTimes();;
		
		expect(mockDatabase.createTable("Models", new H2Column("URI", Type.STRING), new H2Column("nsUri", Type.STRING)))
			.andReturn(dummyModelsTable);
		
		expect(mockDatabase.createTable("CrossReferences", Arrays.asList(new H2Column("sourceModel", Type.STRING),
		                                                                 new H2Column("targetModel", Type.STRING),
		                                                                 new H2Column("sourceFragment", Type.STRING),
		                                                                 new H2Column("targetFragment", Type.STRING),
		                                                                 new H2Column("sourceLabel", Type.STRING),
		                                                                 new H2Column("targetLabel", Type.STRING),
		                                                                 new H2Column("label", Type.STRING))))
		.andReturn(dummyXrefsTable);

		replay(mockDatabase);
		
		
		assertEquals(new ConcordanceH2Database(dummyModelsTable, dummyXrefsTable),
		             ConcordanceH2Database.loadFromOrInitialiseIn(mockDatabase));		
		verify(mockDatabase);
	}
	
	@Test
	public void shouldCreateTablesIfCrossReferencesTableDoesNotExist() throws H2DatabaseAccessException {		
		final H2Table dummyModelsTable = createMock("dummyModelsTable", H2Table.class);
		final H2Table dummyXrefsTable  = createMock("dummyXrefsTable", H2Table.class);
		
		expect(mockDatabase.hasTableNamed("Models"))
			.andReturn(true).anyTimes();;
		
		expect(mockDatabase.hasTableNamed("CrossReferences"))
			.andReturn(false).anyTimes();;
		
		expect(mockDatabase.createTable("Models", new H2Column("URI", Type.STRING), new H2Column("nsUri", Type.STRING)))
			.andReturn(dummyModelsTable);
		
		expect(mockDatabase.createTable("CrossReferences", Arrays.asList(new H2Column("sourceModel", Type.STRING),
				                                                         new H2Column("targetModel", Type.STRING),
				                                                         new H2Column("sourceFragment", Type.STRING),
				                                                         new H2Column("targetFragment", Type.STRING),
				                                                         new H2Column("sourceLabel", Type.STRING),
		                                                                 new H2Column("targetLabel", Type.STRING),
		                                                                 new H2Column("label", Type.STRING))))
		.andReturn(dummyXrefsTable);

		replay(mockDatabase);
		
		
		assertEquals(new ConcordanceH2Database(dummyModelsTable, dummyXrefsTable),
		             ConcordanceH2Database.loadFromOrInitialiseIn(mockDatabase));
		
		verify(mockDatabase);
	}
	
	@Test
	public void shouldNotCreateTablesIfBothTablesExist() throws H2DatabaseAccessException {		
		final H2Table dummyModelsTable = createMock("dummyModelsTable", H2Table.class);
		final H2Table dummyXrefsTable  = createMock("dummyXrefsTable", H2Table.class);
		
		expect(mockDatabase.hasTableNamed("Models"))
			.andReturn(true).anyTimes();;
		
		expect(mockDatabase.hasTableNamed("CrossReferences"))
			.andReturn(true).anyTimes();;
		
		
		expect(mockDatabase.getTableNamed("Models"))
			.andReturn(dummyModelsTable);
	
		expect(mockDatabase.getTableNamed("CrossReferences"))
			.andReturn(dummyXrefsTable);

		replay(mockDatabase);
		
		
		assertEquals(new ConcordanceH2Database(dummyModelsTable, dummyXrefsTable),
		             ConcordanceH2Database.loadFromOrInitialiseIn(mockDatabase));
		
		verify(mockDatabase);
	}
}
