/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
		int i=0;
		while (it.hasNext()) {
			arr[i] = it.next(); i++;
		}
		return arr;
	}
	
	public List<E> toList(E[] arr) {
		if (arr == null) return null;
		ArrayList<E> list = new ArrayList<E>();
		for (E e : arr) {
			list.add(e);
		}
		return list;
	}
}
