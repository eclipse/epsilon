/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.test;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.egl.test.EglTestSuite;
import org.eclipse.epsilon.emc.emf.test.EmfTestSuite;
import org.eclipse.epsilon.eol.engine.test.acceptance.EolAcceptanceTestSuite;
import org.eclipse.epsilon.hutn.test.HutnTestSuite;
import org.eclipse.epsilon.hutn.unparser.HutnUnparserUnitTestSuite;
import org.eclipse.epsilon.hutn.xmi.test.HutnXmiTestSuite;
import org.eclipse.epsilon.migration.test.EpsilonMigrationLanguageTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EmfTestSuite.class,
               EolAcceptanceTestSuite.class, EglTestSuite.class,
               HutnTestSuite.class,
               HutnUnparserUnitTestSuite.class, HutnXmiTestSuite.class,
               EpsilonMigrationLanguageTestSuite.class})
public class EpsilonTestSuite{

	public static Test suite() {
		return new JUnit4TestAdapter(EpsilonTestSuite.class);
	}
}
