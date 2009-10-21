package org.eclipse.epsilon.hutn.xmi.dt.startup;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.IsCollectionContaining.hasItem;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;

import java.io.ByteArrayInputStream;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.epsilon.hutn.xmi.dt.startup.FileLocator;
import org.junit.After;
import org.junit.Before;
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

public class FileLocatorTests {

	private IProject base;
	
	@Before
	public void createProject() throws CoreException {
		base = createProject("base");
	}
	
	@After
	public void deleteProject() throws CoreException {
		deleteResource(base);
	}
	
	@Test
	public void shouldFindAllFilesWithOneSpecifiedExtension() throws CoreException {
		final IFile modelFile     = createEmptyFile(base, "sample.model");
		final IFile notAModelFile = createEmptyFile(base, "sample.xml");
		
		
		final Collection<IFile> matchingFiles = new FileLocator("model").findAllMatchingFiles(base);
		
		assertThat(matchingFiles, hasItem(modelFile));
		assertThat(matchingFiles, not(hasItem(notAModelFile)));
	}
	
	@Test
	public void shouldFindAllFilesWithEverySpecifiedExtension() throws CoreException {
		final IFile modelFile = createEmptyFile(base, "sample.model");
		final IFile xmlFile   = createEmptyFile(base, "sample.xml");
		final IFile txtFile   = createEmptyFile(base, "sample.txt");
		
		
		final Collection<IFile> matchingFiles = new FileLocator("model", "txt").findAllMatchingFiles(base);
		
		assertThat(matchingFiles, hasItems(modelFile, txtFile));
		assertThat(matchingFiles, not(hasItem(xmlFile)));
	}


	
	private static IProject createProject(String name) throws CoreException {
		final IProject base = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		
		base.create(new NullProgressMonitor());
		base.open(new NullProgressMonitor());
		return base;
	}
	
	private static void deleteResource(IResource resource) throws CoreException {
		if (resource != null)
			resource.delete(true, new NullProgressMonitor());
	}
	
	private static IFile createEmptyFile(IProject project, String name) throws CoreException {
		final IFile file = project.getFile(name);
		file.create(new ByteArrayInputStream(new byte[0]), true, new NullProgressMonitor());
		return file;
	}
}
