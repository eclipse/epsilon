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
package org.eclipse.epsilon.migration.emc.wrappers;

import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.migration.execution.Equivalences;
import org.eclipse.epsilon.migration.execution.exceptions.ConservativeCopyException;

public abstract class ModelValue<UnwrappedType> {

	public Variable createReadOnlyVariable(String name) {
		return Variable.createReadOnlyVariable(name, unwrap());
	}

	abstract UnwrappedType unwrap();
	
	abstract ModelValue<UnwrappedType> getEquivalentIn(Model model, Equivalences equivalences) throws ConservativeCopyException;
	
	@Override
	public abstract boolean equals(Object o);

	@Override
	public abstract int hashCode();

	@Override
	public abstract String toString();
}