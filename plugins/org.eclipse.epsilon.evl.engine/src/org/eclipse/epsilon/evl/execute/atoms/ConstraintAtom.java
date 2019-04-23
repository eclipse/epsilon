/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.execute.atoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

/**
 * A constraint-element pair.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ConstraintAtom extends EvlAtom<Constraint> {
	
	public ConstraintAtom(Constraint constraint, Object modelElement, IEvlContext evlContext) {
		super(constraint, modelElement, evlContext);
	}
	
	public ConstraintAtom(Constraint constraint, Object modelElement) {
		super(constraint, modelElement);
	}
	
	public Optional<UnsatisfiedConstraint> execute(IEvlContext context) throws EolRuntimeException {
		return unit.execute(element, context);
	}
	
	public static ArrayList<ConstraintAtom> getConstraintJobs(IEvlModule module) throws EolRuntimeException {
		ArrayList<ConstraintAtom> atoms = new ArrayList<>();
		IEvlContext context = module.getContext();
		for (ConstraintContext constraintContext : module.getConstraintContexts()) {
			Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			for (Object element : allOfKind) {
				if (constraintContext.shouldBeChecked(element, context)) {
					Collection<Constraint> constraints = constraintContext.getConstraints();
					atoms.ensureCapacity(atoms.size()+(constraints.size()*allOfKind.size()));
					
					for (Constraint constraint : constraints) {
						atoms.add(new ConstraintAtom(constraint, element));
					}
				}
			}
		}
		
		return atoms;
	}
}
