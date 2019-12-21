/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.concurrent.atomic;

import java.nio.file.Path;
import java.util.List;
import org.eclipse.epsilon.egl.concurrent.EgxModuleParallel;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.concurrent.IEgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.IErlModuleAtomicBatches;
import org.eclipse.epsilon.erl.execute.context.concurrent.ErlContextParallel;
import org.eclipse.epsilon.erl.execute.data.ExecutableRuleAtom;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 * @param <A>
 */
public abstract class EgxModuleParallelAtomic<A extends ExecutableRuleAtom<?>> extends EgxModuleParallel implements IErlModuleAtomicBatches<A> {

	public EgxModuleParallelAtomic() {
		super();
	}

	public EgxModuleParallelAtomic(Path outputRoot) throws EglRuntimeException {
		super(outputRoot);
	}

	public EgxModuleParallelAtomic(IEgxContextParallel context) {
		super(context);
	}

	protected List<A> jobsCache;

	@Override
	public final List<? extends A> getAllJobs() throws EolRuntimeException {
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
	protected Object processRules() throws EolRuntimeException {
		if (context instanceof ErlContextParallel) {
			return ((ErlContextParallel) context).executeJob(getAllJobs());
		}
		else return getContext().executeAll(this, getAllJobs());
	}
}
