/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.common.util;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * A {@link ConcurrentLinkedDeque} wrapper which supports <code>null</code> values
 * using a constant wrapper in place of null elements. This is suitable as
 * a more efficient replacement for {@link java.util.LinkedList}, when
 * the {@linkplain java.util.List} interface is not needed. The size
 * of this is cached to avoid traversal.
 * 
 * @author Sina Madani
 * @since 1.6
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class NullSupportingSizeCachingConcurrentDeque<E> implements Deque<E> {
	
	protected static final Object NULL = new Object();
	
	protected final ConcurrentLinkedDeque<Object> delegate;
	protected volatile int sizeCache;
	
	protected Object replaceWithNull(Object o) {
		return o == null ? NULL : o;
	}
	
	protected E convertToNull(Object e) {
		return e == NULL ? null : (E) e;
	}
	
	public NullSupportingSizeCachingConcurrentDeque(ConcurrentLinkedDeque<Object> delegate) {
		Objects.requireNonNull(this.delegate = delegate);
		this.sizeCache = delegate.size();
	}
	
	@Override
	public int size() {
		return sizeCache;
	}
	
	@Override
	public void addFirst(E e) {
		delegate.addFirst(replaceWithNull(e));
		++sizeCache;
	}
	
	@Override
	public void addLast(E e) {
		delegate.addLast(replaceWithNull(e));
		++sizeCache;
	}
	
	@Override
	public E pollFirst() {
		E e = convertToNull(delegate.pollFirst());
		if (e != null) --sizeCache;
		return e;
	}
	
	@Override
	public E pollLast() {
		E e = convertToNull(delegate.pollLast());
		if (e != null) --sizeCache;
		return e;
	}
	
	@Override
	public E peekFirst() {
		return convertToNull(delegate.peekFirst());
	}
	
	@Override
	public E peekLast() {
		return convertToNull(delegate.peekLast());
	}
	
	@Override
	public E getFirst() {
		return convertToNull(delegate.getFirst());
	}
	
	@Override
	public E getLast() {
		return convertToNull(delegate.getLast());
	}
	
	@Override
	public E removeFirst() {
		E e = convertToNull(delegate.removeFirst());
		--sizeCache;
		return e;
	}
	
	@Override
	public E removeLast() {
		E e = convertToNull(delegate.removeLast());
		--sizeCache;
		return e;
	}
	
	@Override
	public boolean removeFirstOccurrence(Object o) {
		if (delegate.removeFirstOccurrence(replaceWithNull(o))) {
			--sizeCache;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean removeLastOccurrence(Object o) {
		if (delegate.removeLastOccurrence(replaceWithNull(o))) {
			--sizeCache;
			return true;
		}
		return false;
	}

	@Override
	public boolean removeIf(Predicate<? super E> filter) {
		return delegate.removeIf((Predicate<? super Object>) filter);
	}

	@Override
	public Spliterator<E> spliterator() {
		return (Spliterator<E>) delegate.spliterator();
	}

	@Override
	public Stream<E> stream() {
		return (Stream<E>) delegate.stream();
	}

	@Override
	public Stream<E> parallelStream() {
		return (Stream<E>) delegate.parallelStream();
	}

	@Override
	public void forEach(Consumer<? super E> action) {
		delegate.forEach((Consumer<? super Object>) action);
	}

	@Override
	public boolean offerFirst(Object e) {
		delegate.offerFirst(replaceWithNull(e));
		++sizeCache;
		return true;
	}

	@Override
	public boolean offerLast(Object e) {
		delegate.offerLast(replaceWithNull(e));
		++sizeCache;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	@Override
	public Object[] toArray() {
		return delegate.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return delegate.toArray(a);
	}

	@Override
	public boolean add(Object e) {
		return offerLast(e);
	}

	@Override
	public boolean offer(Object e) {
		return offerLast(e);
	}

	@Override
	public E remove() {
		return removeFirst();
	}

	@Override
	public E poll() {
		return pollFirst();
	}

	@Override
	public E element() {
		return getFirst();
	}

	@Override
	public E peek() {
		return peekFirst();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (delegate.addAll(c)) {
			sizeCache += c.size();
			return true;
		}
		return false;
	}

	@Override
	public void push(Object e) {
		delegate.push(replaceWithNull(e));
		++sizeCache;
	}

	@Override
	public E pop() {
		return removeFirst();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return delegate.containsAll(c);
	}

	@Override
	public boolean remove(Object o) {
		if (delegate.remove(replaceWithNull(o))) {
			--sizeCache;
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return delegate.contains(replaceWithNull(o));
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return delegate.removeAll(c);
	}

	@Override
	public Iterator<E> iterator() {
		return (Iterator<E>) delegate.iterator();
	}

	@Override
	public Iterator<E> descendingIterator() {
		return (Iterator<E>) delegate.descendingIterator();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return delegate.retainAll(c);
	}

	@Override
	public void clear() {
		delegate.clear();
		sizeCache = 0;
	}

	@Override
	public boolean equals(Object o) {
		return delegate.equals(o);
	}

	@Override
	public int hashCode() {
		return delegate.hashCode();
	}
	
	@Override
	public String toString() {
		return delegate.toString();
	}
}
