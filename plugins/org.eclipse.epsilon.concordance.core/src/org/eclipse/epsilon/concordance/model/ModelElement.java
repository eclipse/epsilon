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
package org.eclipse.epsilon.concordance.model;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;

public class ModelElement {

	public final Model model;
	public final String uriFragment;
	public final String label;
	
	public ModelElement(URI uri) {
		this(uri, "");
	}
	
	public ModelElement(URI uri, String label) {
		this(new Model(uri.trimFragment()), uri.fragment(), label);
	}
	
	public ModelElement(Model model, String uriFragment, String label) {
		this.model       = model;
		this.uriFragment = uriFragment == null ? "" : uriFragment;
		this.label       = label;
	}

	public boolean exists() {
		return model.contains(uriFragment);
	}
	
	public IResource getResource() {
		return model.getResource();
	}
	
	public String getUri() {
		return model.getUri().appendFragment(uriFragment).toString();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ModelElement))
			return false;
		
		final ModelElement other = (ModelElement)obj;
		
		return this.model.equals(other.model) &&
		       this.uriFragment.equals(other.uriFragment);
	}
	
	@Override
	public int hashCode() {
		return model.hashCode() + uriFragment.hashCode();
	}
	
	@Override
	public String toString() {
		return "ModelElement (uri=" + getUri() + ")";
	}
}
