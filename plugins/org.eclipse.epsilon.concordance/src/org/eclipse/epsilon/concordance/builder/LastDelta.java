/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.concordance.builder;

import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;

public class LastDelta {
	
	public static LastDelta INSTANCE = new LastDelta();
	protected IResourceDelta delta;
	
	private LastDelta() {}

	public IResourceDelta getDelta() {
		return delta;
	}

	public void setDelta(IResourceDelta delta) {
		this.delta = delta;
	}

	
	public String getCurrentPath(String resourceURI) {
		
		String path = URI.createURI(resourceURI).toPlatformString(true);
		
		CurrentPathFinder currentPathFinder = new CurrentPathFinder();
		currentPathFinder.setOldPath(path);
		
		try {
			delta.accept(currentPathFinder);
		}
		catch (Exception ex) {
			
		}

		String currentURI = URI.createPlatformResourceURI(currentPathFinder.getCurrentPath(), true).toString();
		
		return currentURI;
		
	}
	
	public String getOldPath(String resourceURI) {
		
		String path = URI.createURI(resourceURI).toPlatformString(true);
		
		OldPathFinder oldPathFinder = new OldPathFinder();
		oldPathFinder.setCurrentPath(path);
		
		try {
			delta.accept(oldPathFinder);
		}
		catch (Exception ex) {
			
		}

		String oldURI = URI.createPlatformResourceURI(oldPathFinder.getOldPath(), true).toString();
		
		return oldURI;
		
	}
		
	class OldPathFinder implements IResourceDeltaVisitor {
		
		protected String oldPath = null;
		protected String currentPath = null;
		
		public boolean visit(IResourceDelta delta) throws CoreException {
			
			if (delta.getKind() == IResourceDelta.ADDED && 
					delta.getMovedFromPath() != null) {
				
				if (delta.getResource().getFullPath().toString().equals(currentPath)) {
					oldPath = delta.getMovedFromPath().toString();
					return false;
				}
				
			}
			
			return true;
		}
		
		
		public String getCurrentPath() {
			return currentPath;
		}


		public void setCurrentPath(String currentPath) {
			this.currentPath = currentPath;
		}


		public String getOldPath() {
			if (oldPath == null) {
				return currentPath;
			}
			else return oldPath;
		}
		
	}

	class CurrentPathFinder implements IResourceDeltaVisitor {
		
		protected String oldPath = null;
		protected String currentPath = null;
		
		public boolean visit(IResourceDelta delta) throws CoreException {
			
			if (delta.getKind() == IResourceDelta.ADDED && 
					delta.getMovedFromPath() != null) {
				
				if (delta.getMovedFromPath().toString().equals(oldPath)) {
					currentPath = delta.getResource().getFullPath().toString();
					return false;
				}
				
			}
			
			return true;
		}
		
		
		public String getOldPath() {
			return oldPath;
		}


		public void setOldPath(String oldPath) {
			this.oldPath = oldPath;
		}


		public String getCurrentPath() {
			if (currentPath == null) {
				return oldPath;
			}
			else return currentPath;
		}
		
	}
	
}
 