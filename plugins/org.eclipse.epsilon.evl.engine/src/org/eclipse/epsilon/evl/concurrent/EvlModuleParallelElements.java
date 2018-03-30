package org.eclipse.epsilon.evl.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.erl.execute.concurrent.ErlExecutorService;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.*;

public class EvlModuleParallelElements extends EvlModuleParallel {

	public EvlModuleParallelElements() {
		this(0);
	}
	
	public EvlModuleParallelElements(int parallelism) {
		super(parallelism);

		this.context = new EvlContextParallel(parallelism) {
			{
				// No need for the base to be thread-safe in this implementation!
				frameStack = new FrameStack(null, false);
			}
		};
	}
	
	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		ErlExecutorService executor = context.getExecutor();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			Collection<Constraint> constraintsToCheck = preProcessConstraintContext(constraintContext);
			
			for (Object object : constraintContext.getAllOfSourceKind(context)) {
				executor.execute(() -> {
					try {
						if (constraintContext.shouldBeChecked(object, context)) {
							for (Constraint constraint : constraintsToCheck) {
								constraint.execute(object, context);
							}
						}
					}
					catch (EolRuntimeException ex) {
						context.handleException(ex, executor);
					}
				});
			}
		}
		
		executor.awaitCompletion();
	}

}
