/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.egl.internal;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.egl.execute.operations.EglTemplateOperation;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.EolOperationFactory;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;

public class EglOperationFactory extends EolOperationFactory {
	@Override
	public EolOperation createOperation(AST ast) {
		if (EolAnnotationsUtil.hasAnnotation(ast, "template")) {
			return new EglTemplateOperation(ast); 
		} else {
			return super.createOperation(ast);
		}
	}
}
 