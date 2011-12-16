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
import java.util.HashMap;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolTerminationException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;
import org.eclipse.epsilon.eol.execute.control.DefaultExecutionController;
import org.eclipse.epsilon.eol.execute.control.ExecutionController;
import org.eclipse.epsilon.eol.parse.EolParser;


public class ExecutorFactory {
	
	protected ExecutionController executionController = null;
	protected HashMap<Integer, AbstractExecutor> executorCache = new HashMap<Integer, AbstractExecutor>();
	protected AST activeAst = null;
	protected ArrayList<IExecutionListener> executionListeners = new ArrayList<IExecutionListener>();
	
	public ExecutorFactory(){
		executionController = new DefaultExecutionController();
		cacheExecutors();
	}
	
	public void addExecutionListener(IExecutionListener listener) {
		executionListeners.add(listener);
	}
	
	public boolean removeExecutionListener(IExecutionListener listener) {
		return executionListeners.remove(listener);
	}
	
	public ExecutionController getExecutionController() {
		return executionController;
	}

	public void setExecutionController(ExecutionController executionController) {
		this.executionController = executionController;
	}
	
	protected void cacheExecutors() {
		executorCache.put(EolParser.OPERATOR, new OperatorExecutor());	
		executorCache.put(EolParser.INT,new IntegerExecutor());
		executorCache.put(EolParser.STRING, new StringExecutor());
		executorCache.put(EolParser.ASSIGNMENT, new DefaultAssignExecutor());
		executorCache.put(EolParser.SPECIAL_ASSIGNMENT, new DefaultAssignExecutor());
		executorCache.put(EolParser.POINT, new PointExecutor());
		executorCache.put(EolParser.NAME, new NameExecutor());
		executorCache.put(EolParser.FEATURECALL, new NameExecutor());
		executorCache.put(EolParser.BLOCK, new StatementBlockExecutor());
		executorCache.put(EolParser.IF, new IfStatementExecutor());
		executorCache.put(EolParser.SWITCH, new SwitchStatementExecutor());
		executorCache.put(EolParser.BOOLEAN, new BooleanExecutor());
		executorCache.put(EolParser.ARROW, new ArrowExecutor());
		executorCache.put(EolParser.VAR, new VarStatementExecutor());
		executorCache.put(EolParser.COLLECTION, new CollectionExecutor());
		executorCache.put(EolParser.MAP, new MapExecutor());
		executorCache.put(EolParser.FLOAT, new RealExecutor());
		executorCache.put(EolParser.FOR, new ForStatementExecutor());
		executorCache.put(EolParser.PARAMLIST, new FormalParameterListExecutor());
		executorCache.put(EolParser.EOLMODULE, new EolModuleExecutor());
		executorCache.put(EolParser.PARAMETERS, new ParametersExecutor());
		executorCache.put(EolParser.TYPE, new TypeExecutor());
		//executorCache.put(EolParser.TYPEINIT, new TypeExecutor());
		executorCache.put(EolParser.RETURN, new ReturnStatementExecutor());
		executorCache.put(EolParser.ITEMSELECTOR, new ItemSelectorExecutor());
		//executorCache.put(EolParser.ASYNC, new AsyncStatementExecutor());
		executorCache.put(EolParser.BREAK, new BreakStatementExecutor());
		executorCache.put(EolParser.BREAKALL, new BreakAllStatementExecutor());
		executorCache.put(EolParser.ENUMERATION_VALUE, new EnumerationValueExecutor());
		executorCache.put(EolParser.CONTINUE, new ContinueExecutor());
		executorCache.put(EolParser.WHILE, new WhileStatementExecutor());
		executorCache.put(EolParser.THROW, new ThrowStatementExecutor());	
		executorCache.put(EolParser.DELETE, new DeleteStatementExecutor());
		executorCache.put(EolParser.NEW, new NewExecutor());
		executorCache.put(EolParser.TRANSACTION, new TransactionExecutor());
		executorCache.put(EolParser.ABORT, new AbortExecutor());
	}
	
	public AbstractExecutor getExecutorFor(int type){
		return (AbstractExecutor) executorCache.get(type);
	}	
	
	/*
	protected AbstractExecutor getExecutorFor(int type){
		switch (type){
			case EolParserTokenTypes.OPERATOR: return new OperatorExecutor();
			case EolParserTokenTypes.INT: return new IntegerExecutor();
			case EolParserTokenTypes.STRING: return new StringExecutor();
			case EolParserTokenTypes.ASSIGN_STATEMENT: return new DefaultAssignExecutor();
			case EolParserTokenTypes.ASSIGNMENT: return new DefaultAssignExecutor();
			case EolParserTokenTypes.SPECIAL_ASSIGN_STATEMENT: return new DefaultAssignExecutor();
			case EolParserTokenTypes.POINT: return new PointExecutor();
			case EolParserTokenTypes.NAME: return new NameExecutor();
			case EolParserTokenTypes.BLOCK: return new StatementBlockExecutor();
			case EolParserTokenTypes.IF: return new IfStatementExecutor();
			case EolParserTokenTypes.BOOLEAN: return new BooleanExecutor();
			case EolParserTokenTypes.ARROW: return new ArrowExecutor();
			case EolParserTokenTypes.VAR: return new VarStatementExecutor();
			case EolParserTokenTypes.COLLECTION: return new CollectionExecutor();
			case EolParserTokenTypes.FLOAT: return new RealExecutor();
			case EolParserTokenTypes.FOR: return new ForStatementExecutor();
			case EolParserTokenTypes.PARAMLIST: return new FormalParameterListExecutor();
			case EolParserTokenTypes.EOLPROGRAM: return new EolProgramExecutor();
			case EolParserTokenTypes.PARAMETERS: return new ParametersExecutor();
			case EolParserTokenTypes.TYPE: return new TypeExecutor();
			case EolParserTokenTypes.TYPEINIT: return new TypeExecutor();
			case EolParserTokenTypes.RETURN: return new ReturnStatementExecutor();
			case EolParserTokenTypes.BREAK: return new BreakStatementExecutor();
			case EolParserTokenTypes.ENUMERATION_VALUE: return new EnumerationValueExecutor();
			case EolParserTokenTypes.IO : return new InputOutputExecutor();
			case EolParserTokenTypes.IMPORT : return new ImportExecutor();
			case EolParserTokenTypes.CONTINUE: return new ContinueExecutor();
			case EolParserTokenTypes.WHILE: return new WhileStatementExecutor();
			case EolParserTokenTypes.THROW: return new ThrowStatementExecutor();
		}
		
		return null;
	}
	*/
	
	public Object executeBlockOrExpressionAst(AST ast, IEolContext context) throws EolRuntimeException {
		
		if (ast == null) return null;
		
		if (ast.getType() == EolParser.BLOCK){
			return executeAST(ast,context);
		}
		else {
			return new Return(executeAST(ast,context));
		}
	}
	
	public Object executeBlockOrExpressionAst(AST ast, IEolContext context, Object default_) {
		
		if (ast == null) return default_;
		
		try {
			if (ast.getType() == EolParser.BLOCK){
				Object result = executeAST(ast,context);
				if (result instanceof Return) {
					return ((Return) result).getValue();
				}
				return default_;
			}
			else {
				return executeAST(ast,context);
			}			
		}
		catch (EolRuntimeException ex) {
			context.getErrorStream().println(ex.toString());
			return default_;
		}

	}
	
	public Object executeAST(AST ast, IEolContext context, boolean asStatement) throws EolRuntimeException {
		
		if (ast == null) return null;
		
		if (asStatement && ast.getType() == EolParser.OPERATOR && "=".equals(ast.getText())) {
			ast.getToken().setType(EolParser.ASSIGNMENT);
			ast.getToken().setText(":=");
		}
		
		return executeAST(ast, context);
	}
	
	public Object executeAST(AST ast, IEolContext context) throws EolRuntimeException{
		
		if (ast == null) return null;
		
		activeAst = ast;
		
		if (executionController != null){
			if (executionController.isTerminated()) throw new EolTerminationException(ast);
			try {
				executionController.control(ast, context);
			}
			catch (Exception ex) { throw new EolInternalException(ex); } 
		}
		
		AbstractExecutor executor = getExecutorFor(ast.getType());
		
		if (executor == null){
			throw new EolRuntimeException("No executor found for type #" + ast.getType(), ast);
		}
		
		for (IExecutionListener listener : executionListeners) {
			listener.aboutToExecute(ast, context);
		}
		
		Object result = null;
		
		try {
			result = executor.execute(ast, context);
			return result;
		}
		catch (Exception ex){
			if (ex instanceof EolRuntimeException){
				EolRuntimeException eolEx = (EolRuntimeException) ex;
				if (eolEx.getAst() == null){
					eolEx.setAst(ast);
				}
				throw eolEx;
			}
			else {
				throw new EolInternalException(ex, ast);
			}
		}
		finally {
			for (IExecutionListener listener : executionListeners) {
				listener.finishedExecuting(ast, result, context);
			}
		}
	}

	public AST getActiveAst() {
		return activeAst;
	}
	
}
