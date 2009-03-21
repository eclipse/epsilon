/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.hutn.validation.model;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.EvlFixInstance;
import org.eclipse.epsilon.evl.EvlUnsatisfiedConstraint;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ModelElement;
import org.eclipse.epsilon.hutn.model.hutn.Slot;
import org.eclipse.epsilon.hutn.validation.AbstractFixer;

class HutnFixer extends AbstractFixer {

	@Override
	protected ParseProblem interpretUnsatisfiedConstraint(EvlUnsatisfiedConstraint constraint) {
		if (constraint.getInstance() instanceof ModelElement) {			
			final ModelElement modelElement = (ModelElement)constraint.getInstance();
			return new ParseProblem(modelElement.getLine(), modelElement.getCol(), constraint.getMessage());
		
		} else {
			throw new IllegalArgumentException("Constraint instance was not a ModelElement");
		}
	}

	@Override
	protected boolean applyFix(EvlUnsatisfiedConstraint constraint) throws EolRuntimeException {
		// Assume all fixes are for ClassMustSpecifyRequiredReferences constraint
		return applyFixForClassMustSpecifyRequiredReferences(constraint);
	}
	
	private boolean applyFixForClassMustSpecifyRequiredReferences(EvlUnsatisfiedConstraint constraint) throws EolRuntimeException {
		final ClassObject object = (ClassObject)constraint.getInstance();
		
		final List<Slot<?>> originalSlots = defensiveCopy(object.getSlots());
		
		((EvlFixInstance)constraint.getFixes().get(0)).perform();
		
		// Return true only if fix caused a change.
		return !originalSlots.equals(object.getSlots());
	}
	
	
	private static <T> List<T> defensiveCopy(List<T> original) {
		return new LinkedList<T>(original);
	}
}
