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
package org.eclipse.epsilon.hutn.xmi.util.stack;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.xmi.util.Stack;
import org.junit.Before;
import org.junit.Test;

public class Peek {
private Stack<String> stack;
	
	@Before
	public void setup() {
		 stack = new Stack<String>();
	}
	
	@Test
	public void simple() {
		stack.push("foo");
		assertEquals("foo", stack.peek());
		
		stack.pop();
		assertEquals(null, stack.peek());
	}
	
	@Test
	public void empty() {
		assertEquals(null, stack.peek());
	}
	
	@Test
	public void lifo() {
		stack.push("foo");
		stack.push("bar");
		stack.push("baz");
		assertEquals("baz", stack.peek());
		
		stack.pop();
		assertEquals("bar", stack.peek());
		
		stack.pop();
		assertEquals("foo", stack.peek());
		
		stack.pop();
		assertEquals(null, stack.peek());
	}
}
