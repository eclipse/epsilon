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

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.execution.MigrateRuleContext;
import org.eclipse.epsilon.flock.model.domain.common.ClassifierTypedConstruct;
import org.eclipse.epsilon.flock.parse.FlockParser;

public class MigrateRule extends ClassifierTypedConstruct {

	private ExecutableBlock<Void> body;
	private final IgnoredProperties ignoredProperties = new IgnoredProperties();
	
	@SuppressWarnings("unchecked")
	@Override
	public void build() {
		super.build();
		this.body = (ExecutableBlock<Void>)getFirstChildWithType(FlockParser.BLOCK);
		buildIgnoredProperties();
	}

	private void buildIgnoredProperties() {
		final AST ignoring = (AST)getFirstChildWithType(FlockParser.IGNORING);
		if (ignoring != null) {
			for (AST ignoredProperty : ignoring.getChildren()) {
				this.ignoredProperties.add(ignoredProperty.getText());
			}
		}
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
	
	public void gatherIgnoredPropertiesFor(MigrateRuleContext context, IgnoredProperties ignoredProperties) throws EolRuntimeException {
		final boolean applicable = context.isEligibleFor(this);

		if (applicable) {
			ignoredProperties.addAll(this.ignoredProperties);
		}
	}
	
	public boolean applyTo(MigrateRuleContext context) throws EolRuntimeException {
		final boolean applicable = context.isEligibleFor(this);
		
		if (applicable) {
			context.execute(body);
		}
		
		return applicable;
	}

	@Override
	public String toString() {
		return getAnnotationBlock().toString() + "migrate "  + getOriginalType() + " " +
		       "ignoring " + ignoredProperties + " " + 
		       "when "     + getGuard()        + " " + 
		       "do "       + body;
	}
}
