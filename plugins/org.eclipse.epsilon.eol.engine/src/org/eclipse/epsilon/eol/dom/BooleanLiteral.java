package org.eclipse.epsilon.eol.dom;

public class BooleanLiteral extends LiteralExpression {
	
	protected boolean value;
	
	@Override
	public void build() {
		super.build();
		try {
			value = new Boolean(getText()).booleanValue();
		}
		catch (Exception ex){
			value = false;
		}
	}
	
	public boolean getValue() {
		return value;
	}
	
}
