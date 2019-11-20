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

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.erl.IErlModuleAtomicBatches;
import org.eclipse.epsilon.erl.execute.RuleExecutorFactory;
import org.eclipse.epsilon.erl.execute.data.JobBatch;
import org.eclipse.epsilon.erl.execute.data.RuleAtom;

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
		setExecutorFactory(new RuleExecutorFactory());
	}
	
	protected ErlContextParallel(IEolContext other) {
		super(other);
		setExecutorFactory(executorFactory);
	}
	
	@Override
	protected void initThreadLocals() {
		super.initThreadLocals();
		concurrentExecutorFactories = initDelegateThreadLocal(() -> new RuleExecutorFactory(executorFactory));
	}
	
	@Override
	public void setProfilingEnabled(boolean profilingEnabled) {
		super.setProfilingEnabled(profilingEnabled);
		getExecutorFactory().setProfilingEnabled(profilingEnabled);
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
	
	@Override
	protected Object executeJob(Object job) throws EolRuntimeException {
		if (job instanceof RuleAtom) {
			return ((RuleAtom<?>) job).execute(this);
		}
		Object module;
		if (job instanceof JobBatch && (module = getModule()) instanceof IErlModuleAtomicBatches) {
			 return executeJob(((JobBatch) job).split(((IErlModuleAtomicBatches<?>) module).getAllJobs()));
		}
		return super.executeJob(job);
	}
}
