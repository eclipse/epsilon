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
package org.eclipse.epsilon.migration.execution;

import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;

public class TypeBasedEquivalence implements Equivalence {

	protected final IMigrationContext context;
	
	protected final ModelElement original;
	protected final ModelElement equivalent;
	
	public TypeBasedEquivalence(IMigrationContext context, ModelElement original) throws MigrationExecutionException {
		this(context, original, context.createModelElementOfSameTypeInMigratedModel(original));
	}
	
	protected TypeBasedEquivalence(IMigrationContext context, ModelElement original, ModelElement equivalent) {
		this.original   = original;
		this.equivalent = equivalent;
		this.context    = context;
	}
	
	public ModelElement getOriginal() {
		return original;
	}

	public ModelElement getEquivalent() {
		return equivalent;
	}
	
	public void automaticallyPopulateEquivalence() throws MigrationExecutionException {
		if (equivalent != null)
			equivalent.conservativelyCopyPropertiesFrom(original, context);
	}
	
	public void applyStrategyToPopulateEquivalence() throws MigrationExecutionException {
		// no rule applies
	}
	
	@Override
	public String toString() {
		return original + " <-> " + equivalent;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TypeBasedEquivalence))
			return false;
		
		final TypeBasedEquivalence other = (TypeBasedEquivalence)obj;
		
		return original.equals(other.original) &&
		       equivalent == null ? other.equivalent == null : equivalent.equals(other.equivalent);
	}
	
	@Override
	public int hashCode() {
		return original.hashCode() + equivalent.hashCode();
	}
}
