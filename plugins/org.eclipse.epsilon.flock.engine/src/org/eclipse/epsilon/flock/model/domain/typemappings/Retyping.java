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
package org.eclipse.epsilon.flock.model.domain.typemappings;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.context.EquivalenceEstablishmentContext.EquivalentFactory;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.equivalences.TypeBasedEquivalence;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class Retyping extends TypeMappingConstruct {

	private final String evolvedType;
	
	public Retyping(AST ast, String originalType, String evolvedType, AST guard) {
		super(ast, originalType, guard);
		
		if (evolvedType == null)
			throw new IllegalArgumentException("evolvedType cannot be null");
		
		this.evolvedType = evolvedType;
	}
	
	public Retyping(AST ast, String originalType, String evolvedType) {
		this(ast, originalType, evolvedType, null);
	}
	
	public String getEvolvedType() {
		return evolvedType;
	}

	public Equivalence createEquivalence(ModelElement original, EquivalentFactory factory) throws FlockRuntimeException {
		final ModelElement equivalent = factory.createModelElementInMigratedModel(evolvedType);
		return new TypeBasedEquivalence(original, equivalent);
	}
	
	@Override
	public String toString() {
		return "retype " + getOriginalType() + " to " + evolvedType + " when " + getGuard();
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Retyping))
			return false;
		
		final Retyping other = (Retyping)object;
		
		return super.equals(object) &&
		       this.evolvedType.equals(other.evolvedType);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + evolvedType.hashCode();
	}
}
