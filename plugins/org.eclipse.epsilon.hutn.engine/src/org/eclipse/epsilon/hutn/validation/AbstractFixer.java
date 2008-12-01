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

	private IEvlModule module = null;
	private boolean appliedFixes = false;
	
	public void fix(IEvlModule module) throws EolRuntimeException {
		this.module = module; 
		applyFixes();
	}
	
	private void applyFixes() throws EolRuntimeException {
		appliedFixes = false;

		for (EvlUnsatisfiedConstraint constraint : module.getContext().getUnsatisfiedConstraints()) {
			if (!constraint.getFixes().isEmpty()) {				
				appliedFixes = applyFix(constraint);
			}
		}
	}

	public boolean hasAppliedFixes() {
		return appliedFixes ;
	}
	
	public List<ParseProblem> getParseProblems() {
		final List<ParseProblem> problems = new ArrayList<ParseProblem>();
		
		if (module != null) {
			for (EvlUnsatisfiedConstraint constraint : module.getContext().getUnsatisfiedConstraints()) {
				problems.add(interpretUnsatisfiedConstraint(constraint));
			}
		}
		
		return problems;
	}
	
	/**
	 * Clients should override this method if fixes are used by the
	 * validator. Returning true causes validation to be invoked again.
	 * 
	 * @param constraint The unsatisifed constraint for which a fix will be applied. 
	 * @return true if and only if the fix caused the model to be changed.
	 * @throws EolRuntimeException 
	 */
	protected boolean applyFix(EvlUnsatisfiedConstraint constraint) throws EolRuntimeException {
		return false;
	}
	
	protected abstract ParseProblem interpretUnsatisfiedConstraint(EvlUnsatisfiedConstraint constraint);
}
