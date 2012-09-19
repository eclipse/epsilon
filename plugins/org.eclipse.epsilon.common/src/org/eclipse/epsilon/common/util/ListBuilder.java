/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.util;

import java.util.ArrayList;

public class ListBuilder<E> {
	
	public ArrayList<E> build(E...es) {
		ArrayList<E> list = new ArrayList<E>();
		for (E e : es) {
			list.add(e);
		}
		return list;
	}
	
}
