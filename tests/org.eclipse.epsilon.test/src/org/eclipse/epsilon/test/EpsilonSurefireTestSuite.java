/*******************************************************************************
 * Copyright (c) 2020 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors: Sina Madani
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.test;

import org.eclipse.epsilon.egl.dt.traceability.editor.EglTraceabilityEditorTestSuite;
import org.eclipse.epsilon.egl.engine.traceability.fine.test.unit.EglFineGrainedTraceabilityUnitTestSuite;
import org.eclipse.epsilon.flock.test.unit.FlockEngineUnitTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

/**
 * Test suite to be run using
 * <code>mvn -f tests/org.eclipse.epsilon.test surefire:test -P unit,-plugged</code>
 * 
 * @author Sina Madani
 * @since 1.6
 */
@RunWith(Suite.class)
@SuiteClasses({
	EglFineGrainedTraceabilityUnitTestSuite.class,
	EglTraceabilityEditorTestSuite.class,
	FlockEngineUnitTestSuite.class,
	EpsilonJenkinsTestSuite.class
})
public class EpsilonSurefireTestSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(EpsilonSurefireTestSuite.class);
	}
}
