package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.ModuleElement;

public abstract class Statement extends AbstractExecutableModuleElement {
	
	protected StatementBlock toStatementBlock(ModuleElement element) {
		if (element instanceof StatementBlock) {
			return (StatementBlock) element;
		}
		else if (element instanceof Statement) {
			return new StatementBlock((Statement) element);
		}
		else if (element instanceof Expression) {
			return new StatementBlock(new ExpressionStatement((Expression) element));
		}
		else throw new RuntimeException(element + " was expected to be a StatementBlock, Statement or Expression but instead it is " + element);
	}
	
}
