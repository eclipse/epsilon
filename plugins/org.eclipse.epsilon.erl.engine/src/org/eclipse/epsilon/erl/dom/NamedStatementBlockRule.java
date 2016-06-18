package org.eclipse.epsilon.erl.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.StatementBlock;

public class NamedStatementBlockRule extends NamedRule {
	
	protected StatementBlock body = null;
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		body = (StatementBlock) module.createAst(getBodyAst(cst), this);
	}
	
	protected AST getBodyAst(AST cst) {
		int childrenCount = AstUtil.getChildrenCount(cst);
		if (childrenCount == 2) {
			return AstUtil.getChildAt(cst, 1);
		}
		else if (childrenCount == 1) {
			return AstUtil.getChildAt(cst, 0);			
		}
		return null;
	}
	
	@Override
	protected AST getNameAst(AST cst) {
		int childrenCount = AstUtil.getChildrenCount(cst);
		if (childrenCount == 2) {
			return AstUtil.getChildAt(cst, 0);
		}
		return null;
	}
	
	public StatementBlock getBody() {
		return body;
	}
	
	public void setBody(StatementBlock body) {
		this.body = body;
	}
	
}
