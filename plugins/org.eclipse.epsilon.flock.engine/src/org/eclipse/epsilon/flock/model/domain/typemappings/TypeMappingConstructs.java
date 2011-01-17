/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.model.domain.typemappings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.equivalences.factory.DefaultEquivalenceFactory;
import org.eclipse.epsilon.flock.equivalences.factory.EquivalenceFactory;
import org.eclipse.epsilon.flock.execution.TypeMappingContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class TypeMappingConstructs {
	private final List<TypeMappingConstruct> typeMappingConstructs = new LinkedList<TypeMappingConstruct>();
	private final EquivalenceFactory defaultEquivalenceFactory;
	
	public TypeMappingConstructs(TypeMappingConstruct... typeMappings) {
		this(DefaultEquivalenceFactory.getInstance());
		this.typeMappingConstructs.addAll(Arrays.asList(typeMappings));
	}
	
	public TypeMappingConstructs(EquivalenceFactory defaultEquivalenceFactory) {
		this.defaultEquivalenceFactory = defaultEquivalenceFactory;
	}
	
	public void add(TypeMappingConstruct typeMapping) {
		typeMappingConstructs.add(typeMapping);
	}

	public Equivalence createEquivalence(TypeMappingContext context) throws FlockRuntimeException {
		for (TypeMappingConstruct typeMapping : typeMappingConstructs) {
			if (context.isEligibleFor(typeMapping)) {
				return context.createEquivalenceUsing(typeMapping);
			}
		}
				
		return context.createEquivalenceUsing(defaultEquivalenceFactory);
	}
}