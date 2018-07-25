package org.eclipse.epsilon.evl.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.common.concurrent.ConcurrentExecutionStatus;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * @deprecated Performance of the similar {@link EvlModuleParallelElements} is
 * at least as good, so there is no perceivable benefit of using this!
 */
@Deprecated
public class EvlModuleParallelConstraints extends EvlModuleParallel {

	public EvlModuleParallelConstraints() {
		super();
	}
	
	public EvlModuleParallelConstraints(int parallelism) {
		super(parallelism);
	}
	
	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		EolExecutorService executor = context.getExecutorService();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			Collection<Constraint> constraintsToCheck = preProcessConstraintContext(constraintContext);
			
			for (Object object : constraintContext.getAllOfSourceKind(context)) {
				if (constraintContext.shouldBeChecked(object, context)) {
					for (Constraint constraint : constraintsToCheck) {
						executor.execute(() -> {
							try {
								constraint.execute(object, context);
							}
							catch (EolRuntimeException ex) {
								context.handleException(ex, executor);
							}
						});
					}
				}
			}
		}
		
		executor.awaitCompletion();
	}

}
