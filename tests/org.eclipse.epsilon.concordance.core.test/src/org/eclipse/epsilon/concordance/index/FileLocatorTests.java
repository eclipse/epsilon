/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.index;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.test.util.TestThatUsesAProject;
import org.junit.Test;


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
