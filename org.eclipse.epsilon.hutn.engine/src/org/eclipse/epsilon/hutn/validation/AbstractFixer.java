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
package org.eclipse.epsilon.hutn.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.EvlUnsatisfiedConstraint;
import org.eclipse.epsilon.evl.IEvlFixer;
import org.eclipse.epsilon.evl.IEvlModule;

public abstract class AbstractFixer implements IEvlFixer {

	private final List<ParseProblem> problems = new ArrayList<ParseProblem>();
	
	protected abstract ParseProblem interpretUnsatisfiedConstraint(EvlUnsatisfiedConstraint constraint);
	
	public void fix(IEvlModule module) throws EolRuntimeException {
		for (EvlUnsatisfiedConstraint constraint : module.getContext().getUnsatisfiedConstraints()) {
			problems.add(interpretUnsatisfiedConstraint(constraint));
		}
	}
	
	public List<ParseProblem> getParseProblems() {
		return problems;
	}
}
