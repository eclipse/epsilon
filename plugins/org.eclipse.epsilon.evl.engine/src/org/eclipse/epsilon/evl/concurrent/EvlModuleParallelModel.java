package org.eclipse.epsilon.evl.concurrent;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.erl.execute.concurrent.executors.ErlExecutorService;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

@Deprecated
public class EvlModuleParallelModel extends EvlModuleParallel {

	public EvlModuleParallelModel() {
		this(0);
	}

	public EvlModuleParallelModel(int parallelism) {
		super(parallelism, true);
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		ErlExecutorService executor = context.newExecutor();
		
		for (Constraint constraint : getConstraints()) {
			executor.execute(() -> {
				try {
					ConstraintContext constraintContext = constraint.getConstraintContext();
					for (Object element : constraintContext.getAllOfSourceKind(context)) {
						if (constraintContext.shouldBeChecked(element, context)) {
							constraint.execute(element, context);
						}
					}
				}
				catch (EolRuntimeException ex) {
					context.handleException(ex, executor);
				}
			});
		}
		
		executor.awaitCompletion();
	}

}
