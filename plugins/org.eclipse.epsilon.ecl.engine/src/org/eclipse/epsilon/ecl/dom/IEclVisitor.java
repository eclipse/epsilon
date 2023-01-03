package org.eclipse.epsilon.ecl.dom;

import org.eclipse.epsilon.erl.dom.IErlVisitor;

public interface IEclVisitor extends IErlVisitor {
	
	public void visit(MatchRule matcRule);

}
