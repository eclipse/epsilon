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
package org.eclipse.epsilon.concordance.clients.xref;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.model.CrossReference;

// FIXME Duplication with hutn.dt
public class MarkerManager {

	public static final String DANGLING_XREF_MARKER_ID = "org.eclipse.epsilon.concordance.clients.danglingXref";

	private static final String SOURCE_ID = "source_id";
	private static final String TARGET_ID = "target_id";
	
	private final IResource resource;
	
	public MarkerManager(IResource resource) {
		this.resource = resource;
	}
	
	public void addErrorMarker(CrossReference crossReference) {
		try {
			if (resource.exists()) {
				final IMarker marker = addErrorMarker(crossReference.getDanglingMessage(), 1);
				marker.setAttribute(SOURCE_ID, crossReference.source.getUri());
				marker.setAttribute(TARGET_ID, crossReference.target.getUri());
			}
	
		} catch (CoreException e) {
			LogUtil.log("Exception encountered while added marker to: " + resource, e);
		} 
	}
	
	private IMarker addErrorMarker(String message, int line) throws CoreException {
		final IMarker marker = resource.createMarker(DANGLING_XREF_MARKER_ID);
		marker.setAttribute(IMarker.MESSAGE, message);
		marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		marker.setAttribute(IMarker.LINE_NUMBER, line);
		return marker;
	}

	public void removeErrorMarker(CrossReference crossReference) {
		try {
			final IMarker[] markers = resource.findMarkers(DANGLING_XREF_MARKER_ID, true, IResource.DEPTH_ZERO);

			for (IMarker marker : markers) {
				if (matches(crossReference, marker)) {
					marker.delete();
				}
			}
			
		} catch (CoreException e) {
			LogUtil.log("Exception encountered while removing marker from: " + resource, e);

		}
	}

	private boolean matches(CrossReference crossReference, IMarker marker) throws CoreException {
		return crossReference.source.getUri().equals(marker.getAttribute(SOURCE_ID, "")) &&
		       crossReference.target.getUri().equals(marker.getAttribute(TARGET_ID, ""));
	}
}
