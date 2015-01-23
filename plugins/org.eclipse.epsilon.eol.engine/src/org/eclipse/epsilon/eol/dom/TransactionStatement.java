package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolAbortTransactionException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.parse.EolParser;

public class TransactionStatement extends Statement {
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		List<IModel> models = new ArrayList<IModel>();
		Collection<AST> modelNamesAsts = AstUtil.getChildren(this, EolParser.NAME);
		
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
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
			Object result = context.getExecutorFactory().executeAST(AstUtil.getChild(this, EolParser.BLOCK), context);
			context.getFrameStack().leaveLocal(this);
			
			if (result instanceof Return) {
				for (IModel model : models) {
					model.getTransactionSupport().rollbackTransaction();
				}
				models.clear();
				return result;
			}
			else {
				for (IModel model : models) {
					model.getTransactionSupport().commitTransaction();
				}
			}
		}
		catch (EolRuntimeException ex) {
			context.getFrameStack().leaveLocal(this);
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

	@Override
	public void compile(EolCompilationContext context) {
		// TODO Auto-generated method stub
	}
	
}
