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

import java.util.Arrays;
import java.util.Collection;

public class H2Row {

	private final Collection<H2Value> values;
	
	public H2Row(H2Value... values) {
		this(Arrays.asList(values));
	}

	public H2Row(Collection<H2Value> values) {
		this.values = values;
	}

	public Object getValue(String columnName) {
		for (H2Value value : values) {
			if (value.columnName.equals(columnName.toUpperCase())) {
				return value.value;
			}
		}
		
		return null;
	}

	
	@Override
	public String toString() {
		return "H2Row: " + values;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof H2Row))
			return false;
		
		return this.values.equals(((H2Row)obj).values);
	}
	
	@Override
	public int hashCode() {
		return values.hashCode();
	}
}
