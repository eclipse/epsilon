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
import org.eclipse.epsilon.erl.execute.RuleExecutorFactory;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ErlContextParallel extends EolContextParallel implements IErlContextParallel {

	public ErlContextParallel() {
		this(0);
	}

	public ErlContextParallel(int parallelism) {
		super(parallelism);
		setExecutorFactory(null);
	}
	
	public ErlContextParallel(IEolContext other) {
		super(other);
	}

	@Override
	protected void initMainThreadStructures() {
		super.initMainThreadStructures();
		executorFactory = new RuleExecutorFactory(null, true);
	}
	
	@Override
	protected void initThreadLocals() {
		super.initThreadLocals();
		concurrentExecutorFactories = initDelegateThreadLocal(() -> new RuleExecutorFactory(executorFactory, false));
	}
	
	@Override
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		if (executorFactory instanceof RuleExecutorFactory) {
			super.setExecutorFactory(executorFactory);
		}
		else {
			super.setExecutorFactory(new RuleExecutorFactory(executorFactory));
		}
	}
	
	@Override
	public RuleExecutorFactory getExecutorFactory() {
		return (RuleExecutorFactory) super.getExecutorFactory();
	}
}
