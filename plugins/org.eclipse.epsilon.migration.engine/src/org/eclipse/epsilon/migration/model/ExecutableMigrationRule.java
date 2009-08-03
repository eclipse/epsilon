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
package org.eclipse.epsilon.migration.model;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.MigrationExecutionException;

public class ExecutableMigrationRule extends AbstractMigrationRule implements MigrationRule {

	private final String originalType;
	private final AST guard;
	private final AST body;
	
	public ExecutableMigrationRule(String originalType, String targetType, AST guard, AST body) {
		super(targetType);
		
		this.originalType = originalType;
		this.guard        = guard;
		this.body         = body;
	}
	
	public boolean appliesFor(ModelElement original, IMigrationContext context) throws MigrationExecutionException {
		return isOfOriginalType(original) && satisfiesGuard(original, context);
	}
	
	boolean isOfOriginalType(ModelElement original) {
		return originalType.equals(original.getTypeName());
	}

	boolean satisfiesGuard(ModelElement object, IMigrationContext context) throws MigrationExecutionException {
		if (guard == null)
			return true;
		
		return context.executeGuard(guard, createOriginalVariable(object));
	}
	

	public void applyTo(ModelElement original, ModelElement target, IMigrationContext context) throws MigrationExecutionException {
		context.executeBlock(body, createOriginalVariable(original), createTargetVariable(target));
		
	}
	
	private Variable createOriginalVariable(ModelElement original) {
		return original.createReadOnlyVariable("original");
	}
	
	private Variable createTargetVariable(ModelElement target) {
		return target.createReadOnlyVariable("target");
	}
	
	@Override
	public String toString() {
		return originalType + " to " + targetType + " when " + guard + " do " + body;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ExecutableMigrationRule))
			return false;
		
		final ExecutableMigrationRule other = (ExecutableMigrationRule)object;
		
		return super.equals(other) &&
		       equals(originalType, other.originalType) &&
		       equals(guard,        other.guard)        &&
		       equals(body,         other.body);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode()        + 
		       originalType.hashCode() + 
		       guard.hashCode()        + 
		       body.hashCode();
	}
}
