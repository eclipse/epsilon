package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class IfStatement extends Statement {
	
	protected Expression condition;
	protected StatementBlock then;
	protected StatementBlock _else;
	
	@Override
	public void build() {
		super.build();
		condition = (Expression) getFirstChild();
		if (getSecondChild() instanceof StatementBlock) {
			then = (StatementBlock) getSecondChild();
		}
		else {
			then = new StatementBlock();
			then.getStatements().add((Statement) getSecondChild());
		}
		if (getChildCount() == 3) {
			if (getThirdChild() instanceof StatementBlock) {
				_else = (StatementBlock) getThirdChild();
			}
			else {
				_else = new StatementBlock();
				_else.getStatements().add((Statement) getThirdChild());
			}
		}
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
	
	public Expression getCondition() {
		return condition;
	}
	
	public void setCondition(Expression condition) {
		this.condition = condition;
	}
	
	public StatementBlock getThen() {
		return then;
	}
	
	public void setThen(StatementBlock then) {
		this.then = then;
	}
	
	public StatementBlock getElse() {
		return _else;
	}
	
	public void setElse(StatementBlock _else) {
		this._else = _else;
	}
}
