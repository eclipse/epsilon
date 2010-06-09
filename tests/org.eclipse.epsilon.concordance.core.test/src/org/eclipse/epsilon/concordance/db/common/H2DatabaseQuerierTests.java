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

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class H2DatabaseQuerierTests {

	private File databaseFile;
	private H2DatabaseQuerier querier;
	
	@Before
	public void setupDatabase() throws IOException, H2DatabaseAccessException {
		databaseFile = File.createTempFile("h2_database_querier_test_db", "h2");
		querier = new H2DatabaseQuerier(databaseFile.getAbsolutePath());
	}
	
	@After
	public void deleteDatabaseFiles() throws SQLException {
		for (File fileInDatabaseDirectory : databaseFile.getParentFile().listFiles()) {
			if (fileInDatabaseDirectory.getName().startsWith(databaseFile.getName())) {
				fileInDatabaseDirectory.delete();
			}
		}
		
		querier.dispose();
	}
	
	
	@Test
	public void shouldExecuteAValidQueryWithoutThrowingAnException() throws SQLException {
		querier.execute("CREATE TABLE FAMILIES (NAME VARCHAR(255) PRIMARY KEY);");
		
		assertEquals(true, querier.hasTableNamed("FAMILIES"));
	}
	
	@Test(expected=SQLException.class)
	public void shouldThrowAnExceptionForMalformedQuery() throws SQLException {
		querier.execute("CREATE FAMILIES (NAME VARCHAR(255) PRIMARY KEY);");
	}
	
	@Test
	public void shouldReturnARowForEachResult() throws SQLException {
		querier.execute("CREATE TABLE FAMILIES (NAME VARCHAR(255) PRIMARY KEY);");
		
		querier.execute("INSERT INTO FAMILIES (NAME) VALUES ('John Doe');");
		querier.execute("INSERT INTO FAMILIES (NAME) VALUES ('Joe Bloggs');");
		
		assertEquals(Arrays.asList(new H2Row(new H2Value("NAME", "John Doe")),
		                           new H2Row(new H2Value("NAME", "Joe Bloggs"))),
		             querier.execute("SELECT * FROM FAMILIES"));
	}
	
	@Test
	public void shouldReturnAValueForEachSelectedColumn() throws SQLException {
		querier.execute("CREATE TABLE FAMILIES (NAME VARCHAR(255) PRIMARY KEY, AGE INT);");
		
		querier.execute("INSERT INTO FAMILIES (NAME, AGE) VALUES ('John Doe', 42);");
		
		assertEquals(Arrays.asList(new H2Row(new H2Value("NAME", "John Doe"),
		                                     new H2Value("AGE",  42))),
		             querier.execute("SELECT * FROM FAMILIES"));
	}
	
	@Test
	public void shouldExecuteDeleteQuery() throws SQLException {
		querier.execute("CREATE TABLE FAMILIES (NAME VARCHAR(255) PRIMARY KEY, AGE INT);");
		
		querier.execute("INSERT INTO FAMILIES (NAME, AGE) VALUES ('John Doe', 42);");
		querier.execute("INSERT INTO FAMILIES (NAME, AGE) VALUES ('Jane Doe', 15);");
		querier.execute("INSERT INTO FAMILIES (NAME, AGE) VALUES ('Joe Bloggs', 15);");
		
		querier.execute("DELETE FROM FAMILIES WHERE AGE=15;");
		
		assertEquals(Arrays.asList(new H2Row(new H2Value("NAME", "John Doe"),
		                                     new H2Value("AGE",  42))),
		             querier.execute("SELECT * FROM FAMILIES"));
	}
	
	@Test
	public void hasTableNamedShouldReturnFalseForATableThatDoesNotExist() throws SQLException {
		assertEquals(false, querier.hasTableNamed("FAMILIES"));
	}
}
