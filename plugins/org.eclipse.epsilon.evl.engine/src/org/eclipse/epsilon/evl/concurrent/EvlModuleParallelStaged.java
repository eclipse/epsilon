/*******************************************************************************
 * Copyright (c) 2017 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Matthew Smith - initial investigation into parallelising EVL
 *     Sina Madani - Parallel EVL implementation, testing, refactoring
 ******************************************************************************/
package org.eclipse.epsilon.evl.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.concurrent.ThreadLocalBatchData;
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
	
	/**
	 * Context applies to element?
	 * 
	 * @return ConstraintContext-element pairs for which the guard was satisfied.
	 * @throws EolRuntimeException
	 */
	protected Collection<ConstraintContextAtom> processContextGuard() throws EolRuntimeException {
		final IEvlContextParallel context = getContext();
		final ThreadLocalBatchData<ConstraintContextAtom> contextBatch = new ThreadLocalBatchData<>(context.getParallelism());
		final EolExecutorService contextJobExecutor = context.beginParallelJob(this);

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
		context.exitParallelNest(this);
		return contextBatch.getBatch();
	}

	/**
	 * Constraint applies to element?
	 * 
	 * @param contextJobs output from {@link #processContextGuard()}
	 * @return Constraint-element pairs for which the guard was satisfied.
	 * @throws EolRuntimeException
	 */
	protected Collection<ConstraintAtom> processConstraintGuard(Collection<ConstraintContextAtom> contextJobs) throws EolRuntimeException {
		final IEvlContextParallel context = getContext();
		final ThreadLocalBatchData<ConstraintAtom> constraintBatchData = new ThreadLocalBatchData<>(context.getParallelism());
		final EolExecutorService constraintJobExecutor = context.beginParallelJob(this);

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
		context.exitParallelNest(this);
		return constraintBatchData.getBatch();
	}

	/**
	 * Constraint is satisfied?
	 * 
	 * @param constraintJobs output from {@link #processConstraintGuard(Collection)}
	 * @throws EolRuntimeException
	 */
	protected void processConstraintCheck(Collection<ConstraintAtom> constraintJobs) throws EolRuntimeException {
		final IEvlContextParallel context = getContext();
		final EolExecutorService checkBlockExecutor = context.beginParallelJob(this);

		for (ConstraintAtom job : constraintJobs) {
			checkBlockExecutor.execute(() -> {
				try {
					job.unit.execute(job.element, context);
				}
				catch (EolRuntimeException ex) {
					context.handleException(ex, checkBlockExecutor);
				}
			});
		}

		checkBlockExecutor.awaitCompletion();
		context.exitParallelNest(this);
	}
}
