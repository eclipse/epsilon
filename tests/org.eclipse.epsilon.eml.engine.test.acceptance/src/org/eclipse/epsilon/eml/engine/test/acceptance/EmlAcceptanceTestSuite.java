/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eml.engine.test.acceptance;

import org.eclipse.epsilon.eml.engine.test.acceptance.builtins.EmlCanAccessBuiltinsTests;
import org.eclipse.epsilon.eml.engine.test.acceptance.trees.TestXmlTreeMerging;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EmlCanAccessBuiltinsTests.class, TestXmlTreeMerging.class})
public class EmlAcceptanceTestSuite {

}
