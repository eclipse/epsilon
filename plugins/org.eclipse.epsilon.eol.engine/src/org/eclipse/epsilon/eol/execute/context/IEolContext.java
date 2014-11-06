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
package org.eclipse.epsilon.eol.execute.context;

import java.io.PrintStream;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.introspection.IntrospectionManager;
import org.eclipse.epsilon.eol.execute.operations.EolOperationFactory;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.eclipse.epsilon.eol.types.IToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.userinput.IUserInput;

public interface IEolContext {
	
	public void setUserInput(IUserInput userInput);
	
	public IUserInput getUserInput();
	
	public PrettyPrinterManager getPrettyPrinterManager();
	
	public void setPrettyPrinterManager(PrettyPrinterManager prettyPrinterManager);

	public PrintStream getOutputStream();

	public void setOutputStream(PrintStream outputStream);

	public PrintStream getWarningStream();

	public void setWarningStream(PrintStream warningStream);

	public EolOperationFactory getOperationFactory();

	public void setOperationFactory(EolOperationFactory operationFactory);

	public ExecutorFactory getExecutorFactory();

	public void setExecutorFactory(ExecutorFactory executorFactory);
	
	public ModelRepository getModelRepository();
	
	public void setModelRepository(ModelRepository modelRepository);
	
	public FrameStack getFrameStack();
	
	public void setFrameStack(FrameStack scope);

	public IntrospectionManager getIntrospectionManager();

	public void setIntrospectionManager(IntrospectionManager introspectionManager);

	public PrintStream getErrorStream();

	public void setErrorStream(PrintStream defaultErrorStream);
	
	public void setModule(IModule module);
	
	public IModule getModule();

	public void setNativeTypeDelegates(List<IToolNativeTypeDelegate> nativeTypeDelegates);
	
	public List<IToolNativeTypeDelegate> getNativeTypeDelegates();
	
	public boolean isProfilingEnabled();
	
	public void setProfilingEnabled(boolean profilingEnabled);
	
	public boolean isAssertionsEnabled();
	
	public void setAssertionsEnabled(boolean assertionsEnabled);
	
	public ExtendedProperties getExtendedProperties();
	
	public void setExtendedProperties(ExtendedProperties properties);
	
	public void dispose();
	
	public List<AsyncStatementInstance> getAsyncStatementsQueque();
	
	public OperationContributorRegistry getOperationContributorRegistry();
}
