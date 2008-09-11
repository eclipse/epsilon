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
package org.eclipse.epsilon.workflow.tasks;

import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.eunit.EUnitModule;
import org.eclipse.epsilon.eol.eunit.EUnitTestResult;
import org.eclipse.epsilon.eol.eunit.EUnitTestResultType;

//TODO : Add uniform support for showing/hiding complete stack traces
public class EUnitTask extends ExecutableModuleTask {
	
	@Override
	protected IEolExecutableModule createModule() {
		return new EUnitModule();
	}

	@Override
	protected void examine() throws Exception {
		EUnitModule module = (EUnitModule) this.module;
		int failedTests = 0;
		for (EUnitTestResult result : module.getTestResults()) {
			if (result.getType() == EUnitTestResultType.SUCCESS) {
				module.getContext().getOutputStream().println("Test " + result.getOperation().getName() + " passed");
			}
			else if (result.getType() == EUnitTestResultType.FAILURE) {
				module.getContext().getErrorStream().println("Test " + result.getOperation().getName() + " failed : " + result.getMessage());
				failedTests++;
			}
			else if (result.getType() == EUnitTestResultType.ERROR) {
				module.getContext().getErrorStream().println("Test " + result.getOperation().getName() + " failed due to an error : " + result.getException().toString());
				//result.getException().printStackTrace(module.getContext().getErrorStream());
				failedTests++;
			}
		}
		if (failedTests > 0) fail(failedTests + " tests failed");
	}

	@Override
	protected void initialize() throws Exception {
		
	}

}
