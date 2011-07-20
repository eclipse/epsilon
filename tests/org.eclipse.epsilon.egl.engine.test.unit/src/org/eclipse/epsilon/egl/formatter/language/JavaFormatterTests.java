package org.eclipse.epsilon.egl.formatter.language;

import static org.junit.Assert.*;

import org.eclipse.epsilon.egl.formatter.language.JavaFormatter;
import org.junit.Test;

public class JavaFormatterTests {

	@Test
	public void formattingALineContainingOnlyWhitespaceDoesNothing() throws Exception {
		final String text = "\t";
		
		assertEquals(text, format(text));
	}

	private static String format(final String text) {
		return new JavaFormatter().format(text);
	}
}
