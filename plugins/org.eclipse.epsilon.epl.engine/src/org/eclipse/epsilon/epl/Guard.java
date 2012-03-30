package org.eclipse.epsilon.epl;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;

public class Guard extends AbstractModuleElement {
	
	public Guard(AST ast) {
		this.ast = ast;
	}
	
	@Override
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}

}
