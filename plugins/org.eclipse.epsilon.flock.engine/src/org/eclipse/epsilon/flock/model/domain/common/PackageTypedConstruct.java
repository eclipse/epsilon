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

import java.util.LinkedList;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.execution.GuardedConstructContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.checker.PackageTypedConstructChecker;

public abstract class PackageTypedConstruct extends GuardedConstruct {

	private String originalPackage;
	
	public PackageTypedConstruct(AST ast, AST guard, String originalPackage) {
		super(ast, new LinkedList<String>(), guard);
	}
	
	@Override
	public void build() {
		super.build();

		originalPackage = getFirstChild().getText();
		if (originalPackage == null)
			throw new IllegalArgumentException("originalPackage cannot be null");
	}
	
	public String getOriginalPackage() {
		return originalPackage;
	}
	
	public boolean appliesIn(GuardedConstructContext context) throws FlockRuntimeException {
		return context.originalBelongsTo(originalPackage) && 
			   super.appliesIn(context);
	}
	
	public void check(MigrationStrategyCheckingContext context) {
		new PackageTypedConstructChecker(originalPackage, context).check();
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof PackageTypedConstruct))
			return false;
		
		final PackageTypedConstruct other = (PackageTypedConstruct)object;
		
		return super.equals(other) &&
			   originalPackage.equals(other.originalPackage);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + originalPackage.hashCode();
	}
}
