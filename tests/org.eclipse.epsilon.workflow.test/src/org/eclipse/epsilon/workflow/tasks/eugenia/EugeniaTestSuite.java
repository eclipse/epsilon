/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.eugenia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for Eugenia.
 */
@RunWith(Suite.class)
@SuiteClasses({
	EugeniaExtraModelsTest.class,
	EugeniaOptionalAttributeTest.class,
	EugeniaRegressionTest.class,
	EugeniaEmfInRootTest.class
})
public class EugeniaTestSuite {}
