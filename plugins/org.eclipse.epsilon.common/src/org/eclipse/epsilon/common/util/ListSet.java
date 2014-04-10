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
package org.eclipse.epsilon.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListSet<E> implements Set<E> {
	
	protected ArrayList<E> storage = new ArrayList<E>();

	public boolean add(E e) {
		if (contains(e)) {
			return false;
		}
		else {
			return storage.add(e);
		}
	}

	public boolean addAll(Collection<? extends E> c) {
		boolean result = c.size() > 0;
		for (E e : c) {
			result = result & add(e);
		}
		return result;
	}

	public void clear() {
		storage.clear();
	}

	public boolean contains(Object o) {
		for (E e : storage) {
			if (e == o || e.equals(o)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		boolean result = c.size() > 0;
		Iterator<E> it = storage.iterator();
		while (it.hasNext()) {
			E e = it.next();
			result = result & contains(e);
		}
		return result;
	}

	public boolean isEmpty() {
		return storage.isEmpty();
	}

	public Iterator<E> iterator() {
		return storage.iterator();
	}

	public boolean remove(Object o) {
		return storage.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return storage.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return storage.retainAll(c);
	}

	public int size() {
		return storage.size();
	}

	public Object[] toArray() {
		return storage.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return storage.toArray(a);
	}
	
	public List<E> getList() {
		return storage;
	}
	
}
