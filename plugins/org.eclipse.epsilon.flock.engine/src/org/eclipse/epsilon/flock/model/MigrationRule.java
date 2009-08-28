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

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class MigrationRule implements ModuleElement {

	private final String originalType;
	private final String migratedType;
	private final AST guard;
	private final AST body;
	private final AST ast;
	
	public MigrationRule(AST ast, String originalType, String migratedType, AST guard, AST body) {
		this.ast          = ast;
		this.originalType = originalType;
		this.migratedType = migratedType;
		this.guard        = guard;
		this.body         = body;
	}
	
	/**
	 * Constructs a MigrationRule that has no underlying ANTLR parse tree.
	 */
	public MigrationRule(String originalType, String migratedType, AST guard, AST body) {
		this(null, originalType, migratedType, guard, body);
	}
	
	
	public AST getAst() {
		return ast;
	}

	public List<?> getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	public String getOriginalType() {
		return originalType;
	}

	public String getMigratedType() {
		return migratedType;
	}
	

	public ModelElement createMigratedModelElement(IFlockContext context) throws FlockRuntimeException {
		return context.createModelElementInMigratedModel(migratedType);
	}
	
	public boolean appliesFor(ModelElement original, IFlockContext context) throws FlockRuntimeException {
		return isOfOriginalType(original) && satisfiesGuard(original, context);
	}
	
	boolean isOfOriginalType(ModelElement original) {
		return originalType.equals(original.getTypeName());
	}

	boolean satisfiesGuard(ModelElement original, IFlockContext context) throws FlockRuntimeException {
		if (guard == null)
			return true;
		
		return context.executeGuard(guard, createOriginalVariable(original));
	}
	

	public void applyTo(ModelElement original, ModelElement migrated, IFlockContext context) throws FlockRuntimeException {
		context.executeBlock(body, createOriginalVariable(original), createMigratedVariable(migrated));
	}
	
	private Variable createOriginalVariable(ModelElement original) {
		return original.createReadOnlyVariable("original");
	}
	
	private Variable createMigratedVariable(ModelElement migrated) {
		return migrated.createReadOnlyVariable("migrated");
	}
	
	@Override
	public String toString() {
		return originalType + " to " + migratedType + " when " + guard + " do " + body;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof MigrationRule))
			return false;
		
		final MigrationRule other = (MigrationRule)object;
		
		return equals(originalType, other.originalType) &&
		       equals(migratedType, other.migratedType) &&
		       equals(guard,        other.guard)        &&
		       equals(body,         other.body);
	}
	
	@Override
	public int hashCode() {
		return originalType.hashCode() +
		       migratedType.hashCode() +
		       guard.hashCode()        + 
		       body.hashCode();
	}

	private boolean equals(Object first, Object second) {
		if (first == null)
			return second == null;
		else
			return first.equals(second);
	}
}
