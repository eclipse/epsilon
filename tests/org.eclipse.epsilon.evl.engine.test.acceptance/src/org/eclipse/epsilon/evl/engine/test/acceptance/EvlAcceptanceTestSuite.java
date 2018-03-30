/*******************************************************************************
 * Copyright (c) 2017 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Sina Madani - Concurrency tests and refactoring
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.evl.engine.test.acceptance;

import org.eclipse.epsilon.evl.engine.test.acceptance.builtins.EvlCanAccessBuiltinsTests;
import org.eclipse.epsilon.evl.engine.test.acceptance.equivalence.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({
		EvlCanAccessBuiltinsTests.class,
		EvlTests.class,
		EvlModuleEquivalenceTests.class,
	}
)
public class EvlAcceptanceTestSuite {
	
	public static Test suite() {
		return new JUnit4TestAdapter(EvlAcceptanceTestSuite.class);
	}
}
