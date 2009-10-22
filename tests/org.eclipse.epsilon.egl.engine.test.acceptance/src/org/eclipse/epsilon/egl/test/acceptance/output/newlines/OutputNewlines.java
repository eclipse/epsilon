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
package org.eclipse.epsilon.egl.test.acceptance.output.newlines;

import java.io.IOException;

import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.Test;

public class OutputNewlines {
	
	// When processed, a template should produce the same kind of newlines as entered in that template
	
	@Test
	public void windowsNewlinesArePreserved() throws IOException, EglRuntimeException, EolModelLoadingException {
		final String programAndOutput = "Foo\r\n" +
		                                "Bar";
		
		AcceptanceTestUtil.testWithoutNormalizingNewlines(programAndOutput, programAndOutput);
	}
	
	@Test
	public void unixNewlinesArePreserved() throws IOException, EglRuntimeException, EolModelLoadingException {
		final String programAndOutput = "Foo\n" +
		                                "Bar";
		
		AcceptanceTestUtil.testWithoutNormalizingNewlines(programAndOutput, programAndOutput);
	}
	
	@Test
	public void oldMacNewlinesArePreserved() throws IOException, EglRuntimeException, EolModelLoadingException {
		final String programAndOutput = "Foo\r" +
		                                "Bar";
		
		AcceptanceTestUtil.testWithoutNormalizingNewlines(programAndOutput, programAndOutput);
	}
}
