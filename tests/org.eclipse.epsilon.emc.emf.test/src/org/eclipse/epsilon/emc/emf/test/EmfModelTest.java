/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.emc.emf.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.commons.util.OperatingSystem;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.junit.Test;

public class EmfModelTest {
	
	private static final String UNIX_ABSOLUTE_PATH = "/test/Test.model";
	
	@Test
	public void storeUnixAbsolutePath() throws Exception {	
		if (OperatingSystem.isUnix()) {
			final EmfModel model = new EmfModel();
			model.setModelImpl(EmfUtil.createResource());
			
			assertTrue(model.store(URI.createFileURI(UNIX_ABSOLUTE_PATH)));
		}
	}
	
	@Test
	public void storeFailsForAbsoultePathsWithoutASchema() throws Exception {	
		final EmfModel model = new EmfModel();
		model.setModelImpl(EmfUtil.createResource());
			
		assertFalse(model.store(UNIX_ABSOLUTE_PATH));
	}
}
