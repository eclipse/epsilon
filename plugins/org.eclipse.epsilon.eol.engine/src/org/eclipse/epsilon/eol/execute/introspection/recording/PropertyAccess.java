/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.introspection.recording;

public class PropertyAccess implements IPropertyAccess {
	
	protected final Object modelElement;
	protected final String propertyName;
	
	public PropertyAccess(Object modelElement, String propertyName) {
		this.modelElement = modelElement;
		this.propertyName = propertyName;
	}

	@Override
	public Object getModelElement() {
		return this.modelElement;
	}

	@Override
	public String getPropertyName() {
		return this.propertyName;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof PropertyAccess))
			return false;
		
		final PropertyAccess other = (PropertyAccess)object;
		
		return modelElement.equals(other.modelElement) &&
		       propertyName.equals(other.propertyName);
	}
	
	@Override
	public int hashCode() {
		return modelElement.hashCode() + propertyName.hashCode();
	}
	
	@Override
	public String toString() {
		return "PropertyAccess of '" + propertyName + "' on model element: '" + modelElement + "'";
	}
}
