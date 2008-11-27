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
package org.eclipse.epsilon.egl.output;

import java.io.File;
import java.io.IOException;

import org.eclipse.epsilon.commons.util.FileUtil;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;

public class TestWriter {
	
	private static File VALID_PATH;
	private static File READ_ONLY_PATH;
	
	private int testNumber = 0;
	
	@BeforeClass
	public static void setUpOnce() throws IOException {	
		VALID_PATH     = FileUtil.getFile("Valid.txt", TestWriter.class);
		READ_ONLY_PATH = FileUtil.getFile("ReadOnly.txt", TestWriter.class);
		
		READ_ONLY_PATH.createNewFile();
		READ_ONLY_PATH.setReadOnly();
	}
	
	@AfterClass
	public static void tearDownOnce() throws IOException {
		if (VALID_PATH.exists())     VALID_PATH.delete();
		if (READ_ONLY_PATH.exists()) READ_ONLY_PATH.delete();
		
	}
	
	@Before
	public void setUp() {
		testNumber++;
	}
	
	@Test
	public void testWriteValid() throws IOException {
		final String contents = "Hello" + NEWLINE + "World!" + NEWLINE + testNumber;
		new Writer(VALID_PATH, contents).write();
		
		assertEquals(contents, org.eclipse.epsilon.egl.util.FileUtil.read(VALID_PATH));
	}
	
	@Test (expected=IOException.class)
	public void testWriteReadOnly() throws IOException {
		final String contents = "Hello" + NEWLINE + "World!" + NEWLINE + testNumber;
		new Writer(READ_ONLY_PATH, contents).write();
	}
}
