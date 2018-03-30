package org.eclipse.epsilon.evl.execute.concurrent;

import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class ConstraintContextAtom extends EvlAtom<ConstraintContext> {
	
	public ConstraintContextAtom(ConstraintContext constraintContext, Object modelElement, IEvlContext evlContext) {
		super(constraintContext, modelElement, evlContext);
	}
	
	public ConstraintContextAtom(ConstraintContext constraintContext, Object modelElement) {
		super(constraintContext, modelElement);
	}
}
