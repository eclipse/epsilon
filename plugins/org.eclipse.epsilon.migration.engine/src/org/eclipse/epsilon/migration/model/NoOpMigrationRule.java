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

import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;

public class NoOpMigrationRule extends AbstractMigrationRule implements MigrationRule {
	
	public NoOpMigrationRule(String type) {
		super(type);
	}
	
	public void applyTo(ModelElement original, ModelElement migrated, IMigrationContext context) {
		// Do nothing
	}
	
	@Override
	public String toString() {
		return "NoOpMigrationRule for " + migratedType;
	}
}
