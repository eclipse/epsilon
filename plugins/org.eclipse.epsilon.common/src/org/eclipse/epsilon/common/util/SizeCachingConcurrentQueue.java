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
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * A {@link ConcurrentLinkedQueue} wrapper which supports <code>null</code> values
 * using a constant wrapper in place of null elements. This implementation caches
 * the size and updates it when structurally modified to avoid the issue outlined
 * in <a href="https://www.javaspecialists.eu/archive/Issue261.html">Java Specialists Issue 261</a>.
 * Note that null elements are not supported during iteration: clients must call the
 * {@link #convertToNull(Object)} method to obtain null values, otherwise a ClassCastException
 * will occur if attempting to iterate over this collection when null values are present.
 * 
 * @author Sina Madani
 * @since 1.6
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class SizeCachingConcurrentQueue<E> extends ConcurrentLinkedQueue<E> {
	
	private static final long serialVersionUID = 1123011197588756957L;
	
	protected static final Object NULL = new Object();
	
	protected static final Object replaceWithNull(Object o) {
		return o == null ? NULL : o;
	}
	
	public static final <T> T convertToNull(Object o) {
		return o == NULL ? null : (T) o;
	}
	
	protected final AtomicInteger size = new AtomicInteger();
	
	public SizeCachingConcurrentQueue() {
		super();
	}
	
	public SizeCachingConcurrentQueue(Collection<? extends E> initial) {
		super(initial);
		size.set(initial.size());
	}
	
	@Override
	public E peek() {
		return convertToNull(super.peek());
	}
	
	@Override
	public E poll() {
		E res = convertToNull(super.poll());
		size.decrementAndGet();
		return res;
	}
	
	// Compiler-pleasing magic
	protected final Consumer<? extends E> offerSuper = super::offer;
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean offer(E e) {
		((Consumer) offerSuper).accept(replaceWithNull(e));
		size.incrementAndGet();
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean res = false;
		if (c != null && c != this) {
			Collection filtered = c.stream()
				.map(SizeCachingConcurrentQueue::replaceWithNull)
				.collect(Collectors.toList());
			
			res = super.addAll(filtered);
			size.getAndAdd(filtered.size());
		}
		return res;
	}
	
	@Override
	public int size() {
		return size.get();
	}
}
