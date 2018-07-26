/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.util;

import java.util.Comparator;

public class OrderComparator implements Comparator<Object> {

	public OrderComparator() {
		super();
	}
	
	public int compare(Object arg0, Object arg1) {
		if (arg0 == null || arg1 == null) return 1;
		if (arg0.equals(arg1)) return 0;
		else return 1;
	}
	
}
