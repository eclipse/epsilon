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

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

public abstract class EvlModuleParallel extends EvlModule {
	
	@Override
	protected abstract void checkConstraints() throws EolRuntimeException;
	
	public EvlModuleParallel() {
		context = new EvlContextParallel();
	}
	
	public EvlModuleParallel(int parallelism) {
		this(parallelism, true);
	}
	
	protected EvlModuleParallel(int parallelism, boolean threadSafeBaseFrames) {
		context = new EvlContextParallel(parallelism, threadSafeBaseFrames);
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
		return (IEvlContextParallel) context;
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEvlContextParallel) {
			super.setContext(context);
		}
	}
}
