package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolType;

public class NewInstanceExpression extends TypeInitialiser {

	protected TypeExpression typeExpression;
	protected List<Expression> parameterExpressions = new ArrayList<Expression>();
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		typeExpression = (TypeExpression) module.createAst(cst.getFirstChild(), this);
		if (cst.getChildCount() == 2) {
			for (AST parameterAst : cst.getSecondChild().getChildren()) {
				parameterExpressions.add((Expression) module.createAst(parameterAst, this));
			}
		}
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		Object result = context.getExecutorFactory().execute(typeExpression, context);
		
		if (!(result instanceof EolType)) throw new EolRuntimeException("Expected type, found " + result, typeExpression);
		
		return initialiseType((EolType) result, parameterExpressions, context, true);
		
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		typeExpression.compile(context);
		for (Expression parameterExpression : parameterExpressions) {
			parameterExpression.compile(context);
		}
		resolvedType = typeExpression.getResolvedType();
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
