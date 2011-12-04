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

import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.parse.EglToken.TokenType;

public class EglDynamicSection extends EglSection implements ModuleElement {

	protected EglDynamicSection(AST ast) {
		super(ast);
	}
		
	@Override
	public String getText() {
		final StringBuilder value = new StringBuilder();
		
		if (getAst() != null) {
			AST current = getAst().getFirstChild();
			
			while (current != null && TokenType.typeOf(current.getType()) != TokenType.END_TAG) {
				value.append(current.getText().trim());
				
				current = current.getNextSibling();
			}
		}
		
		String result = value.toString();
		
		if (result.contains(";"))
			result = result.substring(0, result.indexOf(';')+1) + " ...";
		
		return result; 
	}

}
