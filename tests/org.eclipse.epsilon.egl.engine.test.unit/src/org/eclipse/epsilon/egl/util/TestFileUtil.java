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
package org.eclipse.epsilon.egl.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestFileUtil {

	private static boolean OS_IS_WINDOWS;
	private static File PARENT;
	
	@BeforeClass
	public static void setup() {
		OS_IS_WINDOWS = System.getProperty("os.name").contains("Windows");
		
		if (OS_IS_WINDOWS) {
			PARENT = new File("C:\\Test");
		} else {
			PARENT = new File("/tmp/test"); 
		}
	}
	
	@Test
	public void testResolveAbsolutePath() {
		final String expected = OS_IS_WINDOWS ? "C:\\TestAbs\\Test.txt" : "/tmp/test-abs/Test.txt";
		final String path     = expected;
		final String actual   = FileUtil.resolve(path, PARENT);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testResolveRelativePath() {
		final String expected = OS_IS_WINDOWS ? "C:\\Test\\Test.txt" : "/tmp/test/Test.txt";
		final String path     = "Test.txt";
		final String actual   = FileUtil.resolve(path, PARENT);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testResolveRelativePathNoParent() {
		final String expected = new File("Test.txt").getAbsolutePath();
		final String path     = "Test.txt";
		final String actual   = FileUtil.resolve(path, null);
		
		assertEquals(expected, actual);
	}
	
	@Test (expected=NullPointerException.class)
	public void testResolveNullPath() {
		FileUtil.resolve(null, null);
	}
	
	@Test
	public void testRead() throws IOException {
		final String expected = "Hello" + FileUtil.NEWLINE + "world!";
		final String actual   = FileUtil.read(org.eclipse.epsilon.common.util.FileUtil.getFile("Read.txt", TestFileUtil.class));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReadTrailing() throws IOException {
		final String expected = "Hello" + FileUtil.NEWLINE + "world!" + FileUtil.NEWLINE;
		final String actual   = FileUtil.read(org.eclipse.epsilon.common.util.FileUtil.getFile("ReadTrailing.txt", TestFileUtil.class));
		
		assertEquals(expected, actual);
	}
}
