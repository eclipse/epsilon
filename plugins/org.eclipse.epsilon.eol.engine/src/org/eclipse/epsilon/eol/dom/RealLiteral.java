package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class RealLiteral extends LiteralExpression implements IExecutableModuleElement {
	
	protected Number value;
	
	@Override
	public void build() {
		super.build();
		
		String text = "";
		boolean doublePrecision = false;
		if (getText().endsWith("f")) {
			text = getText().substring(0, getText().length() - 1);
			doublePrecision = false;
		}
		else if (getText().endsWith("d")) {
			text = getText().substring(0, getText().length() - 1);
			doublePrecision = true;		
		}
		else {
			text = getText();
			doublePrecision = false;			
		}
		
		if (doublePrecision) {
			value = new Double(text);
		}
		else {
			value = new Float(text);
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
