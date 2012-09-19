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

import java.util.Collection;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.execution.MigrateRuleContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.common.TypedAndGuardedConstruct;

public class MigrateRule extends TypedAndGuardedConstruct {

	private final Body body;
	private final IgnoredProperties ignoredProperties;
	
	
	MigrateRule(AST ast, Collection<String> annotations, String originalType, Collection<String> ignoredProperties, AST guard, AST body) {
		super(ast, annotations, originalType, guard);
		
		this.body = new Body(body);
		this.ignoredProperties = new IgnoredProperties(ignoredProperties);
	}
	
	public IgnoredProperties getIgnoredProperties() {
		return ignoredProperties;
	}
	
	public String getDescriptionOfIgnoredProperties() {
		return ignoredProperties.isEmpty() ? "" : "ignoring " + ignoredProperties;
	}
	
	@Override
	public void check(MigrationStrategyCheckingContext context) {
		super.check(context);
		ignoredProperties.check(getOriginalType(), context);
	}
	
	public void gatherIgnoredPropertiesFor(MigrateRuleContext context, IgnoredProperties ignoredProperties) throws FlockRuntimeException {
		final boolean applicable = context.isEligibleFor(this);

		if (applicable) {
			ignoredProperties.addAll(this.ignoredProperties);
		}
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
		return getAnnotationString() + "migrate "  + getOriginalType() + " " +
		       "ignoring " + ignoredProperties + " " + 
		       "when "     + getGuard()        + " " + 
		       "do "       + body;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof MigrateRule))
			return false;
		
		final MigrateRule other = (MigrateRule)object;
		
		return super.equals(other) &&
		       body.equals(other.body) &&
		       ignoredProperties.equals(other.ignoredProperties);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() +
		       body.hashCode()  +
		       ignoredProperties.hashCode();
	}
}
