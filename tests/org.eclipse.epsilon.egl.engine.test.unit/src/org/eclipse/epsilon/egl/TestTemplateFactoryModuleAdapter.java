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

import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.eol.IEolModule;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTemplateFactoryModuleAdapter {

	private static File VALID_PATH;
	private static File INVALID_PATH;
	private static File INVALID_RUNTIME_PATH;
	
	private final static String valid          = "[% for (i in Sequence{1..10}) { %]i is [%=i+2%]" + NEWLINE + "[% } %]";
	private final static String invalid        = "[%  fr (i in Sequence{1..10}) { %]i is [%=i+2%]" + NEWLINE + "[% } %]";
	private final static String invalidRuntime = "[% for (i in Sequence{1..10}) { %]i is [%=j+2%]" + NEWLINE + "[% } %]";
	
	private final IEolModule module = new EglTemplateFactoryModuleAdapter(new EglTemplateFactory());
	
	
	@BeforeClass
	public static void setUpOnce() throws IOException {	
		VALID_PATH           = FileUtil.getFile("Valid.txt",          TestTemplateFactoryModuleAdapter.class);
		INVALID_PATH         = FileUtil.getFile("Invalid.txt",        TestTemplateFactoryModuleAdapter.class);
		INVALID_RUNTIME_PATH = FileUtil.getFile("InvalidRuntime.txt", TestTemplateFactoryModuleAdapter.class);
		
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
	public void parseValidText() throws Exception {
		assertTrue(module.parse(valid));
	}
	
	@Test
	public void parseInvalidText() throws Exception {
		assertFalse(module.parse(invalid));
	}
	
	@Test
	public void parseInvalidRuntimeText() throws Exception {
		assertTrue(module.parse(invalidRuntime));
	}
	
	@Test
	public void parseValidFile() throws Exception {
		assertTrue(module.parse(VALID_PATH));
	}
	
	@Test
	public void parseInvalidFile() throws Exception {
		assertFalse(module.parse(INVALID_PATH));
	}
	
	@Test
	public void parseInvalidRuntimeFile() throws Exception {
		assertTrue(module.parse(INVALID_RUNTIME_PATH));
	}
}
