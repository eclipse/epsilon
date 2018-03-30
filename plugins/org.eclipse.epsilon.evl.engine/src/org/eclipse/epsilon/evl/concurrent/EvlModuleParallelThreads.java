package org.eclipse.epsilon.evl.concurrent;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.execute.concurrent.ErlExecutorService;
import org.eclipse.epsilon.erl.execute.concurrent.ErlThreadPoolExecutor;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.concurrent.ConstraintContextAtom;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

@Deprecated
public class EvlModuleParallelThreads extends EvlModuleParallel {

	public EvlModuleParallelThreads() {
		super();
	}

	public EvlModuleParallelThreads(int parallelism) {
		super(parallelism);
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		
		ArrayList<ConstraintContextAtom> problems = new ArrayList<>();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			problems.ensureCapacity(allOfKind.size());
			for (Object element : allOfKind) {
				problems.add(new ConstraintContextAtom(constraintContext, element, context));
			}
		}
		
		int numThreads = context.getParallelism();
		int problemSize = problems.size();
		int problemBatches = numThreads*2*numThreads;
		int problemsPerThread = problemSize/(problemBatches-1);
		if (problemsPerThread < 2) {
			throw new EolRuntimeException("This module doesn't support trivially sized problems! Please try an alternative IEvlModule implementation.");
		}
		
		ErlExecutorService executor = ErlThreadPoolExecutor.fixedPoolExecutor(numThreads);
		
		for (int batch = 0, sublistStart = 0, sublistEnd = 0; batch < problemBatches; batch++) {
			if (batch == 0) {
				sublistStart = 0;
				sublistEnd = problemSize-(problemsPerThread*(problemBatches-1));
			}
			else {
				sublistStart = sublistEnd;
				sublistEnd = sublistStart+problemsPerThread;
			}
			
			final Collection<ConstraintContextAtom> splitProblems = Collections.unmodifiableCollection(
				problems.subList(sublistStart, sublistEnd)
			);

			executor.execute(() -> {
				for (ConstraintContextAtom contextAtom : splitProblems) {
					try {
						if (contextAtom.unit.shouldBeChecked(contextAtom.element, contextAtom.context)) {
							for (Constraint constraint : contextAtom.unit.getConstraints()) {
								constraint.execute(contextAtom.element, contextAtom.context);
							}
						}
					}
					catch (EolRuntimeException ex) {
						context.handleException(ex, executor);
					}
				}
			});
		}
		
		executor.awaitCompletion();
	}
}
