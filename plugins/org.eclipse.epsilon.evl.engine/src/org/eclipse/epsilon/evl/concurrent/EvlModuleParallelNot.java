package org.eclipse.epsilon.evl.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.dom.Constraint;
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
		// TODO Auto-generated constructor stub
	}

	public EvlModuleParallelNot(int parallelism) {
		super(parallelism);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContext context = getContext();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			Collection<Constraint> constraintsToCheck = preProcessConstraintContext(constraintContext);
			for (Object object : constraintContext.getAllOfSourceKind(context)) {
				if (constraintContext.appliesTo(object, context, false)) {
					for (Constraint constraint : constraintsToCheck) {
						constraint.execute(object, context);
					}
				}
			}
		}
	}

}
