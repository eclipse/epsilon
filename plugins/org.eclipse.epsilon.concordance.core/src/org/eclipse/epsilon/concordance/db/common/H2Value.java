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

public class H2Value {

	public final String columnName;
	public final Object value;
	
	public H2Value(String columnName, Object value) {
		this.columnName = columnName.toUpperCase();
		this.value      = value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof H2Value))
			return false;
		
		final H2Value other = (H2Value)o;

		return this.columnName.equals(other.columnName) &&
		       this.value.equals(other.value);
	}
	
	@Override
	public int hashCode() {
		return columnName.hashCode() + value.hashCode();
	}
	
	@Override
	public String toString() {
		return "<" + columnName + "=" + value + ">";
	}
}
