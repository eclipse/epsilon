/*******************************************************************************
 * Copyright (c) 2017-2018 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Sina Madani - Parallel EVL implementation, testing, refactoring
 ******************************************************************************/
package org.eclipse.epsilon.evl.concurrent.experimental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallel;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallelElements;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.atoms.ConstraintAtom;
import org.eclipse.epsilon.evl.execute.atoms.ConstraintContextAtom;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * 3-stage filtering process.
 * 
 * @author Sina Madani
 * @since 1.6
 * @deprecated Can be MUCH slower than {@linkplain EvlModuleParallelElements}, but very slightly
 * faster in some cases.
 */
@Deprecated
public class EvlModuleParallelStaged extends EvlModuleParallel {
	
	public EvlModuleParallelStaged() {
		super();
	}
	
	public EvlModuleParallelStaged(int parallelism) {
		super(parallelism);
	}

	@Override
	protected final void checkConstraints() throws EolRuntimeException {
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
		final ArrayList<ConstraintContextAtom> contextJobResults = new ArrayList<>();

		for (ConstraintContext constraintContext : getConstraintContexts()) {
			Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			Collection<Callable<ConstraintContextAtom>> contextJobs = new ArrayList<>(allOfKind.size());
			
			for (Object element : allOfKind) {
				contextJobs.add(() -> {
					if (constraintContext.shouldBeChecked(element, context)) {
						return new ConstraintContextAtom(constraintContext, element);
					}
					return null;
				});
			}
			
			contextJobResults.ensureCapacity(contextJobs.size());
			
			context.executeParallelTyped(constraintContext, contextJobs)
				.stream()
				.filter(cca -> cca != null)
				.forEach(contextJobResults::add);
		}

		return contextJobResults;
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
		final ArrayList<ConstraintAtom> constraintGuardResults = new ArrayList<>();

		for (ConstraintContextAtom job : contextJobs) {
			Collection<Constraint> constraints = preProcessConstraintContext(job.unit);
			Collection<Callable<ConstraintAtom>> constraintGuardJobs = new ArrayList<>(constraints.size());
			
			for (Constraint constraint : constraints) {
				constraintGuardJobs.add(() -> {
					if (constraint.shouldBeChecked(job.element, context)) {
						return new ConstraintAtom(constraint, job.element);
					}
					return null;
				});
			}
			
			constraintGuardResults.ensureCapacity(constraints.size());
			
			context.executeParallelTyped(job.unit, constraintGuardJobs)
				.stream()
				.filter(ca -> ca != null)
				.forEach(constraintGuardResults::add);
		}
		
		return constraintGuardResults;
	}

	/**
	 * Constraint is satisfied?
	 * 
	 * @param constraintJobs output from {@link #processConstraintGuard(Collection)}
	 * @throws EolRuntimeException
	 */
	protected void processConstraintCheck(Collection<ConstraintAtom> constraintJobs) throws EolRuntimeException {
		final IEvlContextParallel context = getContext();
		final Collection<Runnable> constraintCheckJobs = new ArrayList<>(constraintJobs.size());

		for (ConstraintAtom job : constraintJobs) {
			constraintCheckJobs.add(() -> {
				try {
					job.unit.execute(job.element, context);
				}
				catch (EolRuntimeException ex) {
					context.handleException(ex);
				}
			});
		}

		context.executeParallel(this, constraintCheckJobs);
	}
}
