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

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.execution.exceptions.ConservativeCopyException;

class CollectionOfModelValues extends ModelValue<EolCollection> implements Iterable<ModelValue<?>> {

	private final Collection<ModelValue<?>> modelValues = new LinkedList<ModelValue<?>>();
	
	CollectionOfModelValues(Model model, Collection<ModelValue<?>> wrappedValues) {
		modelValues.addAll(wrappedValues);
	}
	
	CollectionOfModelValues(Model model, ModelValue<?>... wrappedValues) {
		this(model, Arrays.asList(wrappedValues));
	}
	
	@Override
	CollectionOfModelValues getEquivalentIn(Model model, IMigrationContext context) throws ConservativeCopyException {
		final Collection<ModelValue<?>> copiedModelValues = new LinkedList<ModelValue<?>>();
		
		for (ModelValue<?> modelValue : modelValues) {
			final ModelValue<?> equivalent = modelValue.getEquivalentIn(model, context);
			
			// EMF collections cannot contain nulls
			if (equivalent.unwrap() != null)
				copiedModelValues.add(equivalent);
		}
		
		return new CollectionOfModelValues(model, copiedModelValues);
	}

	@Override
	public EolCollection unwrap() {
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
	public boolean equals(Object o) {
		if (!(o instanceof CollectionOfModelValues))
			return false;
		
		return modelValues.equals(((CollectionOfModelValues)o).modelValues);
	}

	@Override
	public int hashCode() {
		return modelValues.hashCode();
	}
	
	@Override
	public String toString() {
		return modelValues.toString();
	}
}
