/*******************************************************************************
 * Copyright (c) 2012-2015 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - add type parameter and serial version UID
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EolBag<T> implements Collection<T> {

	protected Collection<T> wrapped;
	
	public EolBag() {
		wrapped = new ArrayList<>();
		//CollectionAnnotator.getInstance().annotate(this, AnnotatedCollectionType.Bag);
	}
	
	public EolBag(int initialCapacity) {
		wrapped = new ArrayList<>(initialCapacity);
	}
	
	@Override
	public boolean add(T e) {
		return wrapped.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return wrapped.addAll(c);
	}

	@Override
	public void clear() {
		wrapped.clear();
	}

	@Override
	public boolean contains(Object o) {
		return wrapped.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return wrapped.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return wrapped.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return wrapped.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return wrapped.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return wrapped.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return wrapped.retainAll(c);
	}

	@Override
	public int size() {
		return wrapped.size();
	}

	@Override
	public Object[] toArray() {
		return wrapped.toArray();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object[] toArray(Object[] a) {
		return wrapped.toArray(a);
	}
}
