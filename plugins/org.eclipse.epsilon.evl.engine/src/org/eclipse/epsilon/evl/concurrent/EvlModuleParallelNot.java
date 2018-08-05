package org.eclipse.epsilon.evl.concurrent;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

/**
 * A non-parallel implementation of {@link EvlModuleParallel}.
 * This is used to test the context and module under single-threaded execution.
 * 
 * @author Sina Madani
 * @deprecated Provided for testing purposes only.
 */
@Deprecated
public class EvlModuleParallelNot extends EvlModuleParallel {

	public EvlModuleParallelNot() {
		super();
	}

	public EvlModuleParallelNot(int parallelism) {
		super(parallelism);
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContext context = getContext();
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			constraintContext.execute(preProcessConstraintContext(constraintContext), context);
		}
	}

}
