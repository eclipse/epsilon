/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.trace;

import java.util.Arrays;
import java.util.Collection;

public class ModelLocation {

	public final Object modelElement;
	public final String propertyName;
	
	public ModelLocation(Object modelElement, String propertyName) {
		this.modelElement = modelElement;
		this.propertyName = propertyName;
	}
	
	
	// Getters for compatibility with JavaModel, which are used in acceptance tests

	public Object getModelElement() {
		return modelElement;
	}
	
	public String getPropertyName() {
		return propertyName;
	}

	public Collection<? extends Object> getAllContents() {
		return Arrays.asList(this, modelElement);
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ModelLocation))
			return false;
		
		final ModelLocation other = (ModelLocation)object;
		
		return modelElement.equals(other.modelElement) &&
		       propertyName.equals(other.propertyName);
	}

	@Override
	public int hashCode() {
		return modelElement.hashCode() + propertyName.hashCode();
	}
	
	@Override
	public String toString() {
		return "<ModelLocation modelElement:" + modelElement + ", propertyName:" + propertyName + ">"; 
	}
}
