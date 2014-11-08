package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolType;

public class NewInstanceExpression extends TypeInitialiser {

	protected TypeExpression instanceType;
	protected List<Expression> parameters = new ArrayList<Expression>();
	
	@Override
	public void build() {
		super.build();
		instanceType = (TypeExpression) getFirstChild();
		if (getChildCount() == 2) {
			for (AST parameterAst : getSecondChild().getChildren()) {
				parameters.add((Expression) parameterAst);
			}
		}
	}
	
	public TypeExpression getInstanceType() {
		return instanceType;
	}
	
	public List<Expression> getParameters() {
		return parameters;
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		AST typeAst = getFirstChild();
		
		Object result = context.getExecutorFactory().executeAST(typeAst, context);
		
		if (!(result instanceof EolType)) throw new EolRuntimeException("Expected type, found " + result, typeAst);
		
		AST parametersAst = typeAst.getNextSibling();
		return initialiseType((EolType) result, parametersAst, context, true);
		
	}
}
