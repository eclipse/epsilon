/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.concurrent;

import java.util.Map;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.erl.concurrent.IErlModuleParallel;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * No-op EVL module, useful only for setting parallelisation properties for other operations.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlModuleParallel extends EvlModule implements IErlModuleParallel {
	
	static {
		CONFIG_PROPERTIES.add(IEolContextParallel.NUM_THREADS_CONFIG);
	}
	
	public EvlModuleParallel() {
		this(null);
	}
	
	public EvlModuleParallel(IEvlContextParallel context) {
		super(context != null ? context : new EvlContextParallel());
	}
	
	@Override
	public IEvlContextParallel getContext() {
		return (IEvlContextParallel) super.getContext();
	}
	
	/**
	 * WARNING: This method should only be called by the DT plugin for initialization purposes,
	 * as the context will be reset!
	 */
	@Override
	public void configure(Map<String, ?> properties) throws IllegalArgumentException {
		super.configure(properties);
		IEvlContextParallel context = getContext();
		setContext(IEolContextParallel.configureContext(
			properties,
			EvlContextParallel::new,
			context
		));
	}
}
