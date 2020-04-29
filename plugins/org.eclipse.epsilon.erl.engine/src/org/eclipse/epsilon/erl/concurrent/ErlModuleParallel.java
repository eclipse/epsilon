/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.concurrent;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.erl.ErlModule;
import org.eclipse.epsilon.erl.execute.context.concurrent.ErlContextParallel;
import org.eclipse.epsilon.erl.execute.context.concurrent.IErlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ErlModuleParallel extends ErlModule {

	protected static final Set<String> CONFIG_PROPERTIES = new HashSet<>(2);
	static {
		CONFIG_PROPERTIES.add(IEolContextParallel.NUM_THREADS_CONFIG);
	}
	
	public ErlModuleParallel() {
		this(null);
	}

	public ErlModuleParallel(IErlContextParallel context) {
		super(context != null ? context : new ErlContextParallel());
	}

	@Override
	public IErlContextParallel getContext() {
		return (IErlContextParallel) super.getContext();
	}
	
	/**
	 * WARNING: This method should only be called by the DT plugin for initialization purposes,
	 * as the context will be reset!
	 */
	@Override
	public void configure(Map<String, ?> properties) throws IllegalArgumentException {
		super.configure(properties);
		setContext(IEolContextParallel.configureContext(properties, ErlContextParallel::new, getContext()));
	}
	
	@Override
	public Set<String> getConfigurationProperties() {
		return CONFIG_PROPERTIES;
	}
}
