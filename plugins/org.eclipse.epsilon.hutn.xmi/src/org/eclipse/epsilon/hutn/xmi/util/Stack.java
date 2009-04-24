/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.util;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

	private final List<T> stack = new LinkedList<T>();
	
	public T peek() {
		if (stack.isEmpty())
			return null;
		
		return stack.get(0);
	}
	
	public T pop() {
		if (peek() == null)
			throw new IllegalStateException("Cannot pop from an empty stack.");
		
		final T value = peek();
		stack.remove(0);
		return value;
	}
	
	public void push(T element) {
		stack.add(0, element);
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}
}
