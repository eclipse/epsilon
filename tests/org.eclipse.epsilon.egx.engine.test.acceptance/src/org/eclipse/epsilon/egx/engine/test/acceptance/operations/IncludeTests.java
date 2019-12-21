/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egx.engine.test.acceptance.operations;

import java.nio.file.Paths;
import org.eclipse.epsilon.egl.*;
import org.junit.*;

/**
 * 
 * @since 1.6
 */
public class IncludeTests {
	
	IEgxModule module;
	
	@Test
	public void testEglInclude() throws Exception {
		module = new EgxModule(Paths.get(getClass().getResource("").toURI()));
		module.parse(getClass().getResource("foo.egx"));
		module.execute();
	}
	
}
