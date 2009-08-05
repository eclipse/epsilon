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
import org.eclipse.epsilon.migration.execution.exceptions.IllegalMigrationException;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.eclipse.epsilon.migration.model.MigrationRule;

public class Equivalence {
	
	private final ModelElement original;
	private final ModelElement equivalent;
	private final MigrationRule migrationRule;
	
	public Equivalence(ModelElement original, ModelElement equivalent, MigrationRule migrationRule) {
		this.original      = original;
		this.equivalent    = equivalent;
		this.migrationRule = migrationRule;
	}
	
	ModelElement getOriginal() {
		return original;
	}

	ModelElement getEquivalent() {
		return equivalent;
	}

	void populateEquivalent(Equivalences equivalences, IMigrationContext context) throws MigrationExecutionException {
		checkModelElementsStillResideInCorrectModels(context);
		
		equivalent.conservativelyCopyPropertiesFrom(original, equivalences);
		migrationRule.applyTo(original, equivalent, context);
	}
	
	private void checkModelElementsStillResideInCorrectModels(IMigrationContext context) throws IllegalMigrationException {
		if (!context.isElementInOriginalModel(original))
			throw new IllegalMigrationException("Original model no longer contains the model element: " + original);
		
		if (!context.isElementInMigratedModel(equivalent))
			throw new IllegalMigrationException("Migrated model no longer contains the model element: " + equivalent);
	}

	@Override
	public String toString() {
		return original + " <-> " + equivalent + " via " + migrationRule;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Equivalence))
			return false;
		
		final Equivalence other = (Equivalence)obj;
		
		return original.equals(other.original) &&
		       equivalent.equals(other.equivalent) &&
		       migrationRule.equals(other.migrationRule);
	}
	
	@Override
	public int hashCode() {
		return original.hashCode() + equivalent.hashCode() + migrationRule.hashCode();
	}
}