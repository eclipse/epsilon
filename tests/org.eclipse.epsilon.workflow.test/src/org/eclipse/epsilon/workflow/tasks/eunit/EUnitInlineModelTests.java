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
package org.eclipse.epsilon.workflow.tasks.eunit;

import org.junit.Test;

/**
 * Tests for the inline model support.
 *
 * @author Antonio Garcia-Dominguez
 */
public class EUnitInlineModelTests extends EUnitTestCase {

	@Test
	public void inlineHutnModelsWork() throws Exception {
		runTarget(ANT_BUILD_FILE, "inline-hutn");
	}

	@Test
	public void inlineAntTasksWork() throws Exception {
		runTarget(ANT_BUILD_FILE, "inline-emf");
	}
}
