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
package org.eclipse.epsilon.flock.model;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public abstract class AbstractRule implements Rule {

	private final AST ast;
	private final String originalType;
	
	public AbstractRule(String originalType) {
		this(null, originalType);
	}
	
	public AbstractRule(AST ast, String originalType) {
		if (originalType == null)
			throw new IllegalArgumentException("originalType cannot be null");
		
		this.ast          = ast;
		this.originalType = originalType;
	}
	
	public AST getAst() {
		return ast;
	}

	public List<?> getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	public String getOriginalType() {
		return originalType;
	}
	
	public boolean appliesFor(ModelElement original, IFlockContext context) throws FlockRuntimeException {
		return original.isKindOf(originalType);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AbstractRule))
			return false;
		
		final AbstractRule other = (AbstractRule) obj;
		
		return originalType.equals(other.originalType);
	}
	
	@Override
	public int hashCode() {
		return originalType.hashCode();
	}
}
