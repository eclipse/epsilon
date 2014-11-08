package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

public class VariableDeclaration extends TypeInitialiser {
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		AST variableNameAst = getFirstChild();
		AST variableTypeAst = variableNameAst.getNextSibling();
		AST parametersAst = null;
		if (variableTypeAst != null) {
			parametersAst = variableTypeAst.getNextSibling();
		}
		
		String variableName = variableNameAst.getText();
		
		EolType variableType = null;
		if (variableTypeAst == null){ // No type defined
			variableType = EolAnyType.Instance;
		}
		else { // Type defined
			variableType = (EolType) context.getExecutorFactory().executeAST(variableTypeAst, context);
		}
		
		//TODO : Add try-catch and support for EolInstantiationExceptions
		Object newInstance = initialiseType(variableType, parametersAst, context, getText().equalsIgnoreCase("new"));
		
		Variable variable = new Variable(variableName, newInstance, variableType);
		context.getFrameStack().put(variable);
		return variable;
		
	}
	
}
