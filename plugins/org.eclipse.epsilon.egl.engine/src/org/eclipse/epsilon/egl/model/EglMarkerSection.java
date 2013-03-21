package org.eclipse.epsilon.egl.model;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;

public class EglMarkerSection extends EglSection implements ModuleElement {

	protected EglMarkerSection(AST ast) {
		super(ast);
	}

	@Override
	public String getText() {
		return getAst().getFirstChild().getText();
	}	
}
