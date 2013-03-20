package org.eclipse.epsilon.egl.model;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;

public class EglMarkerSection extends EglSection implements ModuleElement {

	protected EglMarkerSection(AST ast) {
		super(ast);
	}

	@Override
	public String getText() {
		String text = getAst().getFirstChild().getText();
		if (text.length() > 0) text = text.substring(1);
		return text;
	}
	
	
	
}
