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
package org.eclipse.epsilon.egl.test.acceptance.output;

import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;

import java.io.File;

import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class Output {

	private static File process;
	private static File hierachy;
	
	@BeforeClass
	public static void setUpOnce() {
		process  = FileUtil.getFile("Process.egl",  Output.class);
		hierachy = FileUtil.getFile("Hierachy.egl", Output.class);
	}
	
	@Test
	public void testProcess() throws Exception {
		final String expected = "Preprocess"                     + NEWLINE +
		                        "Hello world from SubTemplate1!" + NEWLINE +
		                        "Postprocess"                    + NEWLINE +
		                        "Preprocess"                     + NEWLINE +
		                        "Hello world from SubTemplate2!" + NEWLINE +
		                        "Postprocess"                    + NEWLINE +
		                        "Preprocess"                     + NEWLINE +
		                        "Hello world from SubTemplate3!" + NEWLINE +
		                        "Postprocess"                    + NEWLINE;
		
		AcceptanceTestUtil.test(process, expected);
	}
	
	@Test
	public void testProcessHierachy() throws Exception {
		final String expected = "Hello world from Template!"         + NEWLINE +
		                        "Hello world from SubTemplate!"      + NEWLINE +
		                        "Hello world from SubSubTemplate!"   + NEWLINE +
		                        "Goodbye world from SubSubTemplate!" + NEWLINE +
		                        "Goodbye world from SubTemplate!"    + NEWLINE +
		                        "Goodbye world from Template!";
		
		AcceptanceTestUtil.test(hierachy, expected);
	}
}
