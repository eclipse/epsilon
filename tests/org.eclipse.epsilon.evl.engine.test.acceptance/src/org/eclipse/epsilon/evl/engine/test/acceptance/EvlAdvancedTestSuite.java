/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.engine.test.acceptance;

import org.eclipse.epsilon.evl.engine.test.acceptance.equivalence.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({
	EvlParallelOperationsTests.class,
	EvlModuleEquivalenceTests.class
})
public class EvlAdvancedTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(EvlAdvancedTestSuite.class);
	}
}
