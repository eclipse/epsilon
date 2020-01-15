/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.etl.launch;

import org.eclipse.epsilon.erl.launch.IErlRunConfiguration;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.IEtlModule;
import org.eclipse.epsilon.etl.concurrent.EtlModuleParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EtlRunConfiguration extends IErlRunConfiguration {

	public static class Builder<R extends EtlRunConfiguration, B extends Builder<R, B>> extends IErlRunConfiguration.Builder<R, B> {

		protected Builder() {
			super();
		}
		protected Builder(Class<R> runConfigClass) {
			super(runConfigClass);
		}
		
		@Override
		protected IEtlModule createModule() {
			return isParallel() ?  new EtlModuleParallel() : new EtlModule();
		}
	}
	
	public static Builder<? extends EtlRunConfiguration, ?> Builder() {
		return new Builder<>(EtlRunConfiguration.class);
	}
	
	public EtlRunConfiguration(Builder<? extends IErlRunConfiguration, ?> builder) {
		super(builder);
	}
	
	public EtlRunConfiguration(EtlRunConfiguration other) {
		super(other);
	}

	@Override
	public IEtlModule getModule() {
		return (IEtlModule) super.getModule();
	}
}
