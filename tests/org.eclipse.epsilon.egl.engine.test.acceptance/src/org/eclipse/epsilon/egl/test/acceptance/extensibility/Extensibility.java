/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.test.acceptance.extensibility;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.test.acceptance.AcceptanceTestUtil;
import org.eclipse.epsilon.egl.test.models.Model;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.BeforeClass;
import org.junit.Test;

public class Extensibility {

	private static File Driver;
	
	@BeforeClass
	public static void setUpOnce() {
		Driver = FileUtil.getFile("Driver.egl", Extensibility.class);
	}
	
	@Test
	public void testValid() throws IOException, EglRuntimeException, EolModelLoadingException {
		AcceptanceTestUtil.run(initialiseFactory(), Driver, Model.OOInstance);
		
		final File generatedFile = FileUtil.getFile("Pet.java", Extensibility.class);
		assertEquals(2, CountingTemplate.countFor(generatedFile));
	}

	private static CountingTemplateFactory initialiseFactory() throws EglRuntimeException {
		final CountingTemplateFactory factory = new CountingTemplateFactory();
		factory.setOutputRoot(FileUtil.getDirectoryOf(Extensibility.class).getAbsolutePath());
		return factory;
	}
}
