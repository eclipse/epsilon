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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.evl.execute.concurrent.*;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * Shuffles the constraint-element pairs prior to execution.
 * 
 * @author Sina Madani
 */
@Deprecated
public class EvlModuleParallelRandom extends EvlModuleParallel {

	public EvlModuleParallelRandom() {
		super();
	}

	public EvlModuleParallelRandom(int parallelism) {
		super(parallelism);
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		
		List<ConstraintAtom> originalJobs = ConstraintAtom.getConstraintJobs(context);
		Collections.shuffle(originalJobs);
		List<Runnable> executorJobs = new ArrayList<>(originalJobs.size());
		
		for (ConstraintAtom job : originalJobs) {
			executorJobs.add(() -> {
				try {
					job.execute(context);
				}
				catch (EolRuntimeException exception) {
					context.handleException(exception);
				}
			});
		}
		
		context.executeParallel(this, executorJobs);
	}
	
}
