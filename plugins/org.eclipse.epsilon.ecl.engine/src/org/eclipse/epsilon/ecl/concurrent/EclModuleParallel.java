/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.ecl.concurrent;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.execute.context.concurrent.*;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;

/**
 * A no-op parallel module, useful only for extending and setting
 * threads in parallelMatches.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EclModuleParallel extends EclModule {

	protected static final Set<String> CONFIG_PROPERTIES = new HashSet<>(2);
	static {
		CONFIG_PROPERTIES.add(IEolContextParallel.NUM_THREADS_CONFIG);
	}
	
	public EclModuleParallel() {
		this(0);
	}
	
	public EclModuleParallel(int parallelism) {
		this.context = new EclContextParallel(parallelism);
	}
	
	@Override
	protected void prepareExecution() throws EolRuntimeException {
		super.prepareExecution();
		getContext().goParallel();
	}
	
	@Override
	protected void postExecution() throws EolRuntimeException {
		getContext().endParallel();
		super.postExecution();
	}
	
	@Override
	public IEclContextParallel getContext() {
		return (IEclContextParallel) context;
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEclContextParallel) {
			super.setContext(context);
		}
	}
	
	@Override
	public Set<String> getConfigurationProperties() {
		return CONFIG_PROPERTIES;
	}
	
	/**
	 * WARNING: This method should only be called by the DT plugin for initialization purposes,
	 * as the context will be reset!
	 */
	@Override
	public void configure(Map<String, ?> properties) throws IllegalArgumentException {
		super.configure(properties);
		context = IEolContextParallel.configureContext(properties, EclContextParallel::new, getContext());
	}
}
