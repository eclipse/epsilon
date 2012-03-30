package org.eclipse.epsilon.epl;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;

public class Cardinality extends AbstractModuleElement {
	
	protected int lowerBound;
	protected int upperBound;
	
	public static final int UNBOUNDED = -1;
	
	public Cardinality(AST ast) {
		this.ast = ast;
		if (ast.getChildCount() == 1) {
			int bound = getBound(ast.getFirstChild().getText());
			this.lowerBound = 1;
			this.upperBound = bound;
		}
		else {
			this.lowerBound = getBound(ast.getFirstChild().getText());
			this.upperBound = getBound(ast.getFirstChild().getNextSibling().getText());
		}
	}
	
	protected int getBound(String text) {
		if ("*".equals(text)) {
			return UNBOUNDED;
		}
		else {
			return Integer.parseInt(text);
		}
	}
	
	public Cardinality(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public int getUpperBound() {
		return upperBound;
	}
	
	public int getLowerBound() {
		return lowerBound;
	}
	
	public boolean isUnbounded() {
		return upperBound == UNBOUNDED;
	}
	
	public boolean isMany() {
		return !isOne();
	}
	
	public boolean isOne() {
		return upperBound == 1 && lowerBound == 1;
	}
	
	public boolean isInBounds(int n) {
		return n>=lowerBound && (upperBound == UNBOUNDED || n<=upperBound);
	}
	
	@Override
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
}
