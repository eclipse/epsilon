package org.eclipse.epsilon.eol.dom;

public class VariableDeclarationExpression extends Expression {
	
	protected String name;
	protected String type;
	protected boolean create;
	
	public boolean isCreate() {
		return create;
	}
	
	public void setCreate(boolean create) {
		this.create = create;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
