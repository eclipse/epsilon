package org.eclipse.epsilon.egl.util;

import static org.eclipse.epsilon.egl.util.StringUtil.normalizeNewlines;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStringUtil {

	@Test
	public void normaliseNewlineShouldNotChangeStringWithoutNewlines() {
		assertEquals("foo", normalizeNewlines("foo"));
	}
	
	@Test
	public void normaliseNewlineShouldReplaceWindowsNewLineWithUnixNewLine() {
		assertEquals("foo\nbar", normalizeNewlines("foo\r\nbar"));
	}
	
	@Test
	public void normaliseNewlineShouldReplaceOldMacOsNewLineWithUnixNewLine() {
		assertEquals("foo\nbar", normalizeNewlines("foo\rbar"));
	}
	
	@Test
	public void normaliseNewlineShouldReplaceAllNewLinesWithUnixNewLines() {
		assertEquals("foo\nbar\nbaz\nbaaz", normalizeNewlines("foo\r\nbar\rbaz\nbaaz"));
	}
}
