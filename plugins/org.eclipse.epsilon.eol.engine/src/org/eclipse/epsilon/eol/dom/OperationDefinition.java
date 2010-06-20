package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

public class OperationDefinition extends DomElement {
	
	protected String name;
	protected String contextType;
	protected String returnType;
	protected ArrayList<VariableDeclarationExpression> parameters = new ArrayList<VariableDeclarationExpression>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContextType() {
		return contextType;
	}
	
	public void setContextType(String contextType) {
		this.contextType = contextType;
	}
	
	public ArrayList<VariableDeclarationExpression> getParameters() {
		return parameters;
	}
	
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	public String getReturnType() {
		return returnType;
	}
	
}
