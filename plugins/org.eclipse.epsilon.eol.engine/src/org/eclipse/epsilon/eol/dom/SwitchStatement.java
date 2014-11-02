package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
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
	
}
