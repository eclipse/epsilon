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
package org.eclipse.epsilon.egl.test.acceptance.engine;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.eclipse.epsilon.egl.test.models.Model;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.BeforeClass;
import org.junit.Test;

public class Engine {
	
	private static File OO2JavaProgram, OO2JavaImportProgram;
	private static File OO2JavaExpected;
	private static File runtimeExceptionProgram;
	private static File invalidPath;
	
	
	@BeforeClass
	public static void setUpOnce() {
		OO2JavaProgram          = FileUtil.getFile("OO2Java.egl",       Engine.class);
		OO2JavaImportProgram    = FileUtil.getFile("OO2JavaImport.egl", Engine.class);
		OO2JavaExpected         = FileUtil.getFile("OO2Java.txt",       Engine.class);
		
		runtimeExceptionProgram = FileUtil.getFile("RuntimeException.egl", Engine.class);
		invalidPath             = FileUtil.getFile("Inva*lid.egl",         Engine.class);
	}
	
	@Test
	public void testValid() throws IOException, EglRuntimeException, EolModelLoadingException {
		AcceptanceTestUtil.test(OO2JavaProgram, OO2JavaExpected, Model.OOInstance);
	}
	
	@Test
	public void testImport() throws IOException, EglRuntimeException, EolModelLoadingException {
		AcceptanceTestUtil.test(OO2JavaImportProgram, OO2JavaExpected, Model.OOInstance);
	}
	
	@Test (expected=EglRuntimeException.class)
	public void testRuntimeException() throws IOException, EglRuntimeException, EolModelLoadingException {
		try {
			AcceptanceTestUtil.run(runtimeExceptionProgram);
		
		} catch (EglRuntimeException ex) {
			assertEquals(2,  ex.getLine());
			assertEquals(9, ex.getColumn());
			throw ex;
		}
	}
	
	@Test (expected=EglRuntimeException.class)
	public void testParseInvalid() throws EglRuntimeException, EolModelLoadingException {
		AcceptanceTestUtil.run(invalidPath);
	}
}