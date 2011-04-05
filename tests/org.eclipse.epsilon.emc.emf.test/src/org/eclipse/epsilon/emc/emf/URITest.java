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

package org.eclipse.epsilon.emc.emf;

import junit.framework.Assert;

import org.eclipse.epsilon.commons.util.OperatingSystem;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.junit.Test;

public class URITest {
	
	@Test
	public void testCreateUri() {
		Assert.assertEquals("platform:/resource/project/file.txt", createURI("project/file.txt"));
		Assert.assertEquals("http://www.foo.com", createURI("http://www.foo.com"));
	}
	
	@Test
	public void testWindows() {
		if (OperatingSystem.isWindows()) {
			Assert.assertEquals("file:/c:/foo.txt", createURI("c:/foo.txt"));
		}
	}
	
	@Test
	public void testUnix() {
		if (OperatingSystem.isUnix()) {
			Assert.assertEquals("platform:/resource/local/d0/file.txt", createURI("/local/d0/file.txt"));
			Assert.assertEquals("file:/local/d0/file.txt",     createFileBasedURI("/local/d0/file.txt"));
			
			Assert.assertEquals("file:/local/d0/file.txt", createURI("file:/local/d0/file.txt"));
			Assert.assertEquals("platform:/resource/local/d0/file.txt", createURI("platform:/resource/local/d0/file.txt"));
			Assert.assertEquals("c:/foo.txt", createURI("c:/foo.txt"));			
		}
	}
	
	protected static String createURI(String s) {
		return EmfUtil.createPlatformResourceURI(s).toString();
	}
	
	protected static String createFileBasedURI(String s) {
		return EmfUtil.createFileBasedURI(s).toString();
	}
}
 