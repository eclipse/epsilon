package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolType;

public class NewInstanceExpression extends TypeInitialiser {

	protected TypeExpression typeExpression;
	protected List<Expression> parameterExpressions = new ArrayList<Expression>();
	
	@Override
	public void build() {
		super.build();
		typeExpression = (TypeExpression) getFirstChild();
		if (getChildCount() == 2) {
			for (AST parameterAst : getSecondChild().getChildren()) {
				parameterExpressions.add((Expression) parameterAst);
			}
		}
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		Object result = context.getExecutorFactory().executeAST(typeExpression, context);
		
		if (!(result instanceof EolType)) throw new EolRuntimeException("Expected type, found " + result, typeExpression);
		
		return initialiseType((EolType) result, parameterExpressions, context, true);
		
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		// TODO Auto-generated method stub	
	}
	
	public TypeExpression getTypeExpression() {
		return typeExpression;
	}
	
	public void setTypeExpression(TypeExpression typeExpression) {
		this.typeExpression = typeExpression;
	}
	
	public List<Expression> getParameterExpressions() {
		return parameterExpressions;
	}
	
}
