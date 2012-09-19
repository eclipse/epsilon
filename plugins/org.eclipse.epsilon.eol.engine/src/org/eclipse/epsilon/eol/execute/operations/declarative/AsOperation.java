/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolAnyType;

public class AsOperation extends AbstractOperation {

//	public static void main(String[] args) throws Exception {
//		EolModule module = new EolModule();
//		module.parse("if (1.as(foo).println() > 0) { ('x'+foo).println(); }");
//		module.execute();
//	}
	
	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException{
		AST varAst = ast.getFirstChild().getFirstChild();
		if (isNameAst(varAst)) {
			String varName = varAst.getText();
			Variable var = new Variable(varName, obj, EolAnyType.Instance);
			context.getFrameStack().put(var);
			return obj;
		}
		else {
			throw new EolIllegalOperationParametersException("as", ast);
		}
	}

	@Override
	public boolean isOverridable() {
		return false;
	}
	
	protected boolean isNameAst(AST ast) {
		return ast!= null && ast.getType() == EolParser.FEATURECALL &&
			ast.getChildren().isEmpty();
	}
	
}
