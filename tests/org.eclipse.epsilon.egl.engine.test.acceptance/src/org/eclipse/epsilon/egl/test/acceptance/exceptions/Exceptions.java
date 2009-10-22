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

import static org.junit.Assert.*;
import static org.eclipse.epsilon.egl.util.FileUtil.FILE_SEP;

import java.io.File;
import java.io.IOException;

import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
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
	public void stopPreserve() throws IOException, EolModelLoadingException {
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
	public void startPreserve4() throws IOException, EolModelLoadingException {
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
	public void startPreserve2() throws IOException, EolModelLoadingException {
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
	public void startPreserve2NoCT() throws IOException, EolModelLoadingException {
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
	public void setContentType() throws IOException, EolModelLoadingException {
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
	public void load() throws IOException, EolModelLoadingException {
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
	public void process() throws IOException, EolModelLoadingException {
		try {
			AcceptanceTestUtil.run(Process);
			fail("Expected EglRuntimeException");
			
		} catch (EglRuntimeException e) {
			assertEquals("Could not process '" + StopPreserve.getName() + "'", e.getReason());
			assertEquals(3, e.getLine());
			assertEquals(6, e.getColumn());
			
			final EglRuntimeException cause = (EglRuntimeException)e.getCause();
			
			assertEquals("There is no current region to stop preserving.", cause.getReason());
			assertEquals(1, cause.getLine());
			assertEquals(7, cause.getColumn());
		}
	}
	
	@Test
	public void processDeep() throws IOException, EolModelLoadingException {
		try {
			AcceptanceTestUtil.run(ProcessDeep);
			fail("Expected EglRuntimeException");
			
		} catch (EglRuntimeException e) {
			assertEquals("Could not process '" + Process.getName() + "'", e.getReason());
			assertEquals(3, e.getLine());
			assertEquals(6, e.getColumn());
			
			final EglRuntimeException cause = (EglRuntimeException)e.getCause();
			assertEquals("Could not process '" + StopPreserve.getName() + "'", cause.getReason());
			assertEquals(3, cause.getLine());
			assertEquals(6, cause.getColumn());
			
			final EglRuntimeException causeOfCause = (EglRuntimeException)cause.getCause();
			
			assertEquals("There is no current region to stop preserving.", causeOfCause.getReason());
			assertEquals(1, causeOfCause.getLine());
			assertEquals(7, causeOfCause.getColumn());
		}
	}
}

