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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.execute.DeprecationInfo;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.introspection.IntrospectionManager;
import org.eclipse.epsilon.eol.execute.operations.EolOperationFactory;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.eclipse.epsilon.eol.types.EolClasspathNativeTypeDelegate;
import org.eclipse.epsilon.eol.types.IToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.userinput.IUserInput;
import org.eclipse.epsilon.eol.userinput.JavaConsoleUserInput;

public class EolContext implements IEolContext {
	
	protected IUserInput userInput = new JavaConsoleUserInput();
	protected FrameStack frameStack = new FrameStack();
	protected ModelRepository modelRepository = new ModelRepository();
	protected IntrospectionManager introspectionManager = new IntrospectionManager();
	protected ExecutorFactory executorFactory = new ExecutorFactory();
	protected EolOperationFactory operationFactory = new EolOperationFactory();
	protected PrettyPrinterManager prettyPrinterManager = new PrettyPrinterManager();
	protected PrintStream outputStream = System.out;
	protected PrintStream errorStream = System.err;
	protected PrintStream warningStream = System.out;
	protected IModule module;
	protected boolean profilingEnabled = false;
	protected boolean assertionsEnabled = true;
	protected ExtendedProperties extendedProperties = new ExtendedProperties();
	protected Queue<AsyncStatementInstance> asyncStatementsQueue = new LinkedList<>();
	protected OperationContributorRegistry methodContributorRegistry = new OperationContributorRegistry();
	// The following members are initialised in the constructor
	protected EolClasspathNativeTypeDelegate classpathNativeTypeDelegate;
	protected List<IToolNativeTypeDelegate> nativeTypeDelegates;
	
	public EolContext() {
		this(new EolClasspathNativeTypeDelegate());
	}
	
	protected EolContext(EolClasspathNativeTypeDelegate classpathNativeTypeDelegate) {
		this.classpathNativeTypeDelegate = classpathNativeTypeDelegate;
		this.nativeTypeDelegates = new ArrayList<>(CollectionUtil.asCollection(classpathNativeTypeDelegate));
	}

	@Override
	public OperationContributorRegistry getOperationContributorRegistry() {
		return methodContributorRegistry;
	}
	
	@Override
	public PrintStream getWarningStream() {
		return warningStream;
	}

	@Override
	public void setWarningStream(PrintStream warningStream) {
		this.warningStream = warningStream;
	}

	@Override
	public boolean isAssertionsEnabled() {
		return assertionsEnabled;
	}

	@Override
	public void setAssertionsEnabled(boolean assertionsEnabled) {
		this.assertionsEnabled = assertionsEnabled;
	}

	@Override
	public PrettyPrinterManager getPrettyPrinterManager() {
		return prettyPrinterManager;
	}
	
	@Override
	public void setPrettyPrinterManager(PrettyPrinterManager prettyPrinterManager) {
		this.prettyPrinterManager = prettyPrinterManager;
	}

	@Override
	public PrintStream getOutputStream() {
		return outputStream;
	}

	@Override
	public void setOutputStream(PrintStream outputStream) {
		this.outputStream = outputStream;
	}

	@Override
	public EolOperationFactory getOperationFactory() {
		return operationFactory;
	}

	@Override
	public void setOperationFactory(EolOperationFactory operationFactory) {
		this.operationFactory = operationFactory;
	}

	@Override
	public ExecutorFactory getExecutorFactory() {
		return executorFactory;
	}

	@Override
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		this.executorFactory = executorFactory;
	}
	
	@Override
	public ModelRepository getModelRepository() {
		return modelRepository;
	}
	
	@Override
	public void setModelRepository(ModelRepository modelRepository) {
		this.modelRepository = modelRepository;
	}
	
	@Override
	public FrameStack getFrameStack() {
		return frameStack;
	}
	
	@Override
	public void setFrameStack(FrameStack frameStack) {
		this.frameStack = frameStack;
	}

	@Override
	public IntrospectionManager getIntrospectionManager() {
		return introspectionManager;
	}

	@Override
	public void setIntrospectionManager(IntrospectionManager introspectionManager) {
		this.introspectionManager = introspectionManager;
	}

	@Override
	public PrintStream getErrorStream() {
		return errorStream;
	}

	@Override
	public void setErrorStream(PrintStream errorStream) {
		this.errorStream = errorStream;
	}

	@Override
	public void setModule(IModule module) {
		this.module = module;
	}

	@Override
	public IModule getModule() {
		return module;
	}
	
	//TODO : Do something with the user input
	@Override
	public void setUserInput(IUserInput userInput) {
		String userInputVarName = "UserInput";
		this.userInput = userInput;
		FrameStack fs = getFrameStack();
		Variable variable = fs.get(userInputVarName);
		if (variable == null) {
			variable = Variable.createReadOnlyVariable(userInputVarName, userInput);
			DeprecationInfo deprecationInfo = new DeprecationInfo();
			deprecationInfo.setMessage("Variable UserInput is deprecated. Use System.user instead.");
			variable.setDeprecationInfo(deprecationInfo);
			fs.putGlobal(variable);
		}
		else {
			variable.setValueBruteForce(userInput);
		}
	}

	@Override
	public IUserInput getUserInput() {
		return userInput;
	}

	@Override
	public List<IToolNativeTypeDelegate> getNativeTypeDelegates() {
		return nativeTypeDelegates;
	}

	@Override
	public void setNativeTypeDelegates(List<IToolNativeTypeDelegate> nativeTypeDelegates) {
		this.nativeTypeDelegates = nativeTypeDelegates;
	}

	@Override
	public boolean isProfilingEnabled() {
		return profilingEnabled;
	}

	@Override
	public void setProfilingEnabled(boolean profilingEnabled) {
		this.profilingEnabled = profilingEnabled;
	}

	@Override
	public ExtendedProperties getExtendedProperties() {
		return extendedProperties;
	}

	@Override
	public void setExtendedProperties(ExtendedProperties extendedProperties) {
		this.extendedProperties = extendedProperties;
	}
	
	@Override
	public void dispose() {
		if (executorFactory.getExecutionController() != null) {
			executorFactory.getExecutionController().dispose();
		}
		extendedProperties.clear();
	}

	@Override
	public Queue<AsyncStatementInstance> getAsyncStatementsQueue() {
		return asyncStatementsQueue;
	}
}
