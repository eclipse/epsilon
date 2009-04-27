/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.emc.emf.test;

import junit.framework.Assert;

import org.eclipse.epsilon.commons.util.OperatingSystem;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.junit.Test;

public class URITest {
	
	@Test
	public void testCreateUri() {
		Assert.assertEquals(createURI("project/file.txt"), "platform:/resource/project/file.txt");
		Assert.assertEquals(createURI("http://www.foo.com"), "http://www.foo.com");
	}
	
	@Test
	public void testWindows() {
		if (OperatingSystem.isWindows()) {
			Assert.assertEquals(createURI("c:/foo.txt"), "file:/c:/foo.txt");
		}
	}
	
	@Test
	public void testUnix() {
		if (OperatingSystem.isUnix()) {
			Assert.assertEquals(createURI("/local/d0/file.txt"), "file:/local/d0/file.txt");
			Assert.assertEquals(createURI("c:/foo.txt"), "c:/foo.txt");			
		}
	}
	
	protected String createURI(String s) {
		return EmfUtil.createURI(s).toString();
	}
	
}
 