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
package org.eclipse.epsilon.dt.exeed;

import java.util.ArrayList;

public class UniqueArrayList extends ArrayList {
	
	@Override
	public void add(int index, Object element) {
		if (!contains(element)) {
			super.add(index, element);
		}
	}
	
	@Override
	public boolean add(Object o) {
		if (!contains(o)) {
			return super.add(o);
		}
		return false;
	}
	
}
