/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.model;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.egl.parse.EglToken.TokenType;

public abstract class EglSection implements ModuleElement {

	private final AST ast;
	
	public static EglSection createFrom(AST ast) {
		switch (TokenType.typeOf(ast.getType())) {
		case START_TAG:
			return new EglDynamicSection(ast);
			
		case START_OUTPUT_TAG:
			return new EglShortcutSection(ast);
		
		case PLAIN_TEXT:
			return new EglStaticSection(ast);
			
		case START_COMMENT_TAG: {
			if (ast.getFirstChild() != null && ast.getFirstChild().getText().startsWith("-")) {
				return new EglMarkerSection(ast);
			}
		}
		
		}
		
		return null;
	}
	
	protected EglSection(AST ast) {
		this.ast = ast;
	}
	
	public AST getAst() {
		return ast;
	}

	public List<?> getChildren() {
		return Collections.emptyList();
	}
	
	public abstract String getText();
	
	@Override
	public String toString() {
		final String text = getText();
		
		if (text.length() > 30)
			return text.substring(0, 30) + "...";
		
		return text;
	}
}
