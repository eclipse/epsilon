package org.eclipse.epsilon.egl.formatter.language;

import static org.junit.Assert.*;

import org.junit.Test;

public class PromelaIfBlockFormatterTests {

	@Test
	public void indentsAfterADoubleColon() throws Exception {
		final String input = "if"        + '\n' +
		                     ":: a && b" + '\n' + 
		                     "c;";
		
		final String expected = "if"         + '\n' + 
		                         ":: a && b" + '\n' + 
		                        "\tc;";

		assertEquals(expected, format(input));
	}
	
	@Test
	public void indentationContinuesUntilNextDoubleColon() throws Exception {
		final String input = "if"        + '\n' + 
		                     ":: a && b" + '\n' + 
		                     "c;"        + '\n' +
		                     "d;"        + '\n' +
		                     ":: e || f";
		
		final String expected = "if"        + '\n' + 
		                        ":: a && b" + '\n' + 
		                        "\tc;"      + '\n' +
		                        "\td;"      + '\n' +
		                        ""          + '\n' +
		                        ":: e || f";

		assertEquals(expected, format(input));
	}
	
	@Test
	public void indentationContinuesUntilEndIfKeyword() throws Exception {
		final String input = "if"        + '\n' +
		                     ":: a && b" + '\n' + 
		                     "c;"        + '\n' +
		                     "d;"        + '\n' +
		                     "fi;";
		
		final String expected = "if"        + '\n' +
		                        ":: a && b" + '\n' + 
		                        "\tc;"      + '\n' +
		                        "\td;"      + '\n' +
		                        "fi;";

		assertEquals(expected, format(input));
	}
	
	@Test
	public void reducesIndentationAtNextDoubleColon() throws Exception {
		final String input = "if"        + '\n' +
		                     ":: a && b" + '\n' +
		                     "c;"        + '\n' +
		                     ":: d || e" + '\n' +
		                     "f;";
		
		final String expected = "if"        + '\n' +
		                        ":: a && b" + '\n' + 
		                        "\tc;"      + '\n' +
		                        ""          + '\n' +
		                        ":: d || e" + '\n' +
		                        "\tf;";

		assertEquals(expected, format(input));
	}
	
	@Test
	public void noIndentationUnlessInAnIfBlock() throws Exception {
		final String input = ":: a && b" + '\n' + 
		                     "c;"        + '\n' +
		                     ":: d || e" + '\n' +
		                     "f;";
		
		assertEquals(input, format(input));
	}

	private static String format(String text) {
		return new PromelaFormatter().format(text);
	}
}
