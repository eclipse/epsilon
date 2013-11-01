/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - switch to frame stack
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.FrameStack;

public class EolIllegalPropertyAssignmentException extends EolRuntimeException {
	private static final long serialVersionUID = 7347297871697667137L;

	public String property;
	
	public EolIllegalPropertyAssignmentException(String property, AST ast, FrameStack stack) {
		super("Invalid assignment to property '" + property + "'", ast, stack);
		this.property = property;
	}
}
