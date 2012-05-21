/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - add support for Java generics
 ******************************************************************************/
package org.eclipse.epsilon.dt.exeed;

import java.util.ArrayList;

public class UniqueArrayList<T> extends ArrayList<T> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void add(int index, T element) {
		if (!contains(element)) {
			super.add(index, element);
		}
	}
	
	@Override
	public boolean add(T o) {
		if (!contains(o)) {
			return super.add(o);
		}
		return false;
	}
	
}
