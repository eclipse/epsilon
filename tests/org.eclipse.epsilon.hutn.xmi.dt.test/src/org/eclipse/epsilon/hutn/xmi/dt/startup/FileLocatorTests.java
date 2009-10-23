package org.eclipse.epsilon.hutn.xmi.dt.startup;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.test.util.TestThatUsesAProject;
import org.junit.Test;

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

public class FileLocatorTests extends TestThatUsesAProject {
	
	@Test
	public void shouldFindAllFilesWithOneSpecifiedExtension() throws CoreException {
		final IFile modelFile     = createEmptyFile(project, "sample.model");
		final IFile notAModelFile = createEmptyFile(project, "sample.xml");
		
		
		final Collection<IFile> matchingFiles = new FileLocator("model").findAllMatchingFiles(project);
		
		assertTrue(matchingFiles.contains(modelFile));
		assertFalse(matchingFiles.contains(notAModelFile));
	}
	
	@Test
	public void shouldFindAllFilesWithEverySpecifiedExtension() throws CoreException {
		final IFile modelFile = createEmptyFile(project, "sample.model");
		final IFile xmlFile   = createEmptyFile(project, "sample.xml");
		final IFile txtFile   = createEmptyFile(project, "sample.txt");
		
		
		final Collection<IFile> matchingFiles = new FileLocator("model", "txt").findAllMatchingFiles(project);
		
		assertTrue(matchingFiles.containsAll(Arrays.asList(modelFile, txtFile)));
		assertFalse(matchingFiles.contains(xmlFile));
	}
}
