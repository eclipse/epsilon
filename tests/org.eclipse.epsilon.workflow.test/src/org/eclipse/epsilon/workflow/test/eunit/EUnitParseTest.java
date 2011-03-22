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

import static org.junit.Assert.assertTrue;

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.eol.eunit.EUnitParseException;
import org.junit.Test;

/**
 * Tests the EUnit Ant task with bad .eunit files (with parsing errors).
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public class EUnitParseTest extends EUnitTestCase {

	@Test
	public void buildFailsWithBadImports() {
		try {
			runTarget(ANT_BUILD_FILE, "badImports");
		} catch (BuildException ex) {
				assertTrue("The cause of the build exception should be an Epsilon exception",
						ex.getCause() instanceof EUnitParseException);
		}
	}

}
