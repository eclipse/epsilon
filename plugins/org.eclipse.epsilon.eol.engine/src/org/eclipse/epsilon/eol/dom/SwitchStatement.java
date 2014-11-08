package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SwitchStatement extends Statement {
	
	protected Expression expression;
	protected List<Case> cases = new ArrayList<Case>();
	protected Case _default;
	
	@Override
	public void build() {
		super.build();
		for (AST child : getChildren()) {
			if (child.getType() == EolParser.DEFAULT) {
				_default = (Case) child;
			}
			else if (child.getType() == EolParser.CASE){
				cases.add((Case) child);
			}
			else if (child instanceof Expression){
				expression = (Expression) child;
			}
		}
	}
	
	public List<Case> getCases() {
		return cases;
	}
	
	public Case getDefault() {
		return _default;
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		AST switchValueAst = getFirstChild();
		
		Object switchValue = context.getExecutorFactory().executeAST(switchValueAst, context);
		
		AST nextCase = switchValueAst.getNextSibling();
		
		try {
			
			boolean continue_ = false;
			
			while (nextCase != null) {
				
				if (nextCase.getType() == EolParser.CASE) {
					AST caseValueAst = nextCase.getFirstChild();
					
					if (continue_ || equals(context.getExecutorFactory().executeAST(caseValueAst, context), switchValue)) {
						AST caseBodyStatement = caseValueAst.getNextSibling();
						try {
							Object result = context.getExecutorFactory().executeAST(caseBodyStatement, context);
							if (result instanceof Return) return result;
						}
						catch (EolContinueException ex) {
							continue_ = true;
						}
						
						if (!continue_) { break; }
						
					}
				}
				else if (nextCase.getType() == EolParser.DEFAULT) {
					AST defaultBodyStatement = nextCase.getFirstChild();
					Object result = context.getExecutorFactory().executeAST(defaultBodyStatement, context);
					if (result instanceof Return) return result;
					
				}
				
				nextCase = nextCase.getNextSibling();
				
			}
			
		}
		catch (EolBreakException e) {
			
		}
		
		return null;
	}
	
	protected boolean equals(Object o1, Object o2) {
		if (o1 == null && o2 == null) return true;
		if (o1 == null || o2 == null) return false;
		return o1.equals(o2);
	}
}
