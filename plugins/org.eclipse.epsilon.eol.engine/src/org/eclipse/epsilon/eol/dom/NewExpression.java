package org.eclipse.epsilon.eol.dom;

import java.util.Collection;

public class NewExpression extends Expression {
	
	protected TypeReference typeReference;
	protected Collection<Expression> arguments;
	
	public TypeReference getTypeReference() {
		return typeReference;
	}
	
	public void setTypeReference(TypeReference typeReference) {
		this.typeReference = typeReference;
	}
	
	public Collection<Expression> getArguments() {
		return arguments;
	}
	
}
