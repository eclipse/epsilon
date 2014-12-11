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
package org.eclipse.epsilon.flock.model.domain.common;

import java.util.Collection;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.execution.GuardedConstructContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.checker.ClassifierTypedConstructChecker;

public abstract class ClassifierTypedConstruct extends GuardedConstruct {

	private String originalType;
	
	public ClassifierTypedConstruct(AST ast, Collection<String> annotations, AST guard, String originalType) {
		super(ast, annotations, guard);
		this.originalType = originalType;
	}
	
	@Override // FIXME remove
	protected boolean isAnnotatedWith(String annotation) {
		return hasAnnotation(annotation);
	}
	
	@Override
	public void build() {
		super.build();
		
		originalType = getFirstChild().getText();
		if (originalType == null) throw new IllegalStateException("originalType cannot be null");
	}
	
	public String getOriginalType() {
		return originalType;
	}
	
	protected boolean isStrict() {
		return isAnnotatedWith("strict");
	}
	
	public boolean appliesIn(GuardedConstructContext context) throws FlockRuntimeException {
		return typedFor(context) && super.appliesIn(context);
	}

	protected boolean typedFor(GuardedConstructContext context) {
		return context.originalConformsTo(originalType, isStrict());
	}
	
	public void check(MigrationStrategyCheckingContext context) {
		new ClassifierTypedConstructChecker(originalType, context).check();
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ClassifierTypedConstruct))
			return false;
		
		final ClassifierTypedConstruct other = (ClassifierTypedConstruct)object;
		
		return super.equals(other) &&
			   originalType.equals(other.originalType);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + originalType.hashCode();
	}
}
