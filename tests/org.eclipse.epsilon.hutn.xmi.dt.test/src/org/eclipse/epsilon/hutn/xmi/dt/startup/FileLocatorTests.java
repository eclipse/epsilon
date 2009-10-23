package org.eclipse.epsilon.hutn.xmi.dt.startup;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

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
		
		assertThat(matchingFiles, hasItem(modelFile));
		assertThat(matchingFiles, not(hasItem(notAModelFile)));
	}
	
	@Test
	public void shouldFindAllFilesWithEverySpecifiedExtension() throws CoreException {
		final IFile modelFile = createEmptyFile(project, "sample.model");
		final IFile xmlFile   = createEmptyFile(project, "sample.xml");
		final IFile txtFile   = createEmptyFile(project, "sample.txt");
		
		
		final Collection<IFile> matchingFiles = new FileLocator("model", "txt").findAllMatchingFiles(project);
		
		assertThat(matchingFiles, hasItems(modelFile, txtFile));
		assertThat(matchingFiles, not(hasItem(xmlFile)));
	}
}
