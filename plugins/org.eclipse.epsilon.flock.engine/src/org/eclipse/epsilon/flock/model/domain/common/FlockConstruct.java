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
package org.eclipse.epsilon.flock.model.domain.common;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;

public abstract class FlockConstruct implements ModuleElement {

	private final AST ast;
	private final Collection<String> annotations;

	public FlockConstruct(AST ast, Collection<String> annotations) {
		this.ast = ast;
		this.annotations = annotations;
	}
	
	public AST getAst() {
		return ast;
	}

	public List<?> getChildren() {
		return Collections.emptyList();
	}
	
	protected boolean isAnnotatedWith(String annotation) {
		return annotations.contains(annotation);
	}
	
	protected String getAnnotationString() {
		final StringBuilder annotationString = new StringBuilder();
		
		final Iterator<String> annotationsIterator = annotations.iterator();
		
		while(annotationsIterator.hasNext()) {
			annotationString.append('@');
			annotationString.append(annotationsIterator.next());
			
			if (annotationsIterator.hasNext()) {
				annotationString.append(',');
			}
			
			annotationString.append(' ');
		}
		
		return annotationString.toString();
	}
	
	@Override
	public int hashCode() {
		return annotations.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof FlockConstruct))
			return false;
		
		final FlockConstruct other = (FlockConstruct)object;
		
		return annotations.equals(other.annotations);
	}
}
