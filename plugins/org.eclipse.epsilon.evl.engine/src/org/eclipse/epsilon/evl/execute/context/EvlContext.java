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
package org.eclipse.epsilon.evl.execute.context;

import java.util.ArrayList;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.evl.EvlUnsatisfiedConstraint;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

public class EvlContext extends EolContext implements IEvlContext{

	protected ConstraintTrace constraintTrace = new ConstraintTrace();
	protected ArrayList<EvlUnsatisfiedConstraint> unsatisfiedConstraints = new ArrayList<EvlUnsatisfiedConstraint>();
	
	public EvlContext() {
		super();
	}

	public ConstraintTrace getConstraintTrace() {
		return constraintTrace;
	}
	
	public ArrayList<EvlUnsatisfiedConstraint> getUnsatisfiedConstraints() {
		return unsatisfiedConstraints;
	}
	
	public boolean hasFixes() {
		for (EvlUnsatisfiedConstraint unsatisfiedConstraint : getUnsatisfiedConstraints()) {
			if (unsatisfiedConstraint.getFixes().size() > 0) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public IEvlModule getModule(){
		return (IEvlModule) module;
	}
}
