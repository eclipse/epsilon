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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ColumnCounterTests.WhenNewlineIsSingleChar.class, ColumnCounterTests.WhenNewlineIsTwoChars.class})
public class ColumnCounterTests {

	public static class WhenNewlineIsSingleChar extends CurrentColumnNumberTests {
		@Override protected String getNewLine() {
			return "\n";
		}
	}
	
	public static class WhenNewlineIsTwoChars extends CurrentColumnNumberTests {
		@Override protected String getNewLine() {
			return "\r\n";
		}
	}
	
	public abstract static class CurrentColumnNumberTests {
		final ColumnCounter counter = new ColumnCounter(getNewLine());
	
		protected abstract String getNewLine();

		@Test
		public void shouldBeDeterminedFromText() {
			assertEquals(4, getCurrentColumnNumberFrom("abc"));
		}

		@Test
		public void shouldBeOneWhenThereIsNoText() {
			assertEquals(1, getCurrentColumnNumberFrom(""));
		}
		
		@Test
		public void shouldNotIncludeTextOnLinesOtherThanTheLast() throws Exception {
			assertEquals(3, getCurrentColumnNumberFrom("abc" + getNewLine() + "de"));
		}
		
		@Test
		public void shouldBeOneWhenThereIsNoTextOnTheCurrentLine() {
			assertEquals(1, getCurrentColumnNumberFrom("abc" + getNewLine()));
		}
		
		@Test
		public void shouldBeOneAfterSeveralBlankLines() {
			assertEquals(1, getCurrentColumnNumberFrom("abc" + getNewLine() + getNewLine() + getNewLine()));
		}
		
		@Test
		public void shouldCountNumberOfColumnsInLastLineAfterSeveralBlankLines() {
			assertEquals(3, getCurrentColumnNumberFrom("abc" + getNewLine() + getNewLine() + "de"));
		}
		
		@Test
		public void aTabShouldOccupyOneColumn() {
			assertEquals(2, getCurrentColumnNumberFrom("\t"));
		}

		protected int getCurrentColumnNumberFrom(String text) {
			return counter.getCurrentColumnNumberFrom(text);
		}
	}
}
