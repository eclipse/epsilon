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
package org.eclipse.epsilon.flock.execution;

import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.MigrationRule;

public class RuleBasedEquivalence extends TypeBasedEquivalence implements Equivalence {
	
	private final MigrationRule migrationRule;
	
	public RuleBasedEquivalence(IFlockContext context, ModelElement original, ModelElement equivalent, MigrationRule migrationRule) {
		super(context, original, equivalent);
		
		this.migrationRule = migrationRule;
	}
		
	@Override
	public void applyStrategyToPopulateEquivalence() throws FlockRuntimeException {
		migrationRule.applyTo(original, equivalent, context);
	}

	@Override
	public String toString() {
		return super.toString() + " via " + migrationRule;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RuleBasedEquivalence))
			return false;
		
		final RuleBasedEquivalence other = (RuleBasedEquivalence)obj;
		
		return super.equals(other) &&
		       migrationRule.equals(other.migrationRule);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + migrationRule.hashCode();
	}
}