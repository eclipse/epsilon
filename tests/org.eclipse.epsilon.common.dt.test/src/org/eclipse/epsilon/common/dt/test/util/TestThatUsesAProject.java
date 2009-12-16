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
package org.eclipse.epsilon.common.dt.test.util;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.After;
import org.junit.Before;

public class TestThatUsesAProject {

	protected IProject project;
	
	@Before
	public void setupProject() throws CoreException {
		deleteResource(project);
		project = createProject("sample");
	}
	
	@After
	public void teardownProject() throws CoreException {
		deleteResource(project);
	}
	
	
	protected static IProject createProject(String name) throws CoreException {
		final IProject base = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		
		base.create(new NullProgressMonitor());
		base.open(new NullProgressMonitor());
		return base;
	}
	
	protected static IFolder createFolder(IProject project, String name) throws CoreException {
		final IFolder folder = project.getFolder(name);
		folder.create(true, true, null);
		return folder;
	}
	
	protected static IFile createEmptyFile(IProject project, String name) throws CoreException {
		final IFile file = project.getFile(name);
		file.create(new ByteArrayInputStream(new byte[0]), true, new NullProgressMonitor());
		return file;
	}
	
	protected static IFile createFile(IProject project, String name, String contents) throws CoreException {
		final IFile file = project.getFile(name);
		file.create(new ByteArrayInputStream(contents.getBytes()), true, new NullProgressMonitor());
		return file;
	}
	
	protected static void changeFileContents(IFile file, String newContents) throws CoreException {
		file.setContents(new ByteArrayInputStream(newContents.getBytes()), true, false, new NullProgressMonitor());
	}
	
	protected static void moveResource(IResource resource, String newPath) throws CoreException {
		if (resource != null) {
			resource.move(resource.getProject().getFullPath().append(newPath), true, new NullProgressMonitor());
		}
	}
	
	protected static void deleteResource(IResource resource) throws CoreException {
		if (resource != null)
			resource.delete(true, new NullProgressMonitor());
	}
}
