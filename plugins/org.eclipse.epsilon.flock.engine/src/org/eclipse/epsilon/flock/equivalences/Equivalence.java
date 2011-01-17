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
package org.eclipse.epsilon.flock.equivalences;

import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public abstract class Equivalence {

	public abstract ModelElement getOriginal();

	public abstract ModelElement getEquivalent();
	
	public Variable[] getVariables() {
		return new Variable[] {
		                        getOriginal().createReadOnlyVariable("original"),
		                        getEquivalent().createReadOnlyVariable("migrated")
		                      };
	}

	public abstract void automaticallyPopulateEquivalent(ConservativeCopyContext context) throws FlockRuntimeException;
	
	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract int hashCode();

	@Override
	public abstract String toString();
}