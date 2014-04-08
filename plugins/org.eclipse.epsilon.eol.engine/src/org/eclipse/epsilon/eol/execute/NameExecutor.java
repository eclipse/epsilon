/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.EolTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.EolUndefinedVariableException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolType;


public class NameExecutor extends AbstractExecutor{

	
	public Object execute(AST ast, IEolContext context, boolean returnVariable) throws EolRuntimeException {
		String name = ast.getText();
		
		Variable variable = null;
		FrameStack scope = context.getFrameStack();
		
		if (ast.getFirstChild() != null && ast.getFirstChild().getType() == EolParser.PARAMETERS) {
			return new ContextlessOperationExecutor().execute(ast, context);
		}

		//if (scope.contains(name)){
		variable = scope.get(name);
		
		if (variable != null && variable.getDeprecationInfo() != null) {
			context.getWarningStream().println("Warning: " + variable.getDeprecationInfo().getMessage());
		}
		//}
		
		
		// First look for a model element type
		// if the name contains a !
		if (variable == null) {
			if (name.indexOf("!") > -1){
				variable = getModelElementType(name, context);
			}
		}
		
		// Then look for a model with that name
		if (variable == null) {
			try {
				
				IModel model = context.getModelRepository().getModelByName(name);
			
				if (model != null)
				variable = Variable.createReadOnlyVariable(name,model);
			}
			catch (EolModelNotFoundException mex) {
				// Ignore this exception and go for a 
				// variable in the scope
			}
		}
		
		if (variable == null) {
			try {
				AbstractExecutor typeExecutor = context.getExecutorFactory().getExecutorFor(EolParser.TYPE);
				EolType type = (EolType) typeExecutor.execute(ast, context);
				if (type != null) {
					variable = Variable.createReadOnlyVariable(type.getName(), type);
				}
			}
			catch (EolTypeNotFoundException ex) {}
		}
		
		if (variable == null) throw new EolUndefinedVariableException(name, ast);

		if (returnVariable){
			return variable;
		}
		else {
			return variable.getValue();
		}

	}
	
	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		return execute(ast,context,false);
	}
	
	public Variable getModelElementType(String name, IEolContext context) {
		try {
			EolModelElementType type = null;
			type = EolModelElementType.forName(name,context);
			return Variable.createReadOnlyVariable(name,type);
		}
		catch (EolRuntimeException rex){
			return null;
			// Ignore this exception... We just did not
			// find such a model element type and we can
			// proceed
		}
	}
	
}
