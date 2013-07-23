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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class H2DatabaseQuerier {

	private final String databasePath;
	
	public H2DatabaseQuerier(String databasePath) throws H2DatabaseAccessException {
		this.databasePath = databasePath;
		loadH2Driver();
	}

	private static void loadH2Driver() throws H2DatabaseAccessException {
		try {
			Class.forName("org.h2.Driver");
			
		} catch (ClassNotFoundException e) {
			throw new H2DatabaseAccessException("Could not load H2 driver.", e);
		}
	}
	
	private Connection conn = null;
	
	public Collection<H2Row> execute(String sql, Object... parameters) throws SQLException {
		openConnection();
				
		final PreparedStatement statement = prepareStatement(sql, parameters);
		final Collection<H2Row> results = new LinkedList<H2Row>();
		
		if (statement.execute() && !statement.isClosed()) {
			final ResultSet resultSet = statement.getResultSet();
		
			if (resultSet != null) {
				while (resultSet.next()) {
					final List<H2Value> values = new LinkedList<H2Value>();
					
					for (int columnIndex = 1; columnIndex <= resultSet.getMetaData().getColumnCount(); columnIndex++) {
						values.add(new H2Value(resultSet.getMetaData().getColumnName(columnIndex), resultSet.getObject(columnIndex)));
					}
					
					results.add(new H2Row(values));
				}
			}
		}
		
//		System.err.println("EXECUTED: " + sql);
//		if (!results.isEmpty())
//			System.err.println("RETURNED: " + results);
		
		return results;
	}

	private PreparedStatement prepareStatement(String sql, Object... parameters) throws SQLException {
		final PreparedStatement statement = conn.prepareStatement(sql);
		statement.setQueryTimeout(15);
		
		for (int parameterIndex = 0; parameterIndex < parameters.length; parameterIndex++) {
			statement.setObject(parameterIndex+1, parameters[parameterIndex]);
		}
		
		return statement;
	}
	
	public boolean hasTableNamed(String tableName) throws SQLException {
		openConnection();
		
		final ResultSet tables = conn.getMetaData().getTables(null, null, tableName.toUpperCase(), null);
					
		if (!tables.next())
			return false;
		
		return tableName.toUpperCase().equals(tables.getString("TABLE_NAME"));
	}
	
	private void openConnection() throws SQLException {
		if (conn == null) {
//			System.err.println("CONN OPENED");
			conn = DriverManager.getConnection("jdbc:h2:" + databasePath, "sa", "");
		}
	}
	
	public void dispose() throws SQLException {
		closeConnection();
	}
	
	private void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
//			System.err.println("CONN CLOSED");
		}
	}
	
	@Override
	public String toString() {
		return databasePath;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof H2DatabaseQuerier))
			return false;
		
		return this.databasePath.equals(((H2DatabaseQuerier)obj).databasePath);
	}
	
	@Override
	public int hashCode() {
		return databasePath.hashCode();
	}
}
