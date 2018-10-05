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

import java.util.*;
import org.eclipse.epsilon.erl.execute.context.ErlContext;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

public class EvlContext extends ErlContext implements IEvlContext {

	protected Set<UnsatisfiedConstraint> unsatisfiedConstraints = new HashSet<>();
	protected ConstraintTrace constraintTrace = new ConstraintTrace();
	protected boolean optimizeConstraintTrace = false;
	protected Set<Constraint> constraintDependedOn;
	
	@Override
	public ConstraintTrace getConstraintTrace() {
		return constraintTrace;
	}
	
	@Override
	public Set<UnsatisfiedConstraint> getUnsatisfiedConstraints() {
		return unsatisfiedConstraints;
	}
	
	@Override
	public IEvlModule getModule() {
		return (IEvlModule) module;
	}

	@Override
	public void setOptimizeConstraintTrace(boolean optimize) {
		this.optimizeConstraintTrace = optimize;
	}

	@Override
	public boolean isOptimizeConstraintTrace() {
		return optimizeConstraintTrace;
	}

	@Override
	public Set<Constraint> getConstraintsDependedOn() {
		if (constraintDependedOn == null) {
			constraintDependedOn = IEvlContext.super.getConstraintsDependedOn();
		}
		return constraintDependedOn;
	}
	
	@Override
	public void setConstraintsDependedOn(Set<Constraint> dependencies) {
		this.constraintDependedOn = dependencies;
	}
}
