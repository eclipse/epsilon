/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ecl.engine.test.acceptance;

import org.eclipse.epsilon.ecl.engine.test.acceptance.builtins.EclCanAccessBuiltinsTests;
import org.eclipse.epsilon.ecl.engine.test.acceptance.trees.TestXmlTreeComparison;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EclCanAccessBuiltinsTests.class, TestXmlTreeComparison.class})
public class EclAcceptanceTestSuite {

}
