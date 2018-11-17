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
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
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
public class EvlRunConfiguration extends IErlRunConfiguration<IEvlModule, Set<UnsatisfiedConstraint>> {
	
	public EvlRunConfiguration(IEolRunConfiguration.Builder<IEvlModule, ? extends IErlRunConfiguration<IEvlModule, Set<UnsatisfiedConstraint>>> builder) {
		super(builder);
	}
	
	public EvlRunConfiguration(IEolRunConfiguration<? extends IEvlModule, ? extends Set<UnsatisfiedConstraint>> other) {
		super(other);
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
	
	@Override
	public Set<UnsatisfiedConstraint> execute() throws EolRuntimeException {
		return super.execute();
	}
	
	@Override
	public void postExecute() throws Exception {
		super.postExecute();
		
		if (showResults || profileExecution) {
			IEvlContext context = module.getContext();
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