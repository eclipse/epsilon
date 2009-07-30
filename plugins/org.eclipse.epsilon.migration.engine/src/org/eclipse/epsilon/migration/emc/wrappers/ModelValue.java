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

public abstract class ModelValue<UnwrappedType> {

	protected final Model model;
	protected final UnwrappedType underlyingModelObject;
	
	protected ModelValue(Model model, UnwrappedType underlyingModelObject) {
		this.model                 = model;
		this.underlyingModelObject = underlyingModelObject;
	}

	public Variable createReadOnlyVariable(String name) {
		return Variable.createReadOnlyVariable(name, unwrap());
	}
	
	UnwrappedType unwrap() {
		return underlyingModelObject;
	}
	
	abstract ModelValue<UnwrappedType> getEquivalentIn(Model model, Equivalences equivalences) throws CopyingException;
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ModelValue<?>))
			return false;
		
		final ModelValue<?> other = (ModelValue<?>)o;
		
		return model.equals(other.model) &&
		       underlyingModelObject == null ? 
		       	other.underlyingModelObject == null : 
		       	underlyingModelObject.equals(other.underlyingModelObject);
	}
	
	@Override
	public int hashCode() {
		return model.hashCode() + 
		       (underlyingModelObject == null ? 0 : underlyingModelObject.hashCode());
	}
	
	@Override
	public String toString() {
		return "<" + underlyingModelObject + ">";
	}
}
