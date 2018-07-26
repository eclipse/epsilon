/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.model;

import org.eclipse.epsilon.common.module.AbstractModuleElement;

public abstract class EglSection extends AbstractModuleElement {} /*implements ModuleElement {

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
}*/
