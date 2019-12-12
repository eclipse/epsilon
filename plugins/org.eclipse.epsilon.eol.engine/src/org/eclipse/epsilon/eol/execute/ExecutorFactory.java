/*******************************************************************************
 * Copyright (c) 2008-2019 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Sina Madani - Refactoring + concurrency + parameterised execution
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import org.eclipse.epsilon.common.function.BaseDelegate;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dom.IExecutableModuleElement;
import org.eclipse.epsilon.eol.dom.IExecutableModuleElementParameter;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolTerminationException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.*;

public class ExecutorFactory implements BaseDelegate<ExecutorFactory> {
	
	protected ExecutionController executionController;
	protected ModuleElement activeModuleElement;
	protected Collection<IExecutionListener> executionListeners;
	protected StackTraceManager stackTraceManager;
	protected ExecutorFactory base;
	
	public ExecutorFactory() {
		this(null);
	}
	
	/**
	 * 
	 * @param parent
	 * @since 1.6
	 */
	public ExecutorFactory(ExecutorFactory parent) {
		this.base = parent;
		executionController = new DefaultExecutionController();
		executionListeners = new ArrayList<>(2);
		/*if (base != null) {
			executionListeners.addAll(base.executionListeners
				.stream()
				.filter(el -> el != base.stackTraceManager)
				.collect(Collectors.toSet())
			);
		}*/
		setStackTraceManager(new StackTraceManager());
	}
	
	public void addExecutionListener(IExecutionListener listener) {
		executionListeners.add(listener);
	}
	
	public Collection<IExecutionListener> getExecutionListeners() {
		return Collections.unmodifiableCollection(executionListeners);
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
		addExecutionListener(this.stackTraceManager = stackTraceManager);
	}
	
	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	public boolean isProfilingEnabled() {
		return executionController instanceof ExecutionProfiler;
	}
	
	/**
	 * 
	 * @param moduleElement
	 * @param context
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	protected void preExecute(ModuleElement moduleElement, IEolContext context) throws EolRuntimeException {
		activeModuleElement = moduleElement;
		
		if (executionController != null) {
			if (executionController.isTerminated()) throw new EolTerminationException(moduleElement);
			try {
				executionController.control(moduleElement, context);
			}
			catch (Exception ex) {
				throw new EolInternalException(ex);
			} 
		}
		
		for (IExecutionListener listener : executionListeners) {
			listener.aboutToExecute(moduleElement, context);
		}
	}
	
	/**
	 * 
	 * @param moduleElement
	 * @param result
	 * @param context
	 * @since 1.6
	 */
	protected void postExecuteSuccess(ModuleElement moduleElement, Object result, IEolContext context) {
		for (IExecutionListener listener : executionListeners) {
			listener.finishedExecuting(moduleElement, result, context);
		}
	}
	
	/**
	 * 
	 * @param moduleElement
	 * @param ex
	 * @param context
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	protected void postExecuteFailure(ModuleElement moduleElement, Exception ex, IEolContext context) throws EolRuntimeException {
		EolRuntimeException exception = null;
		if (ex instanceof EolRuntimeException) {
			EolRuntimeException eolEx = (EolRuntimeException) ex;
			if (eolEx.getAst() == null) {
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
	
	/**
	 * 
	 * @param moduleElement
	 * @param context
	 * @since 1.6
	 */
	protected void postExecuteFinally(ModuleElement moduleElement, IEolContext context) {
		if (executionController != null) {
			executionController.done(moduleElement, context);
		}
	}
	
	/**
	 * 
	 * @param moduleElement
	 * @param context
	 * @return
	 * @throws Exception
	 * @since 1.6
	 */
	protected Object executeImpl(ModuleElement moduleElement, IEolContext context) throws Exception {
		if (moduleElement instanceof IExecutableModuleElement) {
			return ((IExecutableModuleElement) moduleElement).execute(context);
		}
		else if (moduleElement instanceof EolModule) {
			return ((EolModule) moduleElement).executeImpl();
		}
		else return null;
	}
	
	/**
	 * 
	 * @param moduleElement
	 * @param context
	 * @param self
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	protected Object executeImpl(IExecutableModuleElementParameter moduleElement, IEolContext context, Object parameter) throws EolRuntimeException {
		return moduleElement.execute(context, parameter);
	}
	
	public final Object execute(ModuleElement moduleElement, IEolContext context) throws EolRuntimeException {	
		if (moduleElement == null) return null;
		
		preExecute(moduleElement, context);
		
		Object result = null;
		
		try {
			result = executeImpl(moduleElement, context);
			postExecuteSuccess(moduleElement, result, context);
		}
		catch (Exception ex) {
			postExecuteFailure(moduleElement, ex, context);
		}
		finally {
			postExecuteFinally(moduleElement, context);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param moduleElement
	 * @param context
	 * @param self
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	public Object execute(IExecutableModuleElementParameter moduleElement, IEolContext context, Object parameter) throws EolRuntimeException {
		if (moduleElement == null) return null;
		
		preExecute(moduleElement, context);
		
		Object result = null;
		
		try {
			result = executeImpl(moduleElement, context, parameter);
			postExecuteSuccess(moduleElement, result, context);
		}
		catch (Exception ex) {
			postExecuteFailure(moduleElement, ex, context);
		}
		finally {
			postExecuteFinally(moduleElement, context);
		}
		
		return result;
	}
	
	public ModuleElement getActiveModuleElement() {
		return activeModuleElement;
	}
	
	/**
	 * 
	 * @param parent
	 * @since 1.6
	 */
	public void setBase(ExecutorFactory parent) {
		this.base = parent;
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public ExecutorFactory getBase() {
		return base;
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public void merge(MergeMode mode) {
		mergeCollectionsUnique(
			ef -> ef.executionListeners
				.stream()
				.filter(el -> el != ef.stackTraceManager && el != this.stackTraceManager)
				.collect(Collectors.toList()),
			ArrayList::new,
			mode
		);
	}

	/**
	 * @since 1.6
	 */
	public void reset() {
		activeModuleElement = null;
		if (stackTraceManager != null) stackTraceManager.reset();
		if (executionController != null) executionController.dispose();
	}
}
