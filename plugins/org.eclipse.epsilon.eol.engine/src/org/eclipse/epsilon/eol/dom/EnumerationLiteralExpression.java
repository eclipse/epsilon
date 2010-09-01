package org.eclipse.epsilon.eol.dom;

public class EnumerationLiteralExpression extends Expression {

	protected String model;
	protected String enumeration;
	protected String literal;
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getEnumeration() {
		return enumeration;
	}
	
	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}
	
	public String getLiteral() {
		return literal;
	}
	
	public void setLiteral(String literal) {
		this.literal = literal;
	}
	
	
	
}
