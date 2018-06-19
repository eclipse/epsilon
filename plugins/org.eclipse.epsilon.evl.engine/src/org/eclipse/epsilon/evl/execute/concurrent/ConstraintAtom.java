package org.eclipse.epsilon.evl.execute.concurrent;

import java.util.Optional;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class ConstraintAtom extends EvlAtom<Constraint> {
	
	public ConstraintAtom(Constraint constraint, Object modelElement, IEvlContext evlContext) {
		super(constraint, modelElement, evlContext);
	}
	
	public ConstraintAtom(Constraint constraint, Object modelElement) {
		super(constraint, modelElement);
	}
	
	public Optional<UnsatisfiedConstraint> execute(IEvlContext context) throws EolRuntimeException {
		return unit.execute(element, context);
	}
}
