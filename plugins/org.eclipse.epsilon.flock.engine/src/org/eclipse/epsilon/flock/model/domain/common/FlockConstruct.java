/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.flock.model.domain.common;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.ModuleElement;
import org.eclipse.epsilon.commons.parse.AST;

public abstract class FlockConstruct implements ModuleElement {

	private final AST ast;

	public FlockConstruct(AST ast) {
		this.ast = ast;
	}
	
	public AST getAst() {
		return ast;
	}

	public List<?> getChildren() {
		return Collections.EMPTY_LIST;
	}
}
