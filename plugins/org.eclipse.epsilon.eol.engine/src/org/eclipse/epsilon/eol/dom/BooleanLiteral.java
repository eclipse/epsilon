package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

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

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return getValue();
	}
	
}
