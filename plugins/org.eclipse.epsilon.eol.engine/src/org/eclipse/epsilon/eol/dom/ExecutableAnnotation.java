package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ExecutableAnnotation extends Annotation {
	
	protected Expression expression = null;
	
	@Override
	public void build() {
		super.build();
		name = getFirstChild().getText();
		expression = (Expression) getSecondChild();
	}
	
	@Override
	public boolean hasValue() {
		return expression != null;
	}
	
	public Object getValue(IEolContext context) throws EolRuntimeException {
		return context.getExecutorFactory().executeAST(expression, context);
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		expression.compile(context);
	}
	
}
