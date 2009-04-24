/*******************************************************************************
 * Copyright (c) 2008 The University of York.
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
package org.eclipse.epsilon.hutn.unparser;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

import org.eclipse.epsilon.hutn.unparser.classObject.UnparserClassObjectSuite;
import org.eclipse.epsilon.hutn.unparser.packageObject.UnparserPackageObjectSuite;
import org.eclipse.epsilon.hutn.unparser.slot.UnparserSlotSuite;
import org.eclipse.epsilon.hutn.unparser.spec.UnparserSpecSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({UnparserSlotSuite.class, UnparserClassObjectSuite.class,
               UnparserPackageObjectSuite.class, UnparserSpecSuite.class})
public class HutnUnparserUnitTestSuite {
	public static Test suite() {
		return new JUnit4TestAdapter(HutnUnparserUnitTestSuite.class);
	}
}
