/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.commons.util;

import java.util.Comparator;

public class OrderComparator implements Comparator {

	public OrderComparator() {
		super();
	}
	
	public int compare(Object arg0, Object arg1) {
		if (arg0 == null || arg1 == null) return 1;
		if (arg0.equals(arg1)) return 0;
		else return 1;
	}
	
}
