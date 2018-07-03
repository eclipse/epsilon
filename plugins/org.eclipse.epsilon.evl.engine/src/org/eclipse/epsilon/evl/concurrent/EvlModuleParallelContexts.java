package org.eclipse.epsilon.evl.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

@Deprecated
public class EvlModuleParallelContexts extends EvlModuleParallel {

	public EvlModuleParallelContexts() {
		super();
	}

	public EvlModuleParallelContexts(int parallelism) {
		super(parallelism);
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		EolExecutorService executor = context.newExecutor();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			Collection<Constraint> constraintsToCheck = preProcessConstraintContext(constraintContext);
			
			executor.execute(() -> {
				try {
					for (Object object : constraintContext.getAllOfSourceKind(context)) {
						if (constraintContext.shouldBeChecked(object, context)) {
							for (Constraint constraint : constraintsToCheck) {
								constraint.execute(object, context);
							}
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