/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.eugenia;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Regression tests for Eugenia: run the transformation and compare
 * the obtained models with the expected models.
 */
@RunWith(Parameterized.class)
public class EugeniaRegressionTest extends EugeniaTest {

	private static final String EUNIT_PATH = RES_PREFIX + "regression.eunit";

	@Parameters
	public static Collection<String[]> getCaseNames() {
		// These should be names of the folders in resources/eugenia
		// and the names of the Ant targets in eunit.xml
		return Arrays.asList(
				new String[] { "filesystem" },
				new String[] { "flowchart" },
				new String[] { "friends" });
	}

	public EugeniaRegressionTest(String caseName) {
		super(caseName);
	}

	@Before
	public void copyEUnitSuite() throws CoreException {
		copyIntoProject(EUNIT_PATH);
	}

	@Test
	public void obtainExpectedModels() throws Exception {
		runAntTarget("base-test");
	}
}
