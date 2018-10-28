/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.concurrent.profiling;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ProfilableEvlModuleParallelElements extends ProfilableEvlModuleParallel {

	public ProfilableEvlModuleParallelElements(int parallelism) {
		super(parallelism, false);
	}

	public ProfilableEvlModuleParallelElements() {
		this(0);
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		ArrayList<Runnable> jobs = new ArrayList<>();
		
		profileCreateJobs(() -> {
			for (ConstraintContext constraintContext : getConstraintContexts()) {
				Collection<Constraint> constraintsToCheck = preProcessConstraintContext(constraintContext);
				Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
				jobs.ensureCapacity(jobs.size() + allOfKind.size());
				
				for (Object object : allOfKind) {
					jobs.add(() -> {
						try {
							constraintContext.execute(constraintsToCheck, object, context);
						}
						catch (EolRuntimeException ex) {
							context.handleException(ex);
						}
					});
				}
			}
		});
		
		profileExecuteJobs(jobs);
	}

}
