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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayUtil<E> {
	
	public E[] toArray(Collection<E> c, Class<?> arrayType) {
		if (c == null) return null;
		
		@SuppressWarnings("unchecked")
		E[] arr = (E[]) Array.newInstance(arrayType, c.size());
		Iterator<E> it = c.iterator();
		for (int i = 0; it.hasNext(); i++) {
			arr[i] = it.next();
		}
		return arr;
	}
	
	public List<E> toList(E[] arr) {
		if (arr == null) return null;
		ArrayList<E> list = new ArrayList<>(arr.length);
		for (E e : arr) {
			list.add(e);
		}
		return list;
	}
}
