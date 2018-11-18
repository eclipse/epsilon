/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.ecl.launch;

import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.erl.launch.IErlRunConfiguration;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EclRunConfiguration extends IErlRunConfiguration<IEclModule> {

	public EclRunConfiguration(Builder<IEclModule, ? extends IErlRunConfiguration<IEclModule>, ?> builder) {
		super(builder);
	}
	
	public EclRunConfiguration(IErlRunConfiguration<IEclModule> other) {
		super(other);
	}

	@Override
	protected IEclModule getDefaultModule() {
		return new EclModule();
	}
	
	@Override
	public MatchTrace getResult() {
		return (MatchTrace) super.getResult();
	}
	
	@Override
	protected void postExecute() throws Exception {
		getResult().toString(module.getContext());
		super.postExecute();
	}
}
