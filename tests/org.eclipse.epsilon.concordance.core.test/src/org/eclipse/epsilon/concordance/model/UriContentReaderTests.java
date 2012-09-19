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
package org.eclipse.epsilon.concordance.model;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.util.FileUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class UriContentReaderTests {

	private static final String NEW_LINE = System.getProperty("line.separator");
	private static final File file = FileUtil.getFile("example.txt", UriContentReaderTests.class);
	
	@BeforeClass
	public static void setupOnce() throws Exception {
		FileUtil.setFileContents("foo" + NEW_LINE + "bar", file);
	}
	
	@Test
	public void shouldReadFileContents() throws IOException {
		assertEquals("foo" + NEW_LINE + "bar", readContents(file));
	}
	
	@Test(expected=IOException.class)
	public void shouldThrowExceptionWhenUriCannotBeResolved() throws IOException {
		readContents(new File("nonexistent.txt"));
	}
	
	
	private static String readContents(File file) throws IOException {
		return new UriContentReader(URI.createFileURI(file.getAbsolutePath())).readContents().trim();
	}
}
