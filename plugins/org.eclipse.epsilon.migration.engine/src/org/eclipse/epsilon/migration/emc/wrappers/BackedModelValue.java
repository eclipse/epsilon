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

/**
 * An implementation of ModelValue that is backed by an underlying
 * Java object, which represents a model value.
 */
public abstract class BackedModelValue<UnwrappedType> extends ModelValue<UnwrappedType> {

	protected final Model model;
	protected final UnwrappedType underlyingModelObject;
	
	protected BackedModelValue(Model model, UnwrappedType underlyingModelObject) {
		this.model                 = model;
		this.underlyingModelObject = underlyingModelObject;
	}
	
	@Override
	UnwrappedType unwrap() {
		return underlyingModelObject;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof BackedModelValue<?>))
			return false;
		
		final BackedModelValue<?> other = (BackedModelValue<?>)o;
		
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
