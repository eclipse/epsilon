package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.EolUserException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ThrowStatement extends Statement implements IExecutableModuleElement {
	
	protected Expression thrown;
	
	@Override
	public void build() {
		super.build();
		thrown = (Expression) getFirstChild();
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		Object thrown = null;
		if (this.thrown != null){
			thrown = context.getExecutorFactory().executeAST(this.thrown, context);
		}
		throw new EolUserException(thrown, this);	
	}
	
}
