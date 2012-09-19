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

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;


public class EglStaticSection extends EglSection implements ModuleElement {

	protected EglStaticSection(AST ast) {
		super(ast);
	}

	@Override
	public String getText() {
		return getAst() == null ? "" : getAst().getText().replaceAll("\\t", "\\\\t");
	}
}
