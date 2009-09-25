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
package org.eclipse.epsilon.flock.execution;

import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class DefaultEquivalenceCreator implements EquivalenceCreator {

	private static final EquivalenceCreator instance = new DefaultEquivalenceCreator();
	
	public static EquivalenceCreator getInstance() {
		return instance;
	}
	
	public Equivalence createEquivalence(ModelElement original, IFlockContext context) throws FlockRuntimeException {
		final ModelElement equivalent = context.safelyCreateModelElementInMigratedModel(original.getTypeName());
		
		if (equivalent == null) {
			return new NoEquivalence(original);
		} else {
			return new TypeBasedEquivalence(context, original, equivalent);
		}
	}
}
