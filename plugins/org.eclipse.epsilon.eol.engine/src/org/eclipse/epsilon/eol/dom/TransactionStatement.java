package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.epsilon.common.module.IModule;
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
	
	protected List<NameExpression> modelNames = new ArrayList<>();
	protected StatementBlock body = null;
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		for (AST modelNameAst : AstUtil.getChildren(cst, EolParser.NAME)) {
			modelNames.add((NameExpression) module.createAst(modelNameAst, this));
		}
		body = (StatementBlock) module.createAst(AstUtil.getChild(cst, EolParser.BLOCK), this);
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		
		List<IModel> models = new ArrayList<>();
		
		if (modelNames.size() > 0) {
			for (NameExpression modelNameAst : modelNames) {
				IModel model = context.getModelRepository().getModelByName(modelNameAst.getName());
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
			Object result = context.getExecutorFactory().execute(body, context);
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
	
	public List<NameExpression> getModelNames() {
		return modelNames;
	}
	
	public void setModelNames(List<NameExpression> modelNames) {
		this.modelNames = modelNames;
	}
	
	public StatementBlock getBody() {
		return body;
	}
	
	public void setBody(StatementBlock body) {
		this.body = body;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		// TODO Auto-generated method stub
	}
	
}
