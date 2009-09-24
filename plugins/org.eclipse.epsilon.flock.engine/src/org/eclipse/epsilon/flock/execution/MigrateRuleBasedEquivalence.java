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
import org.eclipse.epsilon.flock.model.Body;

public class MigrateRuleBasedEquivalence extends TypeBasedEquivalence implements Equivalence {
	
	private final Body migrateRuleBody;
	
	public MigrateRuleBasedEquivalence(IFlockContext context, ModelElement original, ModelElement equivalent, Body migrateRuleBody) {
		super(context, original, equivalent);
		
		this.migrateRuleBody = migrateRuleBody;
	}
		
	@Override
	public void applyStrategyToPopulateEquivalence() throws FlockRuntimeException {
		migrateRuleBody.applyTo(original, equivalent, context);
	}

	@Override
	public String toString() {
		return super.toString() + " via " + migrateRuleBody;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MigrateRuleBasedEquivalence))
			return false;
		
		final MigrateRuleBasedEquivalence other = (MigrateRuleBasedEquivalence)obj;
		
		return super.equals(other) &&
		       migrateRuleBody.equals(other.migrateRuleBody);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + migrateRuleBody.hashCode();
	}
}