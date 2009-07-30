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

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.migration.execution.Equivalences;

class CollectionOfModelValues extends ModelValue<EolCollection> implements Iterable<ModelValue<?>> {

	private final Collection<ModelValue<?>> modelValues = new LinkedList<ModelValue<?>>();
	
	CollectionOfModelValues(Model model, EolCollection underlyingModelObjects) {
		super(model, underlyingModelObjects);
		
		wrapValues(underlyingModelObjects);
	}
	
	private CollectionOfModelValues(Model model, Collection<ModelValue<?>> wrappedValues) {
		super(model, null);
		modelValues.addAll(wrappedValues);
	}

	private void wrapValues(EolCollection underlyingModelObjects) {
		for (Object underlyingModelObject : underlyingModelObjects.getStorage()) {
			modelValues.add(model.wrapValue(underlyingModelObject));
		}
	}
	
	CollectionOfModelValues getEquivalentIn(Model model, Equivalences equivalences) throws CopyingException {
		final Collection<ModelValue<?>> copiedModelValues = new LinkedList<ModelValue<?>>();
		
		for (ModelValue<?> modelValue : modelValues) {
			copiedModelValues.add(modelValue.getEquivalentIn(model, equivalences));
		}
		
		return new CollectionOfModelValues(model, copiedModelValues);
	}

	@Override
	EolCollection unwrap() {
		final EolCollection modelObjects = new EolSequence();
		
		for (ModelValue<?> modelValue : modelValues) {
			modelObjects.add(modelValue.unwrap());
		}
		
		return modelObjects;
	}

	public Iterator<ModelValue<?>> iterator() {
		return modelValues.iterator();
	}
	
	@Override
	public String toString() {
		return modelValues.toString();
	}
}
