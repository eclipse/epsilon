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
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * A {@link Deque} wrapper which supports <code>null</code> values
 * using a constant wrapper in place of null elements. This is suitable as
 * a more efficient replacement for {@link java.util.LinkedList}, when
 * the {@linkplain java.util.List} interface is not needed.
 * 
 * @author Sina Madani
 * @since 1.6
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class NullSupportingDeque<E> implements Deque<E> {
	
	protected static final Object NULL = new Object();
	
	protected final Deque<Object> delegate;
	
	protected Object replaceWithNull(Object o) {
		return o == null ? NULL : o;
	}
	
	protected E convertToNull(Object e) {
		return e == NULL ? null : (E) e;
	}
	
	public NullSupportingDeque(Deque<Object> delegate) {
		Objects.requireNonNull(this.delegate = delegate);
	}

	
	@Override
	public void addFirst(E e) {
		delegate.addFirst(replaceWithNull(e));
	}
	
	@Override
	public void addLast(E e) {
		delegate.addLast(replaceWithNull(e));
	}
	
	@Override
	public E pollFirst() {
		return convertToNull(delegate.pollFirst());
	}
	
	@Override
	public E pollLast() {
		return convertToNull(delegate.pollLast());
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
		return convertToNull(delegate.removeFirst());
	}
	
	@Override
	public E removeLast() {
		return convertToNull(delegate.removeLast());
	}
	
	@Override
	public boolean removeFirstOccurrence(Object o) {
		return delegate.removeFirstOccurrence(replaceWithNull(o));
	}
	
	@Override
	public boolean removeLastOccurrence(Object o) {
		return delegate.removeLastOccurrence(replaceWithNull(o));
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
		return delegate.offerFirst(replaceWithNull(e));
	}

	@Override
	public boolean offerLast(Object e) {
		return delegate.offerLast(replaceWithNull(e));
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
		return delegate.add(replaceWithNull(e));
	}

	@Override
	public boolean offer(Object e) {
		return delegate.offer(replaceWithNull(e));
	}

	@Override
	public E remove() {
		return convertToNull(delegate.remove());
	}

	@Override
	public E poll() {
		return convertToNull(delegate.poll());
	}

	@Override
	public E element() {
		return convertToNull(delegate.element());
	}

	@Override
	public E peek() {
		return convertToNull(delegate.peek());
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return delegate.addAll(c);
	}

	@Override
	public void push(Object e) {
		delegate.push(replaceWithNull(e));
	}

	@Override
	public E pop() {
		return convertToNull(delegate.pop());
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return delegate.containsAll(c);
	}

	@Override
	public boolean remove(Object o) {
		return delegate.remove(replaceWithNull(o));
	}

	@Override
	public boolean contains(Object o) {
		return delegate.contains(replaceWithNull(o));
	}

	@Override
	public int size() {
		return delegate.size();
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
