package org.eclipse.epsilon.eol.dom;

public class IntegerLiteral extends LiteralExpression {
	
	protected Number value;
	
	@Override
	public void build() {
		super.build();
		String text = "";
		if (getText().endsWith("l")) {
			text = getText().substring(0, getText().length() - 1);
			value = Long.parseLong(text);
		}
		else {
			value = Integer.parseInt(getText());
		}
	}
	
	public Number getValue() {
		return value;
	}
	
}
