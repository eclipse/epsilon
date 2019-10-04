/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.execute.context.concurrent;

import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.erl.execute.RuleProfilingExecutorFactory;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ErlContextParallel extends EolContextParallel implements IErlContextParallel {

	public ErlContextParallel() {
		super();
		setExecutorFactory(null);
	}

	public ErlContextParallel(IEolContext other) {
		super(other);
	}

	@Override
	protected void initMainThreadStructures() {
		super.initMainThreadStructures();
		executorFactory = new RuleProfilingExecutorFactory(null, true);
	}
	
	@Override
	protected void initThreadLocals() {
		super.initThreadLocals();
		concurrentExecutorFactories = initDelegateThreadLocal(() -> new RuleProfilingExecutorFactory(executorFactory, false));
	}
	
	@Override
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		if (executorFactory instanceof RuleProfilingExecutorFactory) {
			super.setExecutorFactory(executorFactory);
		}
		else {
			super.setExecutorFactory(new RuleProfilingExecutorFactory(executorFactory));
		}
	}
	
	@Override
	public RuleProfilingExecutorFactory getExecutorFactory() {
		return (RuleProfilingExecutorFactory) super.getExecutorFactory();
	}
	
	public ErlContextParallel(int parallelism) {
		super(parallelism);
	}
}
