/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.launch;

import java.util.Set;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.launch.IErlRunConfiguration;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlRunConfiguration extends IErlRunConfiguration {
	
	public EvlRunConfiguration(Builder<? extends EvlRunConfiguration, ?> builder) {
		super(builder);
	}
	
	public EvlRunConfiguration(EvlRunConfiguration other) {
		super(other);
	}
	
	@Override
	public IEvlModule getModule() {
		return (IEvlModule) super.getModule();
	}
	
	@Override
	protected IEvlModule getDefaultModule() {
		return new EvlModule();
	}
	
	// METHOD VISIBILITY
	
	@Override
	public void preExecute() throws Exception {
		super.preExecute();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<UnsatisfiedConstraint> getResult() {
		return (Set<UnsatisfiedConstraint>) super.getResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<UnsatisfiedConstraint> execute() throws EolRuntimeException {
		return (Set<UnsatisfiedConstraint>) super.execute();
	}
	
	@Override
	public void postExecute() throws Exception {
		super.postExecute();
		
		if (showResults || profileExecution) {
			IEvlContext context = getModule().getContext();
			int numUnsatisfied = context.getUnsatisfiedConstraints().size();
			if (numUnsatisfied > 0) {
				writeOut(numUnsatisfied+" constraint"+(numUnsatisfied > 1 ? "s have" : " has")+" not been satisfied"+(showResults ? ':' : '.'));
				if (showResults) {
					writeOut(context.getUnsatisfiedConstraintsBySize().entrySet());
				}
			}
			else {
				writeOut("All constraints have been satisfied.");
			}
			
			writeOut(printMarker);
		}
	}
}