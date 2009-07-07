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
import org.eclipse.epsilon.migration.execution.ExecutionContext;

public class NoOpMigrationRule implements MigrationRule {
	
	public void migrate(EObject original, EObject target, ExecutionContext context) {
		// Do nothing
	}
	
	@Override
	public String toString() {
		return "DefaultMigrationRule";
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof NoOpMigrationRule;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
}
