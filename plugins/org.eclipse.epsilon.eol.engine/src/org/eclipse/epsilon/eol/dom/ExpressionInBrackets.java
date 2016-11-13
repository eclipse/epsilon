package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ExpressionInBrackets extends Expression {
	
	protected Expression expression;
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		expression = (Expression) module.createAst(cst.getFirstChild(), this);
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return context.getExecutorFactory().execute(expression, context);
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		expression.compile(context);
		resolvedType = expression.getResolvedType();
	}
}
