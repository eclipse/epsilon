package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class BreakStatement extends Statement {
	
	protected boolean all = false;
	
	public BreakStatement(boolean all) {
		this.all = all;
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		throw new EolBreakException(this,all);
	};
	
	@Override
	public void compile(EolCompilationContext context) {}
	
}
