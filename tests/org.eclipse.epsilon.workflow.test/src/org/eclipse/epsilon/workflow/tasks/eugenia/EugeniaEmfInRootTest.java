/*******************************************************************************
 * Copyright (c) 2011 Antonio Garcia-Dominguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.eugenia;

import org.eclipse.core.runtime.CoreException;
import org.junit.Test;

/**
 * Tests that EuGENia works fine when the .emf is in the root folder of the project.
 */
public class EugeniaEmfInRootTest extends EugeniaTest {

	private static final String CASE_NAME = "friends";

	public EugeniaEmfInRootTest() {
		super(CASE_NAME);
	}

	@Test
	public void worksWithEmfInRoot() throws CoreException {
		runAntTarget("emf-in-root");
	}
}
