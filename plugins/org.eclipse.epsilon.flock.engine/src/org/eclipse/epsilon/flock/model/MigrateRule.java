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
import org.eclipse.epsilon.flock.execution.Equivalence;
import org.eclipse.epsilon.flock.execution.MigrateRuleBasedEquivalence;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class MigrateRule extends GuardedRule {

	public final String migratedType;
	private final Body body;
	
	public MigrateRule(AST ast, String originalType, String migratedType, AST guard, AST body) {
		super(ast, originalType, guard);
		
		this.migratedType = migratedType;
		this.body         = new Body(body);
	}
	
	/**
	 * Constructs a MigrationRule that has no underlying ANTLR parse tree.
	 */
	public MigrateRule(String originalType, String migratedType, AST guard, AST body) {
		this(null, originalType, migratedType, guard, body);
	}
	
	
	public Equivalence createEquivalence(ModelElement original, IFlockContext context) throws FlockRuntimeException {
		return new MigrateRuleBasedEquivalence(context, original, context.createModelElementInMigratedModel(migratedType), body);
	}
	
	@Override
	public String toString() {
		return "migrate " + getOriginalType() + " to " + migratedType + " when " + guard + " do " + body;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof MigrateRule))
			return false;
		
		final MigrateRule other = (MigrateRule)object;
		
		return super.equals(other)                      &&
		       equals(migratedType, other.migratedType) &&
		       equals(body,         other.body);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode()        +
		       migratedType.hashCode() +
		       body.hashCode();
	}

	private boolean equals(Object first, Object second) {
		if (first == null)
			return second == null;
		else
			return first.equals(second);
	}
}
