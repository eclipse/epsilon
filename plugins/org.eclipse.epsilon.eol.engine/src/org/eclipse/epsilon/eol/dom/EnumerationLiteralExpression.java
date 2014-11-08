package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EnumerationLiteralExpression extends LiteralExpression {

	protected String enumerationLiteral;
	
	@Override
	public void build() {
		super.build();
		enumerationLiteral = getText();
	}
	
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return context.getModelRepository().getEnumerationValue(enumerationLiteral);
	}

}
