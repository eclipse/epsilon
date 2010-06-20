package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.commons.parse.AST;

public class DomElement {
	
	protected DomElement container;
	
	public void setContainer(DomElement container) {
		this.container = container;
	}
	
	public DomElement eContainer() {
		return container;
	}
	
}
