package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SwitchStatement extends Statement {
	
	protected Expression conditionExpression;
	protected List<Case> cases = new ArrayList<>();
	protected Case _default;
	
	public SwitchStatement() {}
	
	public SwitchStatement(Expression conditionExpression, List<Case> cases, Case _default) {
		this.conditionExpression = conditionExpression;
		this.cases = cases;
		this._default = _default;
	}

	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		for (AST child : cst.getChildren()) {
			
			ModuleElement moduleElement = module.createAst(child, this);
			
			if (child.getType() == EolParser.DEFAULT) {
				_default = (Case) moduleElement;
			}
			else if (child.getType() == EolParser.CASE){
				cases.add((Case) moduleElement);
			}
			else if (moduleElement instanceof Expression){
				conditionExpression = (Expression) moduleElement;
			}
		}
	}
	
	public List<Case> getCases() {
		return cases;
	}
	
	public Case getDefault() {
		return _default;
	}
	
	public Expression getConditionExpression() {
		return conditionExpression;
	}
	
	public void setConditionExpression(Expression conditionExpression) {
		this.conditionExpression = conditionExpression;
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		Object switchValue = context.getExecutorFactory().execute(conditionExpression, context);
		
		boolean continue_ = false;
		
		for (Case c : cases) {
			Object caseValue = context.getExecutorFactory().execute(c.getCondition(), context);
			
			if (continue_ || equals(switchValue, caseValue)) {
				
				try {
					Object result = context.getExecutorFactory().execute(c.getBody(), context);
					if (result instanceof Return) {
						return result;
					}
					else {
						return null;
					}
				}
				catch (EolContinueException ex) {
					continue_ = true;
				}
				
			}
			
			
		}
		
		if (_default != null) {
			Object result = context.getExecutorFactory().execute(_default.getBody(), context);
			
			if (result instanceof Return) {
				return result;
			}
			else {
				return null;
			}
		}
		
		/*
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
		*/
		return null;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		// TODO Auto-generated method stub
		
	}
	
	protected boolean equals(Object o1, Object o2) {
		if (o1 == null && o2 == null) return true;
		if (o1 == null || o2 == null) return false;
		return o1.equals(o2);
	}
}
