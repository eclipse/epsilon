package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class IfStatement extends Statement {
	
	protected Expression condition;
	protected AbstractModuleElement then;
	protected AbstractModuleElement _else;
	
	@Override
	public void build() {
		super.build();
		condition = (Expression) getFirstChild();
		then = (AbstractModuleElement) getSecondChild();
		if (getChildCount() == 3) {
			_else = (AbstractModuleElement) getThirdChild();
		}
	}
	
	public Expression getCondition() {
		return condition;
	}
	
	public AbstractModuleElement getThen() {
		return then;
	}
	
	public AbstractModuleElement getElse() {
		return _else;
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
		Object condition = context.getExecutorFactory().executeAST(getCondition(), context);
		
		if (!(condition instanceof Boolean)) throw new EolIllegalReturnException("Boolean", condition, getCondition(), context);
		
		Object result = null;
		
		if (((Boolean) condition).booleanValue()){
			result = context.getExecutorFactory().executeAST(getThen(), context);
		}
		else if (getElse() != null){
			result = context.getExecutorFactory().executeAST(getElse(), context);
		}
		
		context.getFrameStack().leaveLocal(this);
		return result;
	}
	
	
	
}
