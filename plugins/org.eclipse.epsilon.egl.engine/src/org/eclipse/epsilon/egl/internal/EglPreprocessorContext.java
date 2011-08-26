/*******************************************************************************
 * Copyright (c) 2011 The University of York.
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
import java.util.Map;

import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.EglTraceabilityContext;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglContextWithFineGrainedTraceability;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglTraceabilityContext;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.Printer;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.output.OutputBufferPrinterAdaptor;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.AsyncStatement;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IntrospectionManager;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.eclipse.epsilon.eol.types.IToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.userinput.IUserInput;

public class EglPreprocessorContext implements IEglContextWithFineGrainedTraceability {

	private final IEolContext delegate;
	private IEglTraceabilityContext traceabilityContext = new EglTraceabilityContext(this);
	
	public EglPreprocessorContext(IEolContext delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public Printer getPrinter() {
		return new OutputBufferPrinterAdaptor((OutputBuffer)getFrameStack().get("out").getValue());
	}

	public void setTraceabilityContext(IEglTraceabilityContext traceabilityContext) {
		this.traceabilityContext = traceabilityContext;
	}
	
	@Override
	public IEglTraceabilityContext getTraceabilityContext() {
		return traceabilityContext;
	}

	
	// The following methods delegate to the EolContext member
	
	@Override
	public OperationContributorRegistry getOperationContributorRegistry() {
		return delegate.getOperationContributorRegistry();
	}

	@Override
	public PrintStream getWarningStream() {
		return delegate.getWarningStream();
	}

	@Override
	public PrettyPrinterManager getPrettyPrinterManager() {
		return delegate.getPrettyPrinterManager();
	}

	@Override
	public PrintStream getOutputStream() {
		return delegate.getOutputStream();
	}

	@Override
	public OperationFactory getOperationFactory() {
		return delegate.getOperationFactory();
	}

	@Override
	public ExecutorFactory getExecutorFactory() {
		return delegate.getExecutorFactory();
	}

	@Override
	public ModelRepository getModelRepository() {
		return delegate.getModelRepository();
	}

	@Override
	public FrameStack getFrameStack() {
		return delegate.getFrameStack();
	}

	@Override
	public IntrospectionManager getIntrospectionManager() {
		return delegate.getIntrospectionManager();
	}

	@Override
	public PrintStream getErrorStream() {
		return delegate.getErrorStream();
	}

	@Override
	public IModule getModule() {
		return delegate.getModule();
	}

	@Override
	public IUserInput getUserInput() {
		return delegate.getUserInput();
	}

	@Override
	public List<IToolNativeTypeDelegate> getNativeTypeDelegates() {
		return delegate.getNativeTypeDelegates();
	}

	@Override
	public Map<Object, Map<String, Object>> getExtendedProperties() {
		return delegate.getExtendedProperties();
	}

	@Override
	public void dispose() {
		delegate.dispose();
	}

	@Override
	public List<AsyncStatement> getAsyncStatementsQueque() {
		return delegate.getAsyncStatementsQueque();
	}
	
	@Override
	public void setWarningStream(PrintStream warningStream) {
		delegate.setWarningStream(warningStream);
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
	public void setOutputStream(PrintStream outputStream) {
		delegate.setOutputStream(outputStream);
	}

	@Override
	public void setOperationFactory(OperationFactory operationFactory) {
		delegate.setOperationFactory(operationFactory);
	}

	@Override
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		delegate.setExecutorFactory(executorFactory);
	}

	@Override
	public void setModelRepository(ModelRepository modelRepository) {
		delegate.setModelRepository(modelRepository);
	}
	
	@Override
	public void setFrameStack(FrameStack frameStack) {
		delegate.setFrameStack(frameStack);
	}

	@Override
	public void setIntrospectionManager(
			IntrospectionManager introspectionManager) {
		delegate.setIntrospectionManager(introspectionManager);
	}

	@Override
	public void setErrorStream(PrintStream errorStream) {
		delegate.setErrorStream(errorStream);
	}

	@Override
	public void setModule(IModule module) {
		delegate.setModule(module);
	}

	@Override
	public void setUserInput(IUserInput userInput) {
		delegate.setUserInput(userInput);
	}

	@Override
	public void setNativeTypeDelegates(
			List<IToolNativeTypeDelegate> nativeTypeDelegates) {
		delegate.setNativeTypeDelegates(nativeTypeDelegates);
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
	public void setExtendedProperties(
			Map<Object, Map<String, Object>> extendedProperties) {
		delegate.setExtendedProperties(extendedProperties);
	}
}
