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

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dom.IExecutableModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolTerminationException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.DefaultExecutionController;
import org.eclipse.epsilon.eol.execute.control.ExecutionController;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;


public class ExecutorFactory {
	
	protected ExecutionController executionController = null;
	protected HashMap<Integer, AbstractExecutor> executorCache = new HashMap<Integer, AbstractExecutor>();
	protected ModuleElement activeAst = null;
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
	
	public Object executeAST(ModuleElement ast, IEolContext context) throws EolRuntimeException{
		
		if (ast == null) return null;
		
		activeAst = ast;
		
		if (executionController != null){
			if (executionController.isTerminated()) throw new EolTerminationException(ast);
			try {
				executionController.control(ast, context);
			}
			catch (Exception ex) { throw new EolInternalException(ex); } 
		}
		
		for (IExecutionListener listener : executionListeners) {
			listener.aboutToExecute(ast, context);
		}
		
		Object result = null;
		
		try {
			if (ast instanceof IExecutableModuleElement) {
				result = ((IExecutableModuleElement) ast).execute(context);
			}
			else if (ast instanceof EolModule) {
				result = ((EolModule) ast).executeImpl();
			}
			
			for (IExecutionListener listener : executionListeners) {
				listener.finishedExecuting(ast, result, context);
			}
		}
		catch (Exception ex){
			EolRuntimeException exception = null;
			if (ex instanceof EolRuntimeException){
				EolRuntimeException eolEx = (EolRuntimeException) ex;
				if (eolEx.getAst() == null){
					eolEx.setAst(ast);
				}
				exception = eolEx;
			}
			else {
				exception = new EolInternalException(ex, ast);
			}
			for (IExecutionListener listener : executionListeners) {
				listener.finishedExecutingWithException(ast, exception, context);
			}
			throw exception;
		}
		finally {
			
			if (executionController != null) {
				executionController.done(ast, context);
			}
		}
		
		return result;
	}

	public ModuleElement getActiveAst() {
		return activeAst;
	}
	
}
