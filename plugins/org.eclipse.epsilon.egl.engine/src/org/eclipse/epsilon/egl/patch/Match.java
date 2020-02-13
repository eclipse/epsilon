package org.eclipse.epsilon.egl.patch;

import java.util.List;
import java.util.Map;

public class Match {
	
	protected TextBlock block;
	protected Line startLine;
	protected Line endLine;
	protected Patch patch;
	protected LineMap lineMap;
	
	public Match(TextBlock block, Line startLine, Line endLine, Patch patch, LineMap lineMap) {
		super();
		this.block = block;
		this.startLine = startLine;
		this.endLine = endLine;
		this.patch = patch;
		this.lineMap = lineMap;
	}

	public TextBlock getBlock() {
		return block;
	}

	public void setBlock(TextBlock block) {
		this.block = block;
	}

	public Line getStartLine() {
		return startLine;
	}

	public void setStartLine(Line startLine) {
		this.startLine = startLine;
	}

	public Line getEndLine() {
		return endLine;
	}

	public void setEndLine(Line endLine) {
		this.endLine = endLine;
	}

	public Patch getPatch() {
		return patch;
	}

	public void setPatch(Patch patch) {
		this.patch = patch;
	}
	
	public LineMap getLineMap() {
		return lineMap;
	}
	
	public void setLineMap(LineMap lineMap) {
		this.lineMap = lineMap;
	}
	
}
