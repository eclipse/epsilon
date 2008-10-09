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
package org.eclipse.epsilon.egl;

import static org.junit.Assert.*;
import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;

import java.io.File;
import java.io.IOException;

import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEglModuleImpl {

	private static File VALID_PATH;
	private static File INVALID_PATH;
	private static File INVALID_RUNTIME_PATH;
	
	private final static String valid          = "[% for (i in Sequence{1..10}) { %]i is [%=i+2%]" + NEWLINE + "[% } %]";
	private final static String invalid        = "[%  fr (i in Sequence{1..10}) { %]i is [%=i+2%]" + NEWLINE + "[% } %]";
	private final static String invalidRuntime = "[% for (i in Sequence{1..10}) { %]i is [%=j+2%]" + NEWLINE + "[% } %]";
	
	private final IEglModule module = new EglModule();
	
	private final String output = "i is 3"  + NEWLINE +
	                              "i is 4"  + NEWLINE +
	                              "i is 5"  + NEWLINE +
	                              "i is 6"  + NEWLINE +
	                              "i is 7"  + NEWLINE +
	                              "i is 8"  + NEWLINE +
	                              "i is 9"  + NEWLINE +
	                              "i is 10" + NEWLINE +
	                              "i is 11" + NEWLINE +
	                              "i is 12" + NEWLINE;
	
	
	@BeforeClass
	public static void setUpOnce() throws IOException {	
		VALID_PATH           = FileUtil.getFile("Valid.txt",          TestEglModuleImpl.class);
		INVALID_PATH         = FileUtil.getFile("Invalid.txt",        TestEglModuleImpl.class);
		INVALID_RUNTIME_PATH = FileUtil.getFile("InvalidRuntime.txt", TestEglModuleImpl.class);
		
		org.eclipse.epsilon.egl.util.FileUtil.write(VALID_PATH,           valid);
		org.eclipse.epsilon.egl.util.FileUtil.write(INVALID_PATH,         invalid);
		org.eclipse.epsilon.egl.util.FileUtil.write(INVALID_RUNTIME_PATH, invalidRuntime);
	}
	
	@AfterClass
	public static void tearDownOnce() {
		if (VALID_PATH.exists())           VALID_PATH.delete();
		if (INVALID_PATH.exists())         INVALID_PATH.delete();
		if (INVALID_RUNTIME_PATH.exists()) INVALID_RUNTIME_PATH.delete();
		
	}
	
	@Before
	public void setUp() {
		module.reset();
	}
	
	@Test
	public void parseValidText() {
		assertTrue(module.parse(valid));
	}
	
	@Test
	public void parseInvalidText() {
		assertFalse(module.parse(invalid));
	}
	
	@Test
	public void parseInvalidRuntimeText() {
		assertTrue(module.parse(invalidRuntime));
	}
	
	@Test
	public void parseValidFile() throws IOException {
		assertTrue(module.parse(VALID_PATH));
	}
	
	@Test
	public void parseInvalidFile() throws IOException {
		assertFalse(module.parse(INVALID_PATH));
	}
	
	@Test
	public void parseInvalidRuntimeFile() throws IOException {
		assertTrue(module.parse(INVALID_RUNTIME_PATH));
	}
	
	@Test
	public void execute() throws EglRuntimeException {
		module.parse(valid);
		
		final String processed = module.execute();
		
		assertEquals(output, processed);
	}
	
	@Test
	public void executeTwice() throws EglRuntimeException {
		module.parse(valid);
		
		module.execute();
		final String processed = module.execute();
		
		assertEquals(output, processed);
	}
}
