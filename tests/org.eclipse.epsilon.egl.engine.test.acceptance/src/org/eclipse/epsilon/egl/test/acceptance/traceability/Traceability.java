/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.test.acceptance.traceability;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.common.util.UriUtil;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.eclipse.epsilon.egl.test.models.Model;
import org.eclipse.epsilon.egl.traceability.OutputFile;
import org.eclipse.epsilon.egl.traceability.Template;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class Traceability {

	private final static boolean OS_IS_WINDOWS = OperatingSystem.isWindows();
	
	private static final File program          = FileUtil.getFile("Hierachy.egl", Traceability.class);
	private static final File subProgram       = FileUtil.getFile("Traceability.egl", Traceability.class);
	private static final File subSubProgram    = FileUtil.getFile("OOClass2JavaClass.egl", Traceability.class);
	private static final File programOutput    = FileUtil.getFile("Traceability.txt", Traceability.class);
	private static final File subProgramOutput = FileUtil.getFile("OO2Java.txt", Traceability.class);
	
	@Before
	public void setUp() throws IOException {
		final File existing = FileUtil.getFile("OO2Java_existing.txt", Traceability.class);
		org.eclipse.epsilon.egl.util.FileUtil.write(subProgramOutput, org.eclipse.epsilon.egl.util.FileUtil.read(existing));
	}
	
	@AfterClass
	public static void tearDownOnce() {
		if (programOutput.exists())    programOutput.delete();
		if (subProgramOutput.exists()) subProgramOutput.delete();
	}
	
	@Test
	public void traceability() throws Exception {
		AcceptanceTestUtil.run(subProgram, Model.OOInstance);
		
		final Template expected = new Template(UriUtil.fileToUri(subProgram));
		
		final Template subTemplate = expected.addTemplate(UriUtil.fileToUri(subSubProgram));
		
		subTemplate.addVariable("name", "Animal");
		
		final OutputFile outputFile = subTemplate.addOutputFile(UriUtil.fileToUri(subProgramOutput));
		outputFile.addProtectedRegion("javadoc",  true,  OS_IS_WINDOWS ? 24 : 22);
		outputFile.addProtectedRegion("header",   true,  OS_IS_WINDOWS ? 236 : 226);
		outputFile.addProtectedRegion("sleep",    true,  OS_IS_WINDOWS ? 395 : 378);
		outputFile.addProtectedRegion("talk",     true,  OS_IS_WINDOWS ? 533 : 510);
		outputFile.addProtectedRegion("toString", false, OS_IS_WINDOWS ? 687 : 657);
		
		assertEquals(expected, AcceptanceTestUtil.getTrace());
	}
	
	@Test
	public void traceabilityHierachy() throws Exception {
		AcceptanceTestUtil.run(program, Model.OOInstance);
		
		final Template expected           = new Template(UriUtil.fileToUri(program));
		final Template subProgramTemplate = expected.addTemplate(UriUtil.fileToUri(subProgram));
		
		subProgramTemplate.addVariable("unused", "n/a");
		
		final Template subSubProgramTemplate = subProgramTemplate.addTemplate(UriUtil.fileToUri(subSubProgram));
		
		subSubProgramTemplate.addVariable("name", "Animal");
		
		final OutputFile outputFile = subSubProgramTemplate.addOutputFile(UriUtil.fileToUri(subProgramOutput));
		outputFile.addProtectedRegion("javadoc",  true,  OS_IS_WINDOWS ? 24 : 22);
		outputFile.addProtectedRegion("header",   true,  OS_IS_WINDOWS ? 236 : 226);
		outputFile.addProtectedRegion("sleep",    true,  OS_IS_WINDOWS ? 395 : 378);
		outputFile.addProtectedRegion("talk",     true,  OS_IS_WINDOWS ? 533 : 510);
		outputFile.addProtectedRegion("toString", false, OS_IS_WINDOWS ? 687 : 657);
		
		subProgramTemplate.addOutputFile(UriUtil.fileToUri(programOutput));
		
		System.out.println("e: " +expected);

		assertEquals(expected, AcceptanceTestUtil.getTrace());
	}
}
