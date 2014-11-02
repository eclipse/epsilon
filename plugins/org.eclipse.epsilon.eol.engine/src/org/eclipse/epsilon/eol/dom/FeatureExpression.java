package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

public class FeatureExpression extends Expression {
	
	protected boolean operation;
	protected Parameter iterator;
	protected List<Expression> parameters = new ArrayList<Expression>();
	
	@Override
	public void build() {
		super.build();
		/*
		operation = hasChildren();
		if (getChildCount() == 1) {
			for (AST parameterAst : getFirstChild().getChildren()) {
				try {
				parameters.add((Expression) parameterAst);
				}
				catch (Exception ex) {
					System.err.println(this);
				}
			}
		}
		else if (getChildCount() == 2) {
			iterator = (Parameter) getFirstChild();
			for (AST parameterAst : getSecondChild().getChildren()) {
				try {
				parameters.add((Expression) parameterAst);
				}
				catch (Exception ex) {
					System.err.println(this);
				}
			}
		}*/
	}
	
	public boolean isOperation() {
		return operation;
	}
	
	public boolean isProperty() {
		return !isOperation();
	}
	
	public List<Expression> getParameters() {
		return parameters;
	}
	
	public Parameter getIterator() {
		return iterator;
	}
	
	@Override
	public String getDebugInfo() {
		return isProperty() + ":" + getParameters().size();
	}
}
