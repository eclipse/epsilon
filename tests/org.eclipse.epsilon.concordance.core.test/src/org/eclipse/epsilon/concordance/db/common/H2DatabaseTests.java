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
package org.eclipse.epsilon.concordance.db.common;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Arrays;

import org.eclipse.epsilon.concordance.db.common.H2Column.Type;
import org.junit.Test;

public class H2DatabaseTests {

	private final H2DatabaseQuerier mockDbQuerier   = createMock("mockDb", H2DatabaseQuerier.class);
	private final H2Database        database = new H2Database(mockDbQuerier);
	
	@Test
	public void createTableShouldExecuteDropAndCreateTableStatements() throws H2DatabaseAccessException, SQLException {
		expect(mockDbQuerier.execute("DROP TABLE IF EXISTS FAMILIES;")).andReturn(null);
		expect(mockDbQuerier.execute("CREATE TABLE FAMILIES(ID INT, NAME VARCHAR(255), PRIMARY KEY(ID));")).andReturn(null);
						
		replay(mockDbQuerier);
		
		
		assertEquals(new H2Table(mockDbQuerier, "families"), database.createTable("families", new H2Column("id", Type.INT), new H2Column("name", Type.STRING)));
		
		verify(mockDbQuerier);
	}
	
	@Test
	public void createTableShouldGenerateCompositePrimaryKey() throws H2DatabaseAccessException, SQLException {
		expect(mockDbQuerier.execute("DROP TABLE IF EXISTS FAMILIES;")).andReturn(null);
		expect(mockDbQuerier.execute("CREATE TABLE FAMILIES(ID INT, NAME VARCHAR(255), PRIMARY KEY(ID,NAME));")).andReturn(null);
						
		replay(mockDbQuerier);
		
		
		assertEquals(new H2Table(mockDbQuerier, "families"), database.createTable("families", Arrays.asList(new H2Column("id", Type.INT), new H2Column("name", Type.STRING))));
		
		verify(mockDbQuerier);
	}
	
	@Test
	public void dropAllTablesShouldGenerateDropAllStatement() throws H2DatabaseAccessException, SQLException {
		expect(mockDbQuerier.execute("DROP ALL OBJECTS;")).andReturn(null);
						
		replay(mockDbQuerier);
		
		
		database.dropAllTables();
		
		verify(mockDbQuerier);
	}
}
