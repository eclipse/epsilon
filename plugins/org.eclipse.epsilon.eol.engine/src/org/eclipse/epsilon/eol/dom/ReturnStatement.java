package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ReturnStatement extends Statement implements IExecutableModuleElement {
	
	protected Expression returned;
	
	@Override
	public void build() {
		super.build();
		returned = (Expression) getFirstChild();
	}
	
	public Expression getReturned() {
		return returned;
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
	
		Object result = null;
		if (getReturned() != null){
			result = context.getExecutorFactory().executeAST(getReturned(), context);
		}
		
		return new Return(result);
	}
	
}
