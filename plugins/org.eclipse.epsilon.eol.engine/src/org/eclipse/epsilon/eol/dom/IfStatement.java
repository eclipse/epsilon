package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class IfStatement extends Statement {
	
	protected Expression conditionExpression;
	protected StatementBlock thenStatementBlock;
	protected StatementBlock elseStatementBlock;
	
	@Override
	public void build() {
		super.build();
		conditionExpression = (Expression) getFirstChild();
		if (getSecondChild() instanceof StatementBlock) {
			thenStatementBlock = (StatementBlock) getSecondChild();
		}
		else {
			thenStatementBlock = new StatementBlock();
			thenStatementBlock.getStatements().add((Statement) getSecondChild());
		}
		if (getChildCount() == 3) {
			if (getThirdChild() instanceof StatementBlock) {
				elseStatementBlock = (StatementBlock) getThirdChild();
			}
			else {
				elseStatementBlock = new StatementBlock();
				elseStatementBlock.getStatements().add((Statement) getThirdChild());
			}
		}
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
		Object condition = context.getExecutorFactory().executeAST(conditionExpression, context);
		
		if (!(condition instanceof Boolean)) throw new EolIllegalReturnException("Boolean", condition, conditionExpression, context);
		
		Object result = null;
		
		if (((Boolean) condition).booleanValue()){
			result = context.getExecutorFactory().executeAST(thenStatementBlock, context);
		}
		else if (elseStatementBlock != null){
			result = context.getExecutorFactory().executeAST(elseStatementBlock, context);
		}
		
		context.getFrameStack().leaveLocal(this);
		return result;
	}
	
	public Expression getConditionExpression() {
		return conditionExpression;
	}
	
	public void setConditionExpression(Expression conditionExpression) {
		this.conditionExpression = conditionExpression;
	}
	
	public StatementBlock getThenStatementBlock() {
		return thenStatementBlock;
	}
	
	public void setThenStatementBlock(StatementBlock thenStatementBlock) {
		this.thenStatementBlock = thenStatementBlock;
	}
	
	public StatementBlock getElseStatementBlock() {
		return elseStatementBlock;
	}
	
	public void setElseStatementBlock(StatementBlock elseStatementBlock) {
		this.elseStatementBlock = elseStatementBlock;
	}
}
