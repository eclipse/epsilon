package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

public class VariableDeclaration extends TypeInitialiser {
	
	protected List<Expression> parameters = new ArrayList<Expression>();
	protected String name = null;
	protected boolean instantiate;
	protected TypeExpression typeExpression = null;
	
	@Override
	public void build() {
		super.build();
		name = getFirstChild().getText();
		instantiate = getText().equalsIgnoreCase("new");
		typeExpression = (TypeExpression) getSecondChild();
		if (typeExpression != null) {
			AST parametersAst = typeExpression.getNextSibling();
			if (parametersAst != null) {
				for (AST parameterAst : parametersAst.getChildren()) {
					parameters.add((Expression) parameterAst);
				}
			}
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		
		EolType variableType = null;
		if (typeExpression == null){ // No type defined
			variableType = EolAnyType.Instance;
		}
		else { // Type defined
			variableType = (EolType) context.getExecutorFactory().executeAST(typeExpression, context);
		}
		
		//TODO : Add try-catch and support for EolInstantiationExceptions
		Object newInstance = initialiseType(variableType, parameters, context, instantiate);
		
		Variable variable = new Variable(name, newInstance, variableType);
		context.getFrameStack().put(variable);
		return variable;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isInstantiate() {
		return instantiate;
	}
	
	public void setInstantiate(boolean instantiate) {
		this.instantiate = instantiate;
	}
	
	public TypeExpression getTypeExpression() {
		return typeExpression;
	}
	
	public void setTypeExpression(TypeExpression typeExpression) {
		this.typeExpression = typeExpression;
	}
	
}
