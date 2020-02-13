package org.eclipse.epsilon.egl.patch;

public class Line {
	
	protected LineType type;
	protected String text;
	protected int number;
	
	public Line(LineType type, String text, int number) {
		this.text = text;
		this.number = number;
		this.type = type;
	}
	
	public String getTrimmedText() {
		return getText().trim();
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
		
	public LineType getType() {
		return type;
	}
	
	public void setType(LineType type) {
		this.type = type;
	}
	
	public boolean is(LineType type) {
		return this.type == type;
	}
	
	public boolean isNot(LineType type) {
		return this.type != type;
	}
	
	/*
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		Line other = (Line) obj;
		return other.getType() == getType() && other.getText().contentEquals(getText());
	}*/
	
	@Override
	public String toString() {
		return number + ": " + type + " " + text;
	}
	
}
