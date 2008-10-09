/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: HutnTestSuite.java,v 1.2 2008/08/07 12:44:18 louis Exp $
 */
package org.eclipse.epsilon.hutn.test;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.hutn.test.acceptance.HutnAcceptanceTestSuite;
import org.eclipse.epsilon.hutn.test.unit.HutnUnitTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({HutnUnitTestSuite.class, HutnAcceptanceTestSuite.class})
public class HutnTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(HutnTestSuite.class);
	}
}
