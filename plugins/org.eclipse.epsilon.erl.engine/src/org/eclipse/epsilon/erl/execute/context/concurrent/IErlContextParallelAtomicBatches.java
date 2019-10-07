/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.*;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.execute.context.concurrent.IErlContextParallel;
import org.eclipse.epsilon.erl.execute.data.JobBatch;
import org.eclipse.epsilon.erl.execute.data.RuleAtom;

/**
 * Convenience trait for rule-based languages which have deterministically
 * ordered jobs that can be split into "Atoms" and divided up into batches
 * (i.e. Lists of "Atoms") for parallel execution.
 *
 * @author Sina Madani
 * @since 1.6
 */
public interface IErlModuleParallelAtomicBatches<D extends RuleAtom<?>> extends IErlModuleParallel {

	/**
	 * The atomic units of work.
	 * 
	 * @return A deterministically ordered List of executable rule-element pairs.
	 * @throws EolRuntimeException If any problems are encountered when retrieving the jobs.
	 */
	List<? extends D> getAllJobs() throws EolRuntimeException;
	
	default Collection<?> executeAllJobs() throws EolRuntimeException {
		return (Collection<?>) executeJob(getAllJobs());
	}
	
	/**
	 * Evaluates the job locally.
	 * 
	 * @param job The job (or jobs) to evaluate.
	 * @param isInLoop Whether this method is being called recursively from a loop.
	 * @throws EolRuntimeException If an exception is thrown whilst evaluating the job(s).
	 * @return The result of evaluating the job.
	 */
	@SuppressWarnings("unchecked")
	default Object executeJob(Object job) throws EolRuntimeException {
		if (job instanceof JobBatch) {
			return executeJob(((JobBatch) job).split(getAllJobs()));
		}
		else if (job instanceof RuleAtom) {
			return ((RuleAtom<?>) job).execute(getContext());
		}
		else if (job instanceof Runnable) {
			((Runnable) job).run();
			return null;
		}
		else if (job instanceof Iterable) {
			IErlContextParallel context = getContext();
			final int colSize = job instanceof Collection ? ((Collection<?>) job).size() : 256;
			
			if (context.isParallelisationLegal()) {
				Collection<Callable<Object>> jobs = new ArrayList<>(colSize);
				for (Object next : (Iterable<?>) job) {
					jobs.add(next instanceof Callable ?
						(Callable<Object>) next :
						() -> executeJob(next)
					);
				}
				return context.executeParallelTyped(jobs);
			}
			else {
				final Collection<Object> results = new ArrayList<>(colSize);
				for (Object next : (Iterable<?>) job) {
					results.add(executeJob(next));
				}
				return results;
			}
		}
		else if (job instanceof Stream) {
			Stream<?> stream = (Stream<?>) job;
			boolean finite = stream.spliterator().hasCharacteristics(Spliterator.SIZED);
			return executeJob(finite ? stream.collect(Collectors.toList()) : stream.iterator());
		}
		else if (job instanceof BaseStream) {
			return executeJob(((BaseStream<?,?>)job).iterator());
		}
		else if (job instanceof Iterator) {
			Iterable<?> iter = () -> (Iterator<Object>) job;
			return executeJob(iter);
		}
		else if (job instanceof Spliterator) {
			return executeJob(StreamSupport.stream((Spliterator<?>) job, getContext().isParallelisationLegal()));
		}
		else if (job instanceof Supplier) {
			return ((Supplier<?>) job).get();
		}
		else try {
			if (job instanceof Future) {
				return ((Future<?>) job).get();
			}
			else if (job instanceof Callable) {
				return ((Callable<?>) job).call();
			}
		}
		catch (Exception ex) {
			EolRuntimeException.propagateDetailed(ex);
		}
			
		throw new IllegalArgumentException("Received unexpected object of type "+job.getClass().getName());
	}
	
	/**
	 * Splits the job list (as returned from {@link #getAllJobs()} into the specified number of batches.
	 * @param batchSize This is interpreted as the size of batches, i.e. the distance between start and end indices.
	 * @return The list of start and end indices in order.
	 * @see {@link JobBatch#getBatches(int, int)}.
	 * @throws EolRuntimeException
	 */
	default List<JobBatch> getBatchJobs(int batchSize) throws EolRuntimeException {
		return JobBatch.getBatches(getAllJobs().size(), batchSize);
	}
}
