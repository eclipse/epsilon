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
package org.eclipse.epsilon.eol.exceptions;

import org.eclipse.epsilon.common.module.ModuleElement;

public class EolUserException extends EolRuntimeException {

	Object thrown = null;
	
	public EolUserException(Object thrown) {
		this.thrown = thrown;
	}
	
	public EolUserException(Object thrown, ModuleElement ast) {
		this.thrown = thrown;
		this.ast = ast;
	}
	
	@Override
	public String getReason() {
		return String.valueOf(thrown);
	}
}
