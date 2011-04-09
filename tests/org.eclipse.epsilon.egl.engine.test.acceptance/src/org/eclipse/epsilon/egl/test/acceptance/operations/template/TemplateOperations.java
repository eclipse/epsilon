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
package org.eclipse.epsilon.egl.test.acceptance.operations.template;

import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;

import org.eclipse.epsilon.egl.exceptions.EglUnallocatedOutputBufferException;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.junit.Test;

public class TemplateOperations {
	
	@Test
	public void testTemplateOperation() throws Exception {
		final String template = "[%=main()%]"          +
		                        "[% @template"         + NEWLINE +
		                        "operation main() {%]" + NEWLINE +
		                        "foo"                  + NEWLINE + 
		                        "[%}%]";
		
		final String expected = "foo";
		
		AcceptanceTestUtil.test(template, expected);
	}
	
	@Test
	public void testTemplateOperationWithDynamicSection() throws Exception {
		final String template = "[%=main()%]"          +
		                        "[% @template"         + NEWLINE +
		                        "operation main() {%]" + NEWLINE +
		                        "foo [%='ba'+'r'%]"    + NEWLINE + 
		                        "[%}%]";
		
		final String expected = "foo bar";
		
		AcceptanceTestUtil.test(template, expected);
	}
	
	@Test(expected=EglUnallocatedOutputBufferException.class)
	public void testNonTemplateOperationWithStaticSection() throws Exception {
		final String template = "[%=main()%]"          +
		                        "[%"                   + NEWLINE +
		                        "operation main() {%]" + NEWLINE +
		                        "foo"                  + NEWLINE + 
		                        "[%}%]";
		
		final String expected = "";
		
		AcceptanceTestUtil.test(template, expected);
	}
}
