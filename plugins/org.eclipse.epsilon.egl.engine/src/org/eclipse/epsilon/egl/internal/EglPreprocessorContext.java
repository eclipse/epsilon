/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.internal;

import java.io.PrintStream;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.AsyncStatement;
import org.eclipse.epsilon.eol.execute.context.ExtendedProperties;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IntrospectionManager;
import org.eclipse.epsilon.eol.execute.operations.EolOperationFactory;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.eclipse.epsilon.eol.types.IToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.userinput.IUserInput;

public class EglPreprocessorContext implements IEolContext {

	private final IEolContext delegate;
	private IEglContext parent;
	
	public EglPreprocessorContext(IEolContext delegate) {
		this.delegate = delegate;
	}
	
	public IEglContext getEglContext() {
		return parent;
	}
	
	public void setEglContext(IEglContext parent) {
		this.parent = parent;
	}
	
	
	// The remaining methods delegate to the IEolContext object

	public void setUserInput(IUserInput userInput) {
		delegate.setUserInput(userInput);
	}

	public IUserInput getUserInput() {
		return delegate.getUserInput();
	}

	public PrettyPrinterManager getPrettyPrinterManager() {
		return delegate.getPrettyPrinterManager();
	}

	public void setPrettyPrinterManager(
			PrettyPrinterManager prettyPrinterManager) {
		delegate.setPrettyPrinterManager(prettyPrinterManager);
	}

	public PrintStream getOutputStream() {
		return delegate.getOutputStream();
	}

	public void setOutputStream(PrintStream outputStream) {
		delegate.setOutputStream(outputStream);
	}

	public PrintStream getWarningStream() {
		return delegate.getWarningStream();
	}

	public void setWarningStream(PrintStream warningStream) {
		delegate.setWarningStream(warningStream);
	}

	public EolOperationFactory getOperationFactory() {
		return delegate.getOperationFactory();
	}

	public void setOperationFactory(EolOperationFactory operationFactory) {
		delegate.setOperationFactory(operationFactory);
	}

	public ExecutorFactory getExecutorFactory() {
		return delegate.getExecutorFactory();
	}

	public void setExecutorFactory(ExecutorFactory executorFactory) {
		delegate.setExecutorFactory(executorFactory);
	}

	public ModelRepository getModelRepository() {
		return delegate.getModelRepository();
	}

	public void setModelRepository(ModelRepository modelRepository) {
		delegate.setModelRepository(modelRepository);
	}

	public FrameStack getFrameStack() {
		return delegate.getFrameStack();
	}

	public void setFrameStack(FrameStack scope) {
		delegate.setFrameStack(scope);
	}

	public IntrospectionManager getIntrospectionManager() {
		return delegate.getIntrospectionManager();
	}

	public void setIntrospectionManager(
			IntrospectionManager introspectionManager) {
		delegate.setIntrospectionManager(introspectionManager);
	}

	public PrintStream getErrorStream() {
		return delegate.getErrorStream();
	}

	public void setErrorStream(PrintStream defaultErrorStream) {
		delegate.setErrorStream(defaultErrorStream);
	}

	public void setModule(IModule module) {
		delegate.setModule(module);
	}

	public IModule getModule() {
		return delegate.getModule();
	}

	public void setNativeTypeDelegates(
			List<IToolNativeTypeDelegate> nativeTypeDelegates) {
		delegate.setNativeTypeDelegates(nativeTypeDelegates);
	}

	public List<IToolNativeTypeDelegate> getNativeTypeDelegates() {
		return delegate.getNativeTypeDelegates();
	}

	public boolean isProfilingEnabled() {
		return delegate.isProfilingEnabled();
	}

	public void setProfilingEnabled(boolean profilingEnabled) {
		delegate.setProfilingEnabled(profilingEnabled);
	}

	public boolean isAssertionsEnabled() {
		return delegate.isAssertionsEnabled();
	}

	public void setAssertionsEnabled(boolean assertionsEnabled) {
		delegate.setAssertionsEnabled(assertionsEnabled);
	}

	public ExtendedProperties getExtendedProperties() {
		return delegate.getExtendedProperties();
	}

	public void setExtendedProperties(ExtendedProperties properties) {
		delegate.setExtendedProperties(properties);
	}

	public void dispose() {
		delegate.dispose();
	}

	public List<AsyncStatement> getAsyncStatementsQueque() {
		return delegate.getAsyncStatementsQueque();
	}

	public OperationContributorRegistry getOperationContributorRegistry() {
		return delegate.getOperationContributorRegistry();
	}		
}
