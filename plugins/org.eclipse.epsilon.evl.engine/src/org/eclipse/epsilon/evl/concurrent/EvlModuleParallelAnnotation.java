/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.concurrent;

import java.util.LinkedList;
import java.util.Collection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.function.CheckedEolRunnable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.erl.concurrent.IErlModuleParallel;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.GlobalConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * Allows the user to mix and match sequential and parallel execution for
 * {@linkplain Constraint}s and {@linkplain ConstraintContext}s using the
 * <code>@parallel</code> annotation where desired.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlModuleParallelAnnotation extends EvlModuleParallel implements IErlModuleParallel {

	public EvlModuleParallelAnnotation() {
		super();
	}

	public EvlModuleParallelAnnotation(int parallelism) {
		super(parallelism);
	}
	
	@Override
	protected void checkConstraints() throws EolRuntimeException {
		final IEvlContextParallel context = getContext();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			final Collection<Constraint> constraintsToCheck = preProcessConstraintContext(constraintContext);
			final Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			final int numElements = allOfKind.size();
			final IModel model = constraintContext instanceof GlobalConstraintContext ?
				null : constraintContext.getType(context).getModel();
			
			final Collection<CheckedEolRunnable> jobs = new LinkedList<>();
			
			if (constraintContext.hasAnnotation(PARALLEL_ANNOTATION_NAME)) {
				for (Object object : allOfKind) {
					if (shouldBeParallel(constraintContext, object, model, numElements)) {
						jobs.add(() -> constraintContext.execute(constraintsToCheck, object, context));
					}
					else {
						constraintContext.execute(constraintsToCheck, object, context);
					}
				}
				
				context.executeParallel(constraintContext, jobs);
			}		
			else {
				for (Constraint constraint : constraintsToCheck) {
					for (Object object : allOfKind) {
						if (constraintContext.appliesTo(object, context, false)) {
							if (shouldBeParallel(constraint, object, model, numElements)) {
								jobs.add(() -> constraint.execute(object, context));
							}
							else {
								constraint.execute(object, context);
							}
						}
					}
					
					context.executeParallel(constraint, jobs);
				}
			}
		}
	}
	
}
