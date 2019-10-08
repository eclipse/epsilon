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

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class IErlRunConfiguration extends IEolRunConfiguration {
	
	public static abstract class Builder<R extends IErlRunConfiguration, B extends Builder<R, B>> extends IEolRunConfiguration.Builder<R, B> {
		
		protected Builder() {
			super();
		}
		protected Builder(Class<R> runConfigClass) {
			super(runConfigClass);
		}
		
		@Override
		protected abstract IErlModule createModule();
		
	}
	
	public IErlRunConfiguration(Builder<? extends IErlRunConfiguration, ?> builder) {
		super(builder);
		getModule().getContext().getExecutorFactory().setProfilingEnabled(profileExecution);
	}
	
	public IErlRunConfiguration(IEolRunConfiguration other) {
		super(other);
	}

	@Override
	protected void postExecute() throws Exception {
		super.postExecute();
		if (profileExecution) {
			writeOut(getModule().getContext().getExecutorFactory().getExecutionController(), "");
		}
	}
	
	@Override
	public IErlModule getModule() {
		return (IErlModule) super.getModule();
	}
}
