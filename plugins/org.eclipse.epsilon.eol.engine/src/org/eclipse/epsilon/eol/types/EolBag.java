/*******************************************************************************
 * Copyright (c) 2012-2019 The University of York, Antonio García-Domínguez.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - add type parameter and serial version UID
 *     Sina Madani - hashCode, equals
 ******************************************************************************/
package org.eclipse.epsilon.eol.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
	public boolean equals(Object obj) {
		if (!(obj instanceof EolBag)) return false;
		EolBag<?> other = (EolBag<?>) obj;
		return Objects.equals(wrapped, other.wrapped);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(wrapped.hashCode());
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" "+wrapped.toString();
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
	
	@Override
	public void forEach(Consumer<? super T> action) {
		wrapped.forEach(action);
	}
	
	@Override
	public boolean removeIf(Predicate<? super T> filter) {
		return wrapped.removeIf(filter);
	}
	
	@Override
	public Stream<T> parallelStream() {
		return wrapped.parallelStream();
	}
	
	@Override
	public Stream<T> stream() {
		return wrapped.stream();
	}
	
	@Override
	public Spliterator<T> spliterator() {
		return wrapped.spliterator();
	}
}
