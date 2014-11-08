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

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.IExecutableModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolTerminationException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.DefaultExecutionController;
import org.eclipse.epsilon.eol.execute.control.ExecutionController;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;
import org.eclipse.epsilon.eol.parse.EolParser;


public class ExecutorFactory {
	
	protected ExecutionController executionController = null;
	protected HashMap<Integer, AbstractExecutor> executorCache = new HashMap<Integer, AbstractExecutor>();
	protected AST activeAst = null;
	protected ArrayList<IExecutionListener> executionListeners = new ArrayList<IExecutionListener>();
	protected StackTraceManager stackTraceManager = null;
	
	public ExecutorFactory(){
		executionController = new DefaultExecutionController();
		setStackTraceManager(new StackTraceManager());
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
	
	public StackTraceManager getStackTraceManager() {
		return stackTraceManager;
	}
	
	public void setStackTraceManager(StackTraceManager stackTraceManager) {
		if (this.stackTraceManager != null) {
			removeExecutionListener(this.stackTraceManager);
		}
		
		this.stackTraceManager = stackTraceManager;
		addExecutionListener(stackTraceManager);
	}
	
	protected void cacheExecutors() {
		
	}
	
	public AbstractExecutor getExecutorFor(int type){
		return (AbstractExecutor) executorCache.get(type);
	}
	
	//TODO: Used in a few places in EWL
	public Object executeBlockOrExpressionAst(AST ast, IEolContext context) throws EolRuntimeException {
		
		if (ast == null) return null;
		
		if (ast.getType() == EolParser.BLOCK){
			return executeAST(ast,context);
		}
		else {
			return new Return(executeAST(ast,context));
		}
	}
	
	//TODO: Only used by Flock's EolExecutor
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
		
		AbstractExecutor executor = null;
		if (!(ast instanceof IExecutableModuleElement)) {
			executor = getExecutorFor(ast.getType());
			
			if (executor == null){
				throw new EolRuntimeException("No executor found for type #" + ast.getType() + "/" + ast.getClass().getCanonicalName(), ast);
			}
		}
		
		for (IExecutionListener listener : executionListeners) {
			listener.aboutToExecute(ast, context);
		}
		
		Object result = null;
		
		try {
			if (ast instanceof IExecutableModuleElement) {
				result = ((IExecutableModuleElement) ast).execute(context);
			}
			else {
				result = executor.execute(ast, context);
			}
			for (IExecutionListener listener : executionListeners) {
				listener.finishedExecuting(ast, result, context);
			}
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
			if (executionController != null) {
				executionController.done(ast, context);
			}
		}
	}

	public AST getActiveAst() {
		return activeAst;
	}
	
}
