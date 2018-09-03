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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.epsilon.common.util.profiling.ProfileDiagnostic;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.launch.ProfilableIEolModule;
import org.eclipse.epsilon.evl.execute.concurrent.*;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * Shuffles the constraint-element pairs prior to execution.
 * Also performs profiling.
 * 
 * @author Sina Madani
 */
public final class EvlModuleParallelRandom extends EvlModuleParallel implements ProfilableIEolModule {

	private final Collection<ProfileDiagnostic> profiledStages = new ArrayList<>(8);
	
	public EvlModuleParallelRandom() {
		super();
	}

	public EvlModuleParallelRandom(int parallelism) {
		super(parallelism);
	}

	@Override
	public Collection<ProfileDiagnostic> getProfiledStages() {
		return profiledStages;
	}
	
	@Override
	protected void prepareExecution() throws EolRuntimeException {
		profileExecutionStage("prepareExecution()", super::prepareExecution);
	}
	
	@Override
	protected void postExecution() throws EolRuntimeException {
		profileExecutionStage("postExecution()", super::postExecution);
	}
	
	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		
		List<ConstraintAtom> originalJobs = profileExecutionStage("create jobs", () -> ConstraintAtom.getConstraintJobs(context));

		profileExecutionStage("shuffle jobs", () -> Collections.shuffle(originalJobs));
		
		Collection<Runnable> executorJobs = new ArrayList<>(originalJobs.size());
		
		profileExecutionStage("submit jobs", () -> {
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
		});
		
		profileExecutionStage("execute jobs", () -> context.executeParallel(this, executorJobs));
	}
	
}
