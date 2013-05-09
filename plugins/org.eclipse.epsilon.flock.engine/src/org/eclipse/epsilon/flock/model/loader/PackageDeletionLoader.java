/*******************************************************************************
 * Copyright (c) 2013 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.model.loader;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.flock.model.domain.typemappings.PackageDeletion;

public class PackageDeletionLoader extends Loader {

	public PackageDeletionLoader(AST ast) {
		super(ast);
	}
	
	public PackageDeletion run() {
		return new PackageDeletion(ast, getOriginalPackage(), getGuard());
	}

	private String getOriginalPackage() {
		return getFirstChild().getText();
	}
}
