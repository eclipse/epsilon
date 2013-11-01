/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - switch to frame stacks
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions.flowcontrol;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;


public class EolReturnException extends EolRuntimeException{
	private static final long serialVersionUID = 2325476201640457206L;

	protected Object returned = null;
	
	public EolReturnException(FrameStack stack, Object returned) {
		super("Return statement not allowed in the context", stack);
		this.returned = returned;
	}
	
	public void setReturned(Object returned) {
		this.returned = returned;
	}
	
	public Object getReturned(){
		return returned;
	}
	
	// Make the exception faster - we don't need a stack trace
	@Override
	public Throwable fillInStackTrace() {
		//return super.fillInStackTrace();
		return this;
	}
	
}
