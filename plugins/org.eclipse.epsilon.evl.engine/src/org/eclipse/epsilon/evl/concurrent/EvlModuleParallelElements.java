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
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.*;

/**
 * Provides data-parallelism, executing all applicable constraints for a given
 * model element in a separate job.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlModuleParallelElements extends EvlModuleParallel {

	public EvlModuleParallelElements() {
		this(0);
	}
	
	public EvlModuleParallelElements(int parallelism) {
		// No need for the base FrameStack to be thread-safe in this implementation!
		super(parallelism, false);
	}
	
	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		EolExecutorService executor = context.beginParallelTask(this);
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			Collection<Constraint> constraintsToCheck = preProcessConstraintContext(constraintContext);
			Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			
			for (Object object : allOfKind) {
				executor.submit(() -> {
					// Lambdas are faster for this kind of work
					// invokedynamic is more direct than creating an AIC and
					// dispatching virtual call.
					// @see http://www.oracle.com/technetwork/java/jvmls2013kuksen-2014088.pdf
					try {
						constraintContext.execute(constraintsToCheck, object, context);
					}
					catch (EolRuntimeException ex) {
						context.handleException(ex, executor);
					}
				});
			}
		}
		
		executor.awaitCompletion();		// WARNING: This will kill the executor!
		context.endParallelTask(this);
	}

}
