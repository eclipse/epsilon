/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * Copyright (c) 2014 University of Twente.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Maarten Bezemer - split into base and resource backing implementation
 ******************************************************************************/
package org.eclipse.epsilon.concordance.model;

import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Default implementation of {@link IConcordanceModel} that uses the actual
 * model file for its operations
 */
public class ConcordanceModel extends ConcordanceModelBase {

	private final URI uri;
	
	public ConcordanceModel(IResource resource) {
		this(resource.getFullPath());
	}
	
	public ConcordanceModel(IPath path) {
		this(URI.createPlatformResourceURI(path.toOSString(), true));
	}
	
	public ConcordanceModel(URI uri) {
		this.uri = uri;
	}

	public URI getUri() {
		return uri;
	}
	
	public Resource getEmfResource(boolean resolve) throws IOException {
		final Resource resource = new ResourceSetImpl().createResource(uri);
		
		resource.load(null);
//		resource.load(Collections.singletonMap(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true));
		if (resolve) EcoreUtil.resolveAll(resource);
		
		return resource;
	}
	
	public IResource getResource() {
		if (uri.isPlatformResource()) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ConcordanceModel))
			return false;
		
		return ((ConcordanceModel)obj).uri.equals(this.uri);
	}
	
	@Override
	public int hashCode() {
		return uri.hashCode();
	}
	
	@Override
	public String toString() {
		return "Model (uri=" + uri + ")";
	}
}
