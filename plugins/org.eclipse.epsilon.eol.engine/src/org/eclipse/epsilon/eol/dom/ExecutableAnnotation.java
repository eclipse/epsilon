package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ExecutableAnnotation extends Annotation {
	
	//TODO: Turning this to an expression causes cast exceptions in tests
	protected AST expression = null;
	
	@Override
	public void build() {
		super.build();
		name = getFirstChild().getText();
		expression = getFirstChild().getNextSibling();
	}
	
	@Override
	public boolean hasValue() {
		return expression != null;
	}
	
	public Object getValue(IEolContext context) throws EolRuntimeException {
		return context.getExecutorFactory().executeAST(expression, context);
	}
	
}
