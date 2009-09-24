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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public abstract class GuardedRule extends AbstractRule {

	protected final Guard guard;
	
	public GuardedRule(AST ast, String originalType, AST guard) {
		super(ast, originalType);
		
		this.guard = new Guard(guard);
	}

	public GuardedRule(String originalType, AST guard) {
		this(null, originalType, guard);
	}
	
	public boolean appliesFor(ModelElement original, IFlockContext context) throws FlockRuntimeException {
		return super.appliesFor(original, context) && guard.isSatisifedBy(original, context);
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof GuardedRule))
			return false;
		
		final GuardedRule other = (GuardedRule)object;
		
		return super.equals(other)  &&
		       guard == null ? other.guard == null : guard.equals(other.guard);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + guard.hashCode();
	}
}
