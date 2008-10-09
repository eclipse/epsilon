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
package org.eclipse.epsilon.egl.types;

import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.merge.partition.CommentBlockPartitioner;
import org.eclipse.epsilon.egl.test.MockContext;
import org.eclipse.epsilon.egl.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.epsilon.commons.util.UriUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEglFileGeneratingTemplate {
	
	private static File PROGRAM;
	private static File OUTPUT1;
	private static File OUTPUT2;
	private static File OUTPUT3;
	private static File OUTPUT4;
	private static File EXISTING;
	private static File GENERATED;
	private static File INVALID;
	
	private EglFileGeneratingTemplate template;
	private int testNumber = 1;
	
	@BeforeClass
	public static void setUpOnce() throws IOException {
		PROGRAM   = org.eclipse.epsilon.commons.util.FileUtil.getFile("Generate.egl",  TestEglFileGeneratingTemplate.class);
		OUTPUT1   = org.eclipse.epsilon.commons.util.FileUtil.getFile("Output1.txt",   TestEglFileGeneratingTemplate.class);
		OUTPUT2   = org.eclipse.epsilon.commons.util.FileUtil.getFile("Output2.txt",   TestEglFileGeneratingTemplate.class);
		OUTPUT3   = org.eclipse.epsilon.commons.util.FileUtil.getFile("Output3.txt",   TestEglFileGeneratingTemplate.class);
		OUTPUT4   = org.eclipse.epsilon.commons.util.FileUtil.getFile("Output4.txt",   TestEglFileGeneratingTemplate.class);
		EXISTING  = org.eclipse.epsilon.commons.util.FileUtil.getFile("Existing.txt",  TestEglFileGeneratingTemplate.class);
		GENERATED = org.eclipse.epsilon.commons.util.FileUtil.getFile("Generated.txt", TestEglFileGeneratingTemplate.class);
		INVALID   = org.eclipse.epsilon.commons.util.FileUtil.getFile("Inval*d.egl",   TestEglFileGeneratingTemplate.class);
		
		if (!EXISTING.exists()) EXISTING.createNewFile();
	}
	
	@AfterClass
	public static void tearDownOnce() {
		if (PROGRAM.exists())   PROGRAM.delete();
		if (OUTPUT1.exists())   OUTPUT1.delete();
		if (OUTPUT2.exists())   OUTPUT2.delete();
		if (OUTPUT3.exists())   OUTPUT3.delete();
		if (OUTPUT4.exists())   OUTPUT4.delete();
		if (EXISTING.exists())  EXISTING.delete();
		if (GENERATED.exists()) GENERATED.delete();
	}
	
	@After
	public void tearDown() throws IOException {
		FileUtil.write(PROGRAM,  "");
		FileUtil.write(EXISTING, "");
		
		testNumber++;
	}
	
	@Test
	public void testStore() throws IOException, EglRuntimeException, URISyntaxException {
		String expected = "Hello world!" + testNumber;
		FileUtil.write(PROGRAM, "[% out.print('" + expected + "'); %]");
		
		template = new EglFileGeneratingTemplate(UriUtil.fileToUri(PROGRAM), new MockContext(), UriUtil.fileToUri(PROGRAM.getParentFile()));
		
		template.process();
		template.store(OUTPUT1.getName());
		
		assertEquals(expected, FileUtil.read(OUTPUT1));
	}
	
	@Test
	public void testStoreAbsolute() throws IOException, EglRuntimeException, URISyntaxException {
		String expected = "Hello world!" + testNumber;
		FileUtil.write(PROGRAM, "[% out.print('" + expected + "'); %]");
		
		template = new EglFileGeneratingTemplate(UriUtil.fileToUri(PROGRAM), new MockContext(), UriUtil.fileToUri(PROGRAM.getParentFile()));
		
		template.process();
		template.store(OUTPUT1.getAbsolutePath());
		
		assertEquals(expected, FileUtil.read(OUTPUT1));
	}
	
	@Test
	public void testStoreWithOverwrite() throws IOException, EglRuntimeException, URISyntaxException {
		String expected = "Hello world!" + testNumber;
		FileUtil.write(PROGRAM, "[% out.print('" + expected + "'); %]");
		template = new EglFileGeneratingTemplate(UriUtil.fileToUri(PROGRAM), new MockContext(), UriUtil.fileToUri(PROGRAM.getParentFile()));
		
		template.process();
		template.store(OUTPUT2.getName(), true);
		
		assertEquals(expected, FileUtil.read(OUTPUT2));
	}
	
	
	@Test
	public void testStoreWithoutProcess() throws IOException, EglRuntimeException, URISyntaxException {
		String expected = "Hello world!" + testNumber;
		FileUtil.write(PROGRAM, "[% out.print('" + expected + "'); %]");
		template = new EglFileGeneratingTemplate(UriUtil.fileToUri(PROGRAM), new MockContext(), UriUtil.fileToUri(PROGRAM.getParentFile()));
		
		template.store(OUTPUT3.getName());
		
		assertEquals(expected, FileUtil.read(OUTPUT3));
	}
	
	
	@Test
	public void testStoreOverExisting() throws IOException, EglRuntimeException, URISyntaxException {
		String contents = "Hello world!" + testNumber;
		FileUtil.write(PROGRAM, "[% out.print('" + contents + "'); %]");
		template = new EglFileGeneratingTemplate(UriUtil.fileToUri(PROGRAM), new MockContext(), UriUtil.fileToUri(PROGRAM.getParentFile()));
		
		template.process();
		template.store(EXISTING.getName());
		
		assertEquals("", FileUtil.read(EXISTING));
	}
	
	@Test
	public void testStoreOverExistingWithOverwrite() throws IOException, EglRuntimeException, URISyntaxException {
		String expected = "Hello world!" + testNumber;
		FileUtil.write(PROGRAM, "[% out.print('" + expected + "'); %]");
		template = new EglFileGeneratingTemplate(UriUtil.fileToUri(PROGRAM), new MockContext(), UriUtil.fileToUri(PROGRAM.getParentFile()));
		
		template.process();
		template.store(EXISTING.getName(), true);
		
		assertEquals(expected, FileUtil.read(EXISTING));
	}
	
	
	@Test
	public void testGenerate() throws IOException, EglRuntimeException, URISyntaxException {
		FileUtil.write(PROGRAM, 
		               "This text will appear before the protected region" + NEWLINE +
		               "// protected region test on begin"                 + NEWLINE +
		               "// This default value will not be present"         + NEWLINE + 
		               "// protected region test end"                      + NEWLINE +
		               "This text will appear after the protected region");
		
		FileUtil.write(EXISTING,
		               "This text will not be preserved"   + NEWLINE +
		               "// protected region test on begin" + NEWLINE +
		               "// This region will be preserved"  + NEWLINE + 
		               "// protected region test end"      + NEWLINE +
		               "Also this text will not be preserved");
		
		final String expected = "This text will appear before the protected region" + NEWLINE +
                                "// protected region test on begin"                 + NEWLINE +
                                "// This region will be preserved"                  + NEWLINE + 
                                "// protected region test end"                      + NEWLINE +
                                "This text will appear after the protected region";
		
		final IEglContext context = new MockContext();
		context.getPartitioner().addPartitioner(new CommentBlockPartitioner("//", null));
		
		template = new EglFileGeneratingTemplate(UriUtil.fileToUri(PROGRAM), context, UriUtil.fileToUri(PROGRAM.getParentFile()));
		template.generate(EXISTING.getName());
		
		assertEquals(expected, FileUtil.read(EXISTING));
	}
	
	@Test
	public void testGenerateNoExisting() throws IOException, EglRuntimeException, URISyntaxException {
		final String expected = "This text will appear before the protected region" + NEWLINE +
                                "// protected region test on begin"                 + NEWLINE +
                                "// This region will be preserved"                  + NEWLINE + 
                                "// protected region test end"                      + NEWLINE +
                                "This text will appear after the protected region";
		
		FileUtil.write(PROGRAM, expected);
		
		
		final IEglContext context = new MockContext();
		context.getPartitioner().addPartitioner(new CommentBlockPartitioner("//", null));
		
		template = new EglFileGeneratingTemplate(UriUtil.fileToUri(PROGRAM), context, UriUtil.fileToUri(PROGRAM.getParentFile()));
		template.generate(OUTPUT4.getName());
		
		assertEquals(expected, FileUtil.read(OUTPUT4));
	}
	
	@Test (expected=EglRuntimeException.class)
	public void testGenerateInvalidPath() throws IOException, EglRuntimeException, URISyntaxException {
		final IEglContext context = new MockContext();
		context.getPartitioner().addPartitioner(new CommentBlockPartitioner("//", null));
		
		template = new EglFileGeneratingTemplate(UriUtil.fileToUri(PROGRAM), context, UriUtil.fileToUri(PROGRAM.getParentFile()));
		template.generate(INVALID.getName());
	}
}

