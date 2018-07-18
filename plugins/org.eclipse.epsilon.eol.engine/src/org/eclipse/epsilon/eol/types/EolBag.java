/*******************************************************************************
 * Copyright (c) 2012-2015 The University of York, Antonio García-Domínguez.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - add type parameter and serial version UID
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EolBag<T> implements Collection<T> {

	public EolBag() {
		//CollectionAnnotator.getInstance().annotate(this, AnnotatedCollectionType.Bag);
	}
	
	protected List<T> wrapped = new ArrayList<T>();
	
	public boolean add(T e) {
		return wrapped.add(e);
	}

	public boolean addAll(Collection<? extends T> c) {
		return wrapped.addAll(c);
	}

	public void clear() {
		wrapped.clear();
	}

	public boolean contains(Object o) {
		return wrapped.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return wrapped.containsAll(c);
	}

	public boolean isEmpty() {
		return wrapped.isEmpty();
	}

	public Iterator<T> iterator() {
		return wrapped.iterator();
	}

	public boolean remove(Object o) {
		return wrapped.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return wrapped.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return wrapped.retainAll(c);
	}

	public int size() {
		return wrapped.size();
	}

	public Object[] toArray() {
		return wrapped.toArray();
	}

	@SuppressWarnings("unchecked")
	public Object[] toArray(Object[] a) {
		return wrapped.toArray(a);
	}

}
