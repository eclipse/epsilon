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

public class PushAndPop {

	private Stack<String> stack;
	
	@Before
	public void setup() {
		 stack = new Stack<String>();
	}
	
	@Test
	public void simple() {
		stack.push("foo");
		assertEquals("foo", stack.pop());
	}
	
	@Test
	public void lifo() {
		stack.push("foo");
		stack.push("bar");
		stack.push("baz");
		
		assertEquals("baz", stack.pop());
		assertEquals("bar", stack.pop());
		assertEquals("foo", stack.pop());
	}
	
	@Test
	public void duplicatesAllowed() {
		final String foo = "foo";
		
		stack.push(foo);
		stack.push("bar");
		stack.push(foo);
		
		assertEquals(foo,   stack.pop());
		assertEquals("bar", stack.pop());
		assertEquals(foo,   stack.pop());
	}
	
	@Test(expected=IllegalStateException.class)
	public void popEmptyStack() {
		stack.pop();
	}
}
