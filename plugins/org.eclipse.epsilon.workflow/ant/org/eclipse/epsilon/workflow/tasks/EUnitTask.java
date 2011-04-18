/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitris Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - rewrite with nested Ant task support
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.Task;
import org.apache.tools.ant.TaskContainer;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.common.dt.extensions.ClassBasedExtension;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.eunit.EUnitModule;
import org.eclipse.epsilon.eol.eunit.EUnitTest;
import org.eclipse.epsilon.eol.eunit.EUnitTestListener;
import org.eclipse.epsilon.eol.eunit.EUnitTestResultType;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.OperationFactory;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.eclipse.epsilon.eol.userinput.JavaConsoleUserInput;

/**
 * Ant task for running EUnit test suites.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public class EUnitTask extends ExecutableModuleTask implements EUnitTestListener {

	private static final String EUNIT_TEST_LISTENER_EXTENSION_POINT_ID = "org.eclipse.epsilon.workflow.eunit.listener";

	/**
	 * Class for a nested element which simply contains tasks.
	 */
	public class TaskCollection implements TaskContainer {
		private List<Task> tasks = new ArrayList<Task>();

		public void addTask(Task task) {
			tasks.add(task);
			if (task instanceof ExecutableModuleTask) {
				ExecutableModuleTask moduleTask = (ExecutableModuleTask)task;

				// The gui attribute of the EUnit Ant task is inherited by all nested tasks
				moduleTask.setGUI(isGUI());
			}
		}

		public void run() {
			// We trick tasks into using the EUnit model repository instead of the project's
			final ModelRepository projectRepo = getProjectRepository();
			try {
				setProjectRepository(module.getContext().getModelRepository());
				for (Task task : tasks) {
					task.perform();
				}
			} finally {
				setProjectRepository(projectRepo);
			}
		}
	}

	/**
	 * Operation which can call a series of Ant tasks described inside a
	 * "script" nested element of this Ant task.
	 */
	private class RunTargetOperation extends AbstractSimpleOperation {
		@SuppressWarnings("rawtypes")
		@Override
		public Object execute(Object source, List parameters, IEolContext context, AST ast) throws EolRuntimeException {
			// Check that we only get the name of the script to be run
			if (parameters.size() != 1 || !(parameters.get(0) instanceof String)) {
				throw new EolRuntimeException("runTarget only takes a String with the name of the Ant target to be run");
			}
			final String targetName = (String)parameters.get(0);

			// Check that the name of the target is not null
			if (targetName == null) {
				throw new EolRuntimeException("The name of the target to be run cannot be null");
			}

			// Run tasks, ensuring they manipulate our model repository instead of the project's
			final ModelRepository projectRepo = getProjectRepository();
			try {
				setProjectRepository(module.getContext().getModelRepository());
				getProject().executeTarget(targetName);
			} finally {
				setProjectRepository(projectRepo);
			}

			return true;
		}
	}

	/**
	 * EUnit-specific operation which is equivalent to the "exports" nested element.
	 */
	private class ExportVariableOperation extends AbstractSimpleOperation {
		@Override
		public Object execute(Object source, List parameters, IEolContext context, AST ast) throws EolRuntimeException {
			// Check that we only get the name of the script to be run
			if (parameters.size() != 1 || !(parameters.get(0) instanceof String)) {
				throw new EolRuntimeException("exportVariable only takes a String with the name of the variable to be exported");
			}

			final String varName = (String)parameters.get(0);
			EUnitTask.this.exportVariable(varName, varName, false);
			return true;
		}
	}

	/**
	 * EUnit-specific operation which is equivalent to the "imports" nested element.
	 */
	private class UseVariableOperation extends AbstractSimpleOperation {
		@Override
		public Object execute(Object source, List parameters, IEolContext context, AST ast) throws EolRuntimeException {
			// Check that we only get the name of the script to be run
			if (parameters.size() != 1 || !(parameters.get(0) instanceof String)) {
				throw new EolRuntimeException("useVariable only takes a String with the name of the variable to be exported");
			}

			final String varName = (String)parameters.get(0);
			EUnitTask.this.useVariable(varName, varName, false);
			return true;
		}
	}

	/**
	 * OperationFactory which contributes runScript. As the behaviour of runScript
	 * depends on the contents of the Ant task, this factory belongs to the Ant task,
	 * rather than to the EUnitModule class.
	 */
	private class RunScriptOperationFactory extends OperationFactory {
		@Override
		protected void createCache() {
			super.createCache();
			operationCache.put("runTarget", new RunTargetOperation());
			operationCache.put("exportVariable", new ExportVariableOperation());
			operationCache.put("useVariable", new UseVariableOperation());
		}
	}

	private File fReportDirectory;
	private String fPackage = EUnitModule.DEFAULT_PACKAGE;
	private TaskCollection modelLoadingTasks;

	public EUnitTask() {
		// By default, the EUnit Ant task disables JFace-based user input,
		// which hinders automated testing
		setGUI(false);
	}

	@Override
	protected void initialize() throws Exception {
		final EUnitModule eunitModule = (EUnitModule)module;
		eunitModule.addTestListener(this);
		eunitModule.setPackage(getPackage());
		if (getToDir() != null) {
			eunitModule.setReportDirectory(getToDir());
		}
		else {
			eunitModule.setReportDirectory(getProject().getBaseDir());
		}

		for (EUnitTestListener extraListener : ClassBasedExtension.getImplementations(EUNIT_TEST_LISTENER_EXTENSION_POINT_ID, EUnitTestListener.class)) {
			eunitModule.addTestListener(extraListener);
		}
	}

	@Override
	protected void examine() throws Exception {
		final EUnitTest test = ((EUnitModule)createModule()).getSuiteRoot();
		final PrintStream out = module.getContext().getOutputStream();

		out.println("Global result: " + test.getResult());
		if (test.getResult() == EUnitTestResultType.FAILURE || test.getResult() == EUnitTestResultType.ERROR) {
			fail("At least one test case had a failure or an error", test.getException());
		}
	}

	@Override
	public IEolExecutableModule createModule() {
		// We store the created module, so the EUnit view can call this,
		// register itself as a listener, and then let EUnitTask configure
		// it as usual
		if (module == null) {
			module = new EUnitModule();
			module.getContext().setOperationFactory(new RunScriptOperationFactory());
		}
		return module;
	}

	// TEST LISTENER METHODS

	public void beforeCase(EUnitModule module, EUnitTest test) {
		if (test.isRootTest() && Platform.getExtensionRegistry() != null) {
			EclipseContextManager.setup(module.getContext());

			// Disable notification through dialogs: it's bad for automated test cases.
			// Use the console instead.
			module.getContext().setUserInput(new JavaConsoleUserInput());
		}

		if (test.isLeafTest()) {
			try {
				// Dispose all models in this module's model repository, and reload them from the <model> references
				populateModelRepository(true);
			} catch (Exception e) {
				fail("Exception while repopulating the model repository", e);
			}
			// Run the <modelTasks>
			if (modelLoadingTasks != null) {
				modelLoadingTasks.run();
			}
		}
	}

	public void afterCase(EUnitModule module, EUnitTest test) {
		module.getContext().getModelRepository().dispose();

		final PrintStream out = module.getContext().getOutputStream();
		final PrintStream err = module.getContext().getErrorStream();
		final String sMillis = String.format(" [cpu: %d ms, wallclock: %d ms]", test.getCpuTimeMillis(), test.getWallclockTimeMillis());

		final String testDescription = "Test " + test.getMethodName() + " (" + test.explainAllBindings() + ")";
		if (test.getResult() == EUnitTestResultType.SUCCESS) {
			out.println(testDescription + " passed" + sMillis);
		} else if (test.getResult() == EUnitTestResultType.SKIPPED){
			out.println(testDescription + " skipped" + sMillis);
		} else {
			err.print(testDescription + " failed with status " + test.getResult());
			final Exception testException = test.getException();
			if (testException != null) {
				err.println(": " + testException.getMessage());
				testException.printStackTrace(err);
			}
			else {
				err.println();
			}
		}
	}

	// NESTED ELEMENTS

	public TaskCollection createModelTasks() {
		if (modelLoadingTasks == null) {
			modelLoadingTasks = new TaskCollection();
		}
		return modelLoadingTasks;
	}

	// TEST REPORT METHODS

	/**
	 * Returns the destination directory for the JUnit-like report. By default,
	 * it is the base directory of the Ant project.
	 */
	public File getToDir() {
		return fReportDirectory;
	}

	/**
	 * Changes the destination directory for the JUnit-like report. See {@link #getToDir()} for the default value.
	 */
	public void setToDir(File f) {
		fReportDirectory = f;
	}

	/**
	 * Returns the package in which all tests will be contained. By default, it
	 * is set to {@link EUnitModule#DEFAULT_PACKAGE}.
	 */
	public String getPackage() {
		return fPackage ;
	}

	/**
	 * Changes the package in which all tests will be contained. Empty or null arguments are <b>ignored</b>.
	 */
	public void setPackage(String packageName) {
		fPackage = packageName;
	}
}
