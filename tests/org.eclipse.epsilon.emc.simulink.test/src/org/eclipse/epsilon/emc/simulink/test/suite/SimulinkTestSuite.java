/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.simulink.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * NOTE: This doesn't work unless you use the JRE that came
 * with MATLAB as your JAVA_HOME (and the one that you start Eclipse with),
 * and have your PATH env pointing to MATLAB's bin directory.
 * 
 */
@RunWith(ConditionalMatlabSuite.class)
@SuiteClasses({ 
	org.eclipse.epsilon.emc.simulink.test.unit.AllTests.class,
	//org.eclipse.epsilon.emc.simulink.test.unit.type.AllTests.class
})
public class SimulinkTestSuite {
}
