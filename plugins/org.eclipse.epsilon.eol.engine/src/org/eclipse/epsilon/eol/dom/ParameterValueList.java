package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ParameterValueList extends AbstractExecutableModuleElement {
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		AST parameterAst = getFirstChild();
		ArrayList<Object> parameters = new ArrayList<Object>();
		
		while (parameterAst != null){
			parameters.add(context.getExecutorFactory().executeAST(parameterAst, context));
			parameterAst = parameterAst.getNextSibling();
		}
		return parameters;
	}
	
}
