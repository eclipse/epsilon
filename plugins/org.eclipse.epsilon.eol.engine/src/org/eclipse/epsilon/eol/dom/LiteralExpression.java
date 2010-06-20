package org.eclipse.epsilon.eol.dom;

public class LiteralExpression extends Expression{
	
	protected String value;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
