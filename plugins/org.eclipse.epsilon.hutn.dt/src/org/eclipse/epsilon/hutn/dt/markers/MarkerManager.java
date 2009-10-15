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
package org.eclipse.epsilon.hutn.dt.markers;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;

public class MarkerManager {

	private static final String MARKER_ID = "org.eclipse.epsilon.hutn.dt.inconsistency";
	
	private final IFile file;
	
	public MarkerManager(IFile file) {
		this.file = file;
	}
	
	public void replaceErrorMarkers(Collection<ParseProblem> problems) throws CoreException {
		removeMarkers();
		addErrorMarkers(problems);
	}
	
	private void addErrorMarkers(Collection<ParseProblem> problems) throws CoreException {
		for (ParseProblem problem : problems)
			addErrorMarker(problem);
	}
	
	private void addErrorMarker(ParseProblem problem) throws CoreException {
		addErrorMarker(problem.getReason(), problem.getLine());
	}
	
	private void addErrorMarker(String error, int line) throws CoreException {
		final IMarker marker = file.createMarker(MARKER_ID);
		marker.setAttribute(IMarker.MESSAGE, error);
		marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		marker.setAttribute(IMarker.LINE_NUMBER, line);
	}
	
	public void removeMarkers() throws CoreException {
		file.deleteMarkers(MARKER_ID, true, IResource.DEPTH_ZERO);
	}
}
