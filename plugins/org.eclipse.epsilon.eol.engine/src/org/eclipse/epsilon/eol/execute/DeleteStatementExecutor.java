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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotAModelElementException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.IModel;


public class DeleteStatementExecutor extends AbstractExecutor {

	public DeleteStatementExecutor() {
		super();
	}

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException {
		Object instance = null;
		if (ast.getFirstChild() != null){
			instance = context.getExecutorFactory().executeAST(ast.getFirstChild(), context);
		}
		
		//if (context.getModelRepository().isModelElement(instance)) {
		IModel model = context.getModelRepository().getOwningModel(instance);
			
		if (model != null) {
			model.deleteElement(instance);
		}	
		else {
			throw new EolNotAModelElementException(ast.getFirstChild(), instance, context);
		}
		
		return null;
	}

}
