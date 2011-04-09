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
package org.eclipse.epsilon.egl.test.acceptance.exceptions;

import static org.eclipse.epsilon.egl.util.FileUtil.FILE_SEP;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class Exceptions {

	private static File StopPreserve;
	private static File StartPreserve4;
	private static File StartPreserve2;
	private static File StartPreserve2NoCT;
	private static File SetContentType;
	
	private static File Load;
	private static File Process;
	private static File ProcessDeep;
	
	@BeforeClass
	public static void setUpOnce() {
		StopPreserve       = FileUtil.getFile("StopPreserve.egl",       Exceptions.class);
		StartPreserve4     = FileUtil.getFile("StartPreserve4.egl",     Exceptions.class);
		StartPreserve2     = FileUtil.getFile("StartPreserve2.egl",     Exceptions.class);
		StartPreserve2NoCT = FileUtil.getFile("StartPreserve2NoCT.egl", Exceptions.class);
		SetContentType     = FileUtil.getFile("SetContentType.egl",     Exceptions.class);
		
		Load               = FileUtil.getFile("Load.egl",               Exceptions.class);
		Process            = FileUtil.getFile("Process.egl",            Exceptions.class);
		ProcessDeep        = FileUtil.getFile("ProcessDeep.egl",        Exceptions.class);
	}
	
	
	// OutputBuffer tests \\
	
	@Test
	public void stopPreserve() throws Exception {
		try {
			AcceptanceTestUtil.run(StopPreserve);
			fail("Expected EglRuntimeException");
			
		} catch (EglRuntimeException e) {
			assertEquals("There is no current region to stop preserving.", e.getReason());
			assertEquals(1, e.getLine());
			assertEquals(7, e.getColumn());
		}
	}
	
	@Test
	public void startPreserve4() throws Exception {
		try {
			AcceptanceTestUtil.run(StartPreserve4);
			fail("Expected EglRuntimeException");
			
		} catch (EglRuntimeException e) {
			assertEquals("Preservation of the current region must be stopped before preservation of another region may begin.", e.getReason());
			assertEquals(3, e.getLine());
			assertEquals(8, e.getColumn());
		}
	}
	
	@Test
	public void startPreserve2() throws Exception {
		try {
			AcceptanceTestUtil.run(StartPreserve2);
			fail("Expected EglRuntimeException");
			
		} catch (EglRuntimeException e) {
			assertEquals("Preservation of the current region must be stopped before preservation of another region may begin.", e.getReason());
			assertEquals(5, e.getLine());
			assertEquals(8, e.getColumn());
		}
	}
	
	@Test
	public void startPreserve2NoCT() throws Exception {
		try {
			AcceptanceTestUtil.run(StartPreserve2NoCT);
			fail("Expected EglRuntimeException");
			
		} catch (EglRuntimeException e) {
			assertEquals("A content type must be specified before using startPreserve(id, enabled).", e.getReason());
			assertEquals(2, e.getLine());
			assertEquals(5, e.getColumn());
		}
	}
	
	@Test
	public void setContentType() throws Exception {
		try {
			AcceptanceTestUtil.run(SetContentType);
			fail("Expected EglRuntimeException");
			
		} catch (EglRuntimeException e) {
			assertEquals("'NotAContentType' is not a recognised content type.", e.getReason());
			assertEquals(2, e.getLine());
			assertEquals(5, e.getColumn());
		}
	}
	
	
		
	// EglTemplate tests \\
	
	@Test
	public void load() throws Exception {
		try {
			AcceptanceTestUtil.run(Load);
			fail("Expected EglRuntimeException");
			
		} catch (EglRuntimeException e) {
			assertEquals("Template not found 'include" + FILE_SEP + "NotHere.egl'", e.getReason());
			assertEquals(3, e.getLine());
			assertEquals(16, e.getColumn());
		}
	}
	
	@Test
	public void process() throws Exception {
		try {
			AcceptanceTestUtil.run(Process);
			fail("Expected EglRuntimeException");
			
		} catch (EglRuntimeException e) {
			assertEquals("There is no current region to stop preserving.", e.getReason());
			assertEquals(3, e.getLine());
			assertEquals(6, e.getColumn());
		}
	}
	
	@Test
	public void processDeep() throws Exception {
		try {
			AcceptanceTestUtil.run(ProcessDeep);
			fail("Expected EglRuntimeException");
			
		} catch (EglRuntimeException e) {
			assertEquals("There is no current region to stop preserving.", e.getReason());
			assertEquals(3, e.getLine());
			assertEquals(6, e.getColumn());
		}
	}
}

