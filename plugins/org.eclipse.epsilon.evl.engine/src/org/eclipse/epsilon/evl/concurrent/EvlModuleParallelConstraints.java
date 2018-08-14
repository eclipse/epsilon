package org.eclipse.epsilon.evl.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * Provides data and rule parallelism, executing all constraint-element pairs in
 * a separate job.
 * 
 * @deprecated Performance of the data-parallel {@link EvlModuleParallelElements} is
 * at least as good, so there is no perceivable benefit of using this!
 * 
 * @author Sina Madani
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
		EolExecutorService executor = context.beginParallelJob(this);
		
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
		context.exitParallelNest();
	}

}
