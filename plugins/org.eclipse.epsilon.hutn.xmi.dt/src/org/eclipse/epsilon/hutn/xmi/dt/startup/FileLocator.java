package org.eclipse.epsilon.hutn.xmi.dt.startup;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

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

public class FileLocator {
	
	private final FileLocatingVisitor visitor;
	
	public FileLocator(String... extensions) {
		this(Arrays.asList(extensions));
	}
	
	public FileLocator(Collection<String> extensions) {
		visitor = new FileLocatingVisitor(extensions);
	}

	public Collection<IFile> findAllMatchingFiles(IResource base) throws CoreException {
		visitor.reset();
		base.accept(visitor);
		
		return visitor.getMatchingFiles();
	}

	
	private class FileLocatingVisitor implements IResourceVisitor {

		private final List<String> extensions;
		private final List<IFile> matchingFiles = new LinkedList<IFile>();
		
		public FileLocatingVisitor(Collection<String> extensions) {
			this.extensions = new LinkedList<String>(extensions);
		}

		public boolean visit(IResource resource) throws CoreException {
			if (isFile(resource) && hasMatchingExtension(resource)) {
				matchingFiles.add((IFile)resource);
			}
			
			return true;
		}

		public void reset() {
			matchingFiles.clear();
		}

		private boolean isFile(IResource resource) {
			return resource.getType() == IResource.FILE;
		}

		private boolean hasMatchingExtension(IResource resource) {
			return extensions.contains(resource.getFileExtension());
		}

		public Collection<IFile> getMatchingFiles() {
			return matchingFiles;
		}
		
	}
}
