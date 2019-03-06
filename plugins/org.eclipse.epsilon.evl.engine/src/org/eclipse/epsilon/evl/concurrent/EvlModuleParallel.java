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
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class EvlModuleParallel extends EvlModule {
	
	static {
		CONFIG_PROPERTIES.add(IEolContextParallel.NUM_THREADS_CONFIG);
	}
	
	@Override
	protected abstract void checkConstraints() throws EolRuntimeException;
	
	public EvlModuleParallel() {
		setContext(new EvlContextParallel());
	}
	
	public EvlModuleParallel(int parallelism) {
		setContext(new EvlContextParallel(parallelism, true));
	}
	
	protected EvlModuleParallel(int parallelism, boolean threadSafeBaseFrames) {
		setContext(new EvlContextParallel(parallelism, threadSafeBaseFrames));
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
	public IEvlContextParallel getContext() {
		return (IEvlContextParallel) super.getContext();
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEvlContextParallel) {
			super.setContext(context);
		}
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
			threads -> new EvlContextParallel(threads, context.getFrameStack().isThreadSafe()),
			context
		));
	}
}
