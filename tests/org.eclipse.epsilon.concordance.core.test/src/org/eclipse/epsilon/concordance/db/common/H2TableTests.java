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
package org.eclipse.epsilon.concordance.db.common;

import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.expect;
import static org.easymock.classextension.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Arrays;

import org.junit.Test;

public class H2TableTests {

	private final H2DatabaseQuerier mockDb = createMock("mockDb", H2DatabaseQuerier.class);
	private final H2Table           table  = new H2Table(mockDb, "families");

	
	@Test
	public void insertRowShouldExecuteInsertIntoStatement() throws H2DatabaseAccessException, SQLException {
		expect(mockDb.execute("INSERT INTO FAMILIES(ID,NAME) VALUES('123','Joe Bloggs');")).andReturn(null);
						
		replay(mockDb);
		
		
		table.insertRow(new H2Value("id", 123), new H2Value("name", "Joe Bloggs"));
		
		verify(mockDb);
	}
	
	@Test
	public void deleteAllShouldExecuteDeleteFromStatement() throws H2DatabaseAccessException, SQLException {
		expect(mockDb.execute("DELETE FROM FAMILIES;")).andReturn(null);
						
		replay(mockDb);
		
		
		table.deleteAll();
		
		verify(mockDb);
	}

	@Test
	public void deleteByShouldExecuteConditionalDeleteFromStatement() throws H2DatabaseAccessException, SQLException {
		expect(mockDb.execute("DELETE FROM FAMILIES WHERE ID='123';")).andReturn(null);
						
		replay(mockDb);
		
		
		table.deleteBy(new H2Value("id", 123));
		
		verify(mockDb);
	}
	
	@Test
	public void updateByShouldExecuteConditionalUpdateStatement() throws H2DatabaseAccessException, SQLException {
		expect(mockDb.execute("UPDATE FAMILIES SET ID='456', NAME='John Doe' WHERE ID='123';")).andReturn(null);
						
		replay(mockDb);
		
		
		table.updateBy(new H2Value("id", 123), new H2Value("id", 456), new H2Value("name", "John Doe"));
		
		verify(mockDb);
	}
	
	@Test
	public void findByShouldExecuteConditionalSelectStatement() throws H2DatabaseAccessException, SQLException {
		expect(mockDb.execute("SELECT * FROM FAMILIES WHERE ID='123';")).andReturn(null);
						
		replay(mockDb);
		
		
		table.findBy(new H2Value("id", 123));
		
		verify(mockDb);
	}
	
	@Test
	public void findByWithColumnNameShouldExecuteConditionalSelectStatementAndProcessResults() throws H2DatabaseAccessException, SQLException {
		expect(mockDb.execute("SELECT NAME FROM FAMILIES WHERE ID='123';"));
		expectLastCall().andReturn(Arrays.asList(new H2Row(new H2Value("name", "John Doe")),
		                                         new H2Row(new H2Value("name", "Joe Bloggs"))));
						
		replay(mockDb);
		
		
		assertEquals(Arrays.asList("John Doe", "Joe Bloggs"), table.findBy(new H2Value("id", 123), "name"));
		
		verify(mockDb);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateByShouldThrowExceptionWhenNoUpdatedValuesAreSpecified() throws H2DatabaseAccessException, SQLException {
		table.updateBy(new H2Value("id", 123));
	}
}
