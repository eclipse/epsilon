package org.eclipse.epsilon.evl.dom;

import org.eclipse.epsilon.eol.dom.IEolVisitor;

public interface IEvlVisitor extends IEolVisitor {

	public void visit(ConstraintContext constraintContext);

	public void visit(Constraint constraint);

	public void visit(Fix fix);
	
}
