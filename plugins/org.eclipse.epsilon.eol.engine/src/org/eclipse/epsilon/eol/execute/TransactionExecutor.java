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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolAbortTransactionException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.parse.EolParser;


public class TransactionExecutor extends AbstractExecutor {

	@Override
	public Object execute(AST ast, IEolContext context)
			throws EolRuntimeException {
		
		List<IModel> models = new ArrayList<IModel>();
		Collection<AST> modelNamesAsts = AstUtil.getChildren(ast, EolParser.NAME);
		
		if (modelNamesAsts.size() > 0) {
			for (AST modelNameAst : modelNamesAsts) {
				IModel model = context.getModelRepository().getModelByName(modelNameAst.getText());
				models.add(model);
			}
		}
		else {
			models.addAll(context.getModelRepository().getModels());
		}
		
		for (IModel model : models) {
			model.getTransactionSupport().startTransaction();
		}
		
		try {
			context.getFrameStack().enter(FrameType.UNPROTECTED, ast);
			context.getExecutorFactory().executeAST(AstUtil.getChild(ast, EolParser.BLOCK), context);
			for (IModel model : models) {
				model.getTransactionSupport().commitTransaction();
			}
			context.getFrameStack().leave(ast);
		}
		catch (EolRuntimeException ex) {
			context.getFrameStack().leave(ast);
			for (IModel model : models) {
				model.getTransactionSupport().rollbackTransaction();
			}
			models.clear();
			if (!(ex instanceof EolAbortTransactionException)) {
				throw ex;
			}
		}
		
		return null;
	}

}
