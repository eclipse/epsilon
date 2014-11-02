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
		if (isMarker(ast)) {
			return new EglMarkerSection(ast);
		}
		
		return null;
	}

	private static boolean isMarker(AST ast) {
		return TokenType.typeOf(ast.getType()) == TokenType.START_MARKER_TAG;
	}
	
	protected EglSection(AST ast) {
		this.ast = ast;
	}
	
	public AST getAst() {
		return ast;
	}

	public List<?> getModuleElements() {
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
