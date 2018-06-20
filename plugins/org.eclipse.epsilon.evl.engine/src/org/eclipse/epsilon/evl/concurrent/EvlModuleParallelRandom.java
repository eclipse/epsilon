package org.eclipse.epsilon.evl.concurrent;

import java.util.Collections;
import java.util.List;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.execute.concurrent.executors.ErlExecutorService;
import org.eclipse.epsilon.evl.execute.concurrent.*;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * Shuffles the constraint-element pairs prior to execution.
 */
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
		ErlExecutorService executor = context.newExecutor();
		
		List<ConstraintAtom> jobs = ConstraintAtom.getConstraintJobs(context);
		Collections.shuffle(jobs);
		
		for (ConstraintAtom job : jobs) {
			executor.execute(() -> {
				try {
					job.execute(context);
				}
				catch (EolRuntimeException exception) {
					context.handleException(exception, executor);
				}
			});
		}
		
		executor.awaitCompletion();
	}
	
}
