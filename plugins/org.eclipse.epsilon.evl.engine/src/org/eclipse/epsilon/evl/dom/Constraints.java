/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
