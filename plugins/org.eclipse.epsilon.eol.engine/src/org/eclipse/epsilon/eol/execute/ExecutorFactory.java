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
	protected ModuleElement activeModuleElement = null;
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
	
	public Object execute(ModuleElement moduleElement, IEolContext context) throws EolRuntimeException{
		
		if (moduleElement == null) return null;
		
		activeModuleElement = moduleElement;
		
		if (executionController != null){
			if (executionController.isTerminated()) throw new EolTerminationException(moduleElement);
			try {
				executionController.control(moduleElement, context);
			}
			catch (Exception ex) { throw new EolInternalException(ex); } 
		}
		
		for (IExecutionListener listener : executionListeners) {
			listener.aboutToExecute(moduleElement, context);
		}
		
		Object result = null;
		
		try {
			if (moduleElement instanceof IExecutableModuleElement) {
				result = ((IExecutableModuleElement) moduleElement).execute(context);
			}
			else if (moduleElement instanceof EolModule) {
				result = ((EolModule) moduleElement).executeImpl();
			}
			
			for (IExecutionListener listener : executionListeners) {
				listener.finishedExecuting(moduleElement, result, context);
			}
		}
		catch (Exception ex){
			EolRuntimeException exception = null;
			if (ex instanceof EolRuntimeException){
				EolRuntimeException eolEx = (EolRuntimeException) ex;
				if (eolEx.getAst() == null){
					eolEx.setAst(moduleElement);
				}
				exception = eolEx;
			}
			else {
				exception = new EolInternalException(ex, moduleElement);
			}
			for (IExecutionListener listener : executionListeners) {
				listener.finishedExecutingWithException(moduleElement, exception, context);
			}
			throw exception;
		}
		finally {
			
			if (executionController != null) {
				executionController.done(moduleElement, context);
			}
		}
		
		return result;
	}

	public ModuleElement getActiveModuleElement() {
		return activeModuleElement;
	}
	
}
