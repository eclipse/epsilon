package org.eclipse.epsilon.egl.patch;

public class LineFactory {
	
	public Line createLine(String text, int number) {
		if (text.trim().contentEquals("---")) {
			return new Line(LineType.REMOVE_WILDCARD, "", number);
		}
		else if (text.startsWith("-")) {
			return new Line(LineType.REMOVE, text.substring(1), number);
		}
		else if (text.startsWith("+")) {
			return new Line(LineType.INSERT, text.substring(1), number);
		}
		else if (text.startsWith("#")) {
			return new Line(LineType.COMMENT, text.substring(1), number);
		}
		else if (text.trim().contentEquals("...")) {
			return new Line(LineType.KEEP_WILDCARD, "", number);
		}
		else return new Line(LineType.REGULAR, text, number);
	}
	
}
