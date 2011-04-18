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
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.eunit.EUnitModule;
import org.eclipse.epsilon.eol.eunit.EUnitTest;
import org.eclipse.epsilon.eol.eunit.EUnitTestListener;
import org.eclipse.epsilon.eol.eunit.EUnitTestResultType;
import org.eclipse.epsilon.eol.userinput.JavaConsoleUserInput;
import org.eclipse.epsilon.workflow.tasks.extensions.EUnitListenerExtension;

/**
 * Ant task for running EUnit test suites.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public class EUnitTask extends ModuleTask implements TaskContainer, EUnitTestListener {

	private final List<Task> nestedTasks = new ArrayList<Task>();
	private File fReportDirectory;
	private String fPackage = EUnitModule.DEFAULT_PACKAGE;

	public EUnitTask() {
		// By default, the EUnit Ant task disables JFace-based user input,
		// which hinders automated testing
		setGUI(false);
	}

	public void addTask(Task task) {
		nestedTasks.add(task);
		if (task instanceof ModuleTask) {
			ModuleTask moduleTask = (ModuleTask)task;

			// The gui attribute of the EUnit Ant task is inherited by all nested tasks
			moduleTask.setGUI(isGUI());
		}
	}

	@Override
	protected void initialize() throws Exception {
		final EUnitModule eunitModule = (EUnitModule)module;
		eunitModule.addTestListener(this);
		eunitModule.setPackage(getPackage());
		eunitModule.getContext().setModelRepository(getProjectRepository());
		if (getToDir() != null) {
			eunitModule.setReportDirectory(getToDir());
		}
		else {
			eunitModule.setReportDirectory(getProject().getBaseDir());
		}

		for (EUnitTestListener extraListener : EUnitListenerExtension.getListeners()) {
			eunitModule.addTestListener(extraListener);
		}
	}

	@Override
	protected void examine() throws Exception {
		// nothing to do
	}

	@Override
	public IEolExecutableModule createModule() {
		// We store the created module, so the EUnit view can call this,
		// register itself as a listener, and then let EUnitTask configure
		// it as usual
		if (module == null) {
			module = new EUnitModule();
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
			for (Task task : nestedTasks) {
				task.perform();
			}
		}
	}

	public void afterCase(EUnitModule module, EUnitTest test) {
		Task disposeTask = new DisposeModelsTask();
		disposeTask.setProject(getProject());
		disposeTask.execute();

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

		if (test.isRootTest()) {
			// Root node, with no operation (neither @data nor @test)
			out.println("Global result: " + test.getResult() + sMillis);
			if (test.getResult() == EUnitTestResultType.FAILURE || test.getResult() == EUnitTestResultType.ERROR) {
				fail("At least one test case had a failure or an error", test.getException());
			}
		}
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
