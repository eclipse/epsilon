/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.output;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LineCounterTests {

	public static class WhenNewlineIsSingleChar extends CurrentLineNumberTests {
		@Override protected String getNewLine() {
			return "\n";
		}
	}
	
	public static class WhenNewlineIsTwoChars extends CurrentLineNumberTests {
		@Override protected String getNewLine() {
			return "\r\n";
		}
		
		@Test
		public void partialNewLineDoesNotContributeToCurrentLineNumber() {
			assertEquals(2, getCurrentLineNumberFor("abc" + getNewLine() + "def" + "\n" + "ghi" + "\r" + "jkl"));
		}
	}
	
	
	public static abstract class CurrentLineNumberTests {
	
		private final LineCounter counter = new LineCounter(getNewLine());
				
		protected abstract String getNewLine();

		@Test
		public void shouldBeDeterminedFromText() {
			assertEquals(2, getCurrentLineNumberFor("abc" + getNewLine() + "def"));
		}
		
		@Test
		public void shouldBeOneForBlankText() {
			assertEquals(1, getCurrentLineNumberFor(""));
		}
		
		@Test
		public void shouldCountANewLineAtTheEndOfTheText() {
			assertEquals(2, getCurrentLineNumberFor("abc" + getNewLine()));
		}
		
		@Test
		public void shouldCountBlankLinesAtTheEndOfTheText() {
			assertEquals(4, getCurrentLineNumberFor("abc" + getNewLine() + getNewLine() + getNewLine()));
		}
		
		@Test
		public void shouldCountBlankLinesInTheMiddleOfText() {
			assertEquals(4, getCurrentLineNumberFor("abc" + getNewLine() + getNewLine() + getNewLine() + "def"));
		}
	
		protected int getCurrentLineNumberFor(String text) {
			return counter.getCurrentLineNumberFor(text);
		}
	}
}
