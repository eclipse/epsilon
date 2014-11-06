package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class WhileStatement extends Statement implements IExecutableModuleElement {
	
	protected Expression condition;
	protected AbstractModuleElement body;
	
	@Override
	public void build() {
		super.build();
		condition = (Expression) getFirstChild();
		body = (AbstractModuleElement) getSecondChild();
	} 
	
	public Expression getCondition() {
		return condition;
	}
	
	public AbstractModuleElement getBody() {
		return body;
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		//how many times the loop has been executed
		int loop = 0;
		
		while (true){
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
			
			loop ++;
			Object condition = context.getExecutorFactory().executeAST(getCondition(), context);		
			
			if (!(condition instanceof Boolean)) {
				context.getFrameStack().leaveLocal(this);
				throw new EolIllegalReturnException("Boolean", condition, getCondition(), context);
			}
			
			Object result = null;
			
			if (((Boolean) condition).booleanValue()){
				context.getFrameStack().put(Variable.createReadOnlyVariable("loopCount", loop));
				
				
				try {
					result = context.getExecutorFactory().executeAST(getBody(), context, true);
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

	
}
