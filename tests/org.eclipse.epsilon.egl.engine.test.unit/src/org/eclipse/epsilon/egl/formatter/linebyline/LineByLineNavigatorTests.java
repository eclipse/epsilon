package org.eclipse.epsilon.egl.formatter.linebyline;

import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LineByLineNavigatorTests {

	private final String threeLinesOfText = "foo" + NEWLINE + "bar" + NEWLINE + "baz";
	private final LineByLineNavigator<Line> navigator = new LineByLineNavigator<Line>(threeLinesOfText, new PlainLineFactory());
	
	@Test
	public void iteratesOverLines() {
		final StringBuilder joined = new StringBuilder();
		
		while (navigator.hasMoreLines()) {
			joined.append(navigator.getCurrentLine().getText());
			navigator.moveToNextLine();
		}
	
		assertEquals("foobarbaz", joined.toString());
	}
	
	@Test
	public void getTextReflectsChangesToCurrentLine() {
		while (navigator.hasMoreLines()) {
			navigator.getCurrentLine().addSuffix("!");
			navigator.moveToNextLine();
		}
	
		assertEquals("foo!" + NEWLINE + "bar!" + NEWLINE + "baz!", navigator.getText());
	}
	
	@Test
	public void getTextReflectsChangesToPreviousLine() {
		while (navigator.hasMoreLines()) {
			navigator.moveToNextLine();
			navigator.getPreviousLine().addSuffix("!");
		}
	
		assertEquals("foo!" + NEWLINE + "bar!" + NEWLINE + "baz!", navigator.getText());
	}
	
	@Test
	public void getTextContainsInsertedLines() {
		while (navigator.hasMoreLines()) {
			navigator.insertBeforeCurrentLine(new Line("---"));
			navigator.moveToNextLine();
		}
	
		assertEquals("---" + NEWLINE +
		             "foo" + NEWLINE +
		             "---" + NEWLINE +
		             "bar" + NEWLINE +
		             "---" + NEWLINE +
		             "baz", navigator.getText());
	}
	
	@Test
	public void getTextContainsJoinedLines() {
		joinFirstTwoLines();
		navigator.joinCurrentToPrevious("|");
	
		assertEquals("foo|bar|baz", navigator.getText());
	}
	
	@Test
	public void joiningLinesMovesCurrent() {
		final String textOfThirdLine = "baz";
		
		joinFirstTwoLines();
		
		assertEquals(textOfThirdLine, navigator.getCurrentLine().getText());
	}

	private void joinFirstTwoLines() {
		navigator.moveToNextLine();
		navigator.joinCurrentToPrevious("|");
	}
	
	
	private static class PlainLineFactory implements LineFactory<Line> {

		@Override
		public Line createLine(String rawLine) {
			return new Line(rawLine);
		}
		
	}
}
