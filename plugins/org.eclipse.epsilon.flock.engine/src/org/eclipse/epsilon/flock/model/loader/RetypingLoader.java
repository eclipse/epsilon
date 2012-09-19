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
package org.eclipse.epsilon.flock.model.loader;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.flock.model.domain.typemappings.Retyping;

public class RetypingLoader extends Loader {

	public RetypingLoader(AST ast) {
		super(ast);
	}
	
	public Retyping run() {
		return new Retyping(ast, getAnnotations(), getOriginalType(), getMigratedType(), getGuard());
	}

	private String getOriginalType() {
		return getFirstChild().getText();
	}
	
	private String getMigratedType() {
		return getSecondChild().getText();
	}
}
