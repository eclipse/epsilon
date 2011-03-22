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
import org.eclipse.epsilon.workflow.tasks.extensions.EUnitListenerExtension;

/**
 * Ant task for running EUnit test suites.
 *
 * <p><emph>Important note:</emph> if you change the tag of this Ant task, please do not
 * forget to update o.e.epsilon.eunit.dt! It can't use this task directly, so it has to
 * check for the task type manually, and I can't even use a shared constant because of
 * classloader issues.</p>
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public class EUnitTask extends ModuleTask implements TaskContainer, EUnitTestListener {

	private final List<Task> nestedTasks = new ArrayList<Task>();
	private File fReportDirectory;
	private String fPackage = EUnitModule.DEFAULT_PACKAGE;

	public void addTask(Task task) {
		nestedTasks.add(task);
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

		if (test.getOperation() == null) {
			// Root node, with no operation (neither @data nor @test)
			out.println("Global result: " + test.getResult() + sMillis);
			if (test.getResult() != EUnitTestResultType.SUCCESS) {
				fail("At least one test case had a failure or an error");
			}
			return;
		}
		if (!test.getChildren().isEmpty()) {
			// Test with children: do nothing. We're only interested in leaf nodes and the root node.
			return;
		}

		final String testDescription = "Test " + test.getMethodName() + " (" + test.explainAllBindings() + ")";
		if (test.getResult() == EUnitTestResultType.SUCCESS) {
			out.println(testDescription + " passed" + sMillis);
		} else if (test.getResult() == EUnitTestResultType.FAILURE) {
			err.println(testDescription + " failed: " + test.getException().toString() + sMillis);
		} else if (test.getResult() == EUnitTestResultType.ERROR) {
			err.println(testDescription + " failed due to an error: " + test.getException().toString() + sMillis);
			test.getException().printStackTrace(err);
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
