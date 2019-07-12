/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.concurrent.atomic;

import java.util.List;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.concurrent.IErlModuleParallelAtomicBatches;
import org.eclipse.epsilon.erl.execute.data.RuleAtom;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallel;

/**
 * Parallelisation based on atomic job list.
 *
 * @author Sina Madani
 * @since 1.6
 */
public abstract class EvlModuleParallelAtomic<A extends RuleAtom<?>> extends EvlModuleParallel implements IErlModuleParallelAtomicBatches<A> {

	public EvlModuleParallelAtomic() {
		super();
	}
	
	public EvlModuleParallelAtomic(int parallelism) {
		super(parallelism);
	}

	protected List<A> jobsCache;

	@Override
	public final List<A> getAllJobs() throws EolRuntimeException {
		if (jobsCache == null) {
			jobsCache = getAllJobsImpl();
		}
		return jobsCache;
	}
	
	/**
	 * Non-cached implementation as called by {@link #getAllJobs()}.
	 * @return The deterministically ordered jobs.
	 */
	protected abstract List<A> getAllJobsImpl() throws EolRuntimeException;
	
	@Override
	protected void checkConstraints() throws EolRuntimeException {
		executeJobImpl(getAllJobs(), false);
	}
}
