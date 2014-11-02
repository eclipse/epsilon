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
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.parse.EolParser;


public abstract class AssignExecutor extends AbstractExecutor{

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		AST varAst = ast.getFirstChild();
		AST valueAst = varAst.getNextSibling();
		
		// Executing the varAst can return either a Variable
		// or a SetterMethod with one argument (set method)
		// Executing the valueAst will return an object
		
		Object varAstResult = null;
		
		if (varAst.getType() == EolParser.POINT){
			PointExecutor pointExecutor = (PointExecutor) context.getExecutorFactory().getExecutorFor(EolParser.POINT);
			//pointExecutor.returnSetter = true;
			varAstResult = pointExecutor.execute(varAst, context, true);
		}
		else if (varAst.getType() == EolParser.NAME || varAst.getType() == EolParser.FEATURECALL){
			//NameExecutor nameExecutor = new NameExecutor();
			NameExecutor nameExecutor = (NameExecutor) context.getExecutorFactory().getExecutorFor(EolParser.NAME);
			varAstResult = nameExecutor.execute(varAst, context, true);
		}
		else {
			varAstResult = context.getExecutorFactory().executeAST(varAst, context);
		}
		
		Object valueAstResult = context.getExecutorFactory().executeAST(valueAst, context);
		
		if (varAstResult instanceof IPropertySetter){
			IPropertySetter setter = (IPropertySetter) varAstResult;
			try {
				Object value = getRhsEquivalent(setter.getObject(), valueAstResult, context);
				
				setter.invoke(value);
			}
			catch (EolRuntimeException ex){
				if (ex.getAst() == null) {
					ex.setAst(setter.getAst());
				}
				throw ex;
			}
		} else if (varAstResult instanceof Variable){
			Variable variable = (Variable) varAstResult;
			try {
				Object value = getRhsEquivalent(variable.getValue(), valueAstResult, context);
				variable.setValue(value, context);
			}
			catch (EolRuntimeException ex){
				ex.setAst(varAst);
				throw ex;
			}
		} else {
			throw new EolRuntimeException("Internall error. Expected either a SetterMethod or a Variable and got an " + varAstResult + "instead", ast);
		}
		
		return null;
		
	}
	
	public abstract Object getRhsEquivalent(Object source, Object value, IEolContext context) throws EolRuntimeException;
	
}
