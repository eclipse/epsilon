/*******************************************************************************
 * Copyright (c) 2011 Antonio Garcia-Dominguez.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
