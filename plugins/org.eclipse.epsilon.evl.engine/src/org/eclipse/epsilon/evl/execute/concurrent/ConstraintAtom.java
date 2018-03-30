package org.eclipse.epsilon.evl.execute.concurrent;

import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class ConstraintAtom extends EvlAtom<Constraint> {
	
	public ConstraintAtom(Constraint constraint, Object modelElement, IEvlContext evlContext) {
		super(constraint, modelElement, evlContext);
	}
	
	public ConstraintAtom(Constraint constraint, Object modelElement) {
		super(constraint, modelElement);
	}
}
