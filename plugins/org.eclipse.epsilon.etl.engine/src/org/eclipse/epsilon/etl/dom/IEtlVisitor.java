package org.eclipse.epsilon.etl.dom;

import org.eclipse.epsilon.erl.dom.IErlVisitor;

public interface IEtlVisitor extends IErlVisitor{
	
	public void visit(TransformationRule transformationRule);

}