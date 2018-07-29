/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.test.util;

import java.util.List;

import org.junit.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class AssumeMatlabInstalled implements TestRule {

	private static String version = null;

	public AssumeMatlabInstalled() {
		try {
			int i = 0;
			List<String> versions = MatlabEngineFilesEnum.availableVersions();
			for (String v : versions) {
				int newI = MatlabEngineFilesEnum.VERSIONS.indexOf(v);
				i = newI > i ? newI : i;
			}
			version = MatlabEngineFilesEnum.VERSIONS.get(i);
		} catch (Exception e) {}
	}

	public static String getVersion() {
		return version;
	}

	public AssumeMatlabInstalled(String v) {
		if (MatlabEngineFilesEnum.exists(v)) {			
			version = v; 
		}
	}

	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement() {
			
			@Override
			public void evaluate() throws Throwable {
				if (version != null) {
					base.evaluate();
				} else {
					throw new AssumptionViolatedException("Could not find any MATLAB version installed. Skipping test!");
				}
			}
			
		};
	}

}