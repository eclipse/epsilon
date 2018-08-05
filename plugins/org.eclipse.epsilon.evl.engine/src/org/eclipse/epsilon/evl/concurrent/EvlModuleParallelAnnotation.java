package org.eclipse.epsilon.evl.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.eol.dom.AnnotatableModuleElement;
import org.eclipse.epsilon.eol.dom.Annotation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.GlobalConstraintContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * Allows the user to mix and match sequential and parallel execution for
 * {@linkplain Constraint}s and {@linkplain ConstraintContext}s using the
 * <code>@parallel</code> annotation where desired.
 * 
 * @author Sina Madani
 */
public class EvlModuleParallelAnnotation extends EvlModuleParallel {

	public EvlModuleParallelAnnotation() {
		super();
	}

	public EvlModuleParallelAnnotation(int parallelism) {
		super(parallelism);
	}

	@Override
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContextParallel context = getContext();
		EolExecutorService executor = context.newExecutorService();
		
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			Collection<Constraint> constraintsToCheck = preProcessConstraintContext(constraintContext);
			Collection<?> allOfKind = constraintContext.getAllOfSourceKind(context);
			IModel model = constraintContext instanceof GlobalConstraintContext ?
				null : constraintContext.getType(context).getModel();
			
			if (constraintContext.hasAnnotation("parallel")) {
				context.enterParallelNest(constraintContext);
				
				for (Object object : allOfKind) {
					if (shouldBeParallel(constraintContext, object, model)) {
						executor.execute(() -> {
							try {
								constraintContext.execute(constraintsToCheck, object, context);
							}
							catch (EolRuntimeException exception) {
								context.handleException(exception, executor);
							}
						});
					}
					else {
						constraintContext.execute(constraintsToCheck, object, context);
					}
				}
				context.exitParallelNest();
			}
			else {
				for (Object object : allOfKind) {
					if (constraintContext.appliesTo(object, context, false)) {
						for (Constraint constraint : constraintsToCheck) {
							if (shouldBeParallel(constraint, object, model)) {
								context.enterParallelNest(constraint);
								
								executor.execute(() -> {
									try {
										constraint.execute(object, context);
									}
									catch (EolRuntimeException exception) {
										context.handleException(exception, executor);
									}
								});
								
								context.exitParallelNest();
							}
							else {
								constraint.execute(object, context);
							}
						}
					}
				}
			}
		}
		
		executor.awaitCompletion();
	}

	protected boolean shouldBeParallel(AnnotatableModuleElement ast, Object self, IModel model) throws EolRuntimeException {
		Annotation parallelAnnotation = ast.getAnnotation("parallel");
		
		if (parallelAnnotation != null) {
			if (parallelAnnotation.hasValue()) {
				context.getFrameStack().enterLocal(FrameType.UNPROTECTED, ast,
					Variable.createReadOnlyVariable("self", self),
					Variable.createReadOnlyVariable("MODEL", model),
					Variable.createReadOnlyVariable("THREADS", getContext().getParallelism())
				);
				
				Object result = parallelAnnotation.getValue(context);
				
				context.getFrameStack().leaveLocal(ast);
				
				if (result instanceof Boolean) {
					return (boolean) result;
				}
			}
			else return true;
		}
		
		return false;
	}
	
}
