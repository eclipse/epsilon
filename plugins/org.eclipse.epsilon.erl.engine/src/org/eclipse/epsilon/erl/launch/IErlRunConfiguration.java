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
import org.eclipse.epsilon.erl.concurrent.IErlModuleParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class IErlRunConfiguration extends IEolRunConfiguration {
	
	public static abstract class Builder<R extends IErlRunConfiguration, B extends Builder<R, B>> extends IEolRunConfiguration.Builder<R, B> {
		
		@Override
		protected IErlModule createModule() {
			return isParallel() ? createParallelModule() : createDefaultModule();
		}
		
		protected abstract IErlModule createDefaultModule();
		
		protected abstract IErlModuleParallel createParallelModule();
		
		protected Builder() {
			super();
		}
		protected Builder(Class<R> runConfigClass) {
			super(runConfigClass);
		}
		
	}
	
	public IErlRunConfiguration(Builder<? extends IErlRunConfiguration, ?> builder) {
		super(builder);
	}
	
	public IErlRunConfiguration(IEolRunConfiguration other) {
		super(other);
	}

	@Override
	public IErlModule getModule() {
		return (IErlModule) super.getModule();
	}
	
	@Override
	protected void postExecute() throws Exception {
		super.postExecute();
		if (profileExecution) {
			writeOut(getModule().getContext().getExecutorFactory().getRuleProfiler(), printMarker);
		}
	}
	
}
