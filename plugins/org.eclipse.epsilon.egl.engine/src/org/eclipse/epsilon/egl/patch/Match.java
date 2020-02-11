package org.eclipse.epsilon.egl.patch;

public class Match {
	
	protected TextBlock block;
	protected int startLine;
	protected int endLine;
	protected Patch patch;
	
	public Match(TextBlock block, int startLine, int endLine, Patch patch) {
		super();
		this.block = block;
		this.startLine = startLine;
		this.endLine = endLine;
		this.patch = patch;
	}

	public TextBlock getBlock() {
		return block;
	}

	public void setBlock(TextBlock block) {
		this.block = block;
	}

	public int getStartLine() {
		return startLine;
	}

	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public Patch getPatch() {
		return patch;
	}

	public void setPatch(Patch patch) {
		this.patch = patch;
	}
	
}
