package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;

public class NewInstanceExpression extends Expression {

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
}
