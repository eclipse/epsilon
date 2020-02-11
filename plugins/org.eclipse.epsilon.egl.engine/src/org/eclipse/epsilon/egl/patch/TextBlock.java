package org.eclipse.epsilon.egl.patch;

import java.util.ArrayList;
import java.util.List;

public class TextBlock {
	
	protected List<Line> lines = new ArrayList<Line>();
	
	public TextBlock(String... lines) {
		for (int i=0; i<lines.length; i++) {
			this.lines.add(new Line(LineType.REGULAR, lines[i], i+1));
		}
	}
	
	public List<Line> getLines() {
		return lines;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TextBlock)) return false;
		TextBlock other = (TextBlock) obj;
		if (other.getLines().size() != this.getLines().size()) return false;
		for (int i=0;i<getLines().size();i++) {
			if (!other.getLines().get(i).equals(this.getLines().get(i))) return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return getLines().toString();
	}
	
}
