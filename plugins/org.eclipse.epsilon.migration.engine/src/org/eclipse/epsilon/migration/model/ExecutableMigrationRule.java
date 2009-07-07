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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.migration.execution.ExecutionContext;

public class ExecutableMigrationRule implements MigrationRule {

	private final String originalType;
	private final String targetType;
	private final AST guard;
	private final AST body;
	
	public ExecutableMigrationRule(String originalType, String targetType, AST guard, AST body) {
		this.originalType = originalType;
		this.targetType   = targetType;
		this.guard        = guard;
		this.body         = body;
	}
	
	public boolean appliesFor(EObject object, ExecutionContext context) {
		return isOfOriginalType(object) && satisfiesGuard(object, context);
	}
	
	private boolean isOfOriginalType(EObject object) {
		return originalType.equals(object.eClass().getName());
	}

	private boolean satisfiesGuard(EObject object, ExecutionContext context) {
		if (guard == null)
			return true;
		
		return context.executeGuard(guard, createOriginalVariable(object));
	}
	

	public void migrate(EObject original, EObject target, ExecutionContext context) {
		try {
//			context.getTargetModel().setTypeOf(target, targetType);
			
			context.executeBlock(body, createOriginalVariable(original), createTargetVariable(target));
			
		} catch (EolRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Variable createOriginalVariable(EObject object) {
		return Variable.createReadOnlyVariable("original", object);
	}
	
	private Variable createTargetVariable(EObject target) {
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
