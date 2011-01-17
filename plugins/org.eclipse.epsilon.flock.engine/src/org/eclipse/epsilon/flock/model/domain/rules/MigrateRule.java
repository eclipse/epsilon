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
package org.eclipse.epsilon.flock.model.domain.rules;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.execution.MigrateRuleContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.common.TypedAndGuardedConstruct;

public class MigrateRule extends TypedAndGuardedConstruct {

	private final Body body;
	
	public MigrateRule(AST ast, String originalType, AST guard, AST body) {
		super(ast, originalType, guard);
		
		if (body == null)
			throw new IllegalArgumentException("body cannot be null");
		
		this.body = new Body(body);
	}
	
	/**
	 * Constructs a MigrationRule that has no underlying ANTLR parse tree.
	 */
	public MigrateRule(String originalType, AST guard, AST body) {
		this(null, originalType, guard, body);
	}
	
	public boolean applyTo(MigrateRuleContext context) throws FlockRuntimeException {
		final boolean applicable = context.isEligibleFor(this);
		
		if (applicable) {
			context.execute(body);
		}
		
		return applicable;
	}
	
	@Override
	public String toString() {
		return "migrate " + getOriginalType() + " when " + getGuard() + " do " + body;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof MigrateRule))
			return false;
		
		final MigrateRule other = (MigrateRule)object;
		
		return super.equals(other) && body.equals(other.body);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + body.hashCode();
	}
}
