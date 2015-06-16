/*******************************************************************************
 * Copyright (c) 2009-2015 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Antonio García-Domínguez - copy and disable Concordance tests for Hudson
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.test;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.common.dt.test.CommonDevelopmentToolsTestSuite;
import org.eclipse.epsilon.emc.emf.test.EmfPluggedInTestSuite;
import org.eclipse.epsilon.emc.hutn.test.HutnEmcDriverTestSuite;
import org.eclipse.epsilon.hutn.test.HutnTestSuite;
import org.eclipse.epsilon.hutn.unparser.HutnUnparserUnitTestSuite;
import org.eclipse.epsilon.hutn.xmi.test.HutnXmiTestSuite;
import org.eclipse.epsilon.workflow.tasks.eugenia.EugeniaTestSuite;
import org.eclipse.epsilon.workflow.test.WorkflowPluggedInTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CommonDevelopmentToolsTestSuite.class,
               EmfPluggedInTestSuite.class,
               EugeniaTestSuite.class,
               WorkflowPluggedInTestSuite.class,
               /*, ConcordancePluggedInTestSuite.class*/})
public class EpsilonHudsonPluggedInTestSuite{

	public static Test suite() {
		return new JUnit4TestAdapter(EpsilonHudsonPluggedInTestSuite.class);
	}
}
