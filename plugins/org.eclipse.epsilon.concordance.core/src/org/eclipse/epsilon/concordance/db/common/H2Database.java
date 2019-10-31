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

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class H2Database {

	private final H2DatabaseQuerier querier;
	
	public H2Database(String databasePath) throws H2DatabaseAccessException {
		this(new H2DatabaseQuerier(databasePath));
	}
	
	H2Database(H2DatabaseQuerier databaseManager) {
		this.querier = databaseManager;
	}
	
	public H2Table createTable(String tableName, H2Column primaryKey, H2Column... columns) throws H2DatabaseAccessException {
		return createTable(tableName, Collections.singleton(primaryKey), columns);
	}
	
	public H2Table createTable(String tableName, Collection<H2Column> primaryKeys, H2Column... columns) throws H2DatabaseAccessException {
		tableName = tableName.toUpperCase();
		
		try {
			querier.execute("DROP TABLE IF EXISTS " + tableName + ";");
			
			final Collection<H2Column> allColumns = new LinkedList<>(primaryKeys);
			allColumns.addAll(Arrays.asList(columns));
			
			
			String columnsSql = "";
			
			for (Iterator<H2Column> iterator = allColumns.iterator(); iterator.hasNext();) {
				final H2Column column = (H2Column)iterator.next();
				
				columnsSql += column.name + " " + column.type;
				
				if (iterator.hasNext()) {
					columnsSql += ", ";
				}
			}
			
			
			String primaryKeysSql = "";
			
			for (Iterator<H2Column> iterator = primaryKeys.iterator(); iterator.hasNext();) {
				final H2Column primaryKey = (H2Column)iterator.next();
				
				primaryKeysSql += primaryKey.name;
				
				if (iterator.hasNext()) {
					primaryKeysSql += ",";
				}
			}
						
			querier.execute("CREATE TABLE " + tableName + "(" + columnsSql + ", PRIMARY KEY(" + primaryKeysSql + "));");
		
			return new H2Table(querier, tableName);
			
		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not create a table with name '" + tableName + "' in H2 database at: " + querier, e);
		}
	}
	
	public void dropAllTables() throws H2DatabaseAccessException {
		try {
			querier.execute("DROP ALL OBJECTS;");
						
		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not drop all tables in H2 database at: " + querier, e);
		}
	}

	public boolean hasTableNamed(String tableName) throws H2DatabaseAccessException {
		try {
			return querier.hasTableNamed(tableName);
		
		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not check for table named '" + tableName + "' in H2 database at: " + querier, e);
		}
	}

	public H2Table getTableNamed(String tableName) throws H2DatabaseAccessException {
		if (!hasTableNamed(tableName)) {
			throw new IllegalArgumentException("The table named '" + tableName + "' does not exist.");
		}
		
		return new H2Table(querier, tableName);
	}
	
	public void dispose() throws H2DatabaseAccessException {
		try {
			querier.dispose();
		
		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not dispose H2 database at: " + querier, e);
		}
	}
}
