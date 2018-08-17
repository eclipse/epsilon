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

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.erl.execute.RuleExecutorFactory;

public class ErlContextParallel extends EolContextParallel implements IErlContextParallel {

	public ErlContextParallel() {
		super();
	}

	public ErlContextParallel(IEolContext other, boolean persistThreadLocals) {
		super(other, persistThreadLocals);
	}

	public ErlContextParallel(IEolContext other) {
		super(other);
	}

	public ErlContextParallel(int parallelism, boolean persistThreadLocals) {
		super(parallelism, persistThreadLocals);
	}

	public ErlContextParallel(int parallelism) {
		super(parallelism);
	}

	@Override
	public IErlModule getModule() {
		return (IErlModule) super.getModule();
	}
	
	@Override
	protected void initMainThreadStructures() {
		super.initMainThreadStructures();
		executorFactory = new RuleExecutorFactory(null, true);
	}
	
	@Override
	protected void initThreadLocals() {
		super.initThreadLocals();
		concurrentExecutors = initThreadLocal(() -> new RuleExecutorFactory(executorFactory, false));
	}
	
	@Override
	public RuleExecutorFactory getExecutorFactory() {
		return (RuleExecutorFactory) super.getExecutorFactory();
	}
}
