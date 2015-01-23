package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;

public class WhileStatement extends Statement {
	
	protected Expression conditionExpression;
	protected StatementBlock bodyStatementBlock;
	
	public WhileStatement() {}
	
	
	public WhileStatement(Expression conditionExpression, StatementBlock bodyStatementBlock) {
		this.conditionExpression = conditionExpression;
		this.bodyStatementBlock = bodyStatementBlock;
	}

	@Override
	public void build() {
		super.build();
		conditionExpression = (Expression) getFirstChild();
		bodyStatementBlock = toStatementBlock(getSecondChild());
	} 

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		//how many times the loop has been executed
		int loop = 0;
		
		while (true){
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
			
			loop ++;
			Object condition = context.getExecutorFactory().executeAST(conditionExpression, context);		
			
			if (!(condition instanceof Boolean)) {
				context.getFrameStack().leaveLocal(this);
				throw new EolIllegalReturnException("Boolean", condition, conditionExpression, context);
			}
			
			Object result = null;
			
			if (((Boolean) condition).booleanValue()){
				context.getFrameStack().put(Variable.createReadOnlyVariable("loopCount", loop));
				
				try {
					result = context.getExecutorFactory().executeAST(bodyStatementBlock, context);
				}
				catch (EolBreakException bex){
					if (bex.isBreaksAll() && context.getFrameStack().isInLoop()){
						throw bex;
					}
					context.getFrameStack().leaveLocal(this);
					break;
				}
				catch (EolContinueException cex){
					context.getFrameStack().leaveLocal(this);
					continue;
				}

			}
			else {
				context.getFrameStack().leaveLocal(this);
				break;
			}
			
			context.getFrameStack().leaveLocal(this);
		
			if (result instanceof Return) {
				return result;
			}
		}
		
		return null;
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		// TODO Auto-generated method stub
		conditionExpression.compile(context);
		Object conditionExpressionResolvedType = conditionExpression.getResolvedType();
		if (conditionExpressionResolvedType != EolPrimitiveType.Boolean) {
			context.getMarkers().add(new ModuleMarker(conditionExpression, "Condition must be a boolean", Severity.Error));
		}
	}

	public Expression getConditionExpression() {
		return conditionExpression;
	}
	
	public void setConditionExpression(Expression conditionExpression) {
		this.conditionExpression = conditionExpression;
	}
	
	public StatementBlock getBodyStatementBlock() {
		return bodyStatementBlock;
	}
	
	public void setBodyStatementBlock(StatementBlock bodyStatementBlock) {
		this.bodyStatementBlock = bodyStatementBlock;
	}
	
}
