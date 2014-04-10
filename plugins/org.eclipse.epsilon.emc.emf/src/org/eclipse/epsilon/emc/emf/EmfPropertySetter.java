/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.emf;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyAssignmentException;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;

public class EmfPropertySetter extends AbstractPropertySetter implements IReflectivePropertySetter {

	public Object coerce(Object value) throws EolIllegalPropertyException {
		if (getEStructuralFeature().isMany() && !(value instanceof Collection)) {
			return CollectionUtil.asList(value);
		}
		
		return value;
	}
	
	public boolean conforms(Object value) throws EolIllegalPropertyException {
		if (propertyIsFixed())
			return false;
		
		if (value instanceof Collection) {
			final Collection<?> collection = ((Collection<?>)value);
		
			return propertyCanHoldCollections() &&
			       isConformantSizeForProperty(collection) && 
			       allAreConformantTypeForProperty(collection);
		
		} else {
			return isConformantTypeForProperty(value);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void invoke(Object value) throws EolRuntimeException {
		EStructuralFeature sf = getEStructuralFeature();
		
		
		if (sf.isMany()) {
			if (value != null) {
				Collection<Object> sourceValues = (Collection<Object>) getEObject().eGet(sf);
				if (value instanceof Collection){	
					copyCollectionValues(((Collection<?>)value), sourceValues);
				}
				else {
					throw new EolIllegalPropertyAssignmentException(
							this.getProperty(), this.getAst());
				}
			}
		}
		else {
			getEObject().eSet(sf, value);
		}
	}
	
	protected void copyCollectionValues(Collection<?> source, Collection<Object> target) {
		target.clear();

		for (Object element : source) {
			target.add(element);
		}
	}
	
	protected EObject getEObject() throws EolIllegalPropertyException {
		if (object instanceof EObject)
			return (EObject) object;
		else
			throw new EolIllegalPropertyException(object, property, ast, context);
	}
	
	private EStructuralFeature getEStructuralFeature() throws EolIllegalPropertyException {
		final EStructuralFeature sf = EmfUtil.getEStructuralFeature(getEObject().eClass(), property);
		
		if (sf == null)
			throw new EolIllegalPropertyException(object, property, ast, context);
		else
			return sf;
	}
	
	private boolean propertyIsFixed() throws EolIllegalPropertyException {
		return !getEStructuralFeature().isChangeable();
	}
	
	private boolean propertyCanHoldCollections() throws EolIllegalPropertyException {
		return getEStructuralFeature().isMany();
	}
	
	private boolean isConformantSizeForProperty(Collection<?> values) throws EolIllegalPropertyException {
		return lowerbound() <= values.size() && values.size() <= upperbound();
	}
	
	private int upperbound() throws EolIllegalPropertyException {
		final int upperbound = getEStructuralFeature().getUpperBound();
		
		return upperbound == EStructuralFeature.UNBOUNDED_MULTIPLICITY ? Integer.MAX_VALUE : upperbound;
	}
	
	private int lowerbound() throws EolIllegalPropertyException {
		return getEStructuralFeature().getLowerBound();
	}
	
	private boolean allAreConformantTypeForProperty(Collection<?> values) throws EolIllegalPropertyException {
		for (Object value : values) {
			if (!isConformantTypeForProperty(value))
				return false;
		}
		
		return true;
	}
	
	private boolean isConformantTypeForProperty(Object value) throws EolIllegalPropertyException {
		return getEStructuralFeature().getEType().isInstance(value);
	}	
}
