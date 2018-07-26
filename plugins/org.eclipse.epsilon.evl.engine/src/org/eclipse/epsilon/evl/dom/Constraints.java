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
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

@SuppressWarnings("serial")
public class Constraints extends ArrayList<Constraint> {
	
	public Optional<Constraint> getConstraint(String name, Object target, IEvlContext context) throws EolRuntimeException {
		return getConstraint(name, target, context, false);
	}
	
	public Optional<Constraint> getConstraint(String name, Object target, IEvlContext context, boolean appliesTo) throws EolRuntimeException {
		for (Constraint constraint : this) {
			ConstraintContext constraintContext = constraint.getConstraintContext();
			if (
				constraint.getName().equals(name) && 
				(
					(constraintContext instanceof GlobalConstraintContext) ||
					constraintContext.getAllOfSourceKind(context).contains(target)
				) &&
				(!appliesTo || constraint.appliesTo(target, context))
			) {
				return Optional.of(constraint);
			}
		}
		return Optional.empty();
	}
	
}
