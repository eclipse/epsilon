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

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyAssignmentException;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;

public class EmfPropertySetter extends AbstractPropertySetter {

	public Object coerce(Object value) throws EolIllegalPropertyException {
		if (getEStructuralFeature().isMany() && !(value instanceof EolCollection)) {
			return new EolSequence(Arrays.asList(value));
		}
		
		return value;
	}
	
	@SuppressWarnings("unchecked")
	public boolean conforms(Object value) throws EolIllegalPropertyException {
		if (propertyIsFixed())
			return false;
		
		if (value instanceof EolCollection) {
			final Collection<Object> collection = ((EolCollection)value).getStorage();
		
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
		
		if (value != null) {
			if (sf.isMany()){
				Collection<Object> sourceValues = (Collection<Object>) getEObject().eGet(sf);
				if (value instanceof EolCollection){	
					copyCollectionValues(((EolCollection)value).getStorage(), sourceValues);
				}
				else {
					throw new EolIllegalPropertyAssignmentException(
							this.getProperty(), this.getAst());
				}
			}
			else {
				getEObject().eSet(sf, unwrap(value));
			}
		}
	}
	
	protected void copyCollectionValues(Collection<?> source, Collection<Object> target) {
		target.clear();

		for (Object element : source) {
			target.add(unwrap(element));
		}
	}
	
	private static Object unwrap(Object value) {
		return EolTypeWrapper.getInstance().unwrap(value);
	}
	
	
	private EObject getEObject() throws EolIllegalPropertyException {
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
	
	private boolean allAreConformantTypeForProperty(Collection<Object> values) throws EolIllegalPropertyException {
		for (Object value : values) {
			if (!isConformantTypeForProperty(value))
				return false;
		}
		
		return true;
	}
	
	private boolean isConformantTypeForProperty(Object value) throws EolIllegalPropertyException {
		return getEStructuralFeature().getEType().isInstance(unwrap(value));
	}	
}
