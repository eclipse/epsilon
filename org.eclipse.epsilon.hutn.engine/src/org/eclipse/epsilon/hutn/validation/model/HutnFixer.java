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

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.evl.EvlUnsatisfiedConstraint;
import org.eclipse.epsilon.hutn.model.hutn.ModelElement;
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

}
