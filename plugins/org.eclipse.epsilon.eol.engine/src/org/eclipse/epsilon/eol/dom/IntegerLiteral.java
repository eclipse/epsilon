package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class IntegerLiteral extends LiteralExpression implements IExecutableModuleElement {
	
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
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return getValue();
	}
}
