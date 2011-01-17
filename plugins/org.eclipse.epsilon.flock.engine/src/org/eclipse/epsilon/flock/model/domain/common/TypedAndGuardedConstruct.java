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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.execution.GuardedConstructContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public abstract class TypedAndGuardedConstruct extends FlockConstruct {

	private final String originalType;
	private final Guard guard;
	
	public TypedAndGuardedConstruct(AST ast, String originalType, AST guard) {
		super(ast);
		
		if (originalType == null)
			throw new IllegalArgumentException("originalType cannot be null");
		
		this.originalType = originalType;
		this.guard = new Guard(guard);
	}
	
	public String getOriginalType() {
		return originalType;
	}
	
	protected Guard getGuard() {
		return guard;
	}
	
	public boolean appliesIn(GuardedConstructContext context) throws FlockRuntimeException {
		return context.originalConformsTo(originalType) && context.satisfies(guard);
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TypedAndGuardedConstruct))
			return false;
		
		final TypedAndGuardedConstruct other = (TypedAndGuardedConstruct)object;
		
		return originalType.equals(other.originalType) &&
		       guard.equals(other.guard);
	}
	
	@Override
	public int hashCode() {
		return originalType.hashCode() + guard.hashCode();
	}
}
