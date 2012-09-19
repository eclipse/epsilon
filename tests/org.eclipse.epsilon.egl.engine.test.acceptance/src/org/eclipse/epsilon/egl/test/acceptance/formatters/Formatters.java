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

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class Formatters {
	
	/*
	 * TODO
	 *   - formatter group: ordered bag of formatters for default / template-specific
	 */
	
	private static File DefaultFormatter, DefaultFormatterExpected;
	private static File FormatterGroup, FormatterGroupExpected;
	private static File TemplateSpecificFormatter, TemplateSpecificFormatterExpected;
	private static File TemplateSpecificFormatterGroup, TemplateSpecificFormatterGroupExpected;
	
	@BeforeClass
	public static void setUpOnce() {
		DefaultFormatter         = FileUtil.getFile("DefaultFormatter.egl", Formatters.class);
		DefaultFormatterExpected = FileUtil.getFile("DefaultFormatter.txt", Formatters.class);
		
		FormatterGroup         = FileUtil.getFile("DefaultFormatterGroup.egl", Formatters.class);
		FormatterGroupExpected = FileUtil.getFile("DefaultFormatterGroup.txt", Formatters.class);
		
		TemplateSpecificFormatter         = FileUtil.getFile("TemplateSpecificFormatter.egl", Formatters.class);
		TemplateSpecificFormatterExpected = FileUtil.getFile("TemplateSpecificFormatter.txt", Formatters.class);
		
		TemplateSpecificFormatterGroup         = FileUtil.getFile("TemplateSpecificFormatterGroup.egl", Formatters.class);
		TemplateSpecificFormatterGroupExpected = FileUtil.getFile("TemplateSpecificFormatterGroup.txt", Formatters.class);
	}
	
	@Test
	public void defaultFormatterIsAppliedForAllTemplates() throws Exception {
		AcceptanceTestUtil.test(DefaultFormatter, DefaultFormatterExpected);
	}
	
	@Test
	public void allFormattersInAGroupAreApplied() throws Exception {
		AcceptanceTestUtil.test(FormatterGroup, FormatterGroupExpected);
	}
	
	@Test
	public void templateSpecificFormatterIsPreferredToDefaultFormatter() throws Exception {
		AcceptanceTestUtil.test(TemplateSpecificFormatter, TemplateSpecificFormatterExpected);
	}
	
	@Test
	public void allTemplateSpecificFormattersAreApplied() throws Exception {
		AcceptanceTestUtil.test(TemplateSpecificFormatterGroup, TemplateSpecificFormatterGroupExpected);
	}
}