/*******************************************************************************
 * Copyright (c) 2012 Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio García-Domínguez - initial API and implementation
******************************************************************************/
package org.eclipse.epsilon.eol.engine.test.acceptance.circularImports;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;
import org.junit.Test;

/**
 * Tests that ensure that EOL import cycles are properly detected
 * and reported.
 */
public class CircularImportTests {

	@Test
	public void immediate() throws Exception {
		parse("immediate.eol");
	}

	@Test
	public void oneLevel() throws Exception {
		parse("two-a.eol");
	}

	@Test
	public void twoLevels() throws Exception {
		parse("three-a.eol");
	}

	private void parse(final String script) throws Exception {
		EolModule module = new EolModule();
		final URI eolURI = CircularImportTests.class.getResource(script).toURI();
		module.parse(new File(eolURI.getPath()));
		assertEquals(new ArrayList<ParseProblem>(), module.getParseProblems());
		module.execute();
	}
}
