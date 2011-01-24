/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.model.checker;

import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class IgnoredPropertyChecker {

	private final String originalType;
	private final MigrationStrategyCheckingContext context;

	public IgnoredPropertyChecker(String originalType, MigrationStrategyCheckingContext context) {
		this.originalType = originalType;
		this.context      = context;
	}

	public void check(String property) {
		try {
			if (!context.isPropertyInOriginalMetamodel(originalType, property)) {
				context.addWarning("The " + property + " property should be ignored, "  +  
			                       "but there is no " + property + " property defined " +
			                       "for " + originalType + " in the original metamodel.");
			}
			
		} catch (FlockRuntimeException e) {
			// Ignore, and let checking proceed to next property
		}
	}

}
