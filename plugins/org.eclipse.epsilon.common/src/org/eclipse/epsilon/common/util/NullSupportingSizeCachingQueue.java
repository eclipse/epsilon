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
 * using a constant wrapper in place of null elements. This is suitable as
 * a high-performance concurrent collection. The size of this is cached to avoid traversal.
 * 
 * @author Sina Madani
 * @since 1.6
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class NullSupportingSizeCachingQueue<E> extends ConcurrentLinkedQueue<E> {
	
	private static final long serialVersionUID = -7959402550712221977L;

	protected static final Object NULL = new Object();
	
	protected int sizeCache;
	
	protected final static Object replaceWithNull(Object o) {
		return o == null ? NULL : o;
	}
	
	protected final E convertToNull(Object e) {
		return e == NULL ? null : (E) e;
	}
	
	public NullSupportingSizeCachingQueue(Collection<? extends E> initial) {
		if (initial != null) {
			addAll(initial);
		}
	}
	
	@Override
	public int size() {
		return sizeCache;
	}
	
	@Override
	public E peek() {
		return convertToNull(super.peek());
	}
	
	@Override
	public E poll() {
		E e = convertToNull(super.poll());
		if (e == null) sizeCache = 0;
		else --sizeCache;
		return e;
	}
	
	@Override
	public E remove() {
		return convertToNull(super.remove());
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean add(E e) {
		return ((ConcurrentLinkedQueue) this).offer(replaceWithNull(e));
	}
	
	@Override
	public boolean offer(E e) {
		super.offer(e);
		++sizeCache;
		return true;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (super.addAll(c) && c != null) {
			sizeCache += c.size();
			return true;
		}
		return false;
	}
}
