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
package org.eclipse.epsilon.egl;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;

public abstract class EglSection implements ModuleElement {

	private final AST ast;
	
	public EglSection(AST ast) {
		this.ast = ast;
	}
	
	public AST getAst() {
		return ast;
	}

	public List<?> getChildren() {
		return Collections.EMPTY_LIST;
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
