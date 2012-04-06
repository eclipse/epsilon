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
package org.eclipse.epsilon.eol.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.eol.types.CollectionAnnotator.AnnotatedCollectionType;

public class EolBag implements Collection{
	
	public EolBag() {
		CollectionAnnotator.getInstance().annotate(this, AnnotatedCollectionType.Bag);
	}
	
	protected List wrapped = new ArrayList();
	
	public boolean add(Object e) {
		return wrapped.add(e);
	}

	public boolean addAll(Collection c) {
		return wrapped.addAll(c);
	}

	public void clear() {
		wrapped.clear();
	}

	public boolean contains(Object o) {
		return wrapped.contains(o);
	}

	public boolean containsAll(Collection c) {
		return wrapped.containsAll(c);
	}

	public boolean isEmpty() {
		return wrapped.isEmpty();
	}

	public Iterator iterator() {
		return wrapped.iterator();
	}

	public boolean remove(Object o) {
		return wrapped.remove(o);
	}

	public boolean removeAll(Collection c) {
		return wrapped.removeAll(c);
	}

	public boolean retainAll(Collection c) {
		return wrapped.retainAll(c);
	}

	public int size() {
		return wrapped.size();
	}

	public Object[] toArray() {
		return wrapped.toArray();
	}

	public Object[] toArray(Object[] a) {
		return wrapped.toArray(a);
	}

}
