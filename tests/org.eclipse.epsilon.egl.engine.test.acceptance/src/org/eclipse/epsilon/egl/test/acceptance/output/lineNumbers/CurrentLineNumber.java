/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.test.acceptance.output.lineNumbers;

import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;

import java.io.File;

import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.junit.Test;

public class CurrentLineNumber {
	
	@Test
	public void testLineNumber() throws Exception {
		final String template = "These "                           + NEWLINE +
		                        "are "                             + NEWLINE +
		                        "lines "                           + NEWLINE +
		                        "[%=out.getCurrentLineNumber()%] " + NEWLINE + 
		                        "and "                             + NEWLINE +
		                        "[%=out.getCurrentLineNumber()%].";                
		
		final String expected = "These are lines 4 and 6.".replaceAll(" ", " \n");
		
		AcceptanceTestUtil.test(template, expected);
	}
	
	@Test
	public void testLineNumberCountsLinesGeneratedBySubtemplate() throws Exception {
		final String expected = "Parent 1" + NEWLINE +
		                        "Child 1"  + NEWLINE +
		                        "Child 2"  + NEWLINE +
		                        "Child 3"  + NEWLINE +
		                        "Child 4"  + NEWLINE +
		                        "Parent 6";
		
		AcceptanceTestUtil.test(getParentTemplate(), expected);
	}
	
	
	private static File getParentTemplate() {
		return FileUtil.getFile("Parent.egl",  CurrentLineNumber.class);
	}

}
