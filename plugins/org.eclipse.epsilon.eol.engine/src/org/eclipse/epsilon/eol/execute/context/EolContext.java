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
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.execute.DeprecationInfo;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.introspection.IntrospectionManager;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccessRecorder;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;
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
	protected OperationFactory operationFactory = new OperationFactory();
	protected PrettyPrinterManager prettyPrinterManager = new PrettyPrinterManager();
	protected PrintStream outputStream = System.out;
	protected PrintStream errorStream = System.err;
	protected IModule module = null;
	protected boolean profilingEnabled = false;
	protected boolean assertionsEnabled = true;
	protected ExtendedProperties extendedProperties = new ExtendedProperties();
	protected List<AsyncStatement> asyncStatementsQueque = new ArrayList<AsyncStatement>();
	protected PrintStream warningStream = System.out;
	protected OperationContributorRegistry methodContributorRegistry = new OperationContributorRegistry();
	protected Collection<IPropertyAccessRecorder> propertyAccessRecorders = new ArrayList<IPropertyAccessRecorder>();
	// The following members are initialised in the constructor
	protected EolClasspathNativeTypeDelegate classpathNativeTypeDelegate;
	protected List<IToolNativeTypeDelegate> nativeTypeDelegates;
	
	public EolContext() {
		this(new EolClasspathNativeTypeDelegate());
	}
	
	protected EolContext(EolClasspathNativeTypeDelegate classpathNativeTypeDelegate) {
		this.classpathNativeTypeDelegate = classpathNativeTypeDelegate;
		this.nativeTypeDelegates = new ArrayList(CollectionUtil.asCollection(classpathNativeTypeDelegate));
	}

	public OperationContributorRegistry getOperationContributorRegistry() {
		return methodContributorRegistry;
	}
	
	public PrintStream getWarningStream() {
		return warningStream;
	}

	public void setWarningStream(PrintStream warningStream) {
		this.warningStream = warningStream;
	}

	public boolean isAssertionsEnabled() {
		return assertionsEnabled;
	}

	public void setAssertionsEnabled(boolean assertionsEnabled) {
		this.assertionsEnabled = assertionsEnabled;
	}

	public PrettyPrinterManager getPrettyPrinterManager() {
		return prettyPrinterManager;
	}
	
	public void setPrettyPrinterManager(PrettyPrinterManager prettyPrinterManager) {
		this.prettyPrinterManager = prettyPrinterManager;
	}

	public PrintStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(PrintStream outputStream) {
		this.outputStream = outputStream;
	}

	public OperationFactory getOperationFactory() {
		return operationFactory;
	}

	public void setOperationFactory(OperationFactory operationFactory) {
		this.operationFactory = operationFactory;
	}

	public ExecutorFactory getExecutorFactory() {
		return executorFactory;
	}

	public void setExecutorFactory(ExecutorFactory executorFactory) {
		this.executorFactory = executorFactory;
	}
	
	public ModelRepository getModelRepository() {
		return modelRepository;
	}
	
	public void setModelRepository(ModelRepository modelRepository) {
		this.modelRepository = modelRepository;
	}
	
	public FrameStack getFrameStack() {
		return frameStack;
	}
	
	public void setFrameStack(FrameStack frameStack) {
		this.frameStack = frameStack;
	}

	public IntrospectionManager getIntrospectionManager() {
		return introspectionManager;
	}

	public void setIntrospectionManager(IntrospectionManager introspectionManager) {
		this.introspectionManager = introspectionManager;
	}

	public PrintStream getErrorStream() {
		return errorStream;
	}

	public void setErrorStream(PrintStream errorStream) {
		this.errorStream = errorStream;
	}

	public void setModule(IModule module) {
		this.module = module;
	}

	public IModule getModule() {
		return this.module;
	}
	
	//TODO : Do something with the user input
	public void setUserInput(IUserInput userInput) {
		String userInputVarName = "UserInput";
		this.userInput = userInput;
		Variable var = frameStack.get(userInputVarName);
		if (var == null) {
			var = Variable.createReadOnlyVariable(userInputVarName, userInput);
			DeprecationInfo deprecationInfo = new DeprecationInfo();
			deprecationInfo.setMessage("Variable UserInput is deprecated. Use System.user instead.");
			var.setDeprecationInfo(deprecationInfo);
			frameStack.putGlobal(var);
		}
		else {
			var.setValueBruteForce(userInput);
		}
	}

	public IUserInput getUserInput() {
		return userInput;
	}

	public List<IToolNativeTypeDelegate> getNativeTypeDelegates() {
		return nativeTypeDelegates;
	}

	public void setNativeTypeDelegates(List<IToolNativeTypeDelegate> nativeTypeDelegates) {
		this.nativeTypeDelegates = nativeTypeDelegates;
	}

	public boolean isProfilingEnabled() {
		return profilingEnabled;
	}

	public void setProfilingEnabled(boolean profilingEnabled) {
		this.profilingEnabled = profilingEnabled;
	}

	public ExtendedProperties getExtendedProperties() {
		return extendedProperties;
	}

	public void setExtendedProperties(
			ExtendedProperties extendedProperties) {
		this.extendedProperties = extendedProperties;
	}
	
	public Collection<IPropertyAccessRecorder> getPropertyAccessRecorders() {
		return propertyAccessRecorders;
	}

	public void dispose() {
		if (executorFactory.getExecutionController() != null) {
			executorFactory.getExecutionController().dispose();
		}
		extendedProperties.clear();
	}

	public List<AsyncStatement> getAsyncStatementsQueque() {
		return asyncStatementsQueque;
	}
}
