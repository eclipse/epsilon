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

/**
 * A {@link ConcurrentLinkedQueue} wrapper which supports <code>null</code> values
 * using a constant wrapper in place of null elements. This implementation is
 * synchronized for structural modifications and for querying of its size,
 * however iteration does not require synchronization.
 * 
 * @author Sina Madani
 * @since 1.6
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class NullSupportingConcurrentQueue<E> extends ConcurrentLinkedQueue<E> {
	
	private static final long serialVersionUID = 1123011197588756957L;
	
	protected static final Object NULL = new Object();
	
	protected final static Object replaceWithNull(Object o) {
		return o == null ? NULL : o;
	}
	
	protected static final <T> T convertToNull(Object o) {
		return o == NULL ? null : (T) o;
	}
	
	public NullSupportingConcurrentQueue() {
		super();
	}
	
	public NullSupportingConcurrentQueue(Collection<? extends E> initial) {
		if (initial != null) {
			super.addAll(initial);
		}
	}
	
	@Override
	public E peek() {
		return convertToNull(super.peek());
	}
	
	@Override
	public synchronized E poll() {
		return convertToNull(super.poll());
	}
	
	@Override
	public synchronized E remove() {
		return convertToNull(super.remove());
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean add(E e) {
		return ((ConcurrentLinkedQueue) this).offer(replaceWithNull(e));
	}
	
	@Override
	public synchronized boolean offer(E e) {
		return super.offer(e);
	}
	
	@Override
	public synchronized boolean addAll(Collection<? extends E> c) {
		return super.addAll(c);
	}
	
	@Override
	public synchronized int size() {
		return super.size();
	}
}
