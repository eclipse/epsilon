/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.launch;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.concurrent.EolModuleParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EolRunConfiguration extends IEolRunConfiguration {
	
	public static class Builder<R extends EolRunConfiguration, B extends Builder<R, B>> extends IEolRunConfiguration.Builder<R, B> {
		protected Builder() {
			super();
		}
		protected Builder(Class<R> runConfigClass) {
			super(runConfigClass);
		}
		
		@Override
		protected EolModule createModule() {
			return isParallel() ? new EolModuleParallel(new EolContextParallel(parallelism)) : new EolModule();
		}
	}
	
	public static Builder<? extends EolRunConfiguration, ?> Builder() {
		return new Builder<>(EolRunConfiguration.class);
	}
	
	public EolRunConfiguration(Builder<? extends EolRunConfiguration, ?> builder) {
		super(builder);
	}
	
	public EolRunConfiguration(EolRunConfiguration other) {
		super(other);
	}
	
	@Override
	public EolModule getModule() {
		return (EolModule) super.getModule();
	}
}
