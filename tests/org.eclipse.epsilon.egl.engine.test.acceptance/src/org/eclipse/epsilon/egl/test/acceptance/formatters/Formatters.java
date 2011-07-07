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
package org.eclipse.epsilon.egl.test.acceptance.formatters;

import java.io.File;

import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class Formatters {
	
	/*
	 * TODO
	 *   - formatter group: ordered bag of formatters for default / template-specific
	 */
	
	private static File DefaultFormatter, DefaultFormatterExpected;
	private static File TemplateSpecificFormatter, TemplateSpecificFormatterExpected;
	
	@BeforeClass
	public static void setUpOnce() {
		DefaultFormatter         = FileUtil.getFile("DefaultFormatter.egl", Formatters.class);
		DefaultFormatterExpected = FileUtil.getFile("DefaultFormatter.txt", Formatters.class);
		
		TemplateSpecificFormatter         = FileUtil.getFile("TemplateSpecificFormatter.egl", Formatters.class);
		TemplateSpecificFormatterExpected = FileUtil.getFile("TemplateSpecificFormatter.txt", Formatters.class);
	}
	
	@Test
	public void runtimeDefaultFormatterIsAppliedForAllTemplates() throws Exception {
		AcceptanceTestUtil.test(DefaultFormatter, DefaultFormatterExpected);
	}
	
	@Test
	public void runtimeTemplateSpecificFormatterIsPreferredToDefaultFormatter() throws Exception {
		AcceptanceTestUtil.test(TemplateSpecificFormatter, TemplateSpecificFormatterExpected);
	}
}