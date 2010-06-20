package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

public class MethodCallExpression extends FeatureCallExpression {
	
	protected ArrayList<Expression> arguments = new ArrayList<Expression>();
	protected String method;
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getMethod() {
		return method;
	}
	
	public ArrayList<Expression> getArguments() {
		return arguments;
	}
	
}
