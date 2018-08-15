/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.execute.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class ConstraintContextAtom extends EvlAtom<ConstraintContext> {
	
	public ConstraintContextAtom(ConstraintContext constraintContext, Object modelElement, IEvlContext evlContext) {
		super(constraintContext, modelElement, evlContext);
	}
	
	public ConstraintContextAtom(ConstraintContext constraintContext, Object modelElement) {
		super(constraintContext, modelElement);
	}
	
	public boolean execute(IEvlContext context) throws EolRuntimeException {
		if (unit.shouldBeChecked(element, context)) {
			for (Constraint constraint : unit.getConstraints()) {
				constraint.execute(element, context);
			}
			return true;
		}
		else return false;
	}
	
	public Collection<UnsatisfiedConstraint> executeWithResults(IEvlContext context) throws EolRuntimeException {
		if (unit.shouldBeChecked(element, context)) {
			Collection<Constraint> constraints = unit.getConstraints();
			ArrayList<UnsatisfiedConstraint> results = new ArrayList<>(constraints.size());
			for (Constraint constraint : constraints) {
				constraint.execute(element, context).ifPresent(results::add);
			}
			return results;
		}
		else return Collections.emptyList();
	}
	
	public static ArrayList<ConstraintContextAtom> getContextJobs(IEvlContext context) throws EolRuntimeException {
		ArrayList<ConstraintContextAtom> atoms = new ArrayList<>();
		
		for (ConstraintContext constraintContext : context.getModule().getConstraintContexts()) {
			Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			atoms.ensureCapacity(atoms.size()+allOfKind.size());
			for (Object element : allOfKind) {
				atoms.add(new ConstraintContextAtom(constraintContext, element));
			}
		}
		
		return atoms;
	}
}
