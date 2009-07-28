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
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.migration.IMigrationContext;

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
	
	public boolean appliesFor(Object object, IMigrationContext context) {
		return isOfOriginalType(object, context) && satisfiesGuard(object, context);
	}
	
	private boolean isOfOriginalType(Object object, IMigrationContext context) {
		return originalType.equals(context.typeNameOfOriginalModelElement(object));
	}

	private boolean satisfiesGuard(Object object, IMigrationContext context) {
		if (guard == null)
			return true;
		
		return context.executeGuard(guard, createOriginalVariable(object));
	}
	

	public void migrate(Object original, Object target, IMigrationContext context) {
		try {			
			context.executeBlock(body, createOriginalVariable(original), createTargetVariable(target));
			
		} catch (EolRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Variable createOriginalVariable(Object object) {
		return Variable.createReadOnlyVariable("original", object);
	}
	
	private Variable createTargetVariable(Object target) {
		return Variable.createReadOnlyVariable("target", target);
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
		
		return equals(originalType, other.originalType) &&
		       equals(targetType,   other.targetType)   &&
		       equals(guard,        other.guard)        &&
		       equals(body,         other.body);
	}
	
	private boolean equals(Object first, Object second) {
		if (first == null)
			return second == null;
		else
			return first.equals(second);
	}
}
