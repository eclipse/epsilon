/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.test.eunit;

import java.io.File;

import org.eclipse.epsilon.workflow.test.WorkflowTestCase;
import org.junit.AfterClass;

/**
 * Common superclass for all EUnit unit tests.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public abstract class EUnitTestCase extends WorkflowTestCase {

	protected static final File BASE_DIR = new File("../org.eclipse.epsilon.workflow.test/resources/eunit/");
	protected static final File ANT_BUILD_FILE = new File(BASE_DIR, "eunit.xml");

	@AfterClass
	public static void cleanUp() {
		for (String file : BASE_DIR.list()) {
			if (file.startsWith("TEST-") && file.endsWith(".xml")) {
				new File(BASE_DIR, file).delete();
			}
		}
	}

	public EUnitTestCase() {
		super();
	}

}