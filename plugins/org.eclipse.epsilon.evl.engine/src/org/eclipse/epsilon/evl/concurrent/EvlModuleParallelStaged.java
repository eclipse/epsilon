/*******************************************************************************
 * Copyright (c) 2017 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Matthew Smith - initial investigation into parallelising EVL
 *     Sina Madani - Parallel EVL implementation, testing, refactoring
 ******************************************************************************/
package org.eclipse.epsilon.evl.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.execute.concurrent.ErlExecutorService;
import org.eclipse.epsilon.erl.execute.concurrent.ThreadLocalBatchData;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.concurrent.ConstraintAtom;
import org.eclipse.epsilon.evl.execute.concurrent.ConstraintContextAtom;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

public class EvlModuleParallelStaged extends EvlModuleParallel {

	public EvlModuleParallelStaged() {
		super();
	}
	
	public EvlModuleParallelStaged(int parallelism) {
		super(parallelism);
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		processConstraintCheck(processConstraintGuard(processContextGuard()));
	}
	
	/*
	 * Context applies to element?
	 */
	protected Collection<ConstraintContextAtom> processContextGuard() throws EolRuntimeException {
		final IEvlContextParallel context = getContext();
		final ThreadLocalBatchData<ConstraintContextAtom> contextBatch = new ThreadLocalBatchData<>(context.getParallelism());
		final ErlExecutorService contextJobExecutor = context.getExecutor();

		for (ConstraintContext constraintContext : getConstraintContexts()) {
			for (Object element : constraintContext.getAllOfSourceKind(context)) {
				contextJobExecutor.execute(() -> {
					try {
						if (constraintContext.shouldBeChecked(element, context)) {
							contextBatch.addElement(new ConstraintContextAtom(constraintContext, element));
						}
					}
					catch (EolRuntimeException ex) {
						context.handleException(ex, contextJobExecutor);
					}
				});
			}
		}

		contextJobExecutor.awaitCompletion();
		return contextBatch.getBatch();
	}

	/*
	 * Constraint applies to element?
	 * 
	 * @param prioritySplitter an optional function which splits batch jobs into
	 * a prioritised mapping of sub-batches.
	 */
	protected Collection<ConstraintAtom> processConstraintGuard(Collection<ConstraintContextAtom> contextJobs) throws EolRuntimeException {
		final IEvlContextParallel context = getContext();
		final ThreadLocalBatchData<ConstraintAtom> constraintBatchData = new ThreadLocalBatchData<>(context.getParallelism());
		final ErlExecutorService constraintJobExecutor = context.getExecutor();

		for (ConstraintContextAtom job : contextJobs) {
			for (Constraint constraint : preProcessConstraintContext(job.unit)) {
				constraintJobExecutor.execute(() -> {
					try {
						if (constraint.shouldBeChecked(job.element, context)) {
							constraintBatchData.addElement(new ConstraintAtom(constraint, job.element));
						}
					}
					catch (EolRuntimeException ex) {
						context.handleException(ex, constraintJobExecutor);
					}
				});
			}
		}
		
		constraintJobExecutor.awaitCompletion();
		return constraintBatchData.getBatch();
	}

	/*
	 * Constraint is satisfied?
	 * 
	 * @param prioritySplitter an optional function which splits batch jobs into
	 * a prioritised mapping of sub-batches.
	 */
	protected void processConstraintCheck(Collection<ConstraintAtom> constraintJobs) throws EolRuntimeException {
		final IEvlContextParallel context = getContext();
		final ErlExecutorService checkBlockExecutor = context.getExecutor();

		for (ConstraintAtom job : constraintJobs) {
			checkBlockExecutor.execute(() -> {
				try {
					job.unit.check(job.element, context);
				}
				catch (EolRuntimeException ex) {
					context.handleException(ex, checkBlockExecutor);
				}
			});
		}

		checkBlockExecutor.awaitCompletion();
	}
}
