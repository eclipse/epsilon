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

import org.eclipse.emf.common.util.URI;

public class CrossReference {

	public final ModelElement source, target;
	public final String label;	
	
	public CrossReference(URI source, String sourceLabel, URI target, String targetLabel, String label) {
		this(new ModelElement(source, sourceLabel), new ModelElement(target, targetLabel), label);
	}
	
	public CrossReference(ModelElement source, ModelElement target, String label) {
		this.source = source;
		this.target = target;
		this.label  = label;
	}
	
	public boolean isDangling() {
		return !target.exists();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CrossReference))
			return false;
		
		final CrossReference other = (CrossReference)obj;
		
		return this.source.equals(other.source) &&
		       this.target.equals(other.target);
	}
	
	@Override
	public int hashCode() {
		return source.hashCode() + target.hashCode();
	}
	
	
	public String getDanglingMessage() {
		return "Dangling reference from feature " + label + 
		       " of element " + source.label +
		       " to element " + target.label + 
		       " (" + target.getUri() + ")";
	}
	
	
	@Override
	public String toString() {
		return "Cross-reference between " + source + " and " + target;
	}

}
