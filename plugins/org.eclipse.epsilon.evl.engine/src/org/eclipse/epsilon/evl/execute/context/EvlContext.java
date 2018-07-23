/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.execute.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

public class EvlContext extends EolContext implements IEvlContext{

	protected ConstraintTrace constraintTrace = new ConstraintTrace();
	protected ArrayList<UnsatisfiedConstraint> unsatisfiedConstraints = new ArrayList<UnsatisfiedConstraint>();
	
	public EvlContext() {
		super();
	}

	public ConstraintTrace getConstraintTrace() {
		return constraintTrace;
	}
	
	public ArrayList<UnsatisfiedConstraint> getUnsatisfiedConstraints() {
		return unsatisfiedConstraints;
	}
	
	public boolean hasFixes() {
		for (UnsatisfiedConstraint unsatisfiedConstraint : getUnsatisfiedConstraints()) {
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
