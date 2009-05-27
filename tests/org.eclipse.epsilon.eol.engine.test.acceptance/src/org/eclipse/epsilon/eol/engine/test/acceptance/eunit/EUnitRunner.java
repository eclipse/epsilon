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

package org.eclipse.epsilon.eol.engine.test.acceptance.eunit;

import java.io.File;
import java.util.HashMap;

import junit.framework.TestResult;

import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.eunit.EUnitModule;
import org.eclipse.epsilon.eol.eunit.EUnitTestResult;
import org.eclipse.epsilon.eol.eunit.EUnitTestResultType;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

public class EUnitRunner extends Runner{
	
	protected Class clazz;
	protected EUnitModule module;
	protected HashMap<String, Description> descriptions = new HashMap<String, Description>();
	protected Description testSuiteDescription;
	protected String eolFile;
	
	public EUnitRunner(Class clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public Description getDescription() {
		
		module = new EUnitModule();
		testSuiteDescription = Description.createSuiteDescription(clazz);
		
		try {
			eolFile = clazz.getResource(clazz.getSimpleName() + ".eol").getFile();
			module.parse(new File(eolFile));
		} catch (Exception e) {
			return testSuiteDescription;
		}
		
		
		if (module.getParseProblems().size() > 0) {
			return testSuiteDescription;
		}
		
		for (EolOperation test : module.getTests()) {
			Description testDescription = Description.createTestDescription(clazz, test.getName());
			testSuiteDescription.addChild(testDescription);
			descriptions.put(test.getName(), testDescription);
			
		}
		
		return testSuiteDescription;
	}

	@Override
	public void run(RunNotifier notifier) {
		
		notifier.fireTestStarted(testSuiteDescription);
		
		if (eolFile == null) {
			//notifier.fireTestIgnored(testSuiteDescription);
			notifier.fireTestFailure(new Failure(testSuiteDescription, new Exception("EUnit file " + clazz.getSimpleName() + ".eol does not exist")));
			return;
		}
		
		if (module.getParseProblems().size() > 0) {
			notifier.fireTestFailure(new Failure(testSuiteDescription, new Exception("Syntax errors in " + eolFile)));
			return;
		}
		
		try {
			module.execute();
		}
		catch (Exception ex) {
			notifier.fireTestFailure(new Failure(testSuiteDescription, ex));
		}

		for (EUnitTestResult result : module.getTestResults()) {
			String name = result.getOperation().getName();
			Description description = descriptions.get(name);
			notifier.fireTestStarted(description);
			if (result.getType() == EUnitTestResultType.SUCCESS) {
				notifier.fireTestFinished(description);
			}
			else if (result.getType() == EUnitTestResultType.FAILURE) {
				notifier.fireTestFailure(new Failure(description, new Exception(result.getMessage())));
			}
			else if (result.getType() == EUnitTestResultType.ERROR) {
				notifier.fireTestFailure(new Failure(description, result.getException()));
			}
		}
		
		notifier.fireTestFinished(testSuiteDescription);
		
	}
	
}
 