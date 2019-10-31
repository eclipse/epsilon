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

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

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
		private final List<IFile> matchingFiles = new LinkedList<>();
		
		public FileLocatingVisitor(Collection<String> extensions) {
			this.extensions = new LinkedList<>(extensions);
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
