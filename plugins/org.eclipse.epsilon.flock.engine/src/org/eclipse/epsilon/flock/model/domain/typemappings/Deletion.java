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

import org.eclipse.epsilon.flock.FlockExecution;
import org.eclipse.epsilon.flock.context.EquivalenceEstablishmentContext.EquivalentFactory;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.equivalences.NoEquivalence;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.GuardedConstructContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.common.ClassifierTypedConstruct;

public class Deletion extends ClassifierTypedConstruct implements TypeMappingConstruct {
	
	public Deletion() {
		super(null, null, null, null);
	}
	
	public Equivalence createEquivalence(EolExecutor executor, FlockExecution execution, ModelElement original, EquivalentFactory equivalentFactory) throws FlockRuntimeException {
		return new NoEquivalence(executor, execution, original);
	}
	
	@Override
	public boolean appliesIn(GuardedConstructContext context) throws FlockRuntimeException {
		if (this.typedFor(context) && super.appliesIn(context)) {
			return true;
		
		} else if (this.isCascading()) {
			return this.appliesInAncestorOf(context);
		}

		return false;
	}
	
	private boolean appliesInAncestorOf(GuardedConstructContext context) throws FlockRuntimeException {
		// Attempt to find an ancestor context to which this deletion construct applies
		// by navigating through the parents 
		while (context.isContextForParentElement()) {
			if (super.appliesIn(context.getContextForParentElement())) {
				return true;
			}
			context = context.getContextForParentElement();
		}
		
		return false;
	}

	protected boolean isCascading() {
		return hasAnnotation("cascade");
	}
	
	@Override
	public String toString() {
		return "delete " + getOriginalType() + " when " + getGuard();
	}
}
