/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.launch;

import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.erl.execute.context.IErlContext;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class IErlRunConfiguration<M extends IErlModule, R> extends IEolRunConfiguration<M, R> {
	
	public IErlRunConfiguration(Builder<M, ? extends IErlRunConfiguration<M, R>> builder) {
		super(builder);
	}
	
	public IErlRunConfiguration(IEolRunConfiguration<? extends M, ? extends R> other) {
		super(other);
	}

	@Override
	protected void postExecute() throws Exception {
		super.postExecute();
		if (profileExecution && module.getContext() instanceof IErlContext) {
			writeOut(((IErlContext) module.getContext()).getExecutorFactory().getRuleProfiler(), printMarker);
		}
	}
	
}
