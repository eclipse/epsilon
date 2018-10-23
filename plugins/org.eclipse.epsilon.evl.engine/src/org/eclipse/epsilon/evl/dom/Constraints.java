/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.dom;

import java.util.ArrayList;
import java.util.Optional;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.execute.exceptions.EvlConstraintNotFoundException;

@SuppressWarnings("serial")
public class Constraints extends ArrayList<Constraint> {
	
	public Constraint getConstraint(String name, Object target, IEvlContext context, ModuleElement ast) throws EolRuntimeException {
		Optional<Constraint> constraint = getConstraint(name, null, target, context, false);
		if (!constraint.isPresent()) {
			constraint = this.stream().filter(c -> c.getName().equals(name)).findFirst();
		}
		return constraint.orElseThrow(() -> new EvlConstraintNotFoundException(name, ast));
	}
	
	public Optional<Constraint> getConstraint(String name, ConstraintContext constraintContext, Object target, IEvlContext context, boolean appliesTo) throws EolRuntimeException {
		for (Constraint constraint : this) {
			ConstraintContext cc = constraintContext == null ? constraint.getConstraintContext() : constraintContext;
			if (
				constraint.getName().equals(name) && 
				(
					(cc instanceof GlobalConstraintContext) ||
					cc.getAllOfSourceKind(context).contains(target)
				) &&
				(!appliesTo || constraint.appliesTo(target, context))
			) {
				return Optional.of(constraint);
			}
		}
		return Optional.empty();
	}
	
}
