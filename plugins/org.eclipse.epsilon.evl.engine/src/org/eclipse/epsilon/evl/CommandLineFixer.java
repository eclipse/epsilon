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
package org.eclipse.epsilon.evl;

import java.util.ListIterator;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.userinput.IUserInput;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class CommandLineFixer implements IEvlFixer {

	protected boolean fix = false;
	
	public CommandLineFixer() {
		super();
	}
	
	public void fix(IEvlModule module) throws EolRuntimeException {
		IEvlContext context = module.getContext();
		IUserInput userInput = context.getUserInput();
		ListIterator<EvlUnsatisfiedConstraint> li = context.getUnsatisfiedConstraints().listIterator();
		while (li.hasNext()){
			EvlUnsatisfiedConstraint unsatisfiedConstraint = li.next();
			
			context.getOutputStream().println(unsatisfiedConstraint.getMessage());
			boolean fixIt = fix && (unsatisfiedConstraint.getFixes().size() > 0) && userInput.confirm("Fix error?", true);
			
			if (fixIt) {
				EvlFixInstance fixInstance = (EvlFixInstance) userInput.choose(unsatisfiedConstraint.getMessage(),unsatisfiedConstraint.getFixes(), null);
				if (fixInstance != null) {
					fixInstance.perform();
				}
			}
		}
	}

	public boolean isFix() {
		return fix;
	}

	public void setFix(boolean fix) {
		this.fix = fix;
	}
	
}
