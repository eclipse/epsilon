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
import java.util.Iterator;
import java.util.LinkedList;

public class H2Table {
	
	private final H2DatabaseQuerier querier;
	private final String name;
	
	public H2Table(H2DatabaseQuerier querier, String name) {
		this.querier = querier;
		this.name    = name.toUpperCase();
	}
	
	public void createIndex(String columnName) throws H2DatabaseAccessException {
		try {
			querier.execute("CREATE INDEX " + name + columnName + "INDEX ON " + name + "(" + columnName + ");");
						
		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not drop all tables in H2 database at: " + querier, e);
		}
	}
	
	public void insertRow(H2Value... values) throws H2DatabaseAccessException {
		try {
			final Object[] parameters = new Object[values.length];
	 		String valuesSql = "", columnsSql = "";
			int index = 0;
			
			for (Iterator<H2Value> iterator = Arrays.asList(values).iterator(); iterator.hasNext(); index++) {
				final H2Value value = iterator.next();
				
				parameters[index] = value.value;
				columnsSql += value.columnName;
				valuesSql  += "?";
				
				if (iterator.hasNext()) {
					columnsSql += ",";
					valuesSql  += ",";
				}
			}
			
			querier.execute("INSERT INTO " + name + "(" + columnsSql + ") VALUES(" + valuesSql + ");", parameters);
					
		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not insert values into '" + name + "' in H2 database at: " + querier, e);
		
		}
	}
	
	public void deleteAll() throws H2DatabaseAccessException {
		try {
			querier.execute("DELETE FROM " + name + ";");
					
		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not delete values from '" + name + "' in H2 database at: " + querier, e);
		}
	}
	
	public void deleteBy(H2Value key) throws H2DatabaseAccessException {
		try {
			querier.execute("DELETE FROM " + name + " WHERE " + key.columnName + "=?;", key.value);
					
		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not delete values from '" + name + "' in H2 database at: " + querier, e);
		}
	}
	
	public void updateBy(H2Value key, H2Value... updatedValues) throws H2DatabaseAccessException {
		if (updatedValues.length == 0)
			throw new IllegalArgumentException("At least one updatedValue must be specified.");
		
		try {
			final Object[] parameters = new Object[updatedValues.length+1];
 			String updatesSql = "";
 			int index = 0;
			
 			for (Iterator<H2Value> iterator = Arrays.asList(updatedValues).iterator(); iterator.hasNext(); index++) {
				final H2Value value = iterator.next();
				
				parameters[index] = value.value;
				updatesSql += value.columnName + "=?";
				
				if (iterator.hasNext()) {
					updatesSql  += ", ";
				}
			}
 			
 			parameters[parameters.length-1] = key.value;
 			querier.execute("UPDATE " + name + " SET " + updatesSql + " WHERE " + key.columnName + "=?;", parameters);
							
		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not delete values from '" + name + "' in H2 database at: " + querier, e);
		}
	}
	
	public Collection<H2Row> findBy(H2Value key) throws H2DatabaseAccessException {
		try {
			return querier.execute("SELECT * FROM " + name + " WHERE " + key.columnName + "=?;", key.value.toString());

		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not find values by " + key + " from '" + name + "' in H2 database at: " + querier, e);
		}
	}
	
	public Collection<Object> findBy(H2Value key, String columnName) throws H2DatabaseAccessException {
		try {
			final Collection<Object> results = new LinkedList<>();
			
			for (H2Row row : querier.execute("SELECT " + columnName.toUpperCase() + " FROM " + name + " WHERE " + key.columnName + "=?;", key.value.toString())) {
				results.add(row.getValue(columnName.toUpperCase()));
			}
			
			return results;

		} catch (SQLException e) {
			throw new H2DatabaseAccessException("Could not find values by " + key + " from '" + name + "' in H2 database at: " + querier, e);
		}
	}
	
	
	@Override
	public String toString() {
		return querier.toString() + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof H2Table))
			return false;
		
		final H2Table other = (H2Table)obj;
		
		return this.name.equals(other.name) &&
		       this.querier.equals(other.querier);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + querier.hashCode();
	}
}
