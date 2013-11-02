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
package org.eclipse.epsilon.eol.exceptions.flowcontrol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolTerminationException extends EolRuntimeException{
	
	public EolTerminationException(AST ast) {
		super("Terminated by the user", ast);
	}
	
}
