/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.internal;

import java.io.PrintStream;
import java.util.List;
import java.util.Queue;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.AsyncStatementInstance;
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
		//this.setModule(delegate.getModule());
	}
	
	public IEglContext getEglContext() {
		return parent;
	}
	
	public void setEglContext(IEglContext parent) {
		this.parent = parent;
	}
	
	
	// The remaining methods delegate to the IEolContext object

	@Override
	public void setUserInput(IUserInput userInput) {
		delegate.setUserInput(userInput);
	}

	@Override
	public IUserInput getUserInput() {
		return delegate.getUserInput();
	}

	@Override
	public PrettyPrinterManager getPrettyPrinterManager() {
		return delegate.getPrettyPrinterManager();
	}

	@Override
	public void setPrettyPrinterManager(PrettyPrinterManager prettyPrinterManager) {
		delegate.setPrettyPrinterManager(prettyPrinterManager);
	}

	@Override
	public PrintStream getOutputStream() {
		return delegate.getOutputStream();
	}

	@Override
	public void setOutputStream(PrintStream outputStream) {
		delegate.setOutputStream(outputStream);
	}

	@Override
	public PrintStream getWarningStream() {
		return delegate.getWarningStream();
	}

	@Override
	public void setWarningStream(PrintStream warningStream) {
		delegate.setWarningStream(warningStream);
	}

	@Override
	public EolOperationFactory getOperationFactory() {
		return delegate.getOperationFactory();
	}

	@Override
	public void setOperationFactory(EolOperationFactory operationFactory) {
		delegate.setOperationFactory(operationFactory);
	}

	@Override
	public ExecutorFactory getExecutorFactory() {
		return delegate.getExecutorFactory();
	}

	@Override
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		delegate.setExecutorFactory(executorFactory);
	}

	@Override
	public ModelRepository getModelRepository() {
		return delegate.getModelRepository();
	}

	@Override
	public void setModelRepository(ModelRepository modelRepository) {
		delegate.setModelRepository(modelRepository);
	}

	@Override
	public FrameStack getFrameStack() {
		return delegate.getFrameStack();
	}

	@Override
	public void setFrameStack(FrameStack scope) {
		delegate.setFrameStack(scope);
	}

	@Override
	public IntrospectionManager getIntrospectionManager() {
		return delegate.getIntrospectionManager();
	}

	@Override
	public void setIntrospectionManager(
			IntrospectionManager introspectionManager) {
		delegate.setIntrospectionManager(introspectionManager);
	}

	@Override
	public PrintStream getErrorStream() {
		return delegate.getErrorStream();
	}

	@Override
	public void setErrorStream(PrintStream defaultErrorStream) {
		delegate.setErrorStream(defaultErrorStream);
	}

	@Override
	public void setModule(IModule module) {
		delegate.setModule(module);
	}

	@Override
	public IModule getModule() {
		return delegate.getModule();
	}

	@Override
	public void setNativeTypeDelegates(
			List<IToolNativeTypeDelegate> nativeTypeDelegates) {
		delegate.setNativeTypeDelegates(nativeTypeDelegates);
	}

	@Override
	public List<IToolNativeTypeDelegate> getNativeTypeDelegates() {
		return delegate.getNativeTypeDelegates();
	}

	@Override
	public boolean isProfilingEnabled() {
		return delegate.isProfilingEnabled();
	}

	@Override
	public void setProfilingEnabled(boolean profilingEnabled) {
		delegate.setProfilingEnabled(profilingEnabled);
	}

	@Override
	public boolean isAssertionsEnabled() {
		return delegate.isAssertionsEnabled();
	}

	@Override
	public void setAssertionsEnabled(boolean assertionsEnabled) {
		delegate.setAssertionsEnabled(assertionsEnabled);
	}

	@Override
	public ExtendedProperties getExtendedProperties() {
		return delegate.getExtendedProperties();
	}

	@Override
	public void setExtendedProperties(ExtendedProperties properties) {
		delegate.setExtendedProperties(properties);
	}

	@Override
	public void dispose() {
		delegate.dispose();
	}

	@Override
	public OperationContributorRegistry getOperationContributorRegistry() {
		return delegate.getOperationContributorRegistry();
	}

	@Override
	public Queue<AsyncStatementInstance> getAsyncStatementsQueue() {
		return delegate.getAsyncStatementsQueue();
	}
}
