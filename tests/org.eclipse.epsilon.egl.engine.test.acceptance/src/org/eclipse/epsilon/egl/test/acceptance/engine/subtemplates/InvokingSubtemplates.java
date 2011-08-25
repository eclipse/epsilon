/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.test.acceptance.engine.subtemplates;

import static org.eclipse.epsilon.commons.util.FileUtil.getFile;
import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;

import java.io.File;

import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.junit.Test;

public class InvokingSubtemplates {
	
	@Test
	public void subtemplatesInDifferentDirectories() throws Exception {
		final File   driver   = getFile("Driver.egl", InvokingSubtemplates.class);
		final String expected = "Hello from First" + NEWLINE + "Hello from Second";
		
		AcceptanceTestUtil.test(driver, expected);
	}
}
