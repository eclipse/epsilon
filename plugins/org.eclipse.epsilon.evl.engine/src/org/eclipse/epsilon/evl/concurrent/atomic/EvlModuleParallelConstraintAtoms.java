/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.concurrent.atomic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.execute.data.ExecutableRuleAtom;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlModuleParallelConstraintAtoms extends EvlModuleParallelAtomic<ExecutableRuleAtom<Constraint>> {

	public EvlModuleParallelConstraintAtoms() {
		super();
	}

	public EvlModuleParallelConstraintAtoms(IEvlContextParallel context) {
		super(context);
	}

	@Override
	protected List<ExecutableRuleAtom<Constraint>> getAllJobsImpl() throws EolRuntimeException {
		ArrayList<ExecutableRuleAtom<Constraint>> atoms = new ArrayList<>();
		IEvlContext context = getContext();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			for (Object element : allOfKind) {
				if (constraintContext.shouldBeChecked(element, context)) {
					Collection<Constraint> constraints = constraintContext.getConstraints();
					atoms.ensureCapacity(atoms.size()+(constraints.size()*allOfKind.size()));
					
					for (Constraint constraint : constraints) {
						atoms.add(new ExecutableRuleAtom<>(constraint, element, context));
					}
				}
			}
		}
		
		return atoms;
	}

}
