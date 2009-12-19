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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
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
		createFile(file, contents);
		return file;
	}
	
	protected static void changeFileContents(IFile file, String newContents) throws CoreException {
		if (file.exists())
			file.setContents(new ByteArrayInputStream(newContents.getBytes()), true, false, new NullProgressMonitor());
		else
			createFile(file, newContents);
	}
	
	private static void createFile(IFile file, String contents) throws CoreException {
		file.create(new ByteArrayInputStream(contents.getBytes()), true, new NullProgressMonitor());
	}

	protected static IFile moveFile(IFile file, String newPath) throws CoreException {
		if (file == null) return null;
		
		final IPath destination = file.getProject().getFullPath().append(newPath);
		file.move(destination, true, new NullProgressMonitor());
		return (IFile)ResourcesPlugin.getWorkspace().getRoot().findMember(destination);
	}
	
	protected static void deleteResource(IResource resource) throws CoreException {
		if (resource != null && resource.exists())
			resource.delete(true, new NullProgressMonitor());
	}
	
	protected static void printFileContents(IFile file) throws CoreException {
		try {
			final InputStreamReader reader = new InputStreamReader(file.getContents());
			int c;
			while((c = reader.read()) != -1) {
				System.err.print((char)c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	protected static void addNature(IProject project, String natureId) throws CoreException {
		applyNaturesToProject(project, addNature(project.getDescription().getNatureIds(), natureId));
	}
	
	private static void applyNaturesToProject(IProject project, Collection<String> natureIds) throws CoreException {
		final IProjectDescription desc = project.getDescription();
				
		desc.setNatureIds(natureIds.toArray(new String[0]));
		
		project.setDescription(desc, null);
	}

	private static final Collection<String> addNature(final String[] natureIds, String natureId) {
		final Collection<String> newNatureIds = new LinkedList<String>();
		newNatureIds.add(natureId);
		newNatureIds.addAll(Arrays.asList(natureIds));
		return newNatureIds;
	}
}
