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
 * $Id: HutnUnitTestSuite.java,v 1.3 2008/08/07 14:51:10 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.unit;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ParseSuite.class, PostProcessorSuite.class, TranslatorSuite.class,
               ModelValidatorSuite.class, ConfigFileValidatorSuite.class, ModelGeneratorSuite.class})
public class HutnUnitTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(HutnUnitTestSuite.class);
	}
}
