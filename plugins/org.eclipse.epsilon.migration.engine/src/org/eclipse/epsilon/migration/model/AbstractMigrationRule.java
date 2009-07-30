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
import org.eclipse.epsilon.migration.execution.MigrationExecutionException;

public abstract class AbstractMigrationRule implements MigrationRule {

	protected final String targetType;
	
	public AbstractMigrationRule(String targetType) {
		this.targetType = targetType;
	}
	
	ModelElement createTargetModelElement(IMigrationContext context) throws MigrationExecutionException {
		return context.createTargetModelElement(targetType);
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof AbstractMigrationRule))
			return false;
		
		return equals(targetType, ((AbstractMigrationRule)other).targetType);
	}
	
	@Override
	public int hashCode() {
		return targetType.hashCode();
	}
	
	protected boolean equals(Object first, Object second) {
		if (first == null)
			return second == null;
		else
			return first.equals(second);
	}
}
