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

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.IErlModuleParallelAnnotation;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlModuleParallelAnnotation extends EvlModuleParallel implements IErlModuleParallelAnnotation {

	public EvlModuleParallelAnnotation() {
		super();
	}

	public EvlModuleParallelAnnotation(IEvlContextParallel context) {
		super(context);
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			final Collection<Constraint> constraintsToCheck = preProcessConstraintContext(constraintContext);
			final Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			
			final Collection<Callable<Object>> jobs = new LinkedList<>();
			
			if (constraintContext.hasAnnotation("parallel")) {
				for (Object object : allOfKind) {
					if (shouldBeParallel(constraintContext, object)) {
						jobs.add(() -> constraintContext.execute(constraintsToCheck, object, context));
					}
					else {
						constraintContext.execute(constraintsToCheck, object, context);
					}
				}
				
				context.executeAll(constraintContext, jobs);
			}	
			else {
				for (Constraint constraint : constraintsToCheck) {
					for (Object object : allOfKind) {
						if (constraintContext.shouldBeChecked(object, context)) {
							if (shouldBeParallel(constraint, object)) {
								jobs.add(() -> context.getExecutorFactory().execute(constraint, context, object));
							}
							else {
								context.getExecutorFactory().execute(constraint, context, object);
							}
						}
					}
					
					context.executeAll(constraint, jobs);
				}
			}
		}
	}
}
