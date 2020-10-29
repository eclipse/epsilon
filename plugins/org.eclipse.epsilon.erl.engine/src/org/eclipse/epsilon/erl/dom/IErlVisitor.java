package org.eclipse.epsilon.erl.dom;

import org.eclipse.epsilon.eol.dom.IEolVisitor;

public interface IErlVisitor extends IEolVisitor {

	public void visit(Post post);

	public void visit(Pre pre);
	
}
