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

public class H2Column {

	public final String name;
	public final Type type;
	
	public H2Column(String name, Type type) {
		this.name = name.toUpperCase();
		this.type = type;
	}
	
	@Override
	public String toString() {
		return name + " : " + type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof H2Column))
			return false;
		
		final H2Column other = (H2Column)obj;
		
		return this.name.equals(other.name) &&
		       this.type.equals(other.type);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + type.hashCode();
	}
	
	
	public static enum Type {
		INT("INT"),
		STRING("VARCHAR(255)");
		
		private final String sql;
		
		private Type(String sql) {
			this.sql = sql;
		}
		
		@Override
		public String toString() {
			return sql;
		}
	}
}
