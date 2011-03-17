/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.extensions;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

/**
 * Exception for illegal extensions for EUnit listeners.
 *
 * @author Antonio Garcia-Dominguez
 * @version 1.0
 */
public class EUnitIllegalExtensionException extends EolRuntimeException {

	private static final long serialVersionUID = 1L;
	private Throwable cause;

	public EUnitIllegalExtensionException(String message) {
		super(message);
	}

	public EUnitIllegalExtensionException(String message, AST ast) {
		super(message, ast);
	}

	public EUnitIllegalExtensionException(Throwable cause) {
		this.setStackTrace(cause.getStackTrace());
		this.cause = cause;
	}

	public Throwable getCause() {
		return this.cause;
	}

}
